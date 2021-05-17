package LeetCode.Java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}};
        System.out.println(Arrays.deepToString(new Solution1().merge(arrays)));
    }

    private static class Solution1 {

        /**
         * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
         * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/merge-intervals
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：13 ms, 在所有 Java 提交中击败了6.03% 的用户
         * 内存消耗：40.5 MB, 在所有 Java 提交中击败了98.39% 的用户
         * <p>
         * 题解：https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
         */
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
            int l, r, len;
            // 存放结果
            List<int[]> merged = new ArrayList<>(intervals.length);
            for (int[] interval : intervals) {
                l = interval[0];
                r = interval[1];
                len = merged.size();
                // 为空/超出区间
                if (len == 0 || merged.get(len - 1)[1] < l) {
                    merged.add(new int[]{l, r});
                }
                // 合并区间
                else {
                    merged.get(len - 1)[1] = Math.max(merged.get(len - 1)[1], r);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
