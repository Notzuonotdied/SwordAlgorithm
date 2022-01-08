package LeetCode.Java.array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] array1 = new int[]{0, 1, 0, 3, 12};
        new Solution1().moveZeroes(array1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = new int[]{0, 1, 0, 3, 12};
        new Solution2().moveZeroes(array2);
        System.out.println(Arrays.toString(array2));
    }

    private interface IMoveZeroes {
        void moveZeroes(int[] nums);
    }

    private static class Solution1 implements IMoveZeroes {
        /**
         * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
         * <p>
         * 示例:
         * 输入: [0,1,0,3,12]
         * 输出: [1,3,12,0,0]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/move-zeroes
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了5.62%的用户
         */
        @Override
        public void moveZeroes(int[] nums) {
            int temp;
            for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
                if (nums[cur] == 0) {
                    continue;
                }
                temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = nums[cur];
                nums[cur] = temp;
            }
        }
    }

    private static class Solution2 implements IMoveZeroes {

        /**
         * 执行用时：1 ms, 在所有 Java 提交中击败了83.88% 的用户
         * 内存消耗：39 MB, 在所有 Java 提交中击败了79.79% 的用户
         */
        @Override
        public void moveZeroes(int[] nums) {
            int i = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[i++] = num;
                }
            }
            for (; i < nums.length; ++i) {
                nums[i] = 0;
            }
        }
    }
}
