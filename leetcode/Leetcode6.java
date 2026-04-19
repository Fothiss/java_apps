package leetcode;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int row = 0;
        boolean down = true;
        
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            
            if (down) {
                if (row == numRows - 1) {
                    down = false;
                    row--;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    down = true;
                    row++;
                } else {
                    row--;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }
        
        return result.toString();
    }
}