package BaseAlgorithm.Kotlin

fun main(args: Array<String>) {
    sort(arrayOf(9, 18, 7, 36, 95, 24, 31, 72, 1))
}

/**
 * 归并排序
 *
 * @param array 代排序的数组
 * */
private fun sort(array: Array<Int>) {
    // 初始化一个大小为array.size的空数组
    val temp = Array(array.size, { 0 })
    println(array.toList())
    // 开始排序
    sort(array, 0, array.size - 1, temp)
    println(temp.toList())
}

/**
 * 归并排序——分离
 *
 * @param array 代排序的数组
 * @param left  左下标
 * @param right 右下标
 * @param temp  存放每次排序后的数组
 * */
private fun sort(array: Array<Int>, left: Int, right: Int, temp: Array<Int>) {
    if (left < right) {
        val mid = (left + right) / 2
        // 对左边的进行排序
        sort(array, left, mid, temp)
        // 对右边的进行排序
        sort(array, mid + 1, right, temp)
        // 对排序后的数组进行合并
        merge(array, left, mid, right, temp)
    }
}

/**
 * 归并排序——合并
 *
 * @param array 代排序的数组
 * @param left  左下标
 * @param mid   中间下标
 * @param right 右下标
 * @param temp  存放每次排序后的数组
 * */
private fun merge(array: Array<Int>, left: Int, mid: Int, right: Int, temp: Array<Int>) {
    var i = left
    // j默认从中间的右边地一个元素
    var j = mid + 1
    var t = 0

    // 将左边和右边的排序好的数组依次复制到temp数组中
    while (i <= mid && j <= right) {
        if (array[i] <= array[j]) temp[t++] = array[i++]
        else temp[t++] = array[j++]
    }

    // 将左边剩余的元素复制到temp数组中
    while (i <= mid) temp[t++] = array[i++]
    // 将右边剩余的元素复制到temp数组中
    while (j <= right) temp[t++] = array[j++]

    // 将数组从temp中复制到array
    t = 0
    i = left
    while (i <= right) array[i++] = temp[t++]
}