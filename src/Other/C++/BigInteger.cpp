#include "BigInteger.h"
#include <cstring>

static bool IsZero(const char *c, std::size_t len)
{
    std::size_t count = len / sizeof(unsigned long long);
    while(count-- > 0)
    {
        if(*reinterpret_cast<const unsigned long long *>(c) != 0)
        {
            return false;
        }
        c += sizeof(unsigned long long);
    }

    count = len % sizeof(unsigned long long);
    while(count-- > 0)
    {
        if(*c++ != 0)
        {
            return false;
        }
    }

    return true;
}

bool _M_BigInteger_Base::LessThan(const _M_BigInteger_Base &v) const
{
    if(Symbol() == SYMBOL::NEGATIVE && v.Symbol() == SYMBOL::POSITIVE)
    {
        return false;
    }
    else if(v.Symbol() == SYMBOL::POSITIVE && Symbol() == SYMBOL::NEGATIVE)
    {
        return true;
    }

    const char *str1 = _M_data.data(), *str2 = v._M_data.data();
    std::size_t len1 = _M_data.size(), len2 = v._M_data.size();
    std::size_t len = len1 > len2 ? len2 : len1;

    if(!IsZero(str1 + len, len1 - len))
    {
        return false;
    }

    if(!IsZero(str2 + len, len2 - len))
    {
        return true;
    }

    while(len-- > 1)
    {
        if(str1[len] >= str2[len])
        {
            return false;
        }
    }

    return true;
}

bool _M_BigInteger_Base::GreaterThan(const _M_BigInteger_Base &v) const
{
    if(Symbol() == SYMBOL::NEGATIVE && v.Symbol() == SYMBOL::POSITIVE)
    {
        return true;
    }
    else if(v.Symbol() == SYMBOL::NEGATIVE && Symbol() == SYMBOL::POSITIVE)
    {
        return false;
    }

    const char *str1 = _M_data.data(), *str2 = v._M_data.data();
    std::size_t len1 = _M_data.size(), len2 = v._M_data.size();
    std::size_t len = len1 > len2 ? len2 : len1;

    if(!IsZero(str1 + len, len1 - len))
    {
        return true;
    }

    if(!IsZero(str2 + len, len2 - len))
    {
        return false;
    }

    while(len-- > 1)
    {
        if(str1[len] <= str2[len])
        {
            return false;
        }
    }

    return true;
}

bool _M_BigInteger_Base::EqualTo(const _M_BigInteger_Base &v) const
{
    const char *str1 = _M_data.data(), *str2 = v._M_data.data();
    std::size_t len = _M_data.size() > v._M_data.size() ? _M_data.size() : v._M_data.size();
    
    std::size_t count = len / 8;
    while(count-- > 0)
    {
        if(*reinterpret_cast<const unsigned long long *>(str1) != *reinterpret_cast<const unsigned long long *>(str2))
        {
            return false;
        }
        str1 += 8;
        str2 += 8;
    }

    count = len % 8;
    while(count-- > 0)
    {
        if(*str1++ != *str2++)
        {
            return false;
        }
    }

    if(!IsZero(str1, _M_data.size() - len) || !IsZero(str2, v._M_data.size() - len))
    {
        return false;
    }

    return true;
}

std::ostream& operator<<(std::ostream &os, const BigInteger &bi) 
{
    std::vector<char>::const_iterator end = bi._M_data.end()--;
    if(*end != 0)
    {
        os << '-';
    }
    std::vector<char>::const_iterator it = bi._M_data.begin();
    while(it != end && *it++ == 0);
    if(it == end)
    {
        os << '0';
    }
    while(it != end)
    {
        os << *it++ + '0';
    }
    return os;
}

BigInteger BigInteger::abs() const
{
    BigInteger result(*this);
    result.Symbol() = SYMBOL::POSITIVE;
    return result;
}

BigInteger& BigInteger::operator=(const BigInteger &v)
{
    Copy(v);
    return *this;
}

#if __cplusplus >= 201103L
BigInteger& BigInteger::operator=(BigInteger &&v)
{
    Swap(v);
    return *this;
}
#endif // __cplusplus >= 201103L

