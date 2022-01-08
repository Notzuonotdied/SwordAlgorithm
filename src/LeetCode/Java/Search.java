package LeetCode.Java;

public class Search {
    public static void main(String[] args) {
        test(new Solution1());
    }

    private static void test(ISolution solution) {
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{5, 1, 3}, 5));
    }

    private interface ISolution {
        int search(int[] nums, int target);
    }

    private static class Solution1 implements ISolution {
        /**
         * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
         * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
         * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
         * 你可以假设数组中不存在重复的元素。
         * 你的算法时间复杂度必须是 O(log n) 级别。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：37.4 MB, 在所有 Java 提交中击败了96.39% 的用户
         */
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int start = 0, end = nums.length - 1;
            int mid = (start + end) >> 1;
            while (start <= end) {
                if (nums[mid] == target) {
                    return mid;
                }
                // 左边升序
                if (nums[start] <= nums[mid]) {
                    // 在左边查找（通过有序的部分来判断）
                    if (nums[start] <= target && target < nums[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                // 右边升序
                else {
                    // 在右边查找（通过有序的部分来判断）
                    if (nums[mid] <= target && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                mid = (start + end) >> 1;
            }
            return -1;
        }
    }
}
