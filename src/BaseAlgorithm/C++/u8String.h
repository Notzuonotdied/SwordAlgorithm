#ifndef U8_STRING_H
#define U8_STRING_H

#include <string>

/*
 * utf8字符串处理库
 */

namespace utf8
{

/* 判断目标utf8字符占用字节数
 * @c  目标字符，utf8字符的第一个字节
 */
extern 
#if __cplusplus >= 201103L
constexpr
#endif 
std::size_t GetByteSize(unsigned char c);

/* 获取utf8字符数
 * @s  utf8编码的字符串
 * @return  返回数量
 */
extern std::size_t GetLength(const std::string &s);

/* 截取utf8字符串
 * @s      目标串
 * @index  子串开始位置
 * @len    截取长度
 */
extern std::string SubString(const std::string &s, std::size_t index, std::size_t len);

// 反转
extern std::string Reverse(const std::string &s);

}

#endif // U8_STRING_H