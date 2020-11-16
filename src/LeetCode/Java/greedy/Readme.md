# 前言

这是LeetCode上的关于贪心算法的刷题记录。

 - 贪心题集：[Greedy](https://leetcode-cn.com/tag/greedy/)。

贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。

贪心算法不是对所有问题都能得到整体最优解，关键是贪心策略的选择，选择的贪心策略必须具备无后效性，即某个状态以前的过程不会影响以后的状态，只与当前状态有关。

# 题目

## DP常见推导公式

| 问题 | 公式 |
| ---- | ---- |
| [面试题14- II. 剪绳子 II](CuttingRope.java) | 数学归纳+贪心 |
| [整数转罗马数字](IntToRoman.java) | 贪心法 |

## 题集

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [面试题14- I. 剪绳子](CuttingRopeOne.java) | 数学归纳+贪心 | [给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/) |
| [面试题14- II. 剪绳子 II](CuttingRope.java) |  数学归纳+贪心  | [给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/) |
| [整数转罗马数字](IntToRoman.java) | 贪心法 | [给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。](https://leetcode-cn.com/problems/integer-to-roman/) |
| [最大子序和](MaxSubArray.java) |  贪心 | [给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。](https://leetcode-cn.com/problems/maximum-subarray/) |
| [跳跃游戏](CanJump.java) |  贪心 | [给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个位置。](https://leetcode-cn.com/problems/jump-game/) |
| [跳跃游戏 II](Jump.java) |  贪心  | [给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置。](https://leetcode-cn.com/problems/jump-game-ii/) |
| [买卖股票的最佳时机](../dp/MaxProfit.java) | 贪心 / DP | [给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) |
| [买卖股票的最佳时机 II](../dp/MaxProfit2.java) | 贪心 / DP  | [给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) |
| [加油站](CanCompleteCircuit.java) |  贪心 | [在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。](https://leetcode-cn.com/problems/gas-station/) |

# 附录

 - [https://leetcode-cn.com](https://leetcode-cn.com)