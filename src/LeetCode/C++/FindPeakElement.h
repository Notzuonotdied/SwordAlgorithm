#include <vector>

/*
峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */

static int FindPeakElement(const std::vector<int>& nums) 
{
    int n = static_cast<int>(nums.size());
    for(int i = n - 1; i > 0; --i)
    {
        bool greater_than_before = i < 1 || nums[i] > nums[i - 1];
        bool greater_than_after = i > n - 2 || nums[i] > nums[i + 1];
        if(greater_than_before && greater_than_after)
        {
            return i;
        }
    }

    return 0;
}
