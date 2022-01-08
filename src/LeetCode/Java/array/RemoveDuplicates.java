package LeetCode.Java.array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        test(new Solution1());
    }

    private static void test(IRemoveDuplicates iRemoveDuplicates) {
        System.out.println(iRemoveDuplicates.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    private interface IRemoveDuplicates {
        int removeDuplicates(int[] nums);
    }

    private static class Solution1 implements IRemoveDuplicates {
        /**
         * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
         * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：1 ms, 在所有 Java 提交中击败了95.71% 的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了79.71% 的用户
         */
        @Override
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int i = 0;
            for (int j = 1; j < nums.length; ++j) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
