#include "u8String.h"
#include <stack>

namespace utf8
{

#if __cplusplus >= 201103L
constexpr
#endif
static const int u8Size[] = {0x00, 0xC0, 0xE0, 0XF0, 0XF8, 0XFC};

#if __cplusplus >= 201103L
constexpr
#endif 
std::size_t GetByteSize(unsigned char c)
{
    std::size_t byte_size = 0;
    while(u8Size[byte_size] < c)
    {
        ++byte_size;
    }
    return byte_size;
}

std::size_t GetLength(const std::string &s)
{
    const char *c = s.data();
    const char *end = s.data() + s.length();
    std::size_t len = 0;

    while(c < end)
    {
        c += GetByteSize(*c);
        ++len;
    }

    return len;
}

std::string SubString(const std::string &s, std::size_t index, std::size_t len)
{
    const char *c = s.data() + index;
    const char *end = s.data() + s.length();
    std::string result;

    while(c < end)
    {
        std::size_t byte_size = GetByteSize(*c);
        result.append(c, byte_size);
        c += byte_size;

        if(--len == 0)
        {
            break;
        }
    }

    return result;
}

// 反转
std::string Reverse(const std::string &s)
{
    std::stack<const char *> tmp_char_beg;
    std::stack<std::size_t> tmp_char_size;
    std::string result;

    const char *c = s.data();
    const char *end = s.data() + s.length();

    while(c < end)
    {
        std::size_t byte_size = GetByteSize(*c);
        tmp_char_beg.push(c);
        tmp_char_size.push(byte_size);
        c += byte_size;
    }

    while(!tmp_char_size.empty())
    {
        c = tmp_char_beg.top();
        result.append(c, tmp_char_size.top());
        tmp_char_beg.pop();
        tmp_char_size.pop();
    }

    return result;
}

} // namespace utf8