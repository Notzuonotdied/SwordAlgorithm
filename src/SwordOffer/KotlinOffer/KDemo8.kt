package SwordOffer.KotlinOffer

fun main(args: Array<String>) {
    println(countOne(9))
    println(countOne2(9))
}

fun countOne(what: Int): Int {
    var count = 0
    var temp = what

    while (temp != 0) {
        ++count
        // 9 & 8 = 1001 & 1000 = 1000 = 8 不为0，
        // 8 & 7 = 1000 & 0111 = 0
        // 刚好两个
        temp = (temp - 1) and temp
    }

    return count
}

fun countOne2(what: Int): Int {
    var count = 0
    var temp = what

    // 因为Kotlin的Int类型的长度为4字节，总共32位
    for (i in 0..32) {
        // 与1相与，统计为1的个数
        count += temp and 1
        // 无符号右移
        temp = temp ushr 1
    }

    return count
}