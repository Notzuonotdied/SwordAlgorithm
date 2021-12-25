package LeetCode.Java;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(new Solution1().findKthLargest(new int[]{-1, 2, 0}, 1));
    }

    private interface ISolution {
        int findKthLargest(int[] nums, int k);
    }

    private static class Solution1 implements ISolution {

        /**
         * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
         * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
         * 示例 1:
         * 输入: [3,2,1,5,6,4] 和 k = 2
         * 输出: 5
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * @see BaseAlgorithm.Java.QuickSort 利用了快排的思路
         * @see SwordOffer.JavaOffer.Demo29  利用快排找最小的第 K 个元素
         */
        public int findKthLargest(int[] nums, int k) {
            int index = 0;
            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                index = partition(nums, start, end);

                if (index == k - 1) {
                    break;
                } else if (index < k - 1) {
                    start = index + 1;
                } else {
                    end = index - 1;
                }
            }
            return nums[index];
        }

        /**
         * 对数组 nums 的子区间 [left..right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
         * 在遍历过程中保持循环不变量的定义：
         * nums[left + 1..j] < nums[left]
         * nums(j..i) >= nums[left]
         * <p>
         * 作者：liweiwei1419
         * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        private int partition(int[] nums, int start, int end) {
            int pivot = nums[start];

            while (start < end) {
                while (start < end && nums[end] <= pivot) {
                    end--;
                }
                swap(nums, start, end);
                while (start < end && nums[start] >= pivot) {
                    start++;
                }
                swap(nums, start, end);
            }
            return start;
        }

        private void swap(int[] nums, int start, int j) {
            int temp = nums[start];
            nums[start] = nums[j];
            nums[j] = temp;
        }
    }
}
