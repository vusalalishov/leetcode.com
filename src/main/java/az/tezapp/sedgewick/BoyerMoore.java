package az.tezapp.sedgewick;

public class BoyerMoore {

    public int indexOf(String s, String pat) {
        final int R = 26;
        int[] right = new int[R];

        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < pat.length(); i++) {
            right[charAt(pat, i)] = i;
        }

        int skip;
        for (int i = 0; i <= s.length() - pat.length(); i += skip) {
            skip = 0;
            for (int j = pat.length() - 1; j >= 0; j--) {
                if (pat.charAt(j) != s.charAt(i + j)) {
                    skip = Math.max(1, j - right[charAt(s, i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }

        return -1;
    }

    private int charAt(String s, int index) {
        return s.charAt(index) - 'a';
    }

    public static void main(String[] args) {
        BoyerMoore boyerMoore = new BoyerMoore();
        System.out.println(boyerMoore.indexOf("asdasdthingasdsd", "thing"));
    }

}
