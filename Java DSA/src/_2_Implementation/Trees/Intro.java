package _2_Implementation.Trees;

import java.util.*;

public class Intro {
    // Theory, Ideas and Properties discussed in Notes
    public static void main(String[] args) {
        Binary_Tree bTree = new Binary_Tree();
        bTree.printTree();
        bTree.populate();
        bTree.printTree();
    }
}

// Implementing the tree:

class Binary_Tree {

    Node root;
    Binary_Tree() {
        root = null;
    }

    void populate() {
        Scanner in = new Scanner(System.in);
        if(root != null) populate(in, root);
        System.out.println("Enter root node value: ");
        root = new Node(in.nextInt());
        populate(in, root);
    }

    private void populate(Scanner in, Node node) {
        System.out.println("Do you want to enter left child to "+node.value);
        boolean opt = (in.nextBoolean());
        if(opt) {
            System.out.println("Enter value: ");
            node.left = new Node(in.nextInt());
            populate(in, node.left);
        }
        System.out.println("Do you want to enter right child to "+node.value);
        opt = (in.nextBoolean());
        if(opt) {
            System.out.println("Enter value: ");
            node.right = new Node(in.nextInt());
            populate(in, node.right);
        }
    }

    void printTree() { // Checking root
        System.out.println();
        if(root == null) {
            System.out.println("Empty Tree");
            return;
        }
        printDFS();
        System.out.println();
        prettyPrint(root, 0);
    }

    Node[] convertToNodeArr(Integer[] arr) {
        Node[] nodes = new Node[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                nodes[i] = null;
                continue;
            }
            nodes[i] = new Node(arr[i]);
        }
        return nodes;
    }

    void fillWithArr(Integer[] nodes) {
        Queue<Node> queue = new LinkedList<>();
        Collections.addAll(queue, convertToNodeArr(nodes));
        this.root = fillWithArr(queue);
    }

    private Node fillWithArr(Queue<Node> queue) {
        Node node = queue.poll(); // poll() returns 'null' when the queue is empty
        if(node == null) return null;
        node.left = fillWithArr(queue);
        node.right = fillWithArr(queue);
        return node;
    }

    void printDFS() {
        printDFS(this.root);
    }

    private void printDFS(Node node) { // Depth First Search (left-sided)
        System.out.print(node.value+" ");
        if(node.left != null) printDFS(node.left);
        if(node.right != null) printDFS(node.right);
    }

    void printBFS() {
        ArrayDeque<Node> ad = new ArrayDeque<>();
        ad.push(this.root);
        System.out.print("\nBFS Sequence: ");
        while(!ad.isEmpty()) {
            Node node = ad.poll();
            if(node.left != null) ad.add(node.left);
            if(node.right != null) ad.add(node.right);
            System.out.print(node.value+" ");
        }
        System.out.println();
    }

    private void prettyPrint(Node node, int level) { // Printing right child first, then parent, then going left
        if(node == null) return;
        prettyPrint(node.right, level + 1);
        if(level != 0) {
            for(int i = 0; i < level - 1; i++) System.out.print("|\t\t");
            System.out.println("|------>"+node.value);
        }
        else System.out.println(node.value);
        prettyPrint(node.left, level + 1);
    }
}
