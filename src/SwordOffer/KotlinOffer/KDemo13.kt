package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    print(initLinkList(6))
    print(reverseByLoop(initLinkList(6)))
    print(reverseByRecur(initLinkList(6)))
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
 * 循环逆序
 *
 * @param root 头结点
 * @return 返回逆序后的头结点
 * */
private fun reverseByLoop(root: LinkNode?): LinkNode? {
    if (root == null) return root

    var pre = root
    var cur = root.next
    var next: LinkNode?

    // 1    2    3    4    5
    // pre  cur  next
    while (cur != null) {
        next = cur.next
        cur.next = pre
        pre = cur
        cur = next
    }
    root.next = null
    return pre
}

/**
 * 递归反转
 *
 * @param current 当前结点
 * @return 返回逆序后的头结点
 */
private fun reverseByRecur(current: LinkNode?): LinkNode? {
    // 如果current为空，或者next结点为空，就直接返回
    if (current?.next == null) return current
    // 1    2    3    4    5
    // cur  next（保存cur，next结点）
    // 1    2    3    4    5
    //      cur  next（保存cur，next结点）
    // 1    2    3    4    5
    //           cur  next（保存cur，next结点）
    // 1    2    3    4    5
    //                cur  next（保存cur，next结点）
    // 1    2    3    4    5
    //                     cur  next（保存cur，next结点）结束递归
    // 1    2    3    4    5
    //                cur  next（修改next.next = cur）
    // 1    2    3    4    5
    //           cur  next（修改next.next = cur）
    // 1    2    3    4    5
    //      cur  next（修改next.next = cur）
    // 1    2    3    4    5
    // cur  next（修改next.next = cur）
    //            1    2    3    4    5
    // cur = null next（修改next.next = cur）
    val nextNode = current.next
    // 将结点独立，解除末尾循环指向的问题
    current.next = null
    // 递归，利用递归的特性将结点逆向指回上一个结点
    val reverseRest = reverseByRecur(nextNode)
    // 让下一个结点指向前一个结点
    nextNode?.next = current
    return reverseRest
}