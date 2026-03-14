package leetcode;
import java.util.*;

public class Leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (diffs.containsKey(complement)) {
                return new int[] {diffs.get(complement), i};
            }
            diffs.put(nums[i], i);
        }
        return new int[] {};
    }
}