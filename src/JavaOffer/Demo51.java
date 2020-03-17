package JavaOffer;

public class Demo51 {
    public static void main(String[] args) {

    }

    private static class Solution {

        public static int[] multiply(int[] A) {
            int length = A.length;
            int[] B = new int[length];
            // 边界
            if (A.length <= 1) {
                return null;
            }
            // 计算下三角
            // 初始化第一行
            B[0] = 1;
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            // 计算上三角
            // 初始化最后一行
            int temp = 1;
            for (int i = length - 1; i >= 0; i--) {
                B[i] = temp * B[i];
                temp = A[i] * temp;
            }
            return B;
        }
    }
}
