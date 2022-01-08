#ifndef ZCONVERT_H
#define ZCONVERT_H

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

#include <string>
#include <vector>
#include <queue>

static std::string ZConvert(const std::string &s, int numRows)
{
    std::string result;
    if(numRows == 1)
    {
        result = s;
        return result;
    }

    result.resize(s.size(), 0);
    std::size_t index = 0;

    std::vector<std::queue<char>> pos(numRows);
    int row_count = 0, add = -1;
    for(std::size_t i = 0; i < s.size(); ++i)
    {
        std::queue<char> &q = pos[row_count];
        q.push(s[i]);

        if(row_count == numRows - 1 || row_count == 0)
        {
            add = -add;
        }
        row_count += add;
    }

    std::vector<std::queue<char>>::iterator it = pos.begin();
    for(; it != pos.end(); ++it)
    {
        std::queue<char> &q = *it;
        while(!q.empty())
        {
            result[index++] = q.front();
            q.pop();
        }
    }
    
    return result;
}

#endif // ZCONVERT_H
