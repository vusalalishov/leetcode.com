package az.tezapp.leetcode.solutions.milestone2.easy;

public class Solution67 {

    // ACCEPTED: 25%
    public String addBinary(String a, String b) {
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;

        byte remainder = 0;
        StringBuilder sb = new StringBuilder();
        while (aPointer >= 0 && bPointer >= 0) {

            byte aByte = (byte) (a.charAt(aPointer) - 48);
            byte bByte = (byte) (b.charAt(bPointer) - 48);

            byte c = (byte) (aByte + bByte + remainder);

            byte[] data = toBinary(c);

            sb.append(data[1]);
            remainder = data[0];

            aPointer--;
            bPointer--;
        }

        int index = a.length() > b.length() ? 1 : b.length() > a.length() ? 2 : 0;
        if (index == 0) {
            if (remainder != 0) {
                sb.append(remainder);
            }
        } else {
            String left = index == 1 ? a : b;
            int leftPointer = index == 1 ? aPointer : bPointer;
            while (leftPointer >= 0) {
                byte tmp = (byte) (left.charAt(leftPointer) - 48);
                if (remainder == 0) {
                    sb.append(tmp);
                } else {
                    byte c = (byte) (tmp + remainder);
                    byte[] data = toBinary(c);

                    sb.append(data[1]);
                    remainder = data[0];
                }
                leftPointer--;
            }

            if (remainder != 0) {
                sb.append(remainder);
            }

        }

        return sb.reverse().toString();
    }

    private static byte[] toBinary(byte a) {
        byte[] bytes = new byte[2];
        byte bIndex = 1;
        while (a != 0) {
            bytes[bIndex] = (byte) (a % 0b10);
            a /= 0b10;
            bIndex--;
        }
        return bytes;
    }

}
