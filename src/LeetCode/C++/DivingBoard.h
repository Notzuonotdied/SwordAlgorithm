#ifndef DIVING_BOARD_H
#define DIVING_BOARD_H

#include <vector>

/* 你正在使用一堆木板建造跳水板。有两种类型的木板，其中
长度较短的木板长度为shorter，长度较长的木板长度为longer。
你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。
*/

static std::vector<int> DivingBoard(int shorter, int longer, int k)
{
    std::vector<int> result;

    if(k == 0)
    {
        return result;
    }

    int tmp = shorter * k;
    result.push_back(tmp);

    if(longer == shorter)
    {
        return result;
    }

    int interval = longer - shorter;

    while(k-- > 0)
    {
        result.push_back(tmp += interval);
    }

    return result;
}

#endif // DIVING_BOARD_H