package LeetCode.Java.common;

public class CMaxSubArray {

    protected static void test(IMaxSubArray iMaxSubArray) {
        System.out.println(iMaxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) + ", result:" + 6);
        System.out.println(iMaxSubArray.maxSubArray(new int[]{1}) + ", result:" + 1);
        System.out.println(iMaxSubArray.maxSubArray(new int[]{-2, 1}) + ", result:" + 1);
    }

    protected interface IMaxSubArray {
        int maxSubArray(int[] nums);
    }
}
