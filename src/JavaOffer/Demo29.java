package JavaOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo29 {
    // 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                Solution1
                        .GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10)
                        .toArray())
        );
    }

    private static class Solution1 {
        /**
         * 利用了快排的分区的思想，找到了前K个最小的数字。
         * <p>
         * https://github.com/A11Might/CodingInterview/blob/master/code/offer40.java
         *
         * @see BaseAlgorithm.Java.QuickSort 快排算法实现。
         * @see LeetCode.Java.FindKthLargest 寻找数组中最大的第 K 个元素。
         */
        public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            if (input == null || input.length == 0 || k == 0 || k > input.length) {
                return new ArrayList<>();
            }

            int start = 0;
            int end = input.length - 1;
            while (start <= end) {
                int index = partition(input, start, end);

                if (index == k - 1) {
                    break;
                } else if (index < k - 1) {
                    start = index + 1;
                } else {
                    end = index - 1;
                }
            }

            System.out.println(Arrays.toString(input));
            ArrayList<Integer> result = new ArrayList<>(k);
            for (int i = 0; i < k; ++i) {
                result.add(input[i]);
            }
            return result;
        }

        /**
         * 利用快排的partition获得index，根据index的位置获取第k个数字。
         */
        private static int partition(int[] input, int start, int end) {
            // 分割区间的标志
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
            int temp = input[end];
            input[end] = input[start];
            input[start] = temp;
        }
    }
}
