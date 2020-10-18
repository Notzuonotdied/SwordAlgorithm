package LeetCode.Java.math;

public class CountPrimes {
    public static void main(String[] args) {

    }

    private static class Solution1 {

        public int countPrimes(int n) {
            int count = 0;
            // 建立数组，默认整型数组元素都是0
            int[] array = new int[n];
            // 从2开始进行比较，最后数组元素是0时，为质数，为1时为合数。
            for (int i = 2; i <= (int) Math.sqrt(n); i++) {
                if (array[i] != 0) {
                    continue;
                }
                for (int j = i * i; j < n; j += i) {
                    array[j] = 1;
                }
            }
            for (int i = 2; i < n; i++) {
                if (array[i] == 0) count++;
            }
            return count;
        }
    }
}
