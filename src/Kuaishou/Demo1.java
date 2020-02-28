package Kuaishou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Demo1 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/003482c395bd41c68082f6adc545a600?answerType=1&f=discussion
     * 来源：牛客网
     * <p>
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * ("回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。)
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     * 可用C++,Java,C#实现相关代码逻辑
     */
    public static void main(String[] args) {
        // 输入：aabcb
        // 输出：7
        getPalindromeCount("aabcb");
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(res.size());
    }

    // 最终结果，将paths的结果存入res
    private static ArrayList<String> res = new ArrayList<>();
    // 使用TreeSet来去重
    private static TreeSet<String> paths = new TreeSet<>();
    // 确认是回文数的则存为true，确认不为回文数的则存为false
    private static HashMap<String, Boolean> isPalindrome = new HashMap<>();
    private static boolean[] status;

    /**
     * 获取回文字符串的数量
     *
     * @param input 输入的字符串
     */
    public static void getPalindromeCount(String input) {
        if (input == null || input.length() == 0) {
            return;
        }

        status = new boolean[input.length()];
        findPalindrome(input, 0, 0);
        paths.forEach((string) -> res.add(string.split("-")[0]));
    }

    public static void findPalindrome(String input, int start, int end) {
        // System.out.println("input:" + input + ", start:" + start + ", end:" + end + ", subString:" + input.substring(start, end));
        if (isPalindrome(input.substring(start, end))) {
            paths.add(input.substring(start, end) + "-" + start);
            return;
        }
        for (int i = 0; i < input.length(); ++i) {
            for (int j = i; j < input.length(); ++j) {
                if (!status[j]) {
                    status[j] = true;
                    findPalindrome(input, i, j + 1);
                    status[j] = false;
                }
            }
        }
    }

    public static boolean isPalindrome(String subInput) {
        if (subInput == null || subInput.length() == 0) {
            return false;
        }
        if (subInput.length() == 1) {
            return true;
        }
        if (isPalindrome.containsKey(subInput)) {
            return isPalindrome.get(subInput);
        }

        // System.out.println("subInput:" + subInput);
        int loop = subInput.length() % 2;
        int i = 0;

        while (i <= loop) {
            // System.out.println("对比：" + i + " - " + (subInput.length() - 1 - i));
            // System.out.println("对比：" + subInput.charAt(i) + " - " + subInput.charAt(subInput.length() - 1 - i));
            if (subInput.charAt(i) != subInput.charAt(subInput.length() - 1 - i)) {
                // System.out.println("不是回文数：" + subInput);
                isPalindrome.put(subInput, false);
                return false;
            }
            ++i;
        }
        // System.out.println("确定是回文数：" + subInput);
        isPalindrome.put(subInput, true);
        return true;
    }
}
