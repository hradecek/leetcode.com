package main

type ListNode struct {
    Val int
    Next *ListNode
}

func reverse(head *ListNode) *ListNode {
    var prev, curr, next *ListNode
    curr = head

    for curr != nil {
        next = curr.Next
        curr.Next = prev
        prev = curr
        curr = next
    }
    return prev
}

func findMiddle(head *ListNode) *ListNode {
    slow := head
    fast := head
    for fast.Next != nil && fast.Next.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
    }

    return slow
}

func isPalindrome(head *ListNode) bool {
    if head == nil || head.Next == nil {
        return true
    }

    middle := findMiddle(head)
    firstHalfIter := head
    secondHalfIter := reverse(middle.Next)

    for secondHalfIter != nil {
        if firstHalfIter.Val != secondHalfIter.Val {
            return false
        }
        firstHalfIter = firstHalfIter.Next
        secondHalfIter = secondHalfIter.Next
    }

    return true
}

