package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    println(findMin(intArrayOf(3, 4, 5, 1, 2)))
}

/**
 * 查找旋转数组中的最小值
 *
 * @param array 旋转数组
 * @return 返回最小值
 * */
fun findMin(array: IntArray): Int {
    // 如果数组为空，就抛出异常
    if (array.isEmpty()) throw Exception("数组不能为空～")

    // 起始索引
    var preIndex = 0
    // 末尾索引
    var postIndex = array.size - 1
    // 中间索引
    var inIndex = preIndex

    // 旋转数组的特性，前面起始递增的部分大于后面递增的部分
    while (array[preIndex] >= array[postIndex]) {
        // 如果只有两个数据的话，就直接返回最后一个
        if (postIndex - preIndex == 1) return array[postIndex]

        // 计算中间值
        inIndex = preIndex + (postIndex - preIndex) / 2

        // 如果三个位置的值是一样的，那就没办法了，只能从头搜索到尾了
        if (array[preIndex] == array[postIndex] && array[preIndex] == array[inIndex]) {
            return array.min()!!
        }

        // 如果最小的值位于inIndex右边的话，3, 4, 5, 1, 2
        if (array[inIndex] >= array[preIndex]) preIndex = inIndex
        // 如果最小的值位于inIndex左边的话，3, 4, 5, 1, 2
        else if (array[inIndex] <= array[postIndex]) postIndex = inIndex
    }
    return array[inIndex]
}