#ifndef RSA_H
#define RSA_H

#include <cmath>

#if __cplusplus < 201103L
#error "please support C++11"
#endif 

namespace rsa
{

// 求两数的最大公约数（更相减损法）
template<typename _Tp>
constexpr _Tp GCD(const _Tp &v1, const _Tp &v2)
{
    _Tp t1 = v1, t2 = v2, t;
    while(true)
    {
        if(t1 < t2)
        {
            t = std::move(t1);
            t1 = std::move(t2);
            t2 = std::move(t);
        }
        t = t1 - t2;
        if(t == t1 || t == t2)
        {
            return t;
        }
        t1 = std::move(t);
    }
    return _Tp(1);
}

// 求两数的最小公倍数
template<typename _Tp> 
constexpr _Tp LCM(const _Tp &v1, const _Tp &v2)
{
    return _Tp(v1 / GCD(v1, v2) * v2);
}

/* 判断是否是素数
 * 
 * 考虑到rsa算法可能会采用大数，所以使用模板实现
 * 
 * @v  目标数
 * @return  如果是素数，返回true
 */
template<typename _Type>
constexpr bool IsPrimeNumber(const _Type &v)
{
    _Type t = v.sqrt();
    for(_Type i = 2; i < t; ++i)
    {
        if((v % i) == 0)
        {
            return false;
        }
    }
    return true;
}

template<>
constexpr bool IsPrimeNumber<int>(const int &v)
{
    int t = sqrt(v);
    for(int i = 2; i < t; ++i)
    {
        if((v % i) == 0)
        {
            return false;
        }
    }
    return true;
}

template<>
constexpr bool IsPrimeNumber<unsigned int>(const unsigned int &v)
{
    unsigned int t = sqrt(v);
    for(unsigned int i = 2; i < t; ++i)
    {
        if((v % i) == 0)
        {
            return false;
        }
    }
    return true;
}

template<>
constexpr bool IsPrimeNumber<long long>(const long long &v)
{
    long long t = sqrt(v);
    for(long long i = 2; i < t; ++i)
    {
        if((v % i) == 0)
        {
            return false;
        }
    }
    return true;
}

template<>
constexpr bool IsPrimeNumber<unsigned long long>(const unsigned long long &v)
{
    unsigned long long t = sqrt(v);
    for(unsigned long long i = 2; i < t; ++i)
    {
        if((v % i) == 0)
        {
            return false;
        }
    }
    return true;
}


template<typename _Tp>
class RSA
{
public:
    typedef _Tp ValueType;

private:
    ValueType _M_value1, _M_value2;

public:

    /*
     * 设置两个素数
     */
    bool SetPrimeNumber(const ValueType &v1, const ValueType &v2)
    {
        if(!IsPrimeNumber(v1) || !IsPrimeNumber(v2))
        {
            return false;
        }

        _M_value1 = v1;
        _M_value2 = v2;

        return true;
    }

public:
    /* 
     * 求加密钥
     * @v1和@v2是两个素数
     * 求大于@v1和@v2的第几个素数
     */
    ValueType GetEncryptingKey(unsigned index = 1)
    {
        ValueType f = (_M_value1 - 1) * (_M_value2 - 1);
        ValueType t = (_M_value1 > _M_value2 ? _M_value1 : _M_value2) + 2;
        while(index-- > 0)
        {
            while(GCD(f, t) != 1)
            {
                t += 2;
            }
        }
        return t;
    }

    /* 
     * 求解密钥
     * @e  加密钥
     * @return  解密钥
     */
    ValueType GetDecryptingKey(const ValueType &e)
    {
        ValueType k = 1;
        ValueType v = (_M_value1 - 1) * (_M_value2 - 1);
        ValueType t = k * v + 1;
        while(t % e != 1)
        {
            t = (++k) * v + 1;
        }
        return ValueType(t / e);
    }

    /*
     * 加密
     * @e  加密钥
     * @c  明文
     * @return  密文
     */
    template<typename _CharType>
    _CharType Encrypt(const ValueType &e, const _CharType &c)
    {
        ValueType v = _M_value1 * _M_value2;
        _CharType ret = c % v;
        for(ValueType i = e - 1; i > 0; --i)
        {
            ret = (ret * (c % v)) % v;
        }
        return ret;
    }

    /*
     * 解密
     * @d  解密钥
     * @c  密文
     * @return  明文
     */
    template<typename _CharType>
    _CharType Decrypt(const ValueType &d, const _CharType &c)
    {
        ValueType v = _M_value1 * _M_value2;
        _CharType ret = c % v;
        for(ValueType i = d - 1; i > 0; --i)
        {
            ret = (ret * (c % v)) % v;
        }
        return ret;
    }

};

} // namespace rsa

#include <iostream>
#include <iomanip>
// 测试代码
static void TestRSA()
{
    int a = 7, b = 11;
    rsa::RSA<int> tools;
    if(!tools.SetPrimeNumber(a, b))
    {
        std::cout << "failed to set prime number!" << std::endl;
        return;
    }

    int encrypt_key = tools.GetEncryptingKey();
    int decrypt_key = tools.GetDecryptingKey(encrypt_key);

    std::cout << "encrypt key is: " << encrypt_key << std::endl;
    std::cout << "decrypt key is: " << decrypt_key << std::endl;

    int ch = 11;

    std::cout << "origin number: " << ch << std::endl;
    std::cout << ch << " after encrypt: ";
    ch = tools.Encrypt(encrypt_key, ch);
    std::cout << ch << std::endl;
    std::cout << ch << " after decrypt: ";
    ch = tools.Decrypt(decrypt_key, ch);
    std::cout << ch << std::endl;
}

#endif // RSA_H