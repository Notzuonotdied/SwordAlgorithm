package LeetCode.Java;

public class HammingDistance {
    public static void main(String[] args) {
        test(new Solution1(), 3, 1);
        test(new Solution1(), 5, 2);
    }

    private static void test(ISolution solution, int x, int y) {
        System.out.println(solution.hammingDistance(x, y));
    }

    private interface ISolution {
        int hammingDistance(int x, int y);
    }

    private static class Solution1 implements ISolution {
        /**
         * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
         * 给出两个整数 x 和 y，计算它们之间的汉明距离。
         * 注意：
         * 0 ≤ x, y < 2^31.
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/hamming-distance
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：34.7 MB, 在所有 Java 提交中击败了99.24% 的用户
         */
        public int hammingDistance(int x, int y) {
            int ans = x ^ y;

            int count = 0;
            for (int i = 0; i < 32; ++i) {
                if ((ans & 1) == 1) {
                    count++;
                }
                ans = ans >> 1;
            }
            return count;
        }
    }
}
