import java.util.List;
import java.util.ArrayList;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = valueOrZero(l1) + valueOrZero(l2) + carry;
        ListNode result = new ListNode(sum % 10);
        result.next = addTwoNumbers(nextOrNull(l1), nextOrNull(l2), sum / 10);

        return result;
    }

    private static int valueOrZero(ListNode listNode) {
        return listNode != null ? listNode.val : 0;
    }

    private static ListNode nextOrNull(ListNode listNode) {
        return listNode != null ? listNode.next : null;
    }
}

class ListNode {

    public int val;
    public ListNode next;

    public ListNode() { }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return toString(this, new ArrayList<Integer>());
    }

    protected String toString(ListNode listNode, List<Integer> numbers) {
        if (listNode == null) {
            return numbers.toString(); 
        }
        numbers.add(listNode.val);
        return toString(listNode.next, numbers);
    }
}

