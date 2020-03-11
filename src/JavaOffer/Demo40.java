package JavaOffer;

public class Demo40 {

    public static void main(String[] args) {

    }

    // num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果
    public static class Solution1 {
        /**
         * 链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811?f=discussion
         * 来源：牛客网
         * <p>
         * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
         * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
         * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，
         * 这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，
         * 分组标准是第3位是否为1。如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
         * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
         */
        public static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
            int length = array.length;
            if (length == 2) {
                num1[0] = array[0];
                num2[0] = array[1];
                return;
            }
            int bitResult = 0;
            for (int item : array) {
                bitResult ^= item;
            }
            int index = findFirst1(bitResult);
            for (int value : array) {
                if (isBit1(value, index)) {
                    num1[0] ^= value;
                } else {
                    num2[0] ^= value;
                }
            }
        }

        private static int findFirst1(int bitResult) {
            int index = 0;
            while (((bitResult & 1) == 0) && index < 32) {
                bitResult >>= 1;
                index++;
            }
            return index;
        }

        private static boolean isBit1(int target, int index) {
            return ((target >> index) & 1) == 1;
        }
    }
}
