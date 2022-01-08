package LeetCode.Java.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
         * <p>
         * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
         * <p>
         * 输入："23"
         * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
         * <p>
         * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
         * <p>
         * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
         * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，
         * 并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，
         * 即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
         * <p>
         * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。
         * 在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<>();
            if (digits.length() == 0) {
                return combinations;
            }
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
            return combinations;
        }

        /**
         * 回溯
         *
         * @param combinations 组合结果
         * @param phoneMap     映射表
         * @param digits       字符串
         * @param index        digits的遍历索引
         * @param combination  单次组合结果
         */
        public void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                              String digits, int index, StringBuilder combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
                return;
            }
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); ++i) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
