package _2_Implementation.LinkedLists;

public class RecursiveInsertion {
    //We try to insert new nodes to the linked list using a recursive method
    public static void main(String[] args) {
        LinkedListH<Integer> list = new LinkedListH<>();
        for(int i = 0; i < 10; i++) list.add(i);
        System.out.println(list);
        list.insertRec(0, -100);
        list.insertRec(1, -300);
        list.insertRec(5, -200);
        list.insertRec(12, -400);
        list.insertRec(14, -500);
        System.out.println(list);
    }
}

