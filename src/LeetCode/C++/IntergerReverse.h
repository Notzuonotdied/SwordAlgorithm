#ifndef INTERGER_REVERSE_H
#define INTERGER_REVERSE_H

/* 整数按位反转
 * @x  输入数
 * @return  如果越界，则返回0
 */
static int reverse(int x)
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