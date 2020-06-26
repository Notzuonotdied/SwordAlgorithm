package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    print("第一个递增链表：")
    print(getFirst())
    print("第二个递增链表：")
    print(getSecond())
    print("第三个递增链表：")
    print(getThird())
    println("*****************我是万恶的分割线*****************")
    println("递增排序后结果：")
    print("循环：")
    print(mergeByLoop(getFirst(), getSecond()))
    print("递归：")
    print(mergeByRecur(getFirst(), getSecond()))
    // 测试为空的情况
    println("第一个参数为空：")
    print("循环：")
    print(mergeByLoop(null, getSecond()))
    print("递归：")
    print(mergeByRecur(null, getSecond()))
    println("第二个参数为空：")
    print("循环：")
    print(mergeByLoop(getFirst(), null))
    print("递归：")
    print(mergeByRecur(getFirst(), null))
    println("两个参数都为空：")
    print("循环：")
    print(mergeByLoop(null, null))
    print("递归：")
    print(mergeByRecur(null, null))
    // 两个链表等长
    println("递增链表等长时：")
    print("循环：")
    print(mergeByLoop(getFirst(), getThird()))
    print("递归：")
    print(mergeByRecur(getFirst(), getThird()))
}

private fun getFirst(): LinkNode? {
    return initLinkList(intArrayOf(1, 5, 9, 11, 23, 45, 66, 88, 123))
}

private fun getSecond(): LinkNode? {
    return initLinkList(intArrayOf(3, 5, 19, 26, 44, 68, 75, 108, 128, 133, 233))
}

private fun getThird(): LinkNode? {
    return initLinkList(intArrayOf(19, 26, 44, 68, 75, 108, 128, 133, 233))
}

/**
 * 初始化单链表
 *
 * @return 返回单链表
 * */
private fun initLinkList(array: IntArray): LinkNode? {
    val root = LinkNode(array[0], null)
    var temp: LinkNode = root
    for (i in 1..(array.size - 1)) {
        temp.next = LinkNode(array[i], null)
        temp = temp.next!!
    }
    return root
}


/**
 * 通过循环的方式合并两个递增排序的链表
 *
 * @param first 递增排序链表
 * @param second 递增排序链表
 * @return 合并好的递增排序链表
 * */
private fun mergeByLoop(first: LinkNode?, second: LinkNode?): LinkNode? {
    if (first == null && second == null) return null
    if (first == null) return second
    if (second == null) return first

    val root = LinkNode(0, null)
    var head = root
    var one = first
    var two = second
    while (one != null && two != null) {
        if (one.value > two.value) {
            head.next = two
            two = two.next
        } else {
            head.next = one
            one = one.next
        }
        head = head.next!!
    }

    if (one != null) head.next = one
    if (two != null) head.next = two

    return root.next
}

/**
 * 通过递归的方式合并两个递增排序的链表
 *
 * @param first 递增排序链表
 * @param second 递增排序链表
 * @return 合并好的递增排序链表
 * */
private fun mergeByRecur(first: LinkNode?, second: LinkNode?): LinkNode? {
    if (first == null && second == null) return null
    if (first == null) return second
    if (second == null) return first

    var tmp = first
    if (tmp.value < second.value) {
        tmp.next = mergeByRecur(first.next, second)
    } else {
        tmp = second
        tmp.next = mergeByRecur(first, second.next)
    }

    return tmp
}