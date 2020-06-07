package LeetCode.Java.greedy;

public class CuttingRope {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
         * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
         * <p>
         * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * <p>
         * 问题：
         * 1. 为什么每次都是乘以3，详见题解：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了100.00%的用户
         */
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            long res = 1;
            while (n > 4) {
                res *= 3;
                res = res % 1000000007;
                n -= 3;
            }
            return (int) (res * n % 1000000007);
        }
    }

}
