# 前言

这是LeetCode上的刷题记录。

# 题目

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [两数之和](TwoSum.java) |  | [给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。](https://leetcode-cn.com/problems/two-sum/) |
| [两数相加](AddTwoNumbers.java) | | [给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。](https://leetcode-cn.com/problems/add-two-numbers/) |
| [无重复字符的最长子串](LengthOfLongestSubstring.java) | DP | [给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) |
| [寻找两个有序数组的中位数](FindMedianSortedArrays.java) | 递归 | [给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。](https://leetcode-cn.com/problems/median-of-two-sorted-arrays) |
| [最长回文子串](LongestPalindrome.java) | DP | [给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。](https://leetcode-cn.com/problems/longest-palindromic-substring/) |
| [整数反转](ReverseInteger.java) | | [给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。](https://leetcode-cn.com/problems/reverse-integer/) |
| [回文数](PalindromeNumber.java) | | [判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。](https://leetcode-cn.com/problems/palindrome-number/) |
| [生命游戏](GameOfLife.java) | 归纳法 | [生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。](https://leetcode-cn.com/problems/game-of-life/) |
| [接雨水](Trap.java) | 韦恩图法 | [给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。](https://leetcode-cn.com/problems/trapping-rain-water/) |
| [最长公共前缀](LongestCommonPrefix.java) | | [编写一个函数来查找字符串数组中的最长公共前缀。](https://leetcode-cn.com/problems/longest-common-prefix/) |
| [有效的括号](ValidParenthesis.java) | 辅助栈 | [给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。](https://leetcode-cn.com/problems/valid-parentheses/) | 
| [合并两个有序链表](MergeTwoLists.java) | | [将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。](https://leetcode-cn.com/problems/merge-two-sorted-lists/) |
| [删除排序数组中的重复项](RemoveDuplicates.java) | | [给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) |
| [移除元素](RemoveElement.java) | | [给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。](https://leetcode-cn.com/problems/remove-element/) |
| [搜索插入位置](SearchInsert.java) | 二分查找 | [给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。](https://leetcode-cn.com/problems/search-insert-position/) | 
| [加一](PlusOne.java) | | [给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。](https://leetcode-cn.com/problems/plus-one/) |
| [合并两个有序数组](MergeOrderlyArray.java) | | [给你两个有序整数数组nums1和nums2，请你将nums2合并到nums1中，使num1成为一个有序数组。](https://leetcode-cn.com/problems/merge-sorted-array/) |
| [买卖股票的最佳时机](MaxProfit.java) | DP入门题 | [给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) |
| [反转字符串](ReverseString.java) | | [编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。](https://leetcode-cn.com/problems/reverse-string/) |
| [全排列](Permute.java) | 回溯算法-简单 | [给定一个 没有重复 数字的序列，返回其所有可能的全排列。](https://leetcode-cn.com/problems/permutations/) |
| [反转字符串中的单词 III](ReverseWords.java) | | [给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/) |
| [爬楼梯](ClimbStairs.java) | DP | [假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？](https://leetcode-cn.com/problems/climbing-stairs/) |
| [反转链表](ReverseList.java) | | [反转一个单链表。](https://leetcode-cn.com/problems/reverse-linked-list/) |
| [除自身以外数组的乘积](ProductExceptSelf.java) |   | [给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。](https://leetcode-cn.com/problems/product-of-array-except-self/) |
| [只出现一次的数字](SingleNumber.java) | 异或 | [给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。](https://leetcode-cn.com/problems/single-number/) |
| [存在重复元素](ContainsDuplicate.java) |   | [给定一个整数数组，判断是否存在重复元素。](https://leetcode-cn.com/problems/contains-duplicate/) |
| [数组中的第K个最大元素](FindKthLargest.java) |  快排  | [在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) |
| [多数元素](MajorityElement.java) | Boyer-Moore投票算法 | [给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。](https://leetcode-cn.com/problems/majority-element/) |
| [相交链表](GetIntersectionNode.java) |  快慢指针 | [编写一个程序，找到两个单链表相交的起始节点。](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/) |
| [字符串转换整数 (atoi)](MyAtoi.java) |  | [请你来实现一个 atoi 函数，使其能将字符串转换成整数。](https://leetcode-cn.com/problems/string-to-integer-atoi/) |
| [三数之和](ThreeSum.java) |   | [给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。](https://leetcode-cn.com/problems/3sum/) |
| [最接近的三数之和](ThreeSumClosest.java) |   | [给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。](https://leetcode-cn.com/problems/3sum-closest/) |
| [合并K个排序链表](MergeKLists.java) |  归并排序变形 | [合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。](https://leetcode-cn.com/problems/merge-k-sorted-lists/) |
| [搜索旋转排序数组](Search.java) |  二分查找 | [搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是 O(log n) 级别。](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) |
| [字符串相乘](Multiply.java) |  乘法-竖式运算 | [给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。](https://leetcode-cn.com/problems/multiply-strings/) |
| [环形链表](HasCycle.java) |  快慢指针 | [给定一个链表，判断链表中是否有环。](https://leetcode-cn.com/problems/linked-list-cycle/) |
| [环形链表 II](DetectCycle.java) |  快慢指针 | [给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。](https://leetcode-cn.com/problems/linked-list-cycle-ii/) |
| [最大子序和](MaxSubArray.java) |  贪心 | [给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。](https://leetcode-cn.com/problems/maximum-subarray/) |
| [排序链表](SortList.java) |  归并排序变形 | [在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。](https://leetcode-cn.com/problems/sort-list/) |
| [SpiralOrder](螺旋矩阵.java) |   | [请按照顺时针螺旋顺序，返回矩阵中的所有元素。](https://leetcode-cn.com/problems/spiral-matrix/) |

# 附录

 - [https://leetcode-cn.com](https://leetcode-cn.com)
