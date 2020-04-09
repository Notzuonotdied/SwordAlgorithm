package LeetCode.Java;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(Solution1.reverseWords("Let's take LeetCode contest"));
    }

    private static class Solution1 {
        /**
         * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
         * <p>
         * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
         */
        public static String reverseWords(String s) {
            if (s == null) {
                return null;
            }

            String[] spiltString = s.split(" ");
            StringBuilder sb = new StringBuilder(spiltString.length);
            for (String str : spiltString) {
                sb.append(new StringBuilder(str).reverse().append(" "));
            }
            return sb.toString().trim();
        }
    }
}
