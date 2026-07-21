package _2_Implementation.LinkedLists;

// Solutions for important 'k' node reversal questions

public class K_NodesReversals {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode list1 = ListNode.arrToList(arr.clone()), list2 = ListNode.arrToList(arr.clone());

        // Continuous 'k' nodes reversal
        list1 = ListNode.reverseKGroup(list1, 2);
        ListNode.printList(list1);

        // Alternate 'k' nodes reversal
        list2 = ListNode.reverseAltKGroup(list2, 2);
        ListNode.printList(list2);
    }
}