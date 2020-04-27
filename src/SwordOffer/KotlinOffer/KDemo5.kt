package SwordOffer.KotlinOffer

import java.util.Stack

fun main(args: Array<String>) {
    val testQueue = QueueEnhance<String>()
    testQueue.appendTail("Scala")
    testQueue.appendTail("Kotlin")
    testQueue.appendTail("Python")
    testQueue.appendTail("Ruby")
    testQueue.appendTail("C++")
    testQueue.appendTail("Java")

    while (testQueue.hasNext()) println(testQueue.deleteHead())
    // 测试栈为空异常
    testQueue.deleteHead()
}

class QueueEnhance<T> {
    private val stackForward = Stack<T>()
    private val stackReverse = Stack<T>()

    fun hasNext(): Boolean {
        return !stackForward.isEmpty() || !stackReverse.isEmpty()
    }

    fun appendTail(t: T) {
        stackReverse.add(t)
    }

    fun deleteHead(): T {
        // 先判断正向的栈是否为空，如果为空就将反向的栈pop出来放入正向的栈中
        if (stackForward.isEmpty()) {
            while (!stackReverse.isEmpty()) {
                stackForward.add(stackReverse.pop())
            }
        }

        // 如果正向的栈还是为空，就直接抛出异常
        if (stackForward.isEmpty()) throw Exception("栈为空")

        return stackForward.pop()
    }
}