# 前言

这是LeetCode上的刷题记录。

# 题目

<details>
<summary>尚未分类的题目</summary>

| 代码 | 解法 | 链接 |
| ---- | ---- | ---- |
| [两数相加](AddTwoNumbers.java) | | [给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。](https://leetcode-cn.com/problems/add-two-numbers/) |
| [寻找两个有序数组的中位数](FindMedianSortedArrays.java) | 递归 | [给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。](https://leetcode-cn.com/problems/median-of-two-sorted-arrays) |
| [整数反转](ReverseInteger.java) | | [给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。](https://leetcode-cn.com/problems/reverse-integer/) |
| [回文数](PalindromeNumber.java) | | [判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。](https://leetcode-cn.com/problems/palindrome-number/) |
| [生命游戏](GameOfLife.java) | 归纳法 | [生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。](https://leetcode-cn.com/problems/game-of-life/) |
| [接雨水](Trap.java) | 韦恩图法 | [给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。](https://leetcode-cn.com/problems/trapping-rain-water/) |
| [最长公共前缀](LongestCommonPrefix.java) | | [编写一个函数来查找字符串数组中的最长公共前缀。](https://leetcode-cn.com/problems/longest-common-prefix/) |
| [20.有效的括号](ValidParenthesis.java) | 辅助栈 | [给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。](https://leetcode-cn.com/problems/valid-parentheses/) | 
| [反转字符串](ReverseString.java) | | [编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。](https://leetcode-cn.com/problems/reverse-string/) |
| [反转字符串中的单词 III](ReverseWords.java) | | [给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/) |
| [除自身以外数组的乘积](ProductExceptSelf.java) |   | [给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。](https://leetcode-cn.com/problems/product-of-array-except-self/) |
| [136.只出现一次的数字](SingleNumber.java) | 异或 | [给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。](https://leetcode-cn.com/problems/single-number/) |
| [存在重复元素](ContainsDuplicate.java) |   | [给定一个整数数组，判断是否存在重复元素。](https://leetcode-cn.com/problems/contains-duplicate/) |
| [215.数组中的第K个最大元素](FindKthLargest.java) |  快排  | [在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) |
| [169.多数元素](MajorityElement.java) | Boyer-Moore投票算法 | [给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。](https://leetcode-cn.com/problems/majority-element/) |
| [字符串转换整数 (atoi)](MyAtoi.java) |  | [请你来实现一个 atoi 函数，使其能将字符串转换成整数。](https://leetcode-cn.com/problems/string-to-integer-atoi/) |
| [15.三数之和](ThreeSum.java) | 排序、剪枝 | [给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。](https://leetcode-cn.com/problems/3sum/) |
| [最接近的三数之和](ThreeSumClosest.java) |   | [给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。](https://leetcode-cn.com/problems/3sum-closest/) |
| [合并K个排序链表](MergeKLists.java) |  归并排序变形 | [合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。](https://leetcode-cn.com/problems/merge-k-sorted-lists/) |
| [搜索旋转排序数组](Search.java) |  二分查找 | [搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是 O(log n) 级别。](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) |
| [字符串相乘](Multiply.java) |  乘法-竖式运算 | [给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。](https://leetcode-cn.com/problems/multiply-strings/) |
| [环形链表 II](DetectCycle.java) |  快慢指针 | [给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。](https://leetcode-cn.com/problems/linked-list-cycle-ii/) |
| [排序链表](SortList.java) |  归并排序变形 | [在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。](https://leetcode-cn.com/problems/sort-list/) |
| [螺旋矩阵](SpiralOrder.java) |   | [请按照顺时针螺旋顺序，返回矩阵中的所有元素。](https://leetcode-cn.com/problems/spiral-matrix/) |
| [螺旋矩阵 II](GenerateMatrix.java) |   | [给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。](https://leetcode-cn.com/problems/spiral-matrix-ii/) |
| [旋转链表](RotateRight.java) |   | [给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。](https://leetcode-cn.com/problems/rotate-list/) |
| [二叉树的最大深度](MaxDepth.java) |  DFS   | [给定一个二叉树，找出其最大深度。](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) |
| [2的幂](IsPowerOfTwo.java) | 数学归纳法 | [给定一个整数，编写一个函数来判断它是否是 2 的幂次方。](https://leetcode-cn.com/problems/power-of-two/) |
| [子集](Subsets.java) |  位掩码 | [给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。](https://leetcode-cn.com/problems/subsets/) |
| [二叉搜索树的最近公共祖先](LowestCommonAncestor.java) |  利用二叉搜索树的特性 | [给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) |
| [二叉树的最近公共祖先](LowestCommonAncestor1.java) |  递归 | [给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) |
| [二叉搜索树中第K小的元素](KthSmallest.java) |  辅助栈 | [给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/) |
| [删除链表的倒数第N个节点](RemoveNthFromEnd.java) |  双指针 | [给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/) |
| [解析布尔表达式](ParseBoolExpr.java) | 双辅助栈 | [给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。](https://leetcode-cn.com/problems/parsing-a-boolean-expression/) |
| [逆波兰表达式求值](EvalRPN.java) |  辅助栈 | [根据逆波兰表示法，求表达式的值。](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/) |
| [汉明距离](HammingDistance.java) | 异或、相与 | [给出两个整数 x 和 y，计算它们之间的汉明距离。](https://leetcode-cn.com/problems/hamming-distance/) |
| [盛最多水的容器](MaxArea.java) | 双指针消状态<br/>裁剪搜索空间 | [给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。](https://leetcode-cn.com/problems/container-with-most-water/) |
| [146. LRU 缓存机制](LRUCache.java)| | [运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。](https://leetcode-cn.com/problems/lru-cache/) |

</details>

## 按照题目分类

<details>
<summary>根据大类型分类</summary>

 - [数组](array/Readme.md)
 - [回溯算法](backtrace/Readme.md)
 - [动态规划](dp/Readme.md)
 - [贪心算法](greedy/Readme.md)
 - [数学](math/Readme.md)
 - [矩阵](matrix/Readme.md)
 - [LeetCode 剑指Offer](offer/Readme.md)
 - [树](tree/Readme.md)

</details>

# 附录

 - [https://leetcode-cn.com](https://leetcode-cn.com)
