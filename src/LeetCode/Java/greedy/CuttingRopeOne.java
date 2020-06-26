package LeetCode.Java.greedy;

public class CuttingRopeOne {
    public static void main(String[] args) {

    }

    private static class Solution {
        /**
         * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
         * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了100.00%的用户
         */
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }

            long res = 1;
            while (n > 4) {
                res *= 3;
                n -= 3;
            }
            return (int) res * n;
        }
    }
}
