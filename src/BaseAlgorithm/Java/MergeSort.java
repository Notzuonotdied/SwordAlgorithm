package BaseAlgorithm.Java;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 1, 9, 8, 4, 0};
        System.out.println(Arrays.toString(Solution1.MergeSort(arr, 0, arr.length - 1)));
    }

    private static class Solution1 {
        /**
         * 归并排序详解：
         * https://blog.csdn.net/CSDN_SUSAN/article/details/100555140
         * <p>
         * 递归公式：
         * merge_sort(start...end) = merge(merge_sort(start...q), merge_sort(q+1...end))
         * 终止条件：
         * start >= end 不用再继续分解
         * <p>
         * 实现：
         * https://baike.baidu.com/item/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F/1639015?fr=aladdin
         */
        public static int[] MergeSort(int[] input, int start, int end) {
            if (start == end) {
                return new int[]{input[start]};
            }

            // 递归排序
            int mid = start + (end - start) / 2;
            int[] leftArr = MergeSort(input, start, mid); //左有序数组
            int[] rightArr = MergeSort(input, mid + 1, end); //右有序数组
            int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

            // 复制回来原数组
            int m = 0, i = 0, j = 0;
            while (i < leftArr.length && j < rightArr.length) {
                newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
            }
            while (i < leftArr.length) {
                newNum[m++] = leftArr[i++];
            }
            while (j < rightArr.length) {
                newNum[m++] = rightArr[j++];
            }
            return newNum;
        }
    }
}
