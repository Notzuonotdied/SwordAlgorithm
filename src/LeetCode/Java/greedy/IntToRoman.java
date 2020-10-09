package LeetCode.Java.greedy;

public class IntToRoman {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        // 根据分析的六种情况，定义以下字符串
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        /**
         * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
         *
         * 字符          数值
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         *
         * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
         *
         * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
         * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
         * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
         *
         *     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
         *     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
         *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
         *
         * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/integer-to-roman
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：5 ms, 在所有 Java 提交中击败了91.41% 的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了96.68% 的用户
         */
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            // 贪心法，每次都取最大值
            for (int i = 0; i < values.length && num >= 0; i++) {
                // 每次都取最大值，直到num < 0
                while (values[i] <= num) {
                    num -= values[i];
                    sb.append(symbols[i]);
                }
            }
            return sb.toString();
        }
    }
}
