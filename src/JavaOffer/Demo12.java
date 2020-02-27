package JavaOffer;

public class Demo12 {

    public static void main(String[] args) {
        System.out.println(Power(1.1, 11));
    }

    /**
     * 解题思路：https://www.jianshu.com/p/8e81a4c8dd34
     */
    public static double Power(double base, int exponent) {
        int n = exponent;
        if (exponent == 0) {
            // 当指数为0底数为0时，没有意义，返回0或者返回1都可以
            return 1;
        } else if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            n = -exponent;
        }
        double res = PowerUnsignedExponent(base, n);
        return exponent < 0 ? 1 / res : res;
    }

    public static double PowerUnsignedExponent(double base, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base;
        //递归
        double res = PowerUnsignedExponent(base, n / 2);
        res *= res;
        if (n % 2 == 1)
            res *= base;
        return res;
    }
}
