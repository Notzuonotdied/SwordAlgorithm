package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    // 测试
    printNumByLoop(3)
    printNumByLoop2(3)
    // 边界测试
    printNumByLoop(-1)
    printNumByLoop2(-1)
    printNumByLoop(0)
    printNumByLoop2(0)
}

/**
 * 使用递归的方式输出数字
 *
 * @param bits 位数
 * */
fun printNumByLoop(bits: Int) {
    if (bits < 1) throw RuntimeException("位数不能小于1")

    val array = IntArray(bits)

    /**
     * 输出数字
     *
     * @param array 数字的数组
     * */
    fun printNum(array: IntArray) {
        var index = 0 // 找第一个非零的元素
        while (index < array.size && array[index] == 0) index++
        for (i in index until array.size) print(array[i])
        if (index < array.size) println() // 换行
    }

    fun printNumByLoop(index: Int, array: IntArray) {
        if (index >= array.size) printNum(array)
        else for (i in 0..9) {
            // 初始化，从0开始初始化
            array[index] = i
            // 初始化下一位
            printNumByLoop(index + 1, array)
        }
    }

    printNumByLoop(0, array)
}

/**
 * 非递归实现
 *
 * @param bits 数字的最大位数
 */
fun printNumByLoop2(bits: Int) {
    // 输入值必须大于0
    if (bits < 1) throw RuntimeException("位数不能小于1")
    // 创建一个长度为n的数组
    val arr = IntArray(bits)
    // 为数组元素赋初始值
    for (i in arr.indices) arr[i] = 0

    /**
     * 加1
     *
     * @param arr 待加数组
     * @return 判断最高位是否有进位，如果有进位就返回true
     */
    fun addOne(arr: IntArray): Boolean {
        // 保存进位值，因为每次最低位加1
        var carry = 1
        // 数组的最高位的下标为0，最低位的下标为arr.size - 1
        var index = arr.size

        do {
            --index
            arr[index] += carry // 加上进位
            carry = arr[index] / 10 // 计算高位的进位
            arr[index] %= 10
        } while (carry != 0 && index > 0)

        // 如果index=0说明已经处理了最高位，carry>0说明最高位有进位，返回true
        return carry > 0 && index == 0
    }

    // 求结果，如果最高位没有进位就一直进行处理
    while (addOne(arr)) {
        var index = 0 // 找到非零的位置
        while (index < arr.size && arr[index] == 0) index++
        for (i in index until arr.size) print(arr[i]) // 开始输出
        if (index < arr.size) println() // 换行
    }
}
