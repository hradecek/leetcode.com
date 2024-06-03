#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode listNode;
    struct ListNode *result = &listNode;

    while (list1 != NULL && list2 != NULL) {
        if (list1->val <= list2->val) {
            result->next = list1;
            list1 = list1->next;
        } else {
            result->next = list2;
            list2 = list2->next;
        }
        result = result->next;
    }

    result->next = (list1 != NULL) ? list1 : list2;
    return listNode.next;
}

void print(struct ListNode* list) {
    struct ListNode *current = list;
    while (current != NULL) {
        printf("%d ", current->val);
        current = current->next;
    }
    printf("\n");
}

