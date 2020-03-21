package LeetCode.Java;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 直接利用HashMap就可以了
         */
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            HashMap<Integer, Integer> hash = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (hash.containsKey(nums[i])) {
                    result[0] = i;
                    result[1] = hash.get(nums[i]);
                    return result;
                }
                hash.put(target - nums[i], i);
            }
            return result;
        }
    }
}
