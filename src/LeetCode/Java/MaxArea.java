package LeetCode.Java;

public class MaxArea {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
         * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
         * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
         * <p>
         * 说明：你不能倾斜容器，且 n 的值至少为 2。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/container-with-most-water
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 详见以下题解：
         * <p>
         * 作者：jyd
         * 链接：https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        public static int maxArea(int[] height) {
            int i = 0, j = height.length - 1, res = 0;
            while (i < j) {
                res = height[i] < height[j]
                        ? Math.max(res, (j - i) * height[i++])
                        : Math.max(res, (j - i) * height[j--]);
            }
            return res;
        }
    }
}
