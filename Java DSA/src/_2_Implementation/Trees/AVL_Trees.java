package _2_Implementation.Trees;

public class AVL_Trees {
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 14, 17, 9, 4, 38, 44, 98, 56};
        AVL avl = new AVL();
        BSearchTree bst = new BSearchTree();
        bst.insert(arr);
        avl.insert(arr);
        bst.printTree();
        System.out.println("Binary Search Tree balanced: "+bst.balanced()+"\n");
        avl.printTree();
        System.out.println("AVL Tree balanced: "+avl.balanced()+"\n");
        // Thus, operations in an AVL tree will always take logN time as it is always a balanced BST.
    }
}

class AVL extends BSearchTree {

    @Override
    void insert(int value) {
        if(this.isEmpty()) {
            this.root = new Node(value);
            return;
        }
        this.root = insertBalanced(value, this.root);
    }

    // The reason for overriding above method and creating the new insertBalanced method with
    // 'Node' return type is that, we want to use the new returned node, to reform and reconnect
    // the tree after the performed rotations, which I was unable to do using a 'void' return type.
    static Node insertBalanced(int value, Node node) {
        if(node == null) return new Node(value);
        if(node.value <= value) node.right = insertBalanced(value, node.right);
        else node.left = insertBalanced(value, node.left);
        node.height = nodeHeight(node);
        return rotate(node);
    }

    static Node rotate(Node node) {
        int l = nodeHeight(node.left), r = nodeHeight(node.right);
        if(Math.abs(l - r) > 1) {
            if(l > r) return rightRotate(node);
            return leftRotate(node);
        }
        return node;
    }

    static Node rightRotate(Node node) {
        Node child = node.left;
        if(nodeHeight(child.left) > nodeHeight(child.right)) {
            node.left = child.right;
            child.right = node;
            setNewHeights(node, child);
            return child;
        }
        node.left = child.right;
        child.right = null;
        node.left.left = child;
        return rightRotate(node);
    }

    static Node leftRotate(Node node) {
        Node child = node.right;
        if(nodeHeight(child.right) > nodeHeight(child.left)) {
            node.right = child.left;
            child.left = node;
            setNewHeights(node, child);
            return child;
        }
        node.right = child.left;
        child.left = null;
        node.right.right = child;
        return leftRotate(node);
    }

    static void setNewHeights(Node node1, Node node2) {
        node1.height = nodeHeight(node1);
        node2.height = nodeHeight(node2);
    }

    /*
        Difference in Approach for node rotation:

            Kunal checks for the grand child case in the base rotate function itself.
            He calls the left/right rotate function accordingly.

            What I did was to check for it later in the left/right rotate function, and recursively
            call the left/right rotate function after some manipulation to match the case.
     */
}
