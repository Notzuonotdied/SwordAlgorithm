package JavaOffer;

public class Demo4 {

    private static StringBuilder sb;

    /**
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 中序遍历：左子树 ---> 根结点 ---> 右子树
     * 后序遍历：左子树 ---> 右子树 ---> 根结点
     * 层次遍历：只需按层次遍历即可
     *
     * 前序遍历：1, 2, 4, 7, 3, 5, 6, 8
     * 中序遍历：4, 7, 2, 1, 5, 3, 8, 6
     *
     *         R
     * 前序遍历：1, 2, 4, 7, 3, 5, 6, 8
     * 中序遍历：4, 7, 2, 1, 5, 3, 8, 6
     *                  R
     *
     *         R
     * 前序遍历：1, 2, 4, 7, 3, 5, 6, 8
     * 中序遍历：4, 7, 2, 1, 5, 3, 8, 6
     *                  R
     *
     * 找到中序遍历的1的下标为3，则前序遍历中1的左节点的部分为2, 4, 7
     *         R
     * 前序遍历：1, 2, 4, 7
     * 中序遍历：4, 7, 2, 1
     *                  R
     *             R
     *     前序遍历：2, 4, 7
     *     中序遍历：4, 7, 2
     *                   R
     *
     *         前序遍历：4, 7    4是左节点，7是右节点
     *         中序遍历：4, 7
     *
     * 前序遍历中1的右节点的部分为3, 5, 6, 8
     *
     *         R
     * 前序遍历：3, 5, 6, 8
     * 中序遍历：5, 3, 8, 6
     *            R
     *
     * */

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = construct(preOrder, inOrder);

        System.out.println("前序遍历");
        sb = new StringBuilder();
        preOrder(node);
        System.out.println(sb.toString());

        System.out.println("中序遍历");
        sb.delete(0, sb.length());
        inOrder(node);
        System.out.println(sb.toString());

        System.out.println("后序遍历");
        sb.delete(0, sb.length());
        postOrder(node);
        System.out.println(sb.toString());
    }

    private static void preOrder(TreeNode node) {
        if (node == null) return;
        sb.append(node.val).append(" ");
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }

    private static void inOrder(TreeNode node) {
        if (node == null) return;
        if (node.left != null) inOrder(node.left);
        sb.append(node.val).append(" ");
        if (node.right != null) inOrder(node.right);
    }

    private static void postOrder(TreeNode node) {
        if (node == null) return;
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.val).append(" ");
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preOrder 前序遍历
     * @param inOrder  中序遍历
     * @return 树的根结点
     */
    public static TreeNode construct(int[] preOrder, int[] inOrder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || inOrder.length < 1) {
            return null;
        }

        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preOrder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inOrder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public static TreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {

        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        // 取前序遍历的第一个数字，就是当前的根结点
        int value = preOrder[ps];
        int index = is;
        // 在中序遍历的数组中找根结点的位置
        while (index <= ie && inOrder[index] != value) {
            index++;
        }

        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        // 创建当前的根结点，并且为结点赋值
        TreeNode node = new TreeNode(value);

        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.left = construct(preOrder, ps + 1, ps + index - is, inOrder, is, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(preOrder, ps + index - is + 1, pe, inOrder, index + 1, ie);

        // 返回创建的根结点
        return node;
    }

    /**
     * 二叉树节点类
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
