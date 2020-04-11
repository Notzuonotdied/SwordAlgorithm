package LeetCode.Java;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution1.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    private static class Solution1 {
        /**
         * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 图解 不用除法 o(1)空间的解法 C++
         * https://leetcode-cn.com/problems/product-of-array-except-self/solution/tu-jie-bu-yong-chu-fa-o1kong-jian-de-jie-fa-c-by-t/
         * <p>
         * 1, 2, 3, 4
         * <p>
         * 1, 1, 2, 6(从左往右记录乘积)
         * <p>
         * 24,12,8, 6(从右往左记录乘积)
         */
        public static int[] productExceptSelf(int[] nums) {
            int[] output = new int[nums.length];
            for (int i = 0, multiply = 1; i < nums.length; i++) {
                output[i] = multiply;
                multiply *= nums[i];
            }
            for (int i = nums.length - 1, multiply = 1; i >= 0; i--) {
                output[i] *= multiply;
                multiply *= nums[i];
            }
            return output;
        }
    }
}
