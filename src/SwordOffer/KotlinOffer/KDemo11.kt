package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    val array = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    reorderOddEven(array = array)
}

/**
 * 将数组中的奇数放在前面，偶数放在后面
 *
 * @param array 带变换的数组
 * */
fun reorderOddEven(array: IntArray) {
    if (array.isEmpty()) return

    var startIndex = 0
    var endIndex = array.size - 1

    while (startIndex < endIndex) {
        // 找到偶数的位置
        while (startIndex < endIndex && array[startIndex] % 2 != 0) {
            startIndex++
        }
        // 找到奇数的位置
        while (startIndex < endIndex && array[endIndex] % 2 == 0) {
            endIndex--
        }
        val temp = array[startIndex]
        array[startIndex] = array[endIndex]
        array[endIndex] = temp
    }

    array.forEach { ele -> run { print(ele);print(" ") } }
}