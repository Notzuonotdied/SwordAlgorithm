package JavaOffer;

public class Demo37 {
    public static void main(String[] args) {
        System.out.println(Solution1.GetNumberOfK(new int[]{1, 2, 2, 2, 3, 4, 5}, 2));
    }

    public static class Solution1 {
        public static int GetNumberOfK(int[] array, int k) {
            if (array == null || array.length == 0) {
                return 0;
            }

            int left = getFirstK(array, k, 0, array.length - 1);
            int right = getLastK(array, k, 0, array.length - 1);

            if (left > -1 && right > -1) {
                return right - left + 1;
            }
            return 0;
        }

        private static int getFirstK(int[] array, int k, int start, int end) {
            if (start > end) {
                return -1;
            }

            int midIndex = (start + end) >> 1;
            int midData = array[midIndex];

            if (midData == k) {
                if ((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0) {
                    return midIndex;
                } else {
                    end = midIndex - 1;
                }
            } else if (midData > k) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }

            return getFirstK(array, k, start, end);
        }

        private static int getLastK(int[] array, int k, int start, int end) {
            if (start > end) {
                return -1;
            }

            int midIndex = (start + end) >> 1;
            int midData = array[midIndex];

            if (midData == k) {
                if ((midIndex < array.length - 1 && array[midIndex + 1] != k) || midIndex == array.length - 1) {
                    return midIndex;
                } else {
                    start = midIndex + 1;
                }
            } else if (midIndex < k) {
                start = midIndex + 1;
            } else {
                end = midIndex - 1;
            }

            return getLastK(array, k, start, end);
        }
    }
}
