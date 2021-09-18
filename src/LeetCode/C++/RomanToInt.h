#ifndef ROMAN_TO_INT_H
#define ROMAN_TO_INT_H

#include <string>

static int Value(char v) 
{
    switch(v)
    {
    case 'I': return 1;
    case 'V': return 5;
    case 'X': return 10;
    case 'L': return 50;
    case 'C': return 100;
    case 'D': return 500;
    case 'M': return 1000;
    }
    return 0;
}

static const char * Value(const char *cur, const char *end, int &value)
{
    int v1 = Value(*cur++), v2 = 0;
    if(cur < end)
    {
        v2 = Value(*cur);
    }

    if(v1 < v2)
    {
        value = v2 - v1;
        ++cur;
    }
    else 
    {
        value = v1;
    }
    return cur;
}

int RomanToInt(const std::string &s) {
    const char *cur = s.c_str();
    const char *end = cur + s.size();

    int v = 0;
    while(cur < end)
    {
        int tmp;
        cur = Value(cur, end, tmp);
        v += tmp;
    }

    return v;
}

#endif // ROMAN_TO_INT_H
