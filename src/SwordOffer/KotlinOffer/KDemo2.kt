package SwordOffer.KotlinOffer

/**
 * 替换空格符号
 *
 * @param target 目标数组
 * */
fun replaceBlank(target: CharArray) {
    // 去掉占位符‘*’，计算实际的数组长度
    var targetLength = target.size
    target.forEach { char -> if (char == '*') targetLength-- }

    // 如果是空就直接返回
    if (target.isEmpty()) {
        println("空数组～")
        return
    }
    // 如果不为空就检查空字符的个数
    var blankCount = 0
    target.forEach { char -> if (char == ' ') blankCount++ }

    // 如果空格的数量为0的话，直接退出
    if (blankCount == 0) {
        println("没有空格～")
        return
    }

    // 计算替换后的最终长度
    var finalLength = blankCount * 2 + targetLength

    // 如果得出来的长度大于数组的长度，就直接返回
    if (finalLength > target.size) {
        println("越界了～")
        return
    }

    targetLength--
    finalLength--

    while (finalLength > 0 && finalLength > targetLength) {
        if (target[targetLength] == ' ') {
            target[finalLength--] = '0'
            target[finalLength--] = '2'
            target[finalLength--] = '%'
        } else {
            target[finalLength--] = target[targetLength]
        }
        targetLength--
    }
    println(target)
}

fun main(args: Array<String>) {

    /**
     * 因为数组是固定长度的，所以采用‘*’作为空位
     * */

    // 前面出现空格
    var string = " We are young!******"
    replaceBlank(string.toCharArray())
    // 中间出现空格
    string = "We are young!****"
    replaceBlank(string.toCharArray())
    // 末尾出现空格
    string = "We are young! ******"
    replaceBlank(string.toCharArray())
    // NULL
    string = ""
    replaceBlank(string.toCharArray())
    // 越界情况
    string = "We are young!  "
    replaceBlank(string.toCharArray())
    // 连续的空格
    string = "We are young!    **************"
    replaceBlank(string.toCharArray())
}