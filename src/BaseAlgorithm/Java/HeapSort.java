package BaseAlgorithm.Java;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // 大顶堆
        int[] arr = new int[]{4, 6, 7, 1, 2, 9, 0};
        Solution1.bigHeapSort(arr);
        System.out.println(Arrays.toString(arr));
        // 小顶堆
        arr = new int[]{4, 6, 7, 1, 2, 9, 0};
        Solution1.smallHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static class Solution1 {

        /**
         * 大顶堆
         */
        public static void bigHeapSort(int[] arr) {
            heapSort(arr, (leftChildVal, rightChildVal) -> leftChildVal < rightChildVal);
        }

        /**
         * 小顶堆
         */
        public static void smallHeapSort(int[] arr) {
            heapSort(arr, (leftChildVal, rightChildVal) -> leftChildVal > rightChildVal);
        }

        /**
         * 堆排序的核心实现
         *
         * @param arr             二叉树
         * @param compareCallBack 比较回调
         */
        private static void heapSort(int[] arr, CompareCallBack compareCallBack) {
            int start = arr.length / 2 - 1;
            // 从下到上，从左到右对每个节点进行调整，循环得到非叶子节点，调整所有的节点
            for (; start >= 0; --start) {
                endian(arr, start, arr.length - 1, compareCallBack);
            }

            int end = arr.length - 1;
            for (; end > 0; --end) {
                // 顶部尾部互换位置
                swap(arr, 0, end);
                // 重新调整子节点的顺序，从顶开始调整
                endian(arr, 0, end - 1, compareCallBack);
            }
        }

        /**
         * 调整二叉树的节点
         *
         * @param arr             二叉树
         * @param start           起始节点index
         * @param end             终止节点index
         * @param compareCallBack 比较回调
         */
        private static void endian(int[] arr, int start, int end, CompareCallBack compareCallBack) {
            int root = start;
            int child = root * 2 + 1;
            while (child <= end) {
                // 找出子节点中的一个与父节点比较
                if (child + 1 <= end && compareCallBack.compare(arr[child], arr[child + 1])) {
                    child++;
                }
                // 和父节点进行比较
                if (compareCallBack.compare(arr[root], arr[child])) {
                    swap(arr, root, child);
                    root = child;
                    child = root * 2 + 1;
                } else {
                    break;
                }
            }
        }

        /**
         * 交换参数
         *
         * @param arr    二叉树
         * @param first  第一个交换的index
         * @param second 第二个交换的index
         */
        private static void swap(int[] arr, int first, int second) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }

    /**
     * 回调函数，用于区别大顶堆和小顶堆的判断条件。
     */
    private interface CompareCallBack {
        /**
         * 比较条件
         *
         * @param leftChildVal  左节点
         * @param rightChildVal 右节点
         * @return 左右节点的比较结果
         */
        boolean compare(int leftChildVal, int rightChildVal);
    }
}
