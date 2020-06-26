template<typename _Tp>
struct ListNode
{
    _Tp val;
    ListNode *next;
    ListNode(const _Tp &v) : val(v), next(NULL) { }
};

// 求两数之和
template<typename _Tp>
ListNode<_Tp>* AddTwoNumbers(ListNode<_Tp> *l1, ListNode<_Tp> *l2)
{
    ListNode *head = new ListNode(0);
    ListNode *node = head;

    _Tp c = 0, v;
    while(NULL != l1 || NULL != l2)
    {
        v = 0;
        if(NULL != l1)
        {
            v += l1->val;
            l1 = l1->next;
        }
        if(NULL != l2)
        {
            v += l2->val;
            l2 = l2->next;
        }
        v += c;
        node = node->next = new ListNode(v % 10);
        c = v / 10;
    }

    if(c != 0)
    {
        node = node->next = new ListNode(c);
    }
    node = head;
    head = head->next;
    delete node;
    return head->next;
}

