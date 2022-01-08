package LeetCode.Java.array;

public class SearchInsert {
    public static void main(String[] args) {
        test(new Solution1());
    }

    private static void test(ISearchInsert iSearchInsert) {
        // 2
        System.out.println(iSearchInsert.searchInsert(new int[]{1, 3, 5, 6}, 5));
        // 1
        System.out.println(iSearchInsert.searchInsert(new int[]{1, 3, 5, 6}, 2));
        // 4
        System.out.println(iSearchInsert.searchInsert(new int[]{1, 3, 5, 6}, 7));
        // 0
        System.out.println(iSearchInsert.searchInsert(new int[]{1, 3, 5, 6}, 0));
        // 0
        System.out.println(iSearchInsert.searchInsert(new int[]{1}, 0));
    }

    private interface ISearchInsert {
        int searchInsert(int[] nums, int target);
    }

    private static class Solution1 implements ISearchInsert {
        /**
         * 定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         * <p>
         * 请必须使用时间复杂度为 O(log n) 的算法。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/search-insert-position
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了50.22%的用户
         */
        @Override
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0 || nums[0] > target) {
                return 0;
            } else if (nums[nums.length - 1] < target) {
                return nums.length;
            }

            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }
}
