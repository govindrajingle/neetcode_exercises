// 206
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode current = new ListNode(6);
        current.next = new ListNode(8);
        current.next.next = new ListNode(9);
        System.out.println("Old list: ");
        System.out.println(current.toString());
        ListNode prev = null;
        while (current != null) {
            // 1. Keep track of remaining list
            ListNode temp = current.next;
            // 2. Swap current
            current.next = prev;
            prev = current;
            // 3. Move forward
            current = temp;
        }
        System.out.println(prev);
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
