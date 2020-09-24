#ifndef THREE_SUM_H
#define THREE_SUM_H

/*
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

#include <vector>
#include <algorithm>

static std::vector<std::vector<int>> ThreeSum(std::vector<int> &nums)
{
    std::sort(nums.begin(), nums.end());

    std::vector<std::vector<int>> result;
    for(unsigned i = 0; i < nums.size(); )
    {
        unsigned j = i + 1, k = nums.size() - 1;
        while(j < k)
        {
            int sum = nums[i] + nums[j] + nums[k];
            if(sum == 0)
            {
                result.push_back({nums[i], nums[j], nums[k]});
                while(++j < nums.size() && nums[j] == nums[j - 1]);
                while(j < --k && nums[k] == nums[k + 1]);
            }
            j += sum < 0;
            k -= sum > 0;
        }
        while(++i < nums.size() && nums[i] == nums[i - 1]);
    }
    return result;
}

#endif // THREE_SUM_H
