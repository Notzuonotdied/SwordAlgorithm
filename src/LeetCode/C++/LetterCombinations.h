#ifndef LETTER_COMBINATIONS_H
#define LETTER_COMBINATIONS_H

#include <vector>
#include <string>

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */

std::vector<std::string> letterCombinations(const std::string &digits) 
{
    static constexpr const char *keyboard[8] = 
    {
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    static constexpr unsigned keyboard_len[8] = 
    { 3, 3, 3, 3, 3, 4, 3, 4 };
    
    std::vector<std::string> result;
    if(digits.empty()) return result;

    std::string::const_iterator it = digits.begin();   
    
    const char *str = keyboard[*it - '2'];
    unsigned len = keyboard_len[*it - '2'];

    for(unsigned i = 0; i < len; ++i)
    {
        result.push_back(std::string(&str[i], 1));
    }

    for(++it; it != digits.end(); ++it)
    {
        str = keyboard[*it - '2'];
        len = keyboard_len[*it - '2'];

        std::vector<std::string> tmp;
        for(std::vector<std::string>::iterator rit = result.begin();
            rit != result.end(); ++rit)
        {
            for(unsigned i = 0; i < len; ++i)
            {
                tmp.push_back(*rit + str[i]);
            }
        }
        result.swap(tmp);
    }

    return result;
}


#endif // LETTER_COMBINATIONS_H