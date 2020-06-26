package LeetCode.Java;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 4};
        System.out.println(Solution1.removeElement(array, 1));
        System.out.println(Arrays.toString(array));
    }

    private static class Solution1 {
        public static int removeElement(int[] nums, int val) {
            int ans = 0;
            for (int num : nums) {
                if (num != val) {
                    nums[ans] = num;
                    ans++;
                }
            }
            return ans;
        }
    }
}
