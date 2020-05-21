# 前言

这是LeetCode上的关于动态规划的刷题记录。

 - 动态规划题集：[dynamic-programming](https://leetcode-cn.com/tag/dynamic-programming/)。

# 题目

## DP常见推导公式

| 问题 | 公式 |
| ---- | ---- |
| [三步问题](WaysToStep.java) | dp(n) = dp(n-1) + dp(n-2) |
| [打家劫舍](Rob.java) | dp(n+2) = Max(dp(n+1), dp(n)+array(n)) |
| [使用最小花费爬楼梯](MinCostClimbingStairs.java) | dp(2)=Min(dp(0)+cost(i-2), dp(1)+cost(i-1)) |
| [连续子数组的最大和](MaxSubArray.java) | Sum(1...n) |

## 题集

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [除数博弈](DivisorGame.java) |  归纳法、DP | [只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。](https://leetcode-cn.com/problems/divisor-game/) |
| [三步问题](WaysToStep.java) |  DP  | [三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。](https://leetcode-cn.com/problems/three-steps-problem-lcci/) |
| [打家劫舍](Rob.java) | 最大值 | [你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。](https://leetcode-cn.com/problems/house-robber/) |
| [使用最小花费爬楼梯](MinCostClimbingStairs.java) |  最小值 | [您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。](https://leetcode-cn.com/problems/min-cost-climbing-stairs/) |
| [连续子数组的最大和](MaxSubArray.java) | Sum | [输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/) |
| [按摩师](Massage.java) | 最大值 | [一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。](https://leetcode-cn.com/problems/the-masseuse-lcci/) |
| [最长回文子串](LongestPalindrome.java) | DP | [给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。](https://leetcode-cn.com/problems/longest-palindromic-substring/) |
| [无重复字符的最长子串](LengthOfLongestSubstring.java) | DP | [给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) |
| [买卖股票的最佳时机](MaxProfit.java) | DP入门题 | [给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) |
| [爬楼梯](ClimbStairs.java) | DP | [假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？](https://leetcode-cn.com/problems/climbing-stairs/) |
| [Nim 游戏](CanWinNim.java) |  规律题（DP会超时系列） | [编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。](https://leetcode-cn.com/problems/nim-game/) |

# 附录

 - [https://leetcode-cn.com](https://leetcode-cn.com)