# 前言

- [10分钟速查LeetCode 热题100 【简单】](https://zhuanlan.zhihu.com/p/84230862)
- 经典题目前有「⭐」标记。
- TODO：暂时未刷的题目。

# 题目

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [1.两数之和](../array/TwoSum.java) | Map映射 | [给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。](https://leetcode-cn.com/problems/two-sum/) |
| [20.有效的括号](../ValidParenthesis.java) | 辅助栈 | [给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。](https://leetcode-cn.com/problems/valid-parentheses/) | 
| [136.只出现一次的数字](../SingleNumber.java) | 异或 | [给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。](https://leetcode-cn.com/problems/single-number/) |
| ⭐️[169.多数元素](../MajorityElement.java) | Boyer-Moore投票算法 | [给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。](https://leetcode-cn.com/problems/majority-element/) |
| TODO: 438.找到字符串中所有字母异位词 | | [给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/) |
| [汉明距离](../HammingDistance.java) | 异或、相与 | [给出两个整数 x 和 y，计算它们之间的汉明距离。](https://leetcode-cn.com/problems/hamming-distance/) |

## 数组

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [283.移动零](../array/MoveZeroes.java) |   | [给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。](https://leetcode-cn.com/problems/move-zeroes/) |
| ⭐[448. 找到所有数组中消失的数字](../array/FindDisappearedNumbers.java) | 数组Hash | [给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/) |

## 链表

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [21.合并两个有序链表](../linklist/MergeTwoLists.java) | | [将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。](https://leetcode-cn.com/problems/merge-two-sorted-lists/) |
| [141.环形链表](../linklist/HasCycle.java) |  快慢指针/Set | [给定一个链表，判断链表中是否有环。](https://leetcode-cn.com/problems/linked-list-cycle/) |
| [160.相交链表](../linklist/GetIntersectionNode.java) |  快慢指针 | [编写一个程序，找到两个单链表相交的起始节点。](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/) |
| [234. 回文链表](../linklist/PalindromeLinkedList.java) | 快慢指针、反转链表 | [给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。](https://leetcode-cn.com/problems/palindrome-linked-list/) | 

## 递归

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [101.对称二叉树](../../../SwordOffer/JavaOffer/Demo58.java) | 递归 | [给定一个二叉树，检查它是否是镜像对称的。](https://leetcode-cn.com/problems/symmetric-tree/) |
| [262.翻转二叉树](../tree/InvertTree.java) | 递归 | [翻转一棵二叉树。](https://leetcode-cn.com/problems/invert-binary-tree/) |
| ⭐[437.路径总和 III](../tree/PathSum.java) | 递归、回溯、前缀和 | [给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。](https://leetcode-cn.com/problems/path-sum-iii/) |
| [618.合并二叉树](../tree/MergeTrees.java) | 递归 | [给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。](https://leetcode-cn.com/problems/merge-two-binary-trees/) |

----

- [前缀和定义、原理简介及使用分析](https://zhuanlan.zhihu.com/p/436526162)

## 动态规划

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [53.最大子序和](../dp/MaxSubArray.java) |  动态规划，保证累加和大于0 | [给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。](https://leetcode-cn.com/problems/maximum-subarray/) |
| [70.爬楼梯](../dp/ClimbStairs.java) | f(n)=f(n-1)+f(n-2) | [假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？](https://leetcode-cn.com/problems/climbing-stairs/) |
| [121.买卖股票的最佳时机](../dp/MaxProfit.java) | 最大值 | [给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) |
| [198.打家劫舍](../dp/Rob.java) | f(n)=Math.max(f(n-2)+array(i), f(n-1)) | [你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。](https://leetcode-cn.com/problems/house-robber/) |

## 贪心

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [53.最大子序和](../greedy/MaxSubArray.java) |  贪心，保证累加和大于0 | [给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。](https://leetcode-cn.com/problems/maximum-subarray/) |

# 附录

- [10分钟速查LeetCode 热题100 【简单】](https://zhuanlan.zhihu.com/p/84230862)