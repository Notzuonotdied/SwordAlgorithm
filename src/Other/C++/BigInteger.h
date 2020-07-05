#ifndef BIG_INTEGER_H
#define BIG_INTEGER_H

#include <vector>
#include <ostream>

class BigInteger;

namespace std
{
extern BigInteger abs(const BigInteger &bi);
}

#ifndef BIG_INT_DEFAULT_SIZE
#define BIG_INT_DEFAULT_SIZE 32
#endif

#ifdef BIG_INT_DEFAULT_SIZE
#if BIG_INT_DEFAULT_SIZE < 2
#error "BIG_INT_DEFAULT_SIZE cannot less than 2"
#endif 
#endif

struct _M_BigInteger_Base
{
    _M_BigInteger_Base() : _M_data(BIG_INT_DEFAULT_SIZE) { }

    _M_BigInteger_Base(const _M_BigInteger_Base &v)
     : _M_data(v._M_data) { }

#if __cplusplus >= 201103L
    _M_BigInteger_Base(_M_BigInteger_Base &&v)
     : _M_data(BIG_INT_DEFAULT_SIZE) 
    { _M_data.swap(v._M_data); }
#endif // __cplusplus >= 201103L

    template<typename _Tp>
    _M_BigInteger_Base(const _Tp &v)
     : _M_data(BIG_INT_DEFAULT_SIZE)
    { SetValue<_Tp>(v); }

    template<typename _Tp>
    void SetValue(const _Tp &v)
    {
        _M_data[0] = static_cast<char>(v < 0);
        _Tp tmp = std::abs(v);
        std::size_t index = 1;
        while(tmp > 0)
        {
            _M_data[index++] = tmp % 10;
            tmp /= 10;
        }
    }

    void Copy(const _M_BigInteger_Base &v)
    { _M_data = v._M_data; }

    void Swap(_M_BigInteger_Base &v)
    { v._M_data.swap(_M_data); }

    // 符号，非负数——false，负数——true
    bool Symbol() const 
    { return _M_data[0] != 0; }

    char& Symbol()
    { return _M_data[0]; }

    bool LessThan(const _M_BigInteger_Base &v) const;

    bool GreaterThan(const _M_BigInteger_Base &v) const;

    bool EqualTo(const _M_BigInteger_Base &v) const;

    std::vector<char> _M_data; // 0-符号位（负数为1），1-个位数，2-十位数。。。。
};

struct _M_BigInteger_Add_Impl
{
    void Add(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2);