/***************************************
 *************** 运算符实现 *************
 ***************************************/

// 两数相加
void _M_BigInteger_Add_Impl::Add(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
{
    if(v1.Symbol() == SYMBOL::NEGATIVE && v2.Symbol() == SYMBOL::POSITIVE)
    {
        _M_BigInteger_Sub_Impl()(v1, v2);
        return;
    }
    if(v1.Symbol() == SYMBOL::POSITIVE && v2.Symbol() == SYMBOL::NEGATIVE)
    {
        _M_BigInteger_Base v = _M_BigInteger_Sub_Impl()(v2, v1);
        v1.Swap(v);
        return;
    }

    std::size_t index = 1;
    char *num1 = v1._M_data.data(), *end1 = num1 + v1._M_data.size();
    const char *num2 = v2._M_data.data() + 1, *end2 = num2 + v2._M_data.size();

    char c = 0, v;
    while(num1 + index < end1 || num2 < end2)
    {
        v = 0;
        if(num1 + index < end1)
        {
            v += *(num1 + index);
        }
        if(num2 < end2)
        {
            v += *num2++;
        }
        v += c;

        if(num1 + index == end1)
        {
            v1._M_data.resize(v1._M_data.size() * 2);
            num1 = v1._M_data.data();
            end1 = num1 + v1._M_data.size();
        }

        *(num1 + index++) = v % 10;
        c = v / 10;
    }

    if(c != 0)
    {
        if(num1 + index == end1)
        {
            v1._M_data.resize(v1._M_data.size() * 2);
            num1 = v1._M_data.data();
        }

        *(num1 + index) = c;
    }
}

_M_BigInteger_Base _M_BigInteger_Add_Impl::Add(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
{
    _M_BigInteger_Base v(v1);
    const_cast<_M_BigInteger_Add_Impl *>(this)->Add(v, v2);
    return v;
}

// 两数相减
void _M_BigInteger_Sub_Impl::Sub(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
{
    if(v1.Symbol() == SYMBOL::POSITIVE && v2.Symbol() == SYMBOL::NEGATIVE)
    {
        _M_BigInteger_Add_Impl()(v1, v2);
        return;
    }

    if(v1.Symbol() == SYMBOL::NEGATIVE && v2.Symbol() == SYMBOL::POSITIVE)
    {
        _M_BigInteger_Base v = _M_BigInteger_Add_Impl()(v2, v1);
        v1.Swap(v);
        return;
    }

    if((v1.Symbol() == SYMBOL::NEGATIVE) ^ v1.LessThan(v2))
    {
        _M_BigInteger_Base v(v2);
        Sub(v, v1);
        v.Swap(v1);
        v1.ReverseSymbol();
        return;
    }

    // 这里保证了v1不小于v2
    char *num1 = v1._M_data.data(), *end1 = num1 + v1._M_data.size();
    const char *num2 = v2._M_data.data() + 1, *end2 = num2 + v2._M_data.size();

    char c = 0;
    while(num2 < end2)
    {
        if(*num1 - c < *num2)
        {
            *num1 = 10 + *num1 - *num2;
            c = 1;
        }
        else 
        {
            *num1 -= *num2;
        }

        if(++num1 >= end1)
        {
            break;
        }
        ++num2;
    }

    *num1 -= c;
}

_M_BigInteger_Base _M_BigInteger_Sub_Impl::Sub(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
{
    _M_BigInteger_Base v(v1);
    const_cast<_M_BigInteger_Sub_Impl *>(this)->Sub(v, v2);
    return v;
}

void _M_BigInteger_Mul_Impl::Mul(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
{

}

_M_BigInteger_Base _M_BigInteger_Mul_Impl::Mul(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
{
    _M_BigInteger_Base v(v1);
    const_cast<_M_BigInteger_Mul_Impl *>(this)->Mul(v, v2);
    return v;
}

void _M_BigInteger_Div_Impl::Div(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
{

}

_M_BigInteger_Base _M_BigInteger_Div_Impl::Div(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
{
    _M_BigInteger_Base v(v1);
    const_cast<_M_BigInteger_Div_Impl *>(this)->Div(v, v2);
    return v;
}
