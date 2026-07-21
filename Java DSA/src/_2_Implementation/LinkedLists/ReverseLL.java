package _2_Implementation.LinkedLists;

public class ReverseLL {

    public static void main(String[] args) {
        LinkedListH<Integer> list = new LinkedListH<>();
        int[] arr = {5, 4, 3, 2, 1};
        for(int num: arr) list.add(num);
        System.out.println(list);

        // Using recursion to reverse the linked list
        list.recReverse(); // Method 1
        System.out.println(list);
        list.recReverse2(); // Method 2
        System.out.println(list);

        // Using iteration to reverse the linked list
         list.iterReverse(); // Method 3
         System.out.println(list);
    }
}
