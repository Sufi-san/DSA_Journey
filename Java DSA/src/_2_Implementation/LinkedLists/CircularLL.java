package _2_Implementation.LinkedLists;

public class CircularLL {
    public static void main(String[] args) {
        // Creating circular list and testing toString
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        System.out.println(list);

        // Testing add, addFirst and addLast method
        list.addLast(3);
        System.out.println(list);
        for(int i = 4; i < 7; i++) list.add(i);
        System.out.println(list);
        for(int i = 0; i <= 2; i++) list.addFirst(i);
        System.out.println(list);
        for(int i = 0; i <= 6; i += 2) list.add(i, -(i * i));
        System.out.println(list+"\n");

        // Testing nature of circular linked list and get method
        for(int i = 0; i < 25; i++) System.out.print(list.get(i)+" -> ");
        System.out.print("...\n\n");

        // Testing remove, removeFirst and removeLast method
        list.removeLast();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        for(int i = 0; i < 5; i++) list.add(- (i * i));
        System.out.println(list);
        for(int i = 0; i < 5; i++) list.remove();
        System.out.println(list);
        for(int i = 0; i < 9; i++) if(list.get(i) < 0) list.remove(i);
        System.out.println(list);
    }
}

// Implementing a singly Circular Linked List
// Note: A Circular linked list can also be doubly
class CircularLinkedList<T> {
    private class Node {
        T value;
        Node next;
        Node(T value) {this.value = value;}
        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head;

    CircularLinkedList() {this.head = null;}

    // In circular Linked List, addFirst and addLast are almost the same operation but only the position
    // of head differs after each operation

    void addFirst(T value) {
        addLast(value);
        Node lastNode = getLastNode();
        if(lastNode == null) return;
        this.head = lastNode;
    }
    void addLast(T value) {
        Node newNode = new Node(value, this.head);
        Node lastNode = getLastNode();
        if(lastNode == null) {
            newNode.next = newNode;
            this.head = newNode;
            return;
        }
        lastNode.next = newNode;
    }
    void add(T value) {
        addLast(value);
    }

    void add(int index, T value) {
        if(index == 0) {
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        Node reqNode = getNode(index - 1);
        node.next = reqNode.next;
        reqNode.next = node;
    }

    void removeFirst() {
        Node lastNode = getLastNode();
        if(lastNode == null) throw new IndexOutOfBoundsException(0);
        if(this.head.equals(lastNode)) {
            this.head = null;
            return;
        }
        lastNode.next = this.head.next;
        this.head = this.head.next;
    }

    void removeLast() {
        Node lastNode = getLastNode();
        if(lastNode == null) throw new IndexOutOfBoundsException(0);
        this.head = lastNode;
        removeFirst();
    }

    void remove() {
        removeLast();
    }

    void remove(int index) {
        if(index == 0) {
            removeFirst();
            return;
        }
        Node reqNode = getNode(index - 1);
        if(reqNode.next.equals(this.head)) {
            removeFirst();
            return;
        }
        reqNode.next = reqNode.next.next;
    }

    T get(int index) {
        Node reqNode = getNode(index);
        return reqNode.value;
    }

    private Node getLastNode() {
        if(this.head == null) return null;
        Node currentNode = this.head;
        while(!currentNode.next.equals(this.head)) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node getNode(int index) {
        if(this.head == null || index < 0) throw new IndexOutOfBoundsException(index);
        int pointer = 0;
        Node currentNode = this.head;
        while(pointer < index) {
            currentNode = currentNode.next;
            pointer++;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        Node node = this.head;
        if(node == null) return "...";
        StringBuilder out = new StringBuilder();
        do {
            out.append(node.value).append(" -> ");
            node = node.next;
        } while(node != this.head);
        out.append("...");
        return out.toString();
    }
}