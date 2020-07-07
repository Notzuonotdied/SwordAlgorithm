#ifndef BIG_INTEGER_H
#define BIG_INTEGER_H

#include <vector>
#include <ostream>

class BigInteger;

#ifndef BIG_INT_DEFAULT_SIZE
#define BIG_INT_DEFAULT_SIZE 32
#endif

#ifdef BIG_INT_DEFAULT_SIZE
#if BIG_INT_DEFAULT_SIZE < 2
#error "BIG_INT_DEFAULT_SIZE cannot less than 2"
#endif 
#endif

namespace SYMBOL
{
    enum SYMBOL : bool
    {
        POSITIVE = 0,
        NEGATIVE = 1 
    };
}

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
    void SetValue(const _Tp &v)
    {
        _M_data[0] = v < 0 ? SYMBOL::NEGATIVE : SYMBOL::POSITIVE;
        _Tp tmp = v < 0 ? (0 - v) : v;
        std::size_t index = 1;
        while(tmp > 0)
        {
            if(index == _M_data.size())
            {
                _M_data.resize(_M_data.size() * 2);
            }
            _M_data[index++] = tmp % 10;
            tmp /= 10;
        }
    }

    void Copy(const _M_BigInteger_Base &v)
    { _M_data = v._M_data; }

    void Swap(_M_BigInteger_Base &v)
    { v._M_data.swap(_M_data); }

    // 符号，SYMBOL
    SYMBOL::SYMBOL Symbol() const 
    { return static_cast<SYMBOL::SYMBOL>(_M_data[0]); }

    SYMBOL::SYMBOL& Symbol()
    { return *reinterpret_cast<SYMBOL::SYMBOL *>(&_M_data[0]); }

    void ReverseSymbol()
    { _M_data[0] = 1 - _M_data[0]; }

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
    BigInteger(const _M_BigInteger_Base &bi) : _M_BigInteger_Base(bi) { }

#if __cplusplus >= 201103L
    BigInteger(BigInteger &&bi) : _M_BigInteger_Base(std::move(bi)) { }
    BigInteger(_M_BigInteger_Base &&bi) : _M_BigInteger_Base(std::move(bi)) { }
#endif // __cplusplus >= 201103L

    BigInteger(char v) : _M_BigInteger_Base() 
    { SetValue<char>(v); }
    BigInteger(short v) : _M_BigInteger_Base() 
    { SetValue<short>(v); }
    BigInteger(int v) : _M_BigInteger_Base() 
    { SetValue<int>(v); }
    BigInteger(long v) : _M_BigInteger_Base() 
    { SetValue<long>(v); }
    BigInteger(long long v) : _M_BigInteger_Base() 
    { SetValue<long long>(v); }
    BigInteger(unsigned char v) : _M_BigInteger_Base() 
    { SetValue<unsigned char>(v); }
    BigInteger(unsigned short v) : _M_BigInteger_Base() 
    { SetValue<unsigned short>(v); }
    BigInteger(unsigned int v) : _M_BigInteger_Base() 
    { SetValue<unsigned int>(v); }
    BigInteger(unsigned long v) : _M_BigInteger_Base() 
    { SetValue<unsigned long>(v); }
    BigInteger(unsigned long long v) : _M_BigInteger_Base() 
    { SetValue<unsigned long long>(v); }

    BigInteger& operator=(char v)
    { SetValue<char>(v); return *this; }
    BigInteger& operator=(short v)
    { SetValue<short>(v); return *this; }
    BigInteger& operator=(int v)
    { SetValue<int>(v); return *this; }
    BigInteger& operator=(long v)
    { SetValue<long>(v); return *this; }
    BigInteger& operator=(long long v)
    { SetValue<long long>(v); return *this; }
    BigInteger& operator=(float v)
    { return *this = static_cast<long long>(v); }
    BigInteger& operator=(double v)
    { return *this = static_cast<long long>(v); }
    BigInteger& operator=(unsigned char v)
    { SetValue<unsigned char>(v); return *this; }
    BigInteger& operator=(unsigned short v)
    { SetValue<unsigned short>(v); return *this; }
    BigInteger& operator=(unsigned int v)
    { SetValue<unsigned int>(v); return *this; }
    BigInteger& operator=(unsigned long v)
    { SetValue<unsigned long>(v); return *this; }
    BigInteger& operator=(unsigned long long v)
    { SetValue<unsigned long long>(v); return *this; }
    BigInteger& operator=(const BigInteger &v);
#if __cplusplus >= 201103L
    BigInteger& operator=(BigInteger &&v);
#endif // __cplusplus >= 201103L

    bool operator==(char v) const
    { return *this == BigInteger(v); }
    bool operator==(short v) const
    { return *this == BigInteger(v); }
    bool operator==(int v) const
    { return *this == BigInteger(v); }
    bool operator==(long v) const
    { return *this == BigInteger(v); }
    bool operator==(long long v) const
    { return *this == BigInteger(v); }
    bool operator==(float v) const
    { return v == static_cast<long long>(v) && *this == BigInteger(static_cast<long long>(v)); }
    bool operator==(double v) const
    { return v == static_cast<long long>(v) && *this == BigInteger(static_cast<long long>(v)); }
    bool operator==(unsigned char v) const
    { return *this == BigInteger(v); }
    bool operator==(unsigned short v) const
    { return *this == BigInteger(v); }
    bool operator==(unsigned int v) const
    { return *this == BigInteger(v); }
    bool operator==(unsigned long v) const
    { return *this == BigInteger(v); }
    bool operator==(unsigned long long v) const
    { return *this == BigInteger(v); }
    bool operator==(const BigInteger &v) const
    { return EqualTo(v); }

    bool operator>(char v) const
    { return *this > BigInteger(v); }
    bool operator>(short v) const
    { return *this > BigInteger(v); }
    bool operator>(int v) const
    { return *this > BigInteger(v); }
    bool operator>(long v) const
    { return *this > BigInteger(v); }
    bool operator>(long long v) const
    { return *this > BigInteger(v); }
    bool operator>(float v) const
    { return *this > BigInteger(static_cast<long long>(v)); }
    bool operator>(double v) const
    { return *this > BigInteger(static_cast<long long>(v)); }
    bool operator>(unsigned char v) const
    { return *this > BigInteger(v); }
    bool operator>(unsigned short v) const
    { return *this > BigInteger(v); }
    bool operator>(unsigned int v) const
    { return *this > BigInteger(v); }
    bool operator>(unsigned long v) const
    { return *this > BigInteger(v); }
    bool operator>(unsigned long long v) const
    { return *this > BigInteger(v); }
    bool operator>(const BigInteger &v) const
    { return GreaterThan(v); }

    bool operator>=(char v) const
    { return *this >= BigInteger(v); }
    bool operator>=(short v) const
    { return *this >= BigInteger(v); }
    bool operator>=(int v) const
    { return *this >= BigInteger(v); }
    bool operator>=(long v) const
    { return *this >= BigInteger(v); }
    bool operator>=(long long v) const
    { return *this >= BigInteger(v); }
    bool operator>=(float v) const
    { return *this >= BigInteger(static_cast<long long>(v)); }
    bool operator>=(double v) const
    { return *this >= BigInteger(static_cast<long long>(v)); }
    bool operator>=(unsigned char v) const
    { return *this >= BigInteger(v); }
    bool operator>=(unsigned short v) const
    { return *this >= BigInteger(v); }
    bool operator>=(unsigned int v) const
    { return *this >= BigInteger(v); }
    bool operator>=(unsigned long v) const
    { return *this >= BigInteger(v); }
    bool operator>=(unsigned long long v) const
    { return *this >= BigInteger(v); }
    bool operator>=(const BigInteger &v) const
    { return !LessThan(v); }

    bool operator<(char v) const
    { return *this < BigInteger(v); }
    bool operator<(short v) const
    { return *this < BigInteger(v); }
    bool operator<(int v) const
    { return *this < BigInteger(v); }
    bool operator<(long v) const
    { return *this < BigInteger(v); }
    bool operator<(long long v) const
    { return *this < BigInteger(v); }
    bool operator<(float v) const
    { return *this < BigInteger(static_cast<long long>(v)); }
    bool operator<(double v) const
    { return *this < BigInteger(static_cast<long long>(v)); }
    bool operator<(unsigned char v) const
    { return *this < BigInteger(v); }
    bool operator<(unsigned short v) const
    { return *this < BigInteger(v); }
    bool operator<(unsigned int v) const
    { return *this < BigInteger(v); }
    bool operator<(unsigned long v) const
    { return *this < BigInteger(v); }
    bool operator<(unsigned long long v) const
    { return *this < BigInteger(v); }
    bool operator<(const BigInteger &v) const
    { return LessThan(v); }

    bool operator<=(char v) const
    { return *this <= BigInteger(v); }
    bool operator<=(short v) const
    { return *this <= BigInteger(v); }
    bool operator<=(int v) const
    { return *this <= BigInteger(v); }
    bool operator<=(long v) const
    { return *this <= BigInteger(v); }
    bool operator<=(long long v) const
    { return *this <= BigInteger(v); }
    bool operator<=(float v) const
    { return *this <= BigInteger(static_cast<long long>(v)); }
    bool operator<=(double v) const
    { return *this <= BigInteger(static_cast<long long>(v)); }
    bool operator<=(unsigned char v) const
    { return *this <= BigInteger(v); }
    bool operator<=(unsigned short v) const
    { return *this <= BigInteger(v); }
    bool operator<=(unsigned int v) const
    { return *this <= BigInteger(v); }
    bool operator<=(unsigned long v) const
    { return *this <= BigInteger(v); }
    bool operator<=(unsigned long long v) const
    { return *this <= BigInteger(v); }
    bool operator<=(const BigInteger &v) const
    { return !GreaterThan(v); }

    BigInteger operator/(char v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(short v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(int v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(long v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(long long v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(unsigned char v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(unsigned short v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(unsigned int v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(unsigned long v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(unsigned long long v) const
    { return *this / BigInteger(v); }
    BigInteger operator/(const BigInteger &v) const
    { return _M_BigInteger_Div_Impl::Div(*this, v); }

    BigInteger& operator/=(char v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(short v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(int v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(long v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(long long v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(unsigned char v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(unsigned short v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(unsigned int v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(unsigned long v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(unsigned long long v)
    { return *this /= BigInteger(v); }
    BigInteger& operator/=(const BigInteger &v)
    { 
        _M_BigInteger_Div_Impl::Div(*this, v); 
        return *this;
    }

    BigInteger operator*(char v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(short v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(int v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(long v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(long long v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(unsigned char v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(unsigned short v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(unsigned int v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(unsigned long v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(unsigned long long v) const
    { return *this * BigInteger(v); }
    BigInteger operator*(const BigInteger &v) const
    { return _M_BigInteger_Mul_Impl::Mul(*this, v); }

    BigInteger& operator*=(char v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(short v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(int v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(long v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(long long v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(unsigned char v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(unsigned short v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(unsigned int v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(unsigned long v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(unsigned long long v)
    { return *this *= BigInteger(v); }
    BigInteger& operator*=(const BigInteger &v)
    { 
        _M_BigInteger_Mul_Impl::Mul(*this, v); 
        return *this;
    }

    BigInteger operator-(char v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(short v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(int v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(long v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(long long v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(unsigned char v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(unsigned short v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(unsigned int v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(unsigned long v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(unsigned long long v) const
    { return *this - BigInteger(v); }
    BigInteger operator-(const BigInteger &v) const
    { return _M_BigInteger_Sub_Impl::Sub(*this, v); }

    BigInteger& operator-=(char v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(short v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(int v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(long v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(long long v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(unsigned char v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(unsigned short v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(unsigned int v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(unsigned long v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(unsigned long long v)
    { return *this -= BigInteger(v); }
    BigInteger& operator-=(const BigInteger &v)
    { 
        _M_BigInteger_Sub_Impl::Sub(*this, v); 
        return *this;
    }

    BigInteger operator+(char v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(short v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(int v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(long v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(long long v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(unsigned char v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(unsigned short v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(unsigned int v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(unsigned long v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(unsigned long long v) const
    { return *this + BigInteger(v); }
    BigInteger operator+(const BigInteger &v) const
    { return _M_BigInteger_Add_Impl::Add(*this, v); }

    BigInteger& operator+=(char v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(short v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(int v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(long v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(long long v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(unsigned char v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(unsigned short v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(unsigned int v)
    { return *this += BigInteger(v); }
    BigInteger& operator+=(unsigned long v)
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