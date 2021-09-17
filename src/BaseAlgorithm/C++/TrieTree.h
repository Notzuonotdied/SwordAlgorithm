#ifndef __TRIE_TREE_H__
#define __TRIE_TREE_H__
 
#include <map>
 
#if __cplusplus >= 201103L
#include <type_traits> // std::forward、std::move
#endif
 
#if __cplusplus >= 201103L
#define null nullptr
#else
#define null NULL
#endif 
 
template<typename _KeyType, 
         typename _ValueType,
         typename _CompareType = std::less<_KeyType> 
        >
class TrieTree
{
public:
	typedef _KeyType    key_type;
	typedef _ValueType  value_type;
	typedef const _KeyType & const_reference;
 
public:
	struct TTreeNode;
	typedef std::map<_KeyType, TTreeNode*, _CompareType>  container_type;
 
public:
	struct TTreeNode
	{
		typedef _ValueType*   pointer;
		typedef unsigned long size_type;
 
		typedef TTreeNode self;
 
		TTreeNode(pointer p = null)
			: _M_value(p) { }
 
		TTreeNode(const self &) { }
 
#if __cplusplus >= 201103L
		TTreeNode(self &&node)
			: _M_children(std::move(node._M_children)), _M_value(node._M_value)
		{ node._M_value = null; }
#endif
 
		~TTreeNode()
		{
			typename container_type::iterator it = _M_children.begin();
			while(it != _M_children.end())
			{ delete (it++)->second; }
			if(null != _M_value)
			{ delete _M_value; }
		}
 
		self* child(const key_type &v)
		{ 
			typename container_type::iterator found = _M_children.find(v);
			return found != _M_children.end() ? found->second : null;
		}
 
		size_type child_size() const 
		{ return static_cast<size_type>(_M_children.size()); }
 
		self* append_child(const key_type &v)
		{ 
			typename container_type::iterator found = _M_children.find(v);
			return found == _M_children.end() ? (_M_children[v] = new self()) : found->second;
		}
 
		pointer value() const
		{ return _M_value; }
 
		container_type _M_children;
		pointer        _M_value;
	};
 
public:
	typedef TTreeNode  node_type;
	typedef TTreeNode* node_pointer;
 
	typedef TrieTree<_KeyType, _ValueType, _CompareType> self;
 
public:
	TrieTree() { }
 
	TrieTree(const self &) { }
 
#if __cplusplus >= 201103L 
	TrieTree(self &&tree)
		: _M_root(std::move(tree._M_root)) { }
 
	template<typename _ForwardIterator, typename ... Args>
	TrieTree(_ForwardIterator b, _ForwardIterator e, Args && ... args)
	{ insert(b, e, std::forward<Args>(args)...); }
 
	template<typename _ForwardIterator, typename ... Args>
	node_pointer insert(_ForwardIterator b, _ForwardIterator e, Args && ... args)
	{
		if(b == e)
		{ return null; }
 
		node_pointer node = &_M_root;
		while(b != e)
		{ node = node->append_child(*b++); }
 
		node->_M_value = new value_type(std::forward<Args>(args)...);
		return node;
	}
 
	template<typename _Type, typename ... Args>
	node_pointer insert(const _Type &key_list, Args && ... args)
	{ return insert(key_list.begin(), key_list.end(), std::forward<Args>(args)...); }
 
	template<typename _Type>
	node_pointer insert(const _Type &key_list, value_type &&v)
	{ return insert(key_list.begin(), key_list.end(), std::move(v)); }
 
#else
	template<typename _ForwardIterator>
	TrieTree(_ForwardIterator b, _ForwardIterator e, const value_type &v)
	{ insert<_ForwardIterator>(b, e, v); }
 
	template<typename _ForwardIterator>
	node_pointer insert(_ForwardIterator b, _ForwardIterator e, const value_type &v)
	{
		if(b == e)
		{ return null; }
 
		node_pointer node = &_M_root;
		while(b != e)
		{ node = node->append_child(*b++); }
 
		node->_M_value = new value_type(v);
		return node;
	}
 
#endif
	template<typename _Type>
	node_pointer insert(const _Type &key_list, const value_type &v)
	{
		typedef typename _Type::const_iterator __citer;
		return insert<__citer>(key_list.begin(), key_list.end(), v);
	}
 
	template<typename _ForwardIterator>
	bool contain(_ForwardIterator b, _ForwardIterator e)
	{
		if(b == e)
		{ return false; }
 
		node_pointer node = &_M_root;
		while(b != e)
		{ 
			node = node->child(*b++); 
 
			if(null == node)
			{ return false; }
		}
 
		return null != node;
	}
 
	template<typename _ForwardIterator>
	bool contain(_ForwardIterator b, _ForwardIterator e) const 
	{ return const_cast<self*>(this)->contain<_ForwardIterator>(b, e); }
 
	template<typename _Type>
	bool contain(const _Type &key_list)
	{
		typedef typename _Type::const_iterator __citer;
		return contain<__citer>(key_list.begin(), key_list.end());
	}
	template<typename _Type>
	bool contain(const _Type &key_list) const
	{ return const_cast<self*>(this)->contain<_Type>(key_list); }
 
	template<typename _ForwardIterator>
	node_pointer find(_ForwardIterator b, _ForwardIterator e)
	{
		if(b == e)
		{ return null; }
 
		node_pointer node = &_M_root;
		while(b != e)
		{ 
			node = node->child(*b++); 
 
			if(null == node || (node->child_size() == 0 && null == node->_M_value))
			{ return null; }
		}
 
		if(null == node->_M_value)
		{ return null; }
 
		return node;
	}
 
	template<typename _ForwardIterator>
	const node_pointer find(_ForwardIterator b, _ForwardIterator e) const
	{ return const_cast<self*>(this)->find<_ForwardIterator>(b, e); }
 
	template<typename _Type>
	node_pointer find(const _Type &key_list)
	{
		typedef typename _Type::const_iterator __citer;
		return find<__citer>(key_list.begin(), key_list.end());
	}
 
	template<typename _Type>
	const node_pointer find(const _Type &key_list) const
	{ return const_cast<self*>(this)->find<_Type>(key_list); }
 
	template<typename _ForwardIterator>
	bool exists(_ForwardIterator b, _ForwardIterator e) const 
	{ return null != const_cast<self*>(this)->find<_ForwardIterator>(b, e); }
 
	template<typename _Type>
	bool exists(const _Type &key_list) const 
	{ 
		typedef typename _Type::const_iterator __citer;
		return exists<__citer>(key_list.begin(), key_list.end()); 
	}
 
	template<typename _Type>
	node_pointer operator[](const _Type &key_list)
	{ return find<_Type>(key_list); }
 
	value_type& value(node_pointer p)
	{ return *p->value(); }
 
private:
	node_type _M_root;
};
 
#endif // __TRIE_TREE_H__
