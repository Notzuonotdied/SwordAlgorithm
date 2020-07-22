#ifndef LONGEST_VALID_PARENTHESES
#define LONGEST_VALID_PARENTHESES

#include <string>
#include <stack>
#include <vector>
/*
 * 求最长有效括号字串
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
static int LongestValidParentheses(const std::string &str)
{
    std::vector<bool> v(str.size(), false);
    std::stack<long> s;

    for(long i = 0; static_cast<std::size_t>(i) < str.size(); ++i)
    {
        if(str[i] == ')')
        {
            if(!s.empty())
            {
                v[s.top()] = v[i] = true;
                s.pop();
            }
        }
        else if(str[i] == '(')
        {
            s.push(i);
        }
    }

    long len = 0, len_backup = 0;

    for(long i = 0; static_cast<std::size_t>(i) < v.size(); ++i)
    {
        if(v[i])
        {
            ++len;
        }
        else
        {
            len_backup = std::max(len_backup, len);
            len = 0;
        }
    }

    return std::max(len_backup, len);
}

#endif // LONGEST_VALID_PARENTHESES