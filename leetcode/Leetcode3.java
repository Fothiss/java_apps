package leetcode;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, lastIndex[c]);
            maxLen = Math.max(maxLen, right - left + 1);
            lastIndex[c] = right + 1;
        }
        
        return maxLen;
    }
}
