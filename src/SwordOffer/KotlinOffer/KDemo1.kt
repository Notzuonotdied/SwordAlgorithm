package SwordOffer.KotlinOffer

import java.util.*

/**
 * 查找二维数组中的元素
 *
 * @param args 待查询的数组
 * @param what 查询的数字
 * */
fun find(args: Array<Array<Int>>, what: Int): Boolean {
    // 如果数组为空，就直接返回
    if (args.isEmpty()) return false
    // 遍历行
    args.forEach { array ->
        run {
            when {
            // 判断最后一个元素是否大于what
                array[array.size - 1] > what -> {
                    // 遍历当前行元素
                    array.forEach { temp ->
                        if (temp == what) {
                            print("找到了，查询的值->$what\n")
                            return true
                        }
                    }
                }
                array[array.size - 1] == what -> {
                    print("找到了，查询的值->$what\n")
                    return true
                }
            }
        }
    }
    return false
}

fun main(args: Array<String>) {
    val lines = 10
    val columns = 10
    // 初始化二维数组，全部填充为0
    val test: Array<Array<Int>> = Array(lines, { Array(columns) { 0 } })
    // 开始赋值
    for (line in 1..lines) {
        for (column in 1..columns) {
            test[line - 1][column - 1] = (line - 1) * columns + column
        }
    }
    // 查看初始化的内容
    test.forEach { temp ->
        run {
            temp.forEach { result ->
                print(result)
                print("\t")
            }
            print("\n")
        }
    }
    // 查找
    if (find(test, Random().nextInt(lines * columns))) print("找到了")
    else print("没有找到")
}