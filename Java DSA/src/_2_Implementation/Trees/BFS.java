package _2_Implementation.Trees;

public class BFS {
    public static void main(String[] args) {
        Binary_Tree bt = new Binary_Tree();
        bt.populate();
        BSearchTree bst = new BSearchTree();
        int[] arr = {10, 8, 15, 6, 9, 14, 16};
        bst.insert(arr);

        // Printing BFS sequence:
        bt.printTree();
        bt.printBFS();
        System.out.println();
        bst.display();
        bst.BFS();
    }
}
