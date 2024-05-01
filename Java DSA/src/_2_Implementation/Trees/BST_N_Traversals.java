package _2_Implementation.Trees;

import java.util.Arrays;

public class BST_N_Traversals { // Binary Search Tree
    // Here we are assuming that all trees will be height balanced and not unbalanced
    // Thus, all operations like, add, insert, delete will have time complexity of logN which will be max tree height
    // given 'N' nodes
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};//{78, 12, 98, 22, 44, 33, 58, 19, 96, 86, 110, 114, 5, 4, 10};
        int[] srtArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(srtArr);
        BSearchTree bst = new BSearchTree();
        bst.insert(arr);
        bst.printTree();
        System.out.println("\nTree Balanced? : "+bst.balanced());
        bst.preOrder(); // Parent - Left - Right
        bst.inOrder(); // Left - Parent - Right
        bst.postOrder(); // Left - Right - Parent
        System.out.println("\nInserting elements from sorted array while maintaining balance: ");
        BSearchTree srtBST = new BSearchTree();
        srtBST.insertSorted(srtArr); // Later we will be using, 'Self-Balancing Binary Trees (AVL)'
        srtBST.printTree();
        System.out.println("\nTree Balanced? : "+srtBST.balanced());
    }
}

class BSearchTree {
    protected static class Node {
        int value;
        Node left;
        Node right;
        int height;

        Node(int value) {
            this.value = value;
            this.height = 0;
        }
    }

    Node root;
    BSearchTree() {
        root = null;
    }

    boolean isEmpty() {
        return this.root == null;
    }

    void insert(int value) { // for single value
        if(this.isEmpty()) {
            this.root = new Node(value);
            return;
        }
        insert(value, root);
    }

    void insert(int[] arr) { // for arrays
        for(int num: arr) this.insert(num);
    }

    void insertSorted(int[] arr) { // especially for sorted arrays
        insertSorted(arr, 0, arr.length - 1); // called helper function
    }

    private void insertSorted(int[] arr, int start, int end) { // helper function implementation
        if(start > end) return;
        int mid = start + (end - start) / 2;
        this.insert(arr[mid]);
        insertSorted(arr, start, mid - 1);
        insertSorted(arr, mid + 1, end);
    }

    protected void insert(int value, Node node) {
        if(value <= node.value) {
            if(node.left == null) node.left = new Node(value);
            else insert(value, node.left);
        }
        else {
            if(node.right == null) node.right = new Node(value);
            else insert(value, node.right);
        }
        node.height = nodeHeight(node);
    }

    static int nodeHeight(Node node) {
        if(node == null) return -1;
        int hLeft = (node.left != null)? node.left.height: -1;
        int rLeft = (node.right != null)? node.right.height: -1;
        return Math.max(hLeft, rLeft) + 1;
    }

    int height() {
        if(root == null) return -1;
        return root.height;
    }

    void printTree() {
        display(root, 0);
    }

    void display(Node node, int level) {
        if(node == null) return;
        display(node.right, level + 1);
        if(level != 0) {
            for(int i = 0; i < level - 1; i++) System.out.print("|\t\t");
            System.out.println("|------>"+node.value+"("+node.height+")");
        }
        else System.out.println(node.value+"("+node.height+")");
        display(node.left, level + 1);
    }

    void preOrder() {
        if(this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }
        preOrder(this.root);
        System.out.println(" (Preorder)");
    }

    void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder() {
        if(this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }
        inOrder(this.root);
        System.out.println(" (Inorder)");
    }

    void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    void postOrder() {
        if(this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }
        postOrder(this.root);
        System.out.println(" (Postorder)");
    }

    void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }


    boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node == null) return true;
        int leftH = nodeHeight(node.left);
        int rightH = nodeHeight(node.right);
        boolean c = Math.abs(leftH - rightH) < 2;
        return c && balanced(node.left) && balanced(node.right);
    }
}
