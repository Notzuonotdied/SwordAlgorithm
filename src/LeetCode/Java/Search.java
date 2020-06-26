package LeetCode.Java;

public class Search {
    public static void main(String[] args) {
        System.out.println(Solution1.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(Solution1.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(Solution1.search(new int[]{5, 1, 3}, 5));
    }

    private static class Solution1 {
        /**
         * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
         * <p>
         * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
         * <p>
         * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
         * <p>
         * 你可以假设数组中不存在重复的元素。
         * <p>
         * 你的算法时间复杂度必须是 O(log n) 级别。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了17.74%的用户
         */
        public static int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid = (left + right) >> 1;
            while (left <= right) {
                if (nums[mid] == target) {
                    return mid;
                }
                // 左边升序
                if (nums[left] <= nums[mid]) {
                    // 在左边查找
                    if (target < nums[mid] && target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // 右边升序
                else {
                    // 在右边查找
                    if (target >= nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                mid = (left + right) >> 1;
            }
            return -1;
        }
    }
}
