package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    var node = create(start = 0, end = 10)
    print("初始化输出 -> ")
    print(node)
    print("删除后输出 -> ")
    deleteNode(node, getNode(value = 6, root = node))
    print(node)
    // 边界测试
    print("边界测试0 -> ")
    node = create(start = 0, end = 10)
    print(deleteNode(node, targetNode = node))
    print("边界测试1 -> ")
    node = create(start = 0, end = 10)
    print(deleteNode(node, targetNode = getNode(1, node)))
    print("末尾node测试 -> ")
    node = create(start = 0, end = 10)
    print(deleteNode(node, targetNode = getNode(10, node)))
}

/**
 * 创建链表
 *
 * @param start 起始结点
 * @param end 结束结点
 * @return 返回头结点
 * */
fun create(start: Int, end: Int): LinkNode {
    val root = LinkNode(233, null)
    var temp = root
    for (i in start..end) {
        val node = LinkNode(i, next = null)
        temp.next = node
        temp = node
    }
    return root
}

/**
 * 获取结点
 *
 * @param value 结点的值
 * @param root 头结点
 * @return 返回目标结点
 * */
fun getNode(value: Int, root: LinkNode?): LinkNode? {
    var temp = root
    while (temp != null) {
        if (temp.value == value) return temp
        temp = temp.next!!
    }
    return temp
}

/**
 * 输出链表
 *
 * @param root 头结点
 * */
fun print(root: LinkNode?) {
    var temp = root
    while (temp != null) {
        print(temp.value)
        print(" ")
        temp = temp.next
    }
    println()
}

class LinkNode(var value: Int, var next: LinkNode?)

/**
 * 删除结点
 *
 * @param root 头结点
 * @param targetNode 目标结点
 * @return 头结点
 * */
fun deleteNode(root: LinkNode, targetNode: LinkNode?): LinkNode? {
    // 如果为空，直接返回根结点
    if (targetNode == null) return root

    // 如果是头结点
    if (root == targetNode) return root.next

    // 如果是最后一个结点
    if (targetNode.next == null) {
        var tempRoot = root
        while (tempRoot.next != targetNode) {
            tempRoot = tempRoot.next!!
        }
        tempRoot.next = null
    } else {
        targetNode.value = targetNode.next!!.value
        targetNode.next = targetNode.next!!.next
    }

    return root
}