package SwordOffer.JavaOffer;

public class Demo11 {

    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
        // 效率更高
        System.out.println(numberOfOne2(10));
    }

    /**
     * 9:0000 1001
     * 8:0000 1000
     * 7:0000 0111
     */
    public static int NumberOf1(int n) {
        // 记录数字中1的位数
        int result = 0;

        // JAVA语言规范中，int整形占四个字节，总计32位
        // 对每一个位置与1进行求与操作，再累加就可以求出当前数字的表示是多少位1
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }

        // 返回求得的结果
        return result;
    }

    /**
     * @param n 待的数字
     * @return 数字中二进制表表的1的数目
     */
    public static int numberOfOne2(int n) {
        // 记录数字中1的位数
        int result = 0;

        // 数字的二进制表示中有多少个1就进行多少次操作
        while (n != 0) {
            result++;
            // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
            // 即使是符号位也会进行操作。
            int temp = n;
            n = (n - 1) & n;
            System.out.println(temp + " & " + (temp - 1) + " = " + n);
        }

        // 返回求得的结果
        return result;
    }
}
