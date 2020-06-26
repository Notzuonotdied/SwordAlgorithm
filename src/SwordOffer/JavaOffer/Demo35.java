package SwordOffer.JavaOffer;

public class Demo35 {
    public static void main(String[] args) {
        System.out.println(Solution1.InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }

    private static class Solution1 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     */
    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        // 复制数组是为了重复利用数组，防止重复开辟控件，浪费时间
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return InversePairsCore(array, copy, 0, array.length - 1);
    }

    public static int InversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int mid = (start + end) >> 1;

        int left = InversePairsCore(copy, data, start, mid);
        int right = InversePairsCore(copy, data, mid + 1, end);

        int count = 0;
        int i = mid;
        int j = end;
        int indexCopy = end;
        while (i >= start && j >= mid + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - mid;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }

        for (; i >= start; --i) {
            copy[indexCopy--] = data[i];
        }

        for (; j >= mid + 1; --j) {
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }
    }
}
