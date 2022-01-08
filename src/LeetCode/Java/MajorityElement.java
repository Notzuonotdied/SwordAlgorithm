package LeetCode.Java;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(Solution1.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    private static class Solution1 {
        /**
         * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
         * <p>
         * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/majority-element
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
         * <p>
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.95% 的用户
         * 内存消耗：43.8 MB, 在所有 Java 提交中击败了77.01% 的用户
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
