package FinalProject;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedListModifier {
    
    // Method to remove the n-th node from the end of the list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify edge cases
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // Move fast ahead by n+1 steps to maintain a gap of n between slow and fast
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the n-th node from the end
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        LinkedListModifier modifier1 = new LinkedListModifier();
        ListNode result1 = modifier1.removeNthFromEnd(head1, 2);
        System.out.print("Example 1 Output: ");
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
        System.out.println(); // Output: 1 2 3 5

        // Example 2
        ListNode head2 = new ListNode(1);
        LinkedListModifier modifier2 = new LinkedListModifier();
        ListNode result2 = modifier2.removeNthFromEnd(head2, 1);
        System.out.print("Example 2 Output: ");
        while (result2 != null) {
            System.out.print(result2.val + " ");
            result2 = result2.next;
        }
        System.out.println(); // Output: (empty)

        // Example 3
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        LinkedListModifier modifier3 = new LinkedListModifier();
        ListNode result3 = modifier3.removeNthFromEnd(head3, 1);
        System.out.print("Example 3 Output: ");
        while (result3 != null) {
            System.out.print(result3.val + " ");
            result3 = result3.next;
        }
        System.out.println(); // Output: 1
    }
}


