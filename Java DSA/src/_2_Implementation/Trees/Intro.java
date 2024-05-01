package _2_Implementation.Trees;

import java.util.Scanner;

public class Intro {
    // Theory, Ideas and Properties discussed in Notes
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.printTree();
        bTree.populate(new Scanner(System.in));
        bTree.printTree();
    }
}

// Implementing the tree:

class BinaryTree {
    // Implementing a binary tree node:
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;
    BinaryTree() {
        root = null;
    }

    void populate(Scanner in) {
        if(root != null) populate(in, root);
        System.out.println("Enter root node value: ");
        root = new Node(in.nextInt());
        populate(in, root);
    }

    private void populate(Scanner in, Node node) {
        System.out.println("Do you want to enter left child to "+node.data);
        boolean opt = (in.nextBoolean());
        if(opt) {
            System.out.println("Enter data: ");
            node.left = new Node(in.nextInt());
            populate(in, node.left);
        }
        System.out.println("Do you want to enter right child to "+node.data);
        opt = (in.nextBoolean());
        if(opt) {
            System.out.println("Enter data: ");
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
        printDFS(root);
        System.out.println();
        prettyPrint(root, 0);
    }

    private void printDFS(Node node) { // Depth First Search (left-sided)
        System.out.print(node.data+" ");
        if(node.left != null) printDFS(node.left);
        if(node.right != null) printDFS(node.right);
    }

    private void prettyPrint(Node node, int level) { // Printing right child first, then parent, then going left
        if(node == null) return;
        prettyPrint(node.right, level + 1);
        if(level != 0) {
            for(int i = 0; i < level - 1; i++) System.out.print("|\t\t");
            System.out.println("|------>"+node.data);
        }
        else System.out.println(node.data);
        prettyPrint(node.left, level + 1);
    }
}
