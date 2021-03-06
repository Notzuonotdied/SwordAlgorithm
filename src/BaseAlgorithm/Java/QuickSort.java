package BaseAlgorithm.Java;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{
//                3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321
//        };
        int[] arr = new int[]{5, 3, 2, 1, 9, 8, 4, 0};
        System.out.println(Arrays.toString(arr));
        for (int i : Solution1.quickSort(arr, 0, arr.length - 1)) {
            System.out.print(i + "\t");
        }
        System.out.println();

        // Solution2.Qsort(arr, 0, arr.length - 1);
        Solution3.Qsort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static class Solution3 {
        /**
         * 快排的非递归写法
         * <p>
         * 快速排序(三种算法实现和非递归实现)
         * https://blog.csdn.net/qq_36528114/article/details/78667034
         */
        public static void Qsort(int[] input, int start, int end) {
            Stack<Integer> stack = new Stack<>();
            stack.push(end);
            stack.push(start);

            int left, right, pivot;
            while (!stack.isEmpty()) {
                left = stack.pop();
                right = stack.pop();

                pivot = partition(input, left, right);

                if ((pivot - 1) > left) {
                    stack.push(pivot - 1);
                    stack.push(start);
                }
                if ((pivot + 1) < right) {
                    stack.push(pivot + 1);
                    stack.push(end);
                }
            }
        }

        private static int partition(int[] array, int start, int end) {
            int pivot = array[start];

            while (start < end) {
                while (start < end && array[end] > pivot) {
                    end--;
                }
                swap(array, start, end);
                while (start < end && array[start] < pivot) {
                    start++;
                }
                swap(array, start, end);
            }

            return start;
        }

        private static void swap(int[] array, int start, int end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }

    private static class Solution2 {
        /**
         * 这是正统的解决方案，解题思路更加容易理解
         * <p>
         * 归并和快速排序算法--数据结构和算法之美--CH12
         * https://blog.csdn.net/CSDN_SUSAN/article/details/100555140
         * <p>
         * 快排的递推公式为：
         * quickSort(start...end) = quickSort(start...pivot-1) + quickSort(pivot+1...end)
         * 终止条件：
         * start >= end
         * 如何查找游标pivot：
         */
        public static void Qsort(int[] input, int start, int end) {
            int pivot;
            if (start < end) {
                // 将L[low,high]一分为二,算出枢轴值pivot，该值得位置固定，不用再变化
                pivot = partition(input, start, end);

                //对两边的数组分别排序
                Qsort(input, start, pivot - 1);
                Qsort(input, pivot + 1, end);
            }
        }

        private static int partition(int[] input, int start, int end) {
            int pivot = input[start];

            while (start < end) {
                while (start < end && input[end] >= pivot) {
                    --end;
                }
                swap(input, start, end);
                while (start < end && input[start] <= pivot) {
                    ++start;
                }
                swap(input, start, end);
            }

            return start;
        }

        private static void swap(int[] input, int start, int end) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
        }
    }

    private static class Solution1 {
        /**
         * 归并和快速排序算法--数据结构和算法之美--CH12
         * https://blog.csdn.net/CSDN_SUSAN/article/details/100555140
         * <p>
         * 快排的递推公式为：
         * quickSort(start...end) = quickSort(start...pivot-1) + quickSort(pivot+1...end)
         * 终止条件：
         * start >= end
         * 如何查找游标pivot：
         */
        public static int[] quickSort(int[] arr, int start, int end) {
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
}