package LeetCode.Java.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        test(new Solution1());
        // test(new Solution2());
    }

    private static void test(ITwoSum iTwoSum) {
        System.out.println(Arrays.toString(iTwoSum.twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(iTwoSum.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(iTwoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    private interface ITwoSum {
        int[] twoSum(int[] nums, int target);
    }

    private static class Solution1 implements ITwoSum {
        /**
         * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
         * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
         * 你可以按任意顺序返回答案。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/two-sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：3 ms, 在所有 Java 提交中击败了55.18% 的用户
         * 内存消耗：39.8 MB, 在所有 Java 提交中击败了5.00% 的用户
         */
        @Override
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            // 值 -> 索引（以『3, 2, 4』为例）
            // 3 -> 0（代表3）
            // 4 -> 1（代表2）
            // 2 -> 2（代表4）
            HashMap<Integer, Integer> hash = new HashMap<>(nums.length);
            for (int i = nums.length - 1; i >= 0; --i) {
                if (hash.containsKey(nums[i])) {
                    ans[0] = i;
                    ans[1] = hash.get(nums[i]);
                    return ans;
                }
                hash.put(target - nums[i], i);
            }
            return ans;
        }
    }

    private static class Solution2 implements ITwoSum {
        /**
         * 执行用时：2 ms, 在所有 Java 提交中击败了89.09% 的用户
         * 内存消耗：38.3 MB, 在所有 Java 提交中击败了91.17% 的用户
         */
        @Override
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            // 值 -> 索引（以『3, 2, 4』为例）
            // 3 -> 0（代表3）
            // 4 -> 1（代表2）
            // 2 -> 2（代表4）
            HashMap<Integer, Integer> hash = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                if (hash.containsKey(nums[i])) {
                    ans[1] = i;
                    ans[0] = hash.get(nums[i]);
                    return ans;
                }
                hash.put(target - nums[i], i);
            }
            return ans;
        }
    }
}
