package LeetCode.Java;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(Solution1.hammingDistance(3, 1));
    }

    private static class Solution1 {
        /**
         * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
         * <p>
         * 给出两个整数 x 和 y，计算它们之间的汉明距离。
         * <p>
         * 注意：
         * 0 ≤ x, y < 2^31.
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/hamming-distance
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了6.45%的用户
         */
        public static int hammingDistance(int x, int y) {
            int result = x ^ y;

            int count = 0;
            for (int i = 0; i < 32; ++i) {
                if ((result & 1) == 1) {
                    count++;
                }
                result = result >> 1;
            }
            return count;
        }
    }
}