    _M_BigInteger_Base Add(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const;

    void operator()(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
    { Add(v1, v2); }

    _M_BigInteger_Base operator()(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
    { return Add(v1, v2); }
};

struct _M_BigInteger_Sub_Impl
{
    void Sub(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2);

    _M_BigInteger_Base Sub(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const;

    void operator()(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
    { Sub(v1, v2); }

    _M_BigInteger_Base operator()(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
    { return Sub(v1, v2); }
};

struct _M_BigInteger_Mul_Impl
{
    void Mul(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2);

    _M_BigInteger_Base Mul(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const;

    void operator()(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
    { Mul(v1, v2); }

    _M_BigInteger_Base operator()(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
    { return Mul(v1, v2); }
};

struct _M_BigInteger_Div_Impl
{
    void Div(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2);

    _M_BigInteger_Base Div(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const;

    void operator()(_M_BigInteger_Base &v1, const _M_BigInteger_Base &v2)
    { Div(v1, v2); }

    _M_BigInteger_Base operator()(const _M_BigInteger_Base &v1, const _M_BigInteger_Base &v2) const
    { return Div(v1, v2); }
};

class BigInteger
 : private _M_BigInteger_Base,
 private _M_BigInteger_Add_Impl,
 private _M_BigInteger_Sub_Impl,
 private _M_BigInteger_Mul_Impl,
 private _M_BigInteger_Div_Impl
{
public:
    BigInteger() : _M_BigInteger_Base() { }
    BigInteger(const BigInteger &bi) : _M_BigInteger_Base(bi) { }
    template<typename _Tp>
    BigInteger(const _Tp &v) : _M_BigInteger_Base(v) { }
#if __cplusplus >= 201103L
    BigInteger(BigInteger &&bi) : _M_BigInteger_Base(std::move(bi)) { }
#endif // __cplusplus >= 201103L

    BigInteger operator=(long long v)
    { SetValue<long long>(v); }
    BigInteger operator=(float v)
    { return *this = static_cast<long long>(v); }
    BigInteger operator=(double v)
    { return *this = static_cast<long long>(v); }
    BigInteger operator=(unsigned long long v)
    { SetValue<unsigned long long>(v); }
    BigInteger operator=(const BigInteger &v);
#if __cplusplus >= 201103L
    BigInteger operator=(BigInteger &&v);
#endif // __cplusplus >= 201103L

    bool operator==(long long v) const
    { return *this == BigInteger(v); }
    bool operator==(float v) const
    { return v == static_cast<long long>(v) && *this == BigInteger(static_cast<long long>(v)); }
    bool operator==(double v) const
    { return v == static_cast<long long>(v) && *this == BigInteger(static_cast<long long>(v)); }
    bool operator==(unsigned long long v) const
    { return *this == BigInteger(v); }
    bool operator==(const BigInteger &v) const
    { return EqualTo(v); }

    bool operator>(long long v) const
    { return *this > BigInteger(v); }
    bool operator>(float v) const
    { return *this > BigInteger(static_cast<long long>(v)); }
    bool operator>(double v) const
    { return *this > BigInteger(static_cast<long long>(v)); }
    bool operator>(unsigned long long v) const
    { return *this > BigInteger(v); }
    bool operator>(const BigInteger &v) const
    { return GreaterThan(v); }

    bool operator>=(long long v) const
    { return *this >= BigInteger(v); }
    bool operator>=(float v) const
    { return *this >= BigInteger(static_cast<long long>(v)); }
    bool operator>=(double v) const
    { return *this >= BigInteger(static_cast<long long>(v)); }
    bool operator>=(unsigned long long v) const
    { return *this >= BigInteger(v); }
    bool operator>=(const BigInteger &v) const
    { return !LessThan(v); }

    bool operator<(long long v) const
    { return *this < BigInteger(v); }
    bool operator<(float v) const
    { return *this < BigInteger(static_cast<long long>(v)); }
    bool operator<(double v) const
    { return *this < BigInteger(static_cast<long long>(v)); }
    bool operator<(unsigned long long v) const
    { return *this < BigInteger(v); }
    bool operator<(const BigInteger &v) const
    { return LessThan(v); }

    bool operator<=(long long v) const
    { return *this <= BigInteger(v); }
    bool operator<=(float v) const
    { return *this <= BigInteger(static_cast<long long>(v)); }
    bool operator<=(double v) const
    { return *this <= BigInteger(static_cast<long long>(v)); }
    bool operator<=(unsigned long long v) const
    { return *this <= BigInteger(v); }
    bool operator<=(const BigInteger &v) const
    { return !GreaterThan(v); }

    BigInteger operator/(long long v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(unsigned long long v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(const BigInteger &v) const
    { return _M_BigInteger_Div_Impl::Div(*this, v); }

    BigInteger& operator/=(long long v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(unsigned long long v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(const BigInteger &v)
    { 
        _M_BigInteger_Div_Impl::Div(*this, v); 
        return *this;
    }

    BigInteger operator*(long long v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(unsigned long long v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(const BigInteger &v) const
    { return _M_BigInteger_Mul_Impl::Mul(*this, v); }

    BigInteger& operator*=(long long v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(unsigned long long v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(const BigInteger &v)
    { 
        _M_BigInteger_Mul_Impl::Mul(*this, v); 
        return *this;
    }

    BigInteger operator-(long long v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(unsigned long long v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(const BigInteger &v) const
    { return _M_BigInteger_Sub_Impl::Sub(*this, v); }

    BigInteger& operator-=(long long v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(unsigned long long v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(const BigInteger &v)
    { 
        _M_BigInteger_Sub_Impl::Sub(*this, v); 
        return *this;
    }

    BigInteger operator+(long long v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(unsigned long long v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(const BigInteger &v) const
    { return _M_BigInteger_Add_Impl::Add(*this, v); }

    BigInteger& operator+=(long long v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(unsigned long long v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(const BigInteger &v)
    { 
        _M_BigInteger_Add_Impl::Add(*this, v); 
        return *this;
    }

    void Swap(BigInteger &bi)
    { _M_BigInteger_Base::Swap(bi); }

    BigInteger abs() const;

    friend std::ostream& operator<<(std::ostream &os, const BigInteger &bi);
    friend BigInteger operator-(long long i, const BigInteger &bi)
    { return BigInteger(i) - bi; }
};

#endif // BIG_INTEGER_H