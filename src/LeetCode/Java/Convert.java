package LeetCode.Java;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public static void main(String[] args) {
        System.out.println(Solution1.convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(Solution1.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }

    private static class Solution1 {
        /**
         * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
         *
         * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
         *
         * L   C   I   R
         * E T O E S I I G
         * E   D   H   N
         *
         * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/zigzag-conversion
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public static String convert(String s, int numRows) {
            if (numRows < 2) {
                return s;
            }
            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                rows.add(new StringBuilder());
            }
            int i = 0, flag = -1;
            for (char c : s.toCharArray()) {
                rows.get(i).append(c);
                if (i == 0 || i == numRows - 1) {
                    flag = -flag;
                }
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder row : rows) {
                res.append(row);
            }
            return res.toString();
        }
    }
}
