package _2_Implementation.Trees;

import java.util.Stack;

public class IterativeDFS {
    public static void main(String[] args) {
        Binary_Tree bt = new Binary_Tree();
        Integer[] arr = {8, 3, 1, null, null, 6, 4, null, null, 7, null, null, 10, null, 14, 13, null, null, null};
        bt.fillWithArr(arr);
        bt.printTree();
        System.out.print("\nIterative DFS: ");
        iterativeDFS(bt.root);
    }

    // Using Stack to perform an iterative DFS
    static void iterativeDFS(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value + " ");
            if(node.right != null) stack.push(node.right); // Right added first due to Pre-Order DFS traversal
            if(node.left != null) stack.push(node.left);
            /*
            Can also do: (Adding only the right children)
                while(node != null) {
                    System.out.print(node.value + " ");
                    if(node.right != null) stack.push(node.right);
                    node = node.left;
                }
             */
        }
    }
}
