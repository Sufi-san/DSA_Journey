package _2_Implementation.Trees;

public class Segment_Trees {
    // Segment Trees can be used for getting the answers for a variety of operations on ranges
    // Here, we are using it for summation.
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        // int n = 20;
        // int[] arr = new int[n];
        // for(int i = 0; i < n; i++) arr[i] = i + 1;
        SegTree st = new SegTree(arr);
        System.out.println(st.rangeAns(1, 6));
        st.display();
        for(int i = 0; i < arr.length; i += 2) st.update(i, (int)(Math.random() * 10));
        System.out.println(st.rangeAns(3, st.arr.length - 1));
        st.display();
    }
}

class SegTree {
    private static class Node {
        int result;
        int start;
        int end;
        Node left;
        Node right;

        Node(int result, int start, int end) {
            this.result = result;
            this.start = start;
            this.end = end;
        }
    }

    int[] arr;
    Node root;

    SegTree(int[] arr) {
        this.arr = arr;
        this.root = formTree(0, this.arr.length - 1);
        // System.out.println(this.root.result);
    }

    private Node formTree(int start, int end) {
        int mid = start + (end - start) / 2;
        if(start == end) { // For Leaf nodes
            return new Node(this.arr[mid], start, end);
        }
        // For Internal nodes:
        Node node1 = formTree(start, mid), node2 = formTree(mid + 1, end);
        Node parent = new Node(node1.result + node2.result, node1.start, node2.end);
        parent.left = node1;
        parent.right = node2;
        return parent;
    }

    void update(int index, int value) throws IndexOutOfBoundsException{
        if(index < 0 || index > this.arr.length - 1) throw new IndexOutOfBoundsException(index);
        this.arr[index] = value;
        this.root.result = update(this.root, index, value);
        // System.out.println(this.root.result);
    }

    private int update(Node node, int index, int value) {
        if(index < node.start || index > node.end) return node.result;
        /*
            We don't need to check if node.start or node.end is equal to index,
            because if it isn't, then it will be handled by above condition and
            return the node result as it is.
         */
        if(node.start == node.end) node.result = value;
        else node.result = update(node.left, index, value) + update(node.right, index, value);
        return node.result;
    }

    int rangeAns(int start, int end) {
        if(start < 0 || start > this.arr.length - 1 || end < 0 || end > this.arr.length - 1 || end < start) {
            System.out.print("Invalid Range: ");
            return 0;
        }
        return rangeAns(this.root, start, end);
    }

    private int rangeAns(Node node, int start, int end) {
        if(start > node.end || end < node.start) return 0; // Out of required range
        if(start <= node.start && end >= node.end) return node.result;  // Inside required range
        return rangeAns(node.left, start, end) + rangeAns(node.right, start, end); // Checking children due to overlap
    }

    void display() {
        display(this.root);
    }

    private void display(Node node) {
        if(node == null) return;
        String str = "";
        if(node.left != null) {
            str += "(Interval = [" + node.left.start +", " + node.left.end + "], Data: " + node.left.result +")";
        }
        else str += "No left child";
        str += " => (Interval = [" + node.start +", " + node.end + "], Data: " + node.result +") <= ";
        if(node.right != null) {
            str += "(Interval = [" + node.right.start +", " + node.right.end + "], Data: " + node.right.result + ")";
        }
        else str += "No right child";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
}
