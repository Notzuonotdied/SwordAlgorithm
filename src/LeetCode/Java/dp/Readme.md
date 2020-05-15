# 前言

这是LeetCode上的关于动态规划的刷题记录。

 - 动态规划题集：[dynamic-programming](https://leetcode-cn.com/tag/dynamic-programming/)。

# 题目

## DP常见推导公式

| 问题 | 公式 |
| ---- | ---- |
| [三步问题](WaysToStep.java) | dp(n) = dp(n-1) + dp(n-2) |
| [打家劫舍](Rob.java) | dp(n) = Max(dp(n-1), dp(n-2)+array(n-1)) |
| [使用最小花费爬楼梯](MinCostClimbingStairs.java) | dp(2)=Min(dp(0)+cost(i-2), dp(1)+cost(i-1)) |

## 题集

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [除数博弈](DivisorGame.java) |  归纳法、DP | [只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。](https://leetcode-cn.com/problems/divisor-game/) |
| [三步问题](WaysToStep.java) |  DP  | [三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。](https://leetcode-cn.com/problems/three-steps-problem-lcci/) |
| [打家劫舍](Rob.java) | 最大值 | [你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。](https://leetcode-cn.com/problems/house-robber/) |
| [使用最小花费爬楼梯](MinCostClimbingStairs.java) |  最小值 | [您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。](https://leetcode-cn.com/problems/min-cost-climbing-stairs/) |

# 附录

 - [https://leetcode-cn.com](https://leetcode-cn.com)