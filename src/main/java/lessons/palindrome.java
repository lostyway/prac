package lessons;

import java.util.Arrays;
import java.util.Objects;

public class palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();
        String[] temp = s.replaceAll("[^a-z]", "").split("\\s+");
        if (temp.length % 2 == 0) {
            return false;
        }
        for (int i = 0; i < temp.length / 2; i++) {
            if (!temp[i].equals(temp[temp.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
