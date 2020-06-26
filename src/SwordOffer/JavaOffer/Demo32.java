package SwordOffer.JavaOffer;

public class Demo32 {
    public static void main(String[] args) {
        System.out.println(Solution1.PrintMinNumber(new int[]{3, 32, 321}));
    }

    private static class Solution1 {
        /**
         * 链接：https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993?answerType=1&f=discussion
         * 来源：牛客网
         */
        public static String PrintMinNumber(int[] numbers) {
            if (numbers == null || numbers.length == 0) return "";
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    // 拼接起来对比大小，排序即可
                    int sum1 = Integer.parseInt(numbers[i] + "" + numbers[j]);
                    int sum2 = Integer.parseInt(numbers[j] + "" + numbers[i]);
                    if (sum1 > sum2) {
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            for (int number : numbers) {
                str.append(number);
            }
            return str.toString();
        }
    }
}
