package LeetCode.Java;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 编写一个函数来查找字符串数组中的最长公共前缀。
         * <p>
         * 如果不存在公共前缀，返回空字符串 ""。
         * <p>
         * https://leetcode-cn.com/problems/longest-common-prefix/
         * <p>
         * 可以看看官方的题解的第一个解答：
         * * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
         */
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }

            String prefix = strs[0];
            for (int i = 1; i < strs.length; ++i) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }
            return prefix;
        }
    }
}
