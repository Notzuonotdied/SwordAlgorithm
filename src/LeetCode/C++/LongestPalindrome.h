#ifndef LONGEST_PALINDROME_H
#define LONGEST_PALINDROME_H

#include <string>
#include <stack>
#include <vector>

// 最长回文字符串
static std::string LongestPalindrome(const std::string &str)
{
    std::vector<bool> v(str.size(), false);
    double mid = -1;

    for(long i = 1; static_cast<std::size_t>(i) < str.size(); ++i)
    {
        if(mid == -1)
        {
            if(str[i] == str[i - 1])
            {
                v[i] = v[i - 1] = true;
                mid = i + 0.5;
            }
            else if(i >= 2 && str[i] == str[i - 2])
            {
                v[i] = v[i - 1] = v[i - 2] = true;
                mid = i - 1;
            }
            continue;
        }
        std::size_t tmp = static_cast<std::size_t>(mid + mid - i);
        if(v[i] == v[tmp])
        {
            v[i] = v[tmp] = true;
        }
        else if(v[i] == v[i - 2])
        {
            
        }
    }


}

#endif // LONGEST_PALINDROME_H