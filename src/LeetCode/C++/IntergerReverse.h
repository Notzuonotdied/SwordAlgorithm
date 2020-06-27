#ifndef INTERGER_REVERSE_H
#define INTERGER_REVERSE_H

/* 整数按数位反转
 * @v  输入数
 * @return  结果，不检查溢出
 */
template<typename _Tp>
_Tp reverse(const _Tp &v)
{
    _Tp input = v;
    _Tp result = 0;
    while(input != 0)
    {
        result = result * 10 + input % 10;
        input /= 10;
    }
    return result;
}

/* 整数按位反转
 * @x  输入数
 * @return  如果溢出，则返回0
 */
template<>
int reverse<int>(const int &x)
{
    long long input = x;
    long long result = 0;
    while(input != 0)
    {
        result = result * 10 + input % 10;
        input /= 10;
    } 
    if(result < static_cast<long long>(static_cast<int>(-0x7FFFFFFF)) ||
        result > 0x7FFFFFFF)
    {
        return 0;
    }
    return static_cast<int>(result);
}

#endif // INTERGER_REVERSE_H