#ifndef MY_POW_H
#define MY_POW_H

// 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）

static double MyPow(double x, int n) {
    if(n == 0 || x == 1) return 1;
    if(n == 1) return x;
    if(n == 2) return x * x;

    if(n < 0)
    {
        if(n == -2147483648)
        {
            return 1 / x / MyPow(x, 2147483647);
        }
        return 1 / MyPow(x, -n);
    }

    // 偶数
    if((n & 1) == 0)
    {
        double tmp = MyPow(x, n >> 1);
        return tmp * tmp;
    }

    double tmp = MyPow(x, n >> 1);
    return x * tmp * tmp;
}

#endif // MY_POW_H