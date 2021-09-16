#ifndef FIND_LONGEST_WORD_H
#define FIND_LONGEST_WORD_H

#include <vector>
#include <string>

/*
给你一个字符串 s 和一个字符串数组 dictionary 作为字典，
找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 */


static bool Match(const std::string &longer, const std::string &shorter)
{
	std::string::const_iterator lit = longer.begin();
	std::string::const_iterator sit = shorter.begin();

	while(lit != longer.end())
	{
		if(*lit == *sit)
		{
			++lit;
			if(++sit == shorter.end())
			{
				return true;
			}
		}
		else 
		{
			++lit;
		}
	}

	return false;
}

static std::string FindLongestWord(const std::string &s, const std::vector<std::string>& dictionary) 
{
	std::size_t max_length = 0, result_index = -1;
	for(std::size_t i = 0; i < dictionary.size(); ++i)
	{
		const std::string &a = dictionary[i];

		if(Match(s, a))
		{
			if(a.size() > max_length)
			{
				max_length = a.size();
				result_index = i;
			}
			else if(result_index >= dictionary.size())
			{
				max_length = a.size();
				result_index = i;
			}
			else if(a.size() == max_length && a < dictionary[result_index])
			{
				max_length = a.size();
				result_index = i;
			}
		}
	}
	
	return result_index >= dictionary.size() ? "" : dictionary[result_index];
}


#endif // FIND_LONGEST_WORD_H
