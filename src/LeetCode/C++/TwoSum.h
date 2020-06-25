#ifndef TWO_SUM_H
#define TWO_SUM_H

#if __cplusplus >= 201103L
#include <unordered_map>
#else
#include <map>
#endif

/* 从一堆数中找到两数和为目标值的两个数
 * @out1  __out__ 结果：其中一个数在一堆数中是第几个数
 * @out2  __out__ 结果：另一个数在一堆数中是第几个数
 * @beg   __in__  输入的一堆数的开始位置
 * @end   __in__  输入的一堆数的结束位置（不包含）
 * @target __in__ 目标值
 * @return  true——存在这么两个数的和为目标值
 */
template<typename _ForwardIterator,
         typename _TargetType>
bool TwoSum(std::size_t &out1, 
            std::size_t &out2, 
            _ForwardIterator beg, 
            _ForwardIterator end, 
            _TargetType target)
{
#if __cplusplus >= 201103L
    typedef std::unordered_map<_TargetType, std::size_t> AnotherMapType;
#else
    typedef std::map<_TargetType, std::size_t> AnotherMapType;
#endif
    typedef typename AnotherMapType::iterator AnotherMapIterator;

    AnotherMapType another_num; // 希望遇到的值——已存在的另一个数的位置
    std::size_t index = 0;

    while(beg != end)
    {
        _TargetType another = target - *beg;
        AnotherMapIterator found = another_num.find(*beg);
        if(found != another_num.end())
        {
            out1 = found->second;
            out2 = index;
            return true;
        }
        another_num.insert(std::pair<_TargetType, std::size_t>(another, index++));
        ++beg;
    }

    return false;
}

#include <iostream>

static void TestTwoSum()
{
    int target = 9;
    int nums[] = {2, 7, 11, 15};
    std::size_t index1, index2;
    if(TwoSum<int *, int>(index1, index2, nums, nums + sizeof(nums) / sizeof(int), target))
    {
        std::cout << "the two num: [" << nums[index1] << ',' << nums[index2] << "]" << std::endl;
    }
    else
    {
        std::cout << "there isn't sum of two num is " << target << std::endl;
    }
}

#endif // TWO_SUM_H