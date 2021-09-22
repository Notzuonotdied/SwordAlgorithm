#ifndef SPLIT_LIST_TO_PARTS_H
#define SPLIT_LIST_TO_PARTS_H

/*
给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。

每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。

这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。

返回一个由上述 k 部分组成的数组。
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<ListNode*> splitListToParts(ListNode* head, int k) {

        std::vector<ListNode*> result(k, NULL);

        int node_count = 0, unit_count = 0, remain_count = 0;

        ListNode *v = head;
        while(NULL != v)
        {
            v = v->next;
            ++node_count;
        }

        if(node_count == 0)
        { return result; }

        unit_count = node_count / k;
        remain_count = node_count % k;

        v = head;
        for(int i = 0; i < k; ++i)
        {
            result[i] = v;
            int c = unit_count + static_cast<int>(remain_count > i);
            while(--c > 0 && NULL != v)
            { v = v->next; }

            if(v == NULL) 
            { break; }

            ListNode *n = v->next;
            v->next = NULL;
            v = n;
        }

        return result;
    }
};

#endif // SPLIT_LIST_TO_PARTS_H
