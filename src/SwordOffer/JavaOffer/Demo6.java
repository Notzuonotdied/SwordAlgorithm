package SwordOffer.JavaOffer;

public class Demo6 {

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }

    /**
     * @param numbers 旋转数组
     * @return 数组的最小值
     */
    public static int minNumberInRotateArray(int[] numbers) {
        // 判断输入是否合法
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("Invalid input.");
        }

        // 开始处理的第一个位置
        int lo = 0;
        // 开始处理的最后一个位置
        int hi = numbers.length - 1;
        // 设置初始值
        int mi = lo;

        // 确保lo在前一个排好序的部分，hi在排好序的后一个部分
        while (numbers[lo] >= numbers[hi]) {
            // 当处理范围只有两个数据时，返回后一个结果
            // 因为numbers[lo] >= numbers[hi]总是成立，后一个结果对应的是最小的值
            if (hi - lo == 1) {
                return numbers[hi];
            }

            // 取中间的位置
            mi = lo + (hi - lo) / 2;

            // 如果三个数都相等，则需要进行顺序处理，从头到尾找最小的值
            if (numbers[mi] == numbers[lo] && numbers[hi] == numbers[mi]) {
                return minInorder(numbers, lo, hi);
            }

            // 如果中间位置对应的值在前一个排好序的部分，将lo设置为新的处理位置
            if (numbers[mi] >= numbers[lo]) {
                lo = mi;
            }
            // 如果中间位置对应的值在后一个排好序的部分，将hi设置为新的处理位置
            else if (numbers[mi] <= numbers[hi]) {
                hi = mi;
            }
        }

        // 返回最终的处理结果
        return numbers[mi];
    }

    /**
     * 找数组中的最小值
     *
     * @param numbers 数组
     * @param start   数组的起始位置
     * @param end     数组的结束位置
     * @return 找到的最小的数
     */
    public static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}
