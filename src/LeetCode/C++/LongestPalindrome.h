#ifndef LONGEST_PALINDROME_H
#define LONGEST_PALINDROME_H

#include <string>
#include <vector>

/*
给你一个字符串 s，找到 s 中最长的回文子串。
 */

// 获取臂长
static int ArmLength(const std::string &s, int l, int r)
{
	while(l >= 0 && r < s.size() && s[l] == s[r])
	{
		--l;
		++r;
	}
	return (r - l + 1) / 2;
}

static std::string LongestPalindrome(const std::string &s) 
{
	std::size_t rl = 0, rr = 0;

	std::size_t n = s.size() + s.size() + 1;

	std::string str;
	str.resize(n);
	for(std::size_t i = 0; i < n; ++i)
	{
		str[i++] = '#';
		str[i] = s[(i + 1) / 2 - 1];
	}

	std::vector<std::size_t> arm_len(n, 0);

	std::size_t max_right = 0, mirror = 0, center = 0;

	for(std::size_t i = 0; i < n; ++i)
	{
		std::size_t &cur_arm_len = arm_len[i];
		if(i >= max_right)
		{
			cur_arm_len = ArmLength(str, i - cur_arm_len, i + cur_arm_len);
			max_right = cur_arm_len + i;
			center = i;
		}
		else 
		{
			mirror = 2 * center - i; // center - (i - center)
			cur_arm_len = std::min(arm_len[mirror], max_right - i);
			cur_arm_len = ArmLength(str, i - cur_arm_len, i + cur_arm_len);
		}

		if(i + cur_arm_len > max_right)
		{
			max_right = i + cur_arm_len;
			center = i;
		}

		if(cur_arm_len + cur_arm_len + 1 > rr - rl + 1)
		{
			rl = i - cur_arm_len;
			rr = i + cur_arm_len;
		}
	}

	std::string result;
	++rl;
	--rr;
	while(rl++ < rr)
	{
		result += str[rl++];
	}

	return result;
}

#endif // LONGEST_PALINDROME_H
