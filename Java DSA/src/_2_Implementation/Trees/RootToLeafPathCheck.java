package _2_Implementation.Trees;

import java.util.Arrays;

public class RootToLeafPathCheck {
    // Here, our aim is to check whether a given path exists as a Root to Leaf path inside given tree
    // Note, the path should exist as a Root to Leaf path only and not as any other internal path.
    public static void main(String[] args) {
        Binary_Tree bt = new Binary_Tree();
        Integer[] arr = {5, 6, null, 7, null, null, 8, 9, null, 10, 11, null,null, 12, null, null, 13, null, null};
        bt.fillWithArr(arr);
        bt.printTree();
        Integer[] path = {6, 6, 7};
        if(pathExists(bt.root, path)) System.out.println("Root to Leaf Path: "+ Arrays.toString(path) +" Exists in tree.");
        else System.out.println("Root to Leaf Path "+ Arrays.toString(path) +" does not Exist in the tree.");
        if(pathExists2(bt.root, path)) System.out.println("Root to Leaf Path: "+ Arrays.toString(path) +" Exists in tree.");
        else System.out.println("Root to Leaf Path "+ Arrays.toString(path) +" does not Exist in the tree.");
    }

    static boolean pathExists(Node root, Integer[] arr) {
        return helper(root, arr, 0);
    }

    static boolean helper(Node node, Integer[] arr, int index) {
        if(node == null) return arr.length == 0;
        if(index == arr.length) return false; // In approach two we check whether we have a correct node value too.
        if(node.left == null && node.right == null) {
            return (index == arr.length - 1 && node.value == arr[index]);
        }
        boolean hasPath = node.value == arr[index]; // In approach 2 this check won't be necessary at this point
        return hasPath && (helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1));
    }

    // Depicting another approach (slight logic change) for finding root to leaf path:
    static boolean pathExists2(Node root, Integer[] arr) {
        if(root == null) return arr.length == 0;
        return helper2(root, arr, 0);
    }

    static boolean helper2(Node node, Integer[] arr, int index) {
        if(node == null) return false;
        if(index == arr.length || arr[index] != node.value) return false;
        if(node.left == null && node.right == null && index == arr.length - 1) return true;
        return helper2(node.left, arr, index + 1) || helper2(node.right, arr, index + 1);
    }
}
