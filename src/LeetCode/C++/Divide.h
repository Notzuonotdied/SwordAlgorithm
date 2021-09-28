#ifndef DIVIDE_H
#define DIVIDE_H

/*
给定两个整数，被除数 dividend 和除数 divisor。
将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，
例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2




被除数和除数均为 32 位有符号整数。

除数不为 0。

假设我们的环境只能存储 32 位有符号整数，
其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。

 */

int divide(int dividend, int divisor) 
{
    int result = 0;
    bool neg1 = dividend < 0;
    bool neg2 = divisor < 0;
    bool neg = neg1 != neg2;

    // 特殊值
    if(divisor == 1) 
    { return dividend; }
    if(dividend == -2147483648 && divisor == -1)
    { return 2147483647; }
    if(divisor == -2147483648)
    { return dividend == -2147483648; }
    if(dividend == 0)
    { return 0; }

    // 全部转成负数
    if(!neg1)
    { dividend = -dividend; }

    if(!neg2)
    { divisor = -divisor; }

    // 移位的次数
    int shift_count = 0;
    if(dividend < divisor && divisor > -1073741824)
    {
        while(dividend <= divisor && divisor > -1073741824)
        {
            divisor = -((-divisor) << 1);
            ++shift_count;
        }
        // 回退一位，
        --shift_count;
        divisor = -((-divisor) >> 1);
    }

    while(shift_count > 0)
    {
        int tmp = 0;
        while(dividend <= divisor)
        {
            dividend -= divisor;
            ++tmp;
        }
        tmp <<= shift_count;
        result += tmp;
        divisor = -((-divisor) >> 1);
        --shift_count;
    }
    
    while(dividend <= divisor)
    {
        dividend -= divisor;
        ++result;
    }

    return neg ? (-result) : result;
}

#endif // DIVIDE_H
