package LeetCode.Java.dp;

public class DivisorGame {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 迷惑性极大的题目，其实是个归纳题
         *
         * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
         *
         * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
         *
         *     选出任一 x，满足 0 < x < N 且 N % x == 0 。
         *     用 N - x 替换黑板上的数字 N 。
         *
         * 如果玩家无法执行这些操作，就会输掉游戏。
         *
         * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/divisor-game
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public boolean divisorGame(int N) {
            return N % 2 == 0;
        }
    }
}
