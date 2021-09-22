#ifndef IS_MATCH_H
#define IS_MATCH_H

#include <string>
#include <vector>

class Solution 
{
	std::vector<std::vector<char>> _M_matches;

	struct Token
	{
		char value; // 字符
		bool any; // 是否匹配任意数量
	};

	bool Matches(const std::string &s, std::size_t si, const std::vector<Token> &pattern, std::size_t pi)
	{
		if(si >= s.size())
		{
			while(pi < pattern.size() && pattern[pi].any)
			{ ++pi; }
			return pi >= pattern.size();
		}
		else if(pi >= pattern.size())
		{ return false; }

		if(_M_matches[si][pi] != 2)
		{ return _M_matches[si][pi]; }

		if(s[si] == pattern[pi].value || pattern[pi].value == '.')
		{
			bool m1 = false, m2 = false;
			if(pattern[pi].any)
			{
				m1 = Matches(s, si + 1, pattern, pi);
				m2 = Matches(s, si, pattern, pi + 1);
			}
			return (_M_matches[si][pi] = Matches(s, si + 1, pattern, pi + 1) || m1 || m2);
		}
		if(pattern[pi].any)
		{
			return (_M_matches[si][pi] = Matches(s, si, pattern, pi + 1));
		}

		return (_M_matches[si][pi] = false);
	}

public:
	bool isMatch(const std::string &s, const std::string &p)
	{
		std::vector<Token> pattern;
		
		for(std::string::const_iterator it = p.begin(); it != p.end(); ++it)
		{
			if(*it == '*')
			{ 
				pattern.back().any = true; 
			}
			else
			{
				Token t;
				t.value = *it;
				t.any = false;
				pattern.push_back(t);
			}
		}

		_M_matches.resize(s.size());
		for(std::size_t i = 0; i < s.size(); ++i)
		{
			_M_matches[i].assign(pattern.size(), 2);
		}

		return Matches(s, 0, pattern, 0);
	}
};


#endif // IS_MATCH_H
