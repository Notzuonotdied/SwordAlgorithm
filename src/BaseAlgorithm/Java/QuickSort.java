package BaseAlgorithm.Java;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{
//                3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321
//        };
        int[] arr = new int[]{
                5, 3, 2, 1, 9, 8, 4, 0
        };
        System.out.println(Arrays.toString(arr));
        for (int i : quickSort(arr, 0, arr.length - 1)) {
            System.out.print(i + "\t");
        }
    }

    /**
     * 归并和快速排序算法--数据结构和算法之美--CH12
     * https://blog.csdn.net/CSDN_SUSAN/article/details/100555140
     *
     * 快排的递推公式为：
     *      quickSort(start...end) = quickSort(start...pivot-1) + quickSort(pivot+1...end)
     *  终止条件：
     *      start >= end
     *  如何查找游标pivot：
     *
     */
    private static int[] quickSort(int[] arr, int start, int end) {
        System.out.println("start:" + start + ", end:" + end + "->" + Arrays.toString(arr));
        // key是第一个参数
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) arr = quickSort(arr, start, i - 1);
        if (j + 1 < end) arr = quickSort(arr, j + 1, end);

        return (arr);
    }
}