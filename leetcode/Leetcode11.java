package leetcode;

public class Leetcode11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * width;
            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
