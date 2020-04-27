package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    // 注意：这里假设不会存在相同的value的结点，可以采用key（hashValue）-value解决。
    val preOrder = intArrayOf(1, 2, 4, 7, 3, 5, 6, 8)
    val inOrder = intArrayOf(4, 7, 2, 1, 5, 3, 8, 6)
    // 恢复二叉树
    val node = recoverBinaryTree(preOrder = preOrder, inOrder = inOrder)
    // 前序遍历
    preOrder(node)
    // 中序遍历
    inOrder(node)
    // 后序遍历
    postOrder(node)
}

/**
 * 通过二叉树的前序遍历和中序遍历重建二叉树
 *
 * @param preOrder 前序遍历序列
 * @param inOrder 中序遍历序列
 * @return 返回根结点
 * */
fun recoverBinaryTree(preOrder: IntArray, inOrder: IntArray): BinaryTreeNode? {
    // 如果preOrder和inOrder的大小为空，就直接返回
    if (preOrder.isEmpty() || inOrder.isEmpty() || preOrder.size != inOrder.size) return null

    /**
     * 重建
     *
     * @param preOrder 前序遍历序列
     * @param pStart 前序遍历序列的起始位置
     * @param pEnd 前序遍历序列的结束位置
     * @param inOrder 中序遍历序列
     * @param iStart 中序遍历序列的起始位置
     * @param iEnd 中序遍历序列的结束位置
     * @return 返回根结点
     * */
    fun recover(preOrder: IntArray, pStart: Int, pEnd: Int,
                inOrder: IntArray, iStart: Int, iEnd: Int): BinaryTreeNode? {
        // 判断临界位置，如果数组的起始位置超过结束位置，那么就直接返回了
        if (pStart > pEnd) return null
        // 根结点
        val root = preOrder[pStart]
        var inRootIndex = iStart
        while (inRootIndex <= iEnd && inOrder[inRootIndex] != root) ++inRootIndex

        // 如果查找到的index大于iEnd，那么就表明两个序列不是同一个二叉树的，抛出异常
        if (inRootIndex > iEnd) throw Exception("Error input.")

        // 创建当前的根结点，并且为结点赋值
        val node = BinaryTreeNode(root, null, null)
        // 递归重建左子树，注意：这里假设不会存在相同的value的结点，可以采用key（hashValue）-value解决。
        node.left = recover(preOrder, pStart + 1, pStart + inRootIndex - iStart,
                inOrder, iStart, inRootIndex - 1)
        // 递归重建右子树，注意：这里假设不会存在相同的value的结点，可以采用key（hashValue）-value解决。
        node.right = recover(preOrder, pStart + inRootIndex - iStart + 1, pEnd,
                inOrder, inRootIndex + 1, iEnd)

        // 返回创建的根结点
        return node
    }
    return recover(preOrder, 0, preOrder.size - 1, inOrder, 0, inOrder.size - 1)
}

/**
 * 二叉树的结点结构
 *
 * @param value 结点的值
 * @param left 左结点
 * @param right 右结点
 * */
class BinaryTreeNode(var value: Int,
                     var left: BinaryTreeNode?,
                     var right: BinaryTreeNode?)


/**
 * 前序遍历
 *
 * @param root 根结点
 * */
fun preOrder(root: BinaryTreeNode?) {
    if (root == null) {
        println("根结点为空～")
        return
    }
    val sb = StringBuilder()
    fun order(root: BinaryTreeNode) {
        sb.append(root.value).append(" ")
        if (root.left != null) order(root.left!!)
        if (root.right != null) order(root.right!!)
    }
    order(root)
    println("前序遍历的结果为：$sb")
}

/**
 * 中序遍历
 *
 * @param root 根结点
 * */
fun inOrder(root: BinaryTreeNode?) {
    if (root == null) {
        println("根结点为空～")
        return
    }
    val sb = StringBuilder()
    fun order(root: BinaryTreeNode) {
        if (root.left != null) order(root.left!!)
        sb.append(root.value).append(" ")
        if (root.right != null) order(root.right!!)
    }
    order(root)
    println("中序遍历的结果为：$sb")
}

/**
 * 后序遍历
 *
 * @param root 根结点
 * */
fun postOrder(root: BinaryTreeNode?) {
    if (root == null) {
        println("根结点为空～")
        return
    }
    val sb = StringBuilder()
    fun order(root: BinaryTreeNode) {
        if (root.left != null) order(root.left!!)
        if (root.right != null) order(root.right!!)
        sb.append(root.value).append(" ")
    }
    order(root)
    println("后序遍历的结果为：$sb")
}

