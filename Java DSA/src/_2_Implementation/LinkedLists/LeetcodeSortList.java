package _2_Implementation.LinkedLists;

public class LeetcodeSortList {
    public static void main(String[] args) {
        int[] arr = new int[50000];
        for(int i = 50000; i > 0; i--) arr[50000 - i] = i;
        ListNode head = new ListNode(arr[0]), head2 = new ListNode(arr[0]);
        ListNode node = head, node2 = head2;
        for(int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
            node2.next = new ListNode(arr[i]);
            node2 = node2.next;
        }
        checkSort(head);
        head = ListNode.bubbleSort(head);
        checkSort(head);
        checkSort(head2);
        head2 = ListNode.mergeSort(head2);
        checkSort(head2);
    }

    static void checkSort(ListNode head) {
        ListNode node = head;
        boolean isSorted = true;
        while(node.next != null) {
            if(node.val > node.next.val) {
                isSorted = false;
                break;
            }
            node = node.next;
        }
        if(isSorted) System.out.println("The list is sorted.");
        else System.out.println("The list is NOT sorted.");
    }
}
