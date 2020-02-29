package Mogujie;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Solution1.main("abc");
    }

    private static class Solution1 {
        // 标准的全排列问题，有重复的全排列，偷懒的就用set去重，答案要求字典顺序输出，就用TreeSet咯，
        static TreeSet<String> output = new TreeSet<>();

        public static void main(String input) {
            backtrack(input.toCharArray(), 0, input.length());
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String item : output) {
                sb.append(item).append(",").append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 2) + "]");
        }

        // 回溯算法
        private static void backtrack(char[] chars, int start, int end) {
            if (start == end) {
                output.add(String.valueOf(chars));
                return;
            }
            for (int i = start; i < end; ++i) {
                swap(chars, start, i);
                backtrack(chars, start + 1, end);
                //回溯
                swap(chars, start, i);
            }
        }

        // 交换符号的位置
        private static void swap(char[] chars, int i, int j) {
            // 输出回溯的过程
            printBacktrack(chars, i, j);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        /**
         * 输出回溯的过程，方便调试和理解
         */
        private static void printBacktrack(char[] chars, int i, int j) {
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < i; ++index) {
                sb.append("\t");
            }
            sb.append("swap: (").append(i).append(", ").append(j).append(") = ")
                    .append("(").append(chars[i]).append(", ").append(chars[j]).append(")");
            System.out.println(sb.toString());
        }
    }
}

