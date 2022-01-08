#ifndef THREE_SUM_CLOSEST_H
#define THREE_SUM_CLOSEST_H

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
#include <vector>
#include <algorithm>
#include <cmath>

static int ThreeSumClosest(std::vector<int> &nums, int target)
{
    std::sort(nums.begin(), nums.end());
    int min_gap = __INT_MAX__;

    for(unsigned i = 0; i < nums.size(); )
    {
        unsigned j = i + 1, k = nums.size() - 1;
        while(j < k)
        {
            int sum = nums[i] + nums[j] + nums[k];
            int temp_gap = target - sum;
            if(temp_gap == 0)
            {
                return sum;
            }
            if(std::abs(temp_gap) < std::abs(min_gap))
            {
                min_gap = temp_gap;
            }
            j += temp_gap < 0;
            k -= temp_gap > 0;
        }
        while(++i < nums.size() && nums[i] == nums[i - 1]);
    }

    return target - min_gap;
}

#endif // THREE_SUM_CLOSEST_H
