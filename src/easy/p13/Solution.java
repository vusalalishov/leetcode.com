package easy.p13;

import javafx.scene.control.Slider;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt2("IL"));
    }

    // 3%
    public int romanToInt1(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int c = s.length();
        int y = 0;
        int prev = 0;
        for (int i = c - 1; i >= 0; i--) {
            int tmp = charMap.get(s.charAt(i));
            if (tmp >= prev) {
                y += tmp;
            } else {
                y -= tmp;
            }
            prev = tmp;
        }

        return y;
    }

    // 47%
    public int romanToInt2(String s) {
        int c = s.length();
        int y = 0;
        int prev = 0;
        for (int i = c - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int tmp = 0;
            if (ch == 'I') tmp = 1;
            if (ch == 'V') tmp = 5;
            if (ch == 'X') tmp = 10;
            if (ch == 'L') tmp = 50;
            if (ch == 'C') tmp = 100;
            if (ch == 'D') tmp = 500;
            if (ch == 'M') tmp = 1000;
            if (tmp >= prev) {
                y += tmp;
            } else {
                y -= tmp;
            }
            prev = tmp;
        }

        return y;
    }

}
