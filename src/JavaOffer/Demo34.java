package JavaOffer;

public class Demo34 {
    public static void main(String[] args) {
        String input = "abfahfiajsdia";
        int index = Solution1.FirstNotRepeatingChar(input);
        System.out.println(input.charAt(index));
    }

    private static class Solution1 {
        /**
         * 链接：https://www.nowcoder.com/questionTerminal/1c82e8cf713b4bbeb2a5b31cf5b0417c?f=discussion
         * 来源：牛客网
         * <p>
         * 其实主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。
         * 首先用一个58长度的数组来存储每个字母出现的次数，为什么是58呢，
         * 主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
         * 而每个字母的index=int(word)-65，比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，
         * 最终遍历一遍字符串，找出第一个数组内容为1的字母就可以了，时间复杂度为O(n)
         */
        public static int FirstNotRepeatingChar(String str) {
            int[] words = new int[58];
            for (int i = 0; i < str.length(); i++) {
                words[((int) str.charAt(i)) - 65] += 1;
            }
            for (int i = 0; i < str.length(); i++) {
                if (words[((int) str.charAt(i)) - 65] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
