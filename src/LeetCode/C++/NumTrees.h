#ifndef NUM_TREES_H
#define NUM_TREES_H

#if __cplusplus < 201103L
#error "please support C++11"
#endif // __cplusplus >= 201103L

#include <unordered_map>

static int NumTrees(int n, std::unordered_map<int, int> &temp)
{
    std::unordered_map<int, int>::const_iterator found = temp.find(n);
    if(found != temp.end())
    {
        return found->second;
    }

    int half = n / 2;
    
    int sum = 0;
    for(int v = 0; v < half; ++v)
    {
        sum += NumTrees(v, temp) * NumTrees(n - 1 - v, temp);
    }
    sum *= 2;
    if(n & 1)
    {
        int t = NumTrees(half, temp);
        sum += t * t;
    }
    temp[n] = sum;
    return sum; 
}

static int NumTrees(int n)
{
    std::unordered_map<int, int> temp;
    temp[0] = 1;
    temp[1] = 1;
    temp[2] = 2;
    return NumTrees(n, temp);
}

#endif // NUM_TREES_H