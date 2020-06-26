package SwordOffer.KotlinOffer

import java.util.Stack

/**
 * 结点
 *
 * @param value 结点的值
 * @param next 下一个结点
 * */
class ListNode(var value: Int, var next: ListNode?)

/**
 * 使用栈从后往前输出链表
 *
 * @param root 根结点
 * */
private fun printListInverselyUsingIteration(root: ListNode) {
    var rootBackup = root

    val stack = Stack<ListNode>()
    while (true) {
        if (rootBackup.next == null) {
            stack.push(rootBackup)
            break
        } else {
            stack.push(rootBackup)
            rootBackup = rootBackup.next!!
        }
    }
    println("\n栈开始输出啦～")
    var tmp: ListNode
    while (!stack.isEmpty()) {
        tmp = stack.pop()
        print("${tmp.value} ")
    }
}

/**
 * 递归从后往前输出链表
 *
 * @param root 根结点
 * */
private fun printListInverselyUsingRecursion(root: ListNode) {
    fun recursion(root: ListNode) {
        if (root.next == null) {
            println("为空——\\(≧▽≦)/~啦啦啦")
        } else {
            recursion(root.next!!)
        }
        print("${root.value} ")
    }
    recursion(root)
}

fun main(args: Array<String>) {
    var root = ListNode(0, null)
    val backupRoot: ListNode = root

    // 初始化一个链表
    for (i in 1..10) {
        root.next = ListNode(i, null)
        root = root.next!!
    }
    // 输出不为空的链表
    printListInverselyUsingRecursion(backupRoot)
    printListInverselyUsingIteration(backupRoot)
    // 输出空链表
    // Kotlin自动类型检查，不支持传递空，这里就不测试了
}