// 21
public class MergeTwoSortedLists {

    public static void main(String[] args) {

        // List 1: 3 -> 7
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);

        // List 2: 1
        ListNode l2 = new ListNode(1);

        ListNode resultNode = mergeTwoLists(l1, l2);

        System.out.println(resultNode.toString());
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = new ListNode(l1.val);
            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            current.next = new ListNode(l2.val);
            l2 = l2.next;
            current = current.next;
        }
        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    };

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current.next != null) {
            sb.append(current.val + "->");
            current = current.next;
        }
        sb.append(current.val + "->@");
        return sb.toString();
    }
}
