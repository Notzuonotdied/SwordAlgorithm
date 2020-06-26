#ifndef FIND_MEDIAN_SORTED_ARRAYS_H
#define FIND_MEDIAN_SORTED_ARRAYS_H

template<typename _RandomIterator1, 
         typename _RandomIterator2>
double FindMedianSortedArrays(_RandomIterator1 beg1, 
                              _RandomIterator1 end1, 
                              _RandomIterator2 beg2, 
                              _RandomIterator2 end2) 
{
    unsigned long long total_num = static_cast<unsigned long long>(end1 - beg1 + end2 - beg2);
    bool is_not_even = total_num & 1;
    unsigned long long target_index = total_num / 2 - 1 + is_not_even;

    _RandomIterator1 it1 = beg1;
    _RandomIterator2 it2 = beg2;
    double result = 0;

    while(it1 != end1 || it2 != end2)
    {
        if(it1 == end1)
        {
            result = *it2++;
        }
        else if(it2 == end2)
        {
            result = *it1++;
        }
        else 
        {
            result = *it1 > *it2 ? *it2++ : *it1++;
        }
        if(target_index-- == 0)
        {
            break;
        }
    }

    if(!is_not_even)
    {
        if(it1 == end1)
        {
            result = (result + *it2) / 2;
        }
        else if(it2 == end2)
        {
            result = (result + *it1) / 2;
        }
        else 
        {
            result = (result + (*it1 > *it2 ? *it2 : *it1)) / 2;
        }
    }
    return result;
}

#include <iostream>

static void TestFindMedianSortedArrays()
{
    int nums1[] = {1, 2, 8, 100};
    int nums2[] = {4, 7, 9, 99, 101};
    std::cout << FindMedianSortedArrays<int *, int *>(nums1, nums1 + sizeof(nums1) / sizeof(int), 
        nums2, nums2 + sizeof(nums2) / sizeof(int)) << std::endl;
}

#endif // FIND_MEDIAN_SORTED_ARRAYS_H