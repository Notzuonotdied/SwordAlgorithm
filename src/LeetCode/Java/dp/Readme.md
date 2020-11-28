# 前言

这是LeetCode上的关于动态规划的刷题记录。

 - 动态规划题集：[dynamic-programming](https://leetcode-cn.com/tag/dynamic-programming/)。

动态规划（英语：Dynamic programming，简称 DP）是一种在数学、管理科学、计算机科学、经济学和生物信息学中使用的，通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。

动态规划常常适用于有重叠子问题和最优子结构性质的问题，动态规划方法所耗时间往往远少于朴素解法。

动态规划背后的基本思想非常简单。大致上，若要解一个给定问题，我们需要解其不同部分（即子问题），再根据子问题的解以得出原问题的解。动态规划往往用于优化递归问题，例如斐波那契数列，如果运用递归的方式来求解会重复计算很多相同的子问题，利用动态规划的思想可以减少计算量。

通常许多子问题非常相似，为此动态规划法试图仅仅解决每个子问题一次，具有天然剪枝的功能，从而减少计算量：一旦某个给定子问题的解已经算出，则将其记忆化存储，以便下次需要同一个子问题解之时直接查表。这种做法在重复子问题的数目关于输入的规模呈指数增长时特别有用。


# 题目

## DP常见推导公式

| 问题 | 公式 |
| ---- | ---- |
| [三步问题](WaysToStep.java) | dp(n) = dp(n-1) + dp(n-2) |
| [打家劫舍](Rob.java) | dp(n+2) = Max(dp(n+1), dp(n)+array(n)) |
| [面试题47. 礼物的最大价值](MaxValue.java) | dp(m, n) = Max(dp(m-1, n), dp(m, n-1)) |
| [使用最小花费爬楼梯](MinCostClimbingStairs.java) | dp(2)=Min(dp(0)+cost(i-2), dp(1)+cost(i-1)) |
| [连续子数组的最大和](MaxSubArray.java) | Sum(1...n) |
| [面试题 08.11. 硬币](WaysToChange.java) | dp(n) = (dp(n) + dp(n - coin)) % MOD |

## 题集

<details>
<summary>动态规划 之 <strong>最大/小值</strong></summary>

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [打家劫舍](Rob.java) | 最大值 | [你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。](https://leetcode-cn.com/problems/house-robber/) |
| [按摩师](Massage.java) | 最大值 | [一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。](https://leetcode-cn.com/problems/the-masseuse-lcci/) |
| [面试题47. 礼物的最大价值](MaxValue.java) | 最大值 | [在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/) |
| [使用最小花费爬楼梯](MinCostClimbingStairs.java) |  最小值 | [您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。](https://leetcode-cn.com/problems/min-cost-climbing-stairs/) |
| [最小路径和](MinPathSum.java) | 最小值 | [给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。](https://leetcode-cn.com/problems/minimum-path-sum/) |

</details>

<details>
<summary>动态规划 之 <strong>求和</strong></summary>

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [连续子数组的最大和](MaxSubArray.java) | Sum | [输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/) |

</details>


<details>
<summary>动态规划 之 <strong>数学归纳</strong></summary>

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [除数博弈](DivisorGame.java) |  归纳法、DP | [只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。](https://leetcode-cn.com/problems/divisor-game/) |
| [面试题14- II. 剪绳子 II](CuttingRope.java) |  数学归纳+贪心  | [给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/) |
| [面试题43. 1～n整数中1出现的次数](CountDigitOne.java) | 数位DP+归纳分析 | [输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。](https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/) |
| ✨[面试题 17.06. 2出现的次数](NumberOf2sInRange.java) | 数位DP+归纳分析 | [编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。](https://leetcode-cn.com/problems/number-of-2s-in-range-lcci/)<br/><br/>推荐阅读下题解，完整的✨**数位DP**✨分析逻辑。 |

</details>


<details>
<summary>动态规划 之 <strong>其他</strong></summary>

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [三步问题](WaysToStep.java) |  DP  | [三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。](https://leetcode-cn.com/problems/three-steps-problem-lcci/) |
| [最长回文子串](LongestPalindrome.java) | DP | [给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。](https://leetcode-cn.com/problems/longest-palindromic-substring/) |
| [无重复字符的最长子串](LengthOfLongestSubstring.java) | DP | [给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) |
| [买卖股票的最佳时机](MaxProfit.java) | DP入门题 | [给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) |
| [买卖股票的最佳时机 II](MaxProfit2.java) | 贪心 / DP  | [给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) |
| [爬楼梯](ClimbStairs.java) | DP | [假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？](https://leetcode-cn.com/problems/climbing-stairs/) |
| [Nim 游戏](CanWinNim.java) |  规律题（DP会超时系列） | [编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。](https://leetcode-cn.com/problems/nim-game/) |
| [不同路径](UniquePaths.java) | 动态规划-简单（滚动数组思想） | [一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。问总共有多少条不同的路径？](https://leetcode-cn.com/problems/unique-paths/) |
| [不同路径 II](UniquePathsWithObstacles.java) |  DP（滚动数组思想） | [一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？](https://leetcode-cn.com/problems/unique-paths-ii/) |
| [面试题 08.11. 硬币](WaysToChange.java) | DP | [硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)](https://leetcode-cn.com/problems/coin-lcci/) |

</details>

### 部分题目推导思路

<details>
<summary>“面试题14- II. 剪绳子 II”动态规划的推导思路</summary>

<br/>

> 原题：[面试题14- II. 剪绳子 II](CuttingRope.java)推导思路

| 绳子切分方案 | 乘积 | 结论 |
| ---- | ---- | ---- |
| 2=1+1 | 1×1=1 | 2 不应切分 |
| 3=1+2 | 1×2=2 | 3 不应切分 |
| 4=2+2=1+3 | 2×2=4>1×3=3 | 4 和 2 等价，且 2+2 比 1+3 更优 |
| 5=2+3=1+4 | 2×3=6>1×4=4 | 5 应切分为 2+3 |
| 6=3+3=2+2+2 | 3×3=9>2×2×2=8 | 6 应切分为 3+3 ，进而推出 3 比 2 更优 |
| >7 | ... | 长绳（长度>7）可转化为多个短绳（长度1~6），因此肯定应切分 |

 - 从上面可以看出，拆解的最小单位是2和3，其中拆分为3的取值更大。

> [面试题14- II. 剪绳子 II（数学推导 / 贪心思想 + 快速幂求余，清晰图解）](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/)

</details>

### DP常见优化手段

 - 滚动数组思想
    - 可以使用**滚动数组思想**将问题将空间复杂度由`O(n*n)`优化为`O(n)`。
    - [不同路径](UniquePaths.java)、[不同路径 II](UniquePathsWithObstacles.java)

# 附录

 - [https://leetcode-cn.com](https://leetcode-cn.com)