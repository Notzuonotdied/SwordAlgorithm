#ifndef FLATTEN_H
#define FLATTEN_H

#define NULL 0

/*
多级双向链表中，除了指向下一个节点和前一个节点指针之外，
它还有一个子链表指针，可能指向单独的双向链表。这些子列表也
可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
*/

// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};

class Solution {
public:
    Node* Tail(Node *n)
    {
        while(NULL != n)
        {
            if(NULL != n->child)
            {
                Node *v = n->next;
                Node *t = Tail(n->child);
                n->next = n->child;
                n->child->prev = n;
                t->next = v;
                if(NULL != v)
                {
                    v->prev = t;
                }
                n->child = NULL;
                n = t;
            }

            if(NULL != n->next) 
            {
                n = n->next;
            }
            else break;
        }
        return n;
    }

    Node* flatten(Node* head) {
        Tail(head);
        return head;
    }
};

#endif // FLATTEN_H
