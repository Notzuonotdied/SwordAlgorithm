#ifndef REMOVE_NTH_FROM_END_H
#define REMOVE_NTH_FROM_END_H

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？
 */

#include <list>

struct ListNode 
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* removeNthFromEnd(ListNode* head, int n) 
{
    std::list<ListNode*> l;

    ListNode *v = head;
    while(NULL != v)
    {
        l.push_back(v);
        v = v->next;
        
        // 维持数量在n+1个之内
        if(l.size() > n + 1)
        {
            l.pop_front();
        }
    }

    std::list<ListNode*>::iterator it = l.begin();

    if(l.size() == 1)
    {
        return NULL;
    }

    ++it;
    if(l.front() == head && n == l.size())
    {
        return *it;
    }

    l.front()->next = (*it)->next;
    return head;
}

#endif // REMOVE_NTH_FROM_END_H
