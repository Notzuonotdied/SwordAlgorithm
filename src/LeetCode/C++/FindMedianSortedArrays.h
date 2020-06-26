#ifndef FIND_MEDIAN_SORTED_ARRAYS_H
#define FIND_MEDIAN_SORTED_ARRAYS_H

#include <vector>

double FindMedianSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {
    unsigned total_num = static_cast<unsigned>(nums1.size() + nums2.size());
    bool is_not_even = total_num & 1;
    unsigned target_index = total_num / 2 - 1 + is_not_even;

    std::vector<int>::const_iterator it1 = nums1.begin(), it2 = nums2.begin();
    double result = 0;

    while(it1 != nums1.end() || it2 != nums2.end())
    {
        if(it1 == nums1.end())
        {
            result = *it2++;
        }
        else if(it2 == nums2.end())
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
        if(it1 == nums1.end())
        {
            result = (result + *it2) / 2;
        }
        else if(it2 == nums2.end())
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

#endif // FIND_MEDIAN_SORTED_ARRAYS_H