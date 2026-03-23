// l1 =
// [2,4,9]
// l2 =
// [5,6,4,9]

// Use Testcase
// Output
// [8,9,8,5]
// Expected
// [7,0,4,0,1]

//41
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // List 2: 1
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        // l2.next.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(carry % 10);
            carry /= 10;
            current.next = temp;
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
