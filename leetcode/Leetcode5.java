package leetcode;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Нечетная длина
            int l1 = i, r1 = i;
            while (l1 >= 0 && r1 < s.length() && s.charAt(l1) == s.charAt(r1)) {
                l1--;
                r1++;
            }
            int len1 = r1 - l1 - 1;
            
            // Четная длина
            int l2 = i, r2 = i + 1;
            while (l2 >= 0 && r2 < s.length() && s.charAt(l2) == s.charAt(r2)) {
                l2--;
                r2++;
            }
            int len2 = r2 - l2 - 1;
            
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
}
