package SwordOffer.JavaOffer;

import java.util.Stack;

public class Demo44 {

    public static void main(String[] args) {

    }

    private static class Solution1 {

        /**
         * 使用栈操作更加清晰明了，例如“world！ hello”:
         * <p>
         * 首先每个字符串一次进栈:
         * <p>
         * 然后依次出栈：hello world！
         */
        public static String ReverseSentence(String str) {
            if (str.trim().equals("") && str.length() > 0) {
                return str;
            }
            Stack<String> reverse = new Stack<>();
            StringBuilder string = new StringBuilder(str.trim());
            String[] strings = " ".split(string.toString());
            for (String s : strings) {
                reverse.push(s);
            }
            string = new StringBuilder(reverse.pop());
            while (!reverse.isEmpty()) {
                string.append(" ").append(reverse.pop());
            }
            return string.toString();
        }
    }
}
