package LeetCode.Java.array;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        test(new Solution1());
    }

    private static void test(IRemoveElement iRemoveElement) {
        int[] array = new int[]{1, 1, 2, 3, 4};
        System.out.println(iRemoveElement.removeElement(array, 1));
        System.out.println(Arrays.toString(array));
    }

    private interface IRemoveElement {
        int removeElement(int[] nums, int val);
    }

    private static class Solution1 implements IRemoveElement {

        /**
         * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
         * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
         * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/remove-element
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：36.6 MB, 在所有 Java 提交中击败了98.28% 的用户
         */
        @Override
        public int removeElement(int[] nums, int val) {
            int ans = 0;
            for (int num : nums) {
                if (num != val) {
                    nums[ans++] = num;
                }
            }
            return ans;
        }
    }
}
