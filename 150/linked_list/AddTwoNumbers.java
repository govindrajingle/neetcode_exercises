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
        l1.next.next = new ListNode(9);

        // List 2: 1
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        ListNode result = new ListNode(-1);
        int sum = 0;
        sum = getNumber(l1) + getNumber(l2);
        // System.out.println("Sum is: " + sum);
        // int rev = reverseNum(sum);
        // System.out.println("Reverse num is: " + rev);
        ListNode dummy = result;
        if (sum == 0)
            System.out.println(new ListNode(0));
        while (sum > 0) {
            int digit = sum % 10;
            ListNode temp = new ListNode(digit);
            dummy.next = temp;
            dummy = dummy.next;
            sum /= 10;
        }
        System.out.println(result.next);
    }

    public static int reverseNum(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    public static int getNumber(ListNode root) {
        int num = 0;
        ListNode current = root;
        while (current != null) {
            num = num * 10 + current.val;
            current = current.next;
        }
        return num;
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
