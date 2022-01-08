package LeetCode.Java.greedy;

public class CanCompleteCircuit {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
         *
         * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
         *
         * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
         *
         * 说明:
         *
         *     如果题目有解，该答案即为唯一答案。
         *     输入数组均为非空数组，且长度相同。
         *     输入数组中的元素均为非负数。
         *
         * 示例 1:
         *
         * 输入:
         * gas  = [1,2,3,4,5]
         * cost = [3,4,5,1,2]
         *
         * 输出: 3
         *
         * 解释:
         * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
         * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
         * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
         * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
         * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
         * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
         * 因此，3 可为起始索引。
         *
         *
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/gas-station
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         *
         * 可以看看官方的题解的解题思路：（相当巧妙）
         * https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode/
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了82.42% 的用户
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int length = gas.length;
            int totalTank = 0;
            int curTank = 0;
            int startStation = 0;
            for (int i = 0; i < length; ++i) {
                totalTank += gas[i] - cost[i];
                curTank += gas[i] - cost[i];
                // 当前都不满足情况，走下一个
                if (curTank < 0) {
                    curTank = 0;
                    startStation = i + 1;
                }
            }
            return totalTank >= 0 ? startStation : -1;
        }
    }
}
