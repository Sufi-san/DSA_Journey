package _2_Implementation.StacksNQueues;

public class CustomQueue<T> {
    private class Node {
        T val;
        Node next;
        Node(T val) {this.val = val;}
    }
    private Node head, tail;
    private int size;
    CustomQueue() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public int size() {return this.size;}

    public void add(T element) {
        this.size++;
        Node newNode = new Node(element);
        if(this.tail == null) {
            this.head = this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public T poll() throws Exception {
        if(this.head == null) throw new Exception("Queue Empty");
        this.size--;
        T element = this.head.val;
        if(this.head == this.tail) this.head = this.tail = null;
        else this.head = this.head.next;
        return element;
    }

    public T peek() {
        if(this.head == null) return null;
        return this.head.val;
    }

    @Override
    public String toString() {
        if(this.head == null) return "[]";
        Node node = this.head;
        StringBuilder out = new StringBuilder();
        out.append("[");
        while(node != null) {
            out.append(node.val).append(", ");
            node = node.next;
        }
        out.replace(out.length() - 2, out.length(), "]");
        return out.toString();
    }
}
