package JavaOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Demo27 {

    // 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    // 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Permutation("abc").toArray()));
    }

    private static ArrayList<String> res = new ArrayList<>();
    private static TreeSet<String> paths = new TreeSet<>();
    private static StringBuilder path = new StringBuilder();
    private static boolean[] visited;

    /**
     * 排列
     *
     * @param str 需要排列的字符串
     */
    public static ArrayList<String> Permutation(String str) {
        if (str == null) {
            return res;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        visited = new boolean[chars.length];
        combination(chars, 0);
        res.addAll(paths);
        return res;
    }

    /**
     * 使用回溯的思想进行递归
     *
     * @param chars 输入的字符
     * @param len   字符的长度
     */
    private static void combination(char[] chars, int len) {
        if (len == chars.length) {
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(chars[i]);
                combination(chars, len + 1);
                // Duang ~ 回溯 - 状态重置
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
