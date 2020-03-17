package JavaOffer;

public class Demo50 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            System.out.println(result);
            result = result ^ nums[i];
        }
        System.out.print(result);
    }

    public static class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public static boolean duplicate(int[] numbers, int length, int[] duplication) {
            /**
             * 链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8?f=discussion
             * 来源：牛客网
             *
             * 不需要额外的数组或者hash table来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，
             * 当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
             * */
            for (int i = 0; i < length; i++) {
                int index = numbers[i];
                if (index >= length) {
                    index -= length;
                }

                if (numbers[index] >= length) {
                    duplication[0] = numbers[index] - length;
                    return true;
                }
                numbers[index] = numbers[index] + length;
            }
            return false;
        }
    }
}
