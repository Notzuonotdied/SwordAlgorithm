#ifndef FIND_WORDS_H
#define FIND_WORDS_H

/*
给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，
找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母在一个单词中不允许被重复使用。
*/

#include <vector>
#include <string>
#include <set>
#include <map>

class Solution 
{
private:
	struct Node;
	typedef std::map<char, Node *> SeqNodePtr;

	// 位置结构体
    struct Pos
    {
        Pos(int r = -1, int c = -1) : row(r), col(c) {}
        int row;
        int col;

        unsigned long long Key() const 
        { return *reinterpret_cast<const unsigned long long *>(this); }

		bool Valid() const 
		{ return row >= 0 && col >= 0; }

        bool operator<(const Pos &p) const 
        { return Key() < p.Key(); }
    };

	// 前缀树结点
	struct Node
	{
		Node(char c = 0) : value(c) {}

		~Node()
		{
			for(SeqNodePtr::iterator it = child.begin(); it != child.end(); ++it)
			{ delete it->second; }
		}

		char value;
		Pos pos;
		SeqNodePtr child;

		Node * Append(char v)
		{ 
			SeqNodePtr::iterator f = child.find(v);
			if(f == child.end())
			{ f = child.insert(std::make_pair(v, new Node(v))).first; }
			return f->second;
		}

		Node * Child(char v) const
		{ 
			SeqNodePtr::const_iterator f = child.find(v);
			return f == child.end() ? NULL : f->second;
		}
	};

private:
	typedef std::vector<std::vector<bool>> FlagMatrix; // 整个矩阵的遍历标识

	int _M_row; // 字母矩阵的行数
	int _M_col; // 字母矩阵的列数
	std::vector<std::set<Pos>> _M_pos_set;// 保存每一个字母的所有位置
	FlagMatrix _M_visit_flag; // 遍历标识

private:
	void CheckExistsChild(const std::vector<std::vector<char>>& board, const Pos &p, Node *node)
	{
		SeqNodePtr::const_iterator it = node->child.begin();
		for(; it != node->child.end(); ++it)
		{
			CheckExists(board, p, it->second);
		}
	}

	void CheckExists(const std::vector<std::vector<char>>& board, const Pos &p, Node *node)
	{
		Pos pos = p;
        // 上方
        if(pos.row > 0 && !_M_visit_flag[pos.row - 1][pos.col] && board[pos.row - 1][pos.col] == node->value)
        {
            --pos.row;
			node->pos = pos;
			_M_visit_flag[pos.row][pos.col] = true;
			CheckExistsChild(board, pos, node);
			_M_visit_flag[pos.row][pos.col] = false;
			++pos.row;
        }
        // 下方
        if(pos.row + 1 < _M_row && !_M_visit_flag[pos.row + 1][pos.col] && board[pos.row + 1][pos.col] == node->value)
        {
            ++pos.row;
			node->pos = pos;
			_M_visit_flag[pos.row][pos.col] = true;
			CheckExistsChild(board, pos, node);
			_M_visit_flag[pos.row][pos.col] = false;
            --pos.row;
        }
        // 左边
        if(pos.col > 0 && !_M_visit_flag[pos.row][pos.col - 1] && board[pos.row][pos.col - 1] == node->value)
        {
            --pos.col;
			node->pos = pos;
			_M_visit_flag[pos.row][pos.col] = true;
			CheckExistsChild(board, pos, node);
			_M_visit_flag[pos.row][pos.col] = false;
            ++pos.col;
        }
        // 右边
        if(pos.col + 1 < _M_col && !_M_visit_flag[pos.row][pos.col + 1] && board[pos.row][pos.col + 1] == node->value)
        {
            ++pos.col;
			node->pos = pos;
			_M_visit_flag[pos.row][pos.col] = true;
			CheckExistsChild(board, pos, node);
			_M_visit_flag[pos.row][pos.col] = false;
            --pos.col;
        }
	}

	void CheckNode(const std::vector<std::vector<char>>& board, Node *root)
	{
		const std::set<Pos> &ps = _M_pos_set[root->value];
		for(std::set<Pos>::const_iterator it = ps.begin(); it != ps.end(); ++it)
		{
			// 初始化遍历标识
			_M_visit_flag.resize(_M_row);
			for(int i = 0; i < _M_row; ++i)
			{
				_M_visit_flag[i].assign(_M_col, false);
			}

			_M_visit_flag[it->row][it->col] = true;
			root->pos = *it;
			CheckExistsChild(board, *it, root);
		}
	}

	bool ExistsWord(const Node *node, const std::string &word) const 
	{
		for(std::string::const_iterator it = word.begin(); it != word.end(); ++it)
		{
			node = node->Child(*it);
			if(NULL == node || !node->pos.Valid())
			{ return false; }
		}
		return true;
	}

public:
    std::vector<std::string> findWords(
		std::vector<std::vector<char>>& board, 
        std::vector<std::string>& words) 
    {
        std::vector<std::string> result;

		// 初始化全局变量
        _M_row = static_cast<int>(board.size());
        _M_col = static_cast<int>(board[0].size());

        // 保存各个字符的位置
        _M_pos_set.resize(128);
        for(int i = 0; i < _M_row; ++i)
        {
            for(int j = 0; j < _M_col; ++j)
            {
                Pos p;
                p.row = i;
                p.col = j;
                _M_pos_set[board[i][j]].insert(p);
            }
        }

		// 将所有单词组合，构建成一棵前缀树
		Node *root = new Node;
		for(std::vector<std::string>::const_iterator it = words.begin(); it != words.end(); ++it)
		{
			std::string::const_iterator ch = it->begin();
			Node *node = root;
			while(ch != it->end())
			{ node = node->Append(*ch++); }
		}

		// 遍历前缀树
		SeqNodePtr::const_iterator it = root->child.begin();
		for(; it != root->child.end(); ++it)
		{
			CheckNode(board, it->second);
		}

		// 遍历单词，查看是否在前缀树中
		for(std::vector<std::string>::const_iterator it = words.begin(); it != words.end(); ++it)
		{
			if(ExistsWord(root, *it))
			{ result.push_back(*it); }
		}

		delete root;

        return result;
    }
};

#endif // FIND_WORDS_H
