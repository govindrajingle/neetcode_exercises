import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public static void main(String[] args) {

        // List 1: 3 -> 7
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);

        // List 2: 1
        ListNode l2 = new ListNode(1);

        // List 3: 8 -> 9
        ListNode l3 = new ListNode(8);
        l3.next = new ListNode(9);

        // List 4: 5 -> 6
        ListNode l4 = new ListNode(5);
        l4.next = new ListNode(6);

        // Array of lists
        ListNode[] lists = new ListNode[] { l1, l2, l3, l4 };

        ListNode resultNode = mergeKLists(lists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comaparator = (a, b) -> {
            return a.val - b.val;
        };
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        Queue<ListNode> minHeap = new PriorityQueue<>(comaparator);
        for (ListNode node : lists) {
            if (node != null)
                minHeap.offer(node);
        }
        System.out.println("Original list " + minHeap);
        int i = 0;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            System.out.println("Removed node: " + minNode);
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
                System.out.println("Added node: " + minNode.next);
                System.out.println("index: " + i + " " + minHeap);
                i += 1;
            }
            current.next = minNode;
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
