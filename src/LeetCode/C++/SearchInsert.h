#ifndef SEARCH_INSERT_H
#define SEARCH_INSERT_H

template<typename _RandomIterator,
         typename _ValueType>
_RandomIterator SearchInsert(_RandomIterator beg, _RandomIterator end, _ValueType target) 
{
    _RandomIterator a = beg, b = end - 1;
    _RandomIterator mid;

    while(*a < target && *b > target)
    {
        mid = (a + b) / 2;
        
        if(*mid == target)
        {
            return mid;
        } 
        if(*mid < target)
        {
            a = ++mid;
        }
        else 
        {
            b = --mid;
        }
    }

    if(*b == target)
    {
        return b;
    }
    if(*b < target)
    {
        return b + 1;
    }
    if(*a < target)
    {
        return a + 1;
    }

    return a;
}

#include <iostream>
static void SearchInsert()
{
    int v[]{1, 3, 5, 6};
    
    std::cout << SearchInsert<int *, int>(v, v + sizeof(v) / sizeof(v[0]), 2) - v << std::endl;
    std::cout << SearchInsert<int *, int>(v, v + sizeof(v) / sizeof(v[0]), 5) - v << std::endl;
    std::cout << SearchInsert<int *, int>(v, v + sizeof(v) / sizeof(v[0]), 6) - v << std::endl;
    std::cout << SearchInsert<int *, int>(v, v + sizeof(v) / sizeof(v[0]), 0) - v << std::endl;
}

#endif // SEARCH_INSERT_H