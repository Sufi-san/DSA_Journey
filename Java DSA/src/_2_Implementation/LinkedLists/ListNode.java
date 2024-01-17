package _2_Implementation.LinkedLists;

// Implementation of the widely used 'ListNode' class for later use

public class ListNode {
    int val;
    ListNode next;
    // ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode bubbleSort(ListNode head) {
        // Using Bubble Sort and swapping nodes, not just values
        if(head == null || head.next == null) return head;

        // Starting with a dummy head
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode last = null;
        while(last != head) {
            ListNode first = dummyHead;
            ListNode second = head;
            boolean isSorted = true;
            while(second.next != last) {
                if(first.next.val > second.next.val) {
                    isSorted = false;
                    ListNode temp = second.next;
                    second.next = second.next.next;
                    temp.next = second;
                    first.next = temp;
                    if(first == dummyHead) head = first.next;
                    first = first.next;
                }
                else {
                    first = first.next;
                    second = second.next;
                }
            }
            if(isSorted) break;
            last = second;
        }
        return head;
    }

    static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sortedHead1 = mergeSort(slow.next);
        slow.next = null;
        ListNode sortedHead2 = mergeSort(head);
        return merge(sortedHead1, sortedHead2);
    }

    static ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        ListNode node1 = head1, node2 = head2;
        while(node1 != null && node2 != null) {
            ListNode temp;
            if(node1.val < node2.val) {
                while(node1.next != null && (node1.next.val < node2.val)) {
                    node1 = node1.next;
                }
                temp = node1.next;
                node1.next = node2;
                node1 = temp;
                continue;
            }
            while(node2.next != null && (node2.next.val <= node1.val)) {
                node2 = node2.next;
            }
            temp = node2.next;
            node2.next = node1;
            node2 = temp;
        }
        return (head1.val < head2.val)? head1: head2;
    }

    static ListNode arrToList(int[] arr) {
        ListNode head = null, node = null;
        for(int num: arr) {
            if(node == null) {
                node = new ListNode(num);
                head = node;
                continue;
            }
            node.next = new ListNode(num);
            node = node.next;
        }
        return head;
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null || k == 1) return head;
        ListNode start = new ListNode(0, head), end = head, oldStart = head;
        while(end != null) {
            int temp = k;
            while(temp > 1 && end != null) {
                end = end.next;
                temp--;
            }
            if(end == null) break;
            ListNode nextStart = end.next, lastLink = start;
            end.next = null;
            start = reverseList(start.next);
            if(oldStart == head) head = start;
            lastLink.next = start;
            oldStart.next = nextStart;
            start = oldStart;
            end = oldStart = nextStart;
        }
        return head;
    }

    static ListNode reverseAltKGroup(ListNode head, int k) {
        if(head.next == null || k == 1) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode start = dummyHead, end = head, oldStart = head;
        while(true) {
            int temp = k;
            while(temp > 1 && end != null) {
                end = end.next;
                temp--;
            }
            if(end == null) break;
            ListNode nextStart = end.next, lastLink = start;
            end.next = null;
            start = reverseList(start.next);
            if(oldStart == head) head = start;
            lastLink.next = start;
            oldStart.next = nextStart;
            start = oldStart;
            end = oldStart = nextStart;
            temp = k;
            while(temp > 0 && end != null) {
                start = start.next;
                end = end.next;
                oldStart = oldStart.next;
                temp--;
            }
            if(end == null) break;
        }
        return head;
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;
        while(node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    static void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
