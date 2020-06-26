#ifndef BIG_INTEGER_H
#define BIG_INTEGER_H

#include <vector>
#include <string.h>
#include <ostream>
#include <bitset>

class BigInteger
{
private:
    std::vector<char> _M_data; // 0-个位数，1-十位数。。。。最高位-符号位（负数为1）

private:
    template<typename _Tp>
    void SetValue(const _Tp &v)
    {
        memset(_M_data.data(), 0, _M_data.size());
    }

public:
    BigInteger() : _M_data(16) { }
    BigInteger(const BigInteger &bi) : _M_data(bi._M_data) { }

    template<typename _Tp>
    BigInteger(const _Tp &v)
     : _M_data(16)
    {
        SetValue<_Tp>(v);
    }

#if __cplusplus >= 201103L
    BigInteger(BigInteger &&bi) : _M_data(std::move(bi._M_data)) { }
#endif // __cplusplus >= 201103L

    BigInteger operator=(char v)
    { SetValue<char>(v); }
    BigInteger operator=(short v)
    { SetValue<short>(v); }
    BigInteger operator=(int v)
    { SetValue<int>(v); }
    BigInteger operator=(long v)
    { SetValue<long>(v); }
    BigInteger operator=(long long v)
    { SetValue<long long>(v); }

    BigInteger operator=(unsigned char v)
    { SetValue<unsigned char>(v); }
    BigInteger operator=(unsigned short v)
    { SetValue<unsigned short>(v); }
    BigInteger operator=(unsigned int v)
    { SetValue<unsigned int>(v); }
    BigInteger operator=(unsigned long v)
    { SetValue<unsigned long>(v); }
    BigInteger operator=(unsigned long long v)
    { SetValue<unsigned long long>(v); }

    BigInteger operator/(int v) const 
    {
        BigInteger bi(*this);
    }

    void swap(BigInteger &bi)
    { _M_data.swap(bi._M_data); }

    friend std::ostream& operator<<(std::ostream &oss, const BigInteger &bi) 
    {
        if(bi._M_data.empty())
        {
            return oss;
        }
        std::vector<char>::const_iterator end = bi._M_data.end()--;
        if(*end != 0)
        {
            oss << '-';
        }
        std::vector<char>::const_iterator it = bi._M_data.begin();
        while(it != end && *it++ == 0);
        if(it == end)
        {
            oss << '0';
        }
        while(it != end)
        {
            oss << *it++ + '0';
        }
        return oss;
    }
};


#endif // BIG_INTEGER_H