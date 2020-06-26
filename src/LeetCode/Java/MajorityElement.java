package LeetCode.Java;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(Solution1.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    private static class Solution1 {
        /**
         * 使用HashMap
         */
        public static int majorityElement(int[] nums) {
            int half = Math.floorDiv(nums.length, 2);
            System.out.println(half);
            HashMap<Integer, Integer> numCountMap = new HashMap<>();

            for (int num : nums) {
                if (numCountMap.containsKey(num)) {
                    numCountMap.put(num, numCountMap.get(num) + 1);
                } else {
                    numCountMap.put(num, 1);
                }
            }
            int[] result = new int[2];
            numCountMap.forEach((key, value) -> {
                if (value > result[1]) {
                    result[0] = key;
                    result[1] = value;
                }
            });
            return result[0];
        }
    }

    private static class Solution2 {
        /**
         * 直接排序解决问题
         */
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    private static class Solution3 {
        /**
         * 详见题解——方法五：Boyer-Moore 投票算法
         * <p>
         * https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
         */
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = nums[0];

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (candidate == num) ? 1 : -1;
            }

            return candidate;
        }
    }
}
