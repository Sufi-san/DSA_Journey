package _2_Implementation.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static void main(String[] args) {
        int value = 3; // Value whose successor needs to be found
        // Successor will be the next node that appears after the node in a BFS traversal
        Binary_Tree bt = new Binary_Tree();
        Integer[] arr = {3, 4, 12, null, null, 14, 36, null, null, 9, null, null, 8, 7, null,
                null, 11, 2, null, 44, null, null};
        bt.fillWithArr(arr);
        bt.printTree();
        System.out.println("Level Order Successor of "+ value +": "+getSuccessor(bt.root, value));
    }

    static int getSuccessor(Node root, int value) {
        if(root == null) return -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int ans = root.value;
        boolean getNext = false;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if(getNext) return node.value;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(node.value == value) getNext = true;
            }
        }
        return ans;

    }
}
