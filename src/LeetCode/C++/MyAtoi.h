#ifndef MY_ATOI_H
#define MY_ATOI_H

#include <string>

/* 字符串转数值
 * @str  输入的字符串
 * @return  结果，不检查溢出
 */
template<typename _ResultType>
_ResultType MyAtoi(const std::string &str)
{
    _ResultType result = 0;
    bool conver_start = false; // 标记是否已开始转换
    bool is_negative = false;

    for(const char ch : str)
    {
        if(ch == ' ')
        {
            if(conver_start)
            {
                break;
            }
        }
        else if((ch > '9' || ch < '0') && ch != '-' && ch != '+')
        {
            if(conver_start)
            {
                break;
            }
            else 
            {
                return 0;
            }
        }
        else 
        {
            if(ch == '-' || ch == '+')
            {
                if(conver_start)
                {
                    break;
                }
                is_negative = ch == '-';
            }
            else 
            {
                result = result * 10 - '0' + ch;
            }
            conver_start = true;
        }
    }
    if(is_negative)
    {
        result = -result;
    }
    return result;
}

/* 字符串转int数字
 * @str  输入的字符串
 * @return  如果小于最小值，则返回最小值；如果大于最大值，则返回最大值；如果非法，则返回0
 */
template<>
int MyAtoi<int>(const std::string &str)
{
    long long result = 0;
    bool conver_start = false; // 标记是否已开始转换
    bool is_negative = false;

    for(const char ch : str)
    {
        if(ch == ' ')
        {
            if(conver_start)
            {
                break;
            }
        }
        else if((ch > '9' || ch < '0') && ch != '-' && ch != '+')
        {
            if(conver_start)
            {
                break;
            }
            else 
            {
                return 0;
            }
        }
        else 
        {
            if(ch == '-' || ch == '+')
            {
                if(conver_start)
                {
                    break;
                }
                is_negative = ch == '-';
            }
            else 
            {
                result = result * 10 - '0' + ch;
                if(is_negative && (-result) < static_cast<long long>(INT_MIN))
                {
                    return INT_MIN;
                }
                else if(!is_negative && result > INT_MAX)
                {
                    return INT_MAX;
                }
            }
            conver_start = true;
        }
    }
    if(is_negative)
    {
        result = -result;
    }
    if(result <= static_cast<long long>(int(INT_MIN)))
    {
        return INT_MIN;
    }
    if(result > INT_MAX)
    {
        return INT_MAX;
    }
    return result;
}

#include <iostream>

static void TestMyAtoi()
{
    std::cout << MyAtoi<int>("-123124") << std::endl;
    std::cout << MyAtoi<int>("541564") << std::endl;
}

#endif // MY_ATOI_H