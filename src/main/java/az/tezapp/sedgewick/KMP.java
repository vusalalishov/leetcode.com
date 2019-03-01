package az.tezapp.sedgewick;

public class KMP {

    public int indexOf(String source, String pattern) {
        final int r = 3;
        final int n = source.length();
        final int m = pattern.length();

        // build DFA
        int[][] dfa = new int[r][pattern.length()];

        dfa[charAt(pattern, 0)][0] = 1;

        for (int i = 0, x = 0; i < pattern.length(); i++) {
            for (int c = 0; c < r; c++) {
                dfa[c][i] = dfa[c][x];
            }
            dfa[charAt(pattern, i)][i] = i + 1;
            x = dfa[charAt(pattern, i)][x];
        }

        // iterate through DFA

        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[charAt(source, i)][j];
        }
        if (j == m) {
            return i - m;
        }
        return n;

    }

    private int charAt(String s, int index) {
        return s.charAt(index) - 'a';
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.indexOf("abababbbbcababac", "ababac"));
    }

}
