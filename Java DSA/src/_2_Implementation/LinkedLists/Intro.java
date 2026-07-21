package _2_Implementation.LinkedLists;

public class Intro {

    /*
        Array vs LinkedList:

        - Though we know that Array elements in Java are not allocated contiguous memory, we generally classify
        arrays as a data structure that occupies contiguous memory
        - Compared to that, Linked Lists are not allocated contiguous memory
        - Also, if a typical array gets full, we cannot fill more elements into it, which is not the case for
        Linked Lists
     */
    /*
        Working of LinkedList:

        - Instead of assigning continuous memory, we assign separate individual spaces inside the heap memory to
        the data when it is inserted into the linked list.
        - These individual spaces are termed as nodes
        - Every single node, contains a data member and also the reference to the next node which contains the
        immediate next data member
        - The first node 'head' marks the start of the list and contains the reference to the node of the immediate
        next data member's node
        - The last node 'tail' contains no reference and only the data member and hence marks the end of the list
     */

    public static void main(String[] args) {

        // Creating custom linked list instance:
        LinkedList<Integer> list = new LinkedList<>();

        // Testing internal toString(), add() and remove():
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.remove();
        System.out.println(list);
        for(int i = 0; i < 6; i++) list.add(i);
        System.out.println(list);
        for(int i = 0; i < 3; i++) list.remove();
        System.out.println(list);
        for(int i = 8; i < 17; i++) list.add(i);
        System.out.println(list);

        // Testing get(), set() & size()
        System.out.println();
        for(int i = 0; i < list.size(); i++) System.out.print(list.get(i)+" ");
        System.out.println();
        for(int i = 0; i < list.size(); i++) if(i % 2 == 0) list.set(i, list.get(i) * list.get(i));
        System.out.println(list);

        // Testing insertion and deletion using add() & remove()
        for(int i = 0; i < list.size(); i += 2) {
            list.add(i, - i);
        }
        System.out.println(list);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);

        // Testing addFirst, addLast, removeFirst and removeLast:
        for(int i = -1; i > -5; i--) {
            list.addFirst(i);
            list.addLast(i);
        }
        System.out.println(list);
        for(int i = 0; i < 4; i++) {
            list.removeFirst();
            list.removeLast();
        }
        System.out.println(list);

        // Testing indexOf() and lastIndexOf() methods:
        list.add(8, 8);
        System.out.println(list);
        System.out.print(list.indexOf(-1) +" "); // Should return null
        System.out.print(list.lastIndexOf(-1) +" "); // Should return null
        System.out.print(list.indexOf(10).equals(list.lastIndexOf(10)) +" "); // should return true
        System.out.print(list.indexOf(8) +" ");
        System.out.print(list.lastIndexOf(8) +"\n");
    }
}

// Implementing LinkedList:
// A simple linked list is called a 'Singly Linked List'

class LinkedList<T> { // with Tail Node

    // Implementing LinkedList node:

    private class Node {

        /*
            We can set the data members of this class to private.
            As this is a nested class, if we instantiate its objects in its PARENT class,
            we CAN access the private data members outside of this class via those objects
         */
        private T value; // Data member
        private Node next; // Reference to next node object
        Node(T value) {this.value = value;}

        /*
            Below code can be uncommented if we want to create a new Node and pass to it a value, as well
            as the reference to next node in one go
//            Node(T value, Node next) {
//                this.value = value;
//                this.next = next;
//            }
         */
    }
    private Node head, tail;
    private int size;

    LinkedList() {
        this.size = 0;
    }

    int size() {
        return this.size;
    }

    void add(T value) {
        add(this.size, value);
    }

    void addFirst(T value) {
        add(0, value);
    }

    void addLast(T value) {
        add(value);
    }

    void add(int index, T value) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException();
        Node newNode = new Node(value);
        if(this.tail == null) { // if list is empty
            this.head = this.tail = newNode;
            this.size++;
            return;
        }
        if(index == size) { // equivalent to list.addLast()
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
            return;
        }
        if(index == 0) { // equivalent to list.addFirst()
            newNode.next = this.head;
            this.head = newNode;
            this.size++;
            return;
        }
        Node currentNode = getNode(index - 1);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        this.size++;
    }

    void remove() {
        remove(this.size - 1);
    }

    void removeFirst() {
        remove(0);
    }

    void removeLast() {
        remove();
    }

    void remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        if(index == 0) {
            this.head = this.head.next;
            if(this.head == null) this.tail = null;
            this.size--;
            return;
        }
        Node currentNode = getNode(index - 1);
        if(index == this.size - 1) {
            this.tail = currentNode;
            this.tail.next = null;
            this.size--;
            return;
        }
        currentNode.next = currentNode.next.next;
        this.size--;
    }

    T get(int index) {
        Node reqNode = getNode(index);
        if(reqNode == null) throw new IndexOutOfBoundsException(index);
        return reqNode.value;
    }

    void set(int index, T value) {
        Node reqNode = getNode(index);
        if(reqNode == null) throw new IndexOutOfBoundsException(index);
        reqNode.value = value;
    }

    Integer indexOf(T value) {
        Integer index = 0;
        Node node = this.head;
        while(node != null) {
            if(node.value.equals(value)) return index;
            node = node.next;
            index++;
        }
        return null;
    }

    /*
         We will be able to use the approach of reverse traversing a linked when using a
         doubly linked list.
         However, for now we can just find the last index by traversing from the head
         and not stopping at the first index found.
         Instead, we continue traversing and keep updating the index whenever the node at
         that index contains required value.
     */
    Integer lastIndexOf(T value) {
        int index = 0;
        Integer lastIndex = null;
        Node node = this.head;
        while(node != null) {
            if(node.value.equals(value)) lastIndex = index;
            node = node.next;
            index++;
        }
        return lastIndex;
    }

    private Node getNode(int index) {
        if(index < 0) return null;
        int pointer = 0;
        Node reqNode = this.head;
        while(pointer < index && reqNode != null) {
            reqNode = reqNode.next;
            pointer++;
        }
        return reqNode;
    }

    @Override
    public String toString() {
        Node currentNode = this.head;
        StringBuilder out = new StringBuilder();
        while(currentNode != null) {
            out.append(currentNode.value).append(" -> ");
            currentNode = currentNode.next;
        }
        out.append("END");
        return out.toString();
    }
}
