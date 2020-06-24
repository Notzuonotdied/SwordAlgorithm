package LeetCode.Java.tree;

import LeetCode.Java.component.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    public static void main(String[] args) {
        // 模拟树结构
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);

        System.out.println(Solution1.pathSum(root, 8));
    }

    private static class Solution1 {

        /**
         * 解题思路
         *
         * 这道题用到了一个概念，叫前缀和。就是到达当前元素的路径上，之前所有元素的和。
         *
         * 前缀和怎么应用呢？
         *
         * 如果两个数的前缀总和是相同的，那么这些节点之间的元素总和为零。进一步扩展相同的想法，如果前缀总和currSum，
         * 在节点A和节点B处相差target，则位于节点A和节点B之间的元素之和是target。
         *
         * 因为本题中的路径是一棵树，从根往任一节点的路径上(不走回头路)，有且仅有一条路径，因为不存在环。
         * (如果存在环，前缀和就不能用了，需要改造算法)
         *
         * 抵达当前节点(即B节点)后，将前缀和累加，然后查找在前缀和上，有没有前缀和currSum-target的节点(即A节点)，
         * 存在即表示从A到B有一条路径之和满足条件的情况。结果加上满足前缀和currSum-target的节点的数量。然后递归进入左右子树。
         *
         * 左右子树遍历完成之后，回到当前层，需要把当前节点添加的前缀和去除。避免回溯之后影响上一层。
         * 因为思想是前缀和，不属于前缀的，我们就要去掉它。
         *
         * 时间复杂度：每个节点只遍历一次,O(N).
         *
         * 空间复杂度：开辟了一个hashMap,O(N).
         *
         * 作者：burning-summer
         * 链接：https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        public static int pathSum(TreeNode root, int sum) {
            // key是前缀和, value是大小为key的前缀和出现的次数
            Map<Integer, Integer> prefixSumCount = new HashMap<>();
            // 前缀和为0的一条路径
            prefixSumCount.put(0, 1);
            // 前缀和的递归回溯思路
            return recursionPathSum(root, prefixSumCount, sum, 0);
        }

        /**
         * 前缀和的递归回溯思路
         * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
         * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
         * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
         *
         * @param node           树节点
         * @param prefixSumCount 前缀和Map
         * @param target         目标值
         * @param currSum        当前路径和
         * @return 满足题意的解
         */
        private static int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
            // 1.递归终止条件
            if (node == null) {
                return 0;
            }
            // 2.本层要做的事情
            int res = 0;
            // 当前路径上的和
            currSum += node.val;

            //---核心代码
            // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
            // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
            // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
            res += prefixSumCount.getOrDefault(currSum - target, 0);
            // 更新路径上当前节点前缀和的个数
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
            //---核心代码

            // 3.进入下一层
            res += recursionPathSum(node.left, prefixSumCount, target, currSum);
            res += recursionPathSum(node.right, prefixSumCount, target, currSum);

            // 4.回到本层，恢复状态，去除当前节点的前缀和数量
            prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
            return res;
        }
    }
}
