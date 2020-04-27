package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    val length = 16
    val root = initLinkList(length)
    print(root)
    // index比链表长度小
    var postIndex = 5
    println("倒数第${postIndex}个的值为：${printLastKthNode(root, postIndex)?.value}")
    // index比链表长度大
    postIndex = length + 1
    println("倒数第${postIndex}个的值为：${printLastKthNode(root, postIndex)?.value}")

    // 测试边界
    println("××××××测试一个结点的情况××××××")
    val root1 = LinkNode(0, null)
    // 一个元素
    println("倒数第${1}个的值为：${printLastKthNode(root1, 1)?.value}")
    println("倒数第${2}个的值为：${printLastKthNode(root1, 2)?.value}")
    // 零个元素
    println("××××××测试零个结点的情况××××××")
    println("倒数第${1}个的值为：${printLastKthNode(null, 1)?.value}")
    println("倒数第${2}个的值为：${printLastKthNode(null, 2)?.value}")

}

/**
 * 初始化单链表
 *
 * @return 返回单链表
 * */
private fun initLinkList(length: Int): LinkNode? {
    val root = LinkNode(0, null)
    var temp: LinkNode = root
    for (i in 1..(length - 1)) {
        temp.next = LinkNode(i, null)
        temp = temp.next!!
    }
    return root
}

/**
 * 输出倒数第K个结点
 *
 * @param root 头结点
 * @param k 倒数第几个结点的索引值
 * @return 返回倒数第K个结点
 * */
fun printLastKthNode(root: LinkNode?, k: Int): LinkNode? {
    // 如果k的值等于0，就直接抛出异常
    if (k == 0) throw Exception("请输入大于0的数字k")
    // 如果头结点为空，就直接返回root
    if (root == null) return root

    // 初始化遍历的head索引
    var head = root
    // head先遍历k个结点，保持head和
    for (i in 0..(k - 1)) {
        // 不为空就往下走，为空就直接返回null
        if (head != null) {
            head = head.next
        } else return null
    }
    // 遍历直到head为null，找到倒数第k个结点
    var last = root
    while (head != null) {
        head = head.next
        last = last?.next
    }

    return last
}