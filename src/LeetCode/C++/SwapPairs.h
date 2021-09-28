#ifndef SWAP_PAIR_H
#define SWAP_PAIR_H

/*
给定一个链表，两两交换其中相邻的节点，
并返回交换后的链表。你不能只是单纯的
改变节点内部的值，而是需要实际的进行节点交换。
*/

#ifndef NULL
#define NULL 0
#endif

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* SwapPairs(ListNode* head) 
{
    ListNode *cur = head, *next = NULL, *nextnext = NULL, *prev = NULL;

    if(NULL == head || NULL == head->next)
    { return head; }

    head = head->next;

    next = cur->next;
    nextnext = next->next;

    prev = cur;
    next->next = cur;
    cur->next = nextnext;
    cur = nextnext;

    while(NULL != cur && NULL != cur->next)
    {
        next = cur->next;
        nextnext = next->next;

        prev->next = next;
        next->next = cur;
        cur->next = nextnext;
        prev = cur;
        cur = nextnext;
    }

    return head;
}

#endif // SWAP_PAIR_H
