package leetcode;

public class Leetcode9 {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}

