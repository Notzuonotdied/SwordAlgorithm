package BaseAlgorithm.Java;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 7, 1, 2, 9, 0};
        Solution1.bubbleSort(arr, Solution1.Order.Ascending);
        System.out.println(Arrays.toString(arr));
        Solution1.bubbleSort(arr, Solution1.Order.Descending);
        System.out.println(Arrays.toString(arr));
    }

    private static class Solution1 {
        public static void bubbleSort(int[] array, Order order) {
            switch (order) {
                case Ascending:
                    bubbleSortAsc(array);
                    break;
                case Descending:
                    bubbleSortDesc(array);
                    break;
                default:
                    break;
            }
        }

        private static void bubbleSortAsc(int[] array) {
            boolean isOk = true;
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i] < array[j]) {
                        swap(array, i, j);
                        isOk = false;
                    }
                }

                if (isOk) {
                    break;
                }
            }
        }

        private static void bubbleSortDesc(int[] array) {
            boolean isOk = true;
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        swap(array, i, j);
                        isOk = false;
                    }
                }

                if (isOk) {
                    break;
                }
            }
        }


        private static void swap(int[] array, int start, int end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }

        public enum Order {
            Ascending, Descending
        }
    }
}
