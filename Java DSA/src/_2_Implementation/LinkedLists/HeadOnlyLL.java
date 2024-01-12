package _2_Implementation.LinkedLists;

public class HeadOnlyLL {
    public static void main(String[] args) {

        // Creating a linked list that maintains only the head node
        LinkedListH<Integer> list = new LinkedListH<>();

        // Testing internal toString(), add() and remove():
        System.out.println(list);
        list.add(4);
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
        System.out.print(list.indexOf(144).equals(list.lastIndexOf(144)) +" "); // should return true
        System.out.print(list.indexOf(0) +" ");
        System.out.print(list.lastIndexOf(0) +"\n");

     /*
        The process of reversing a singly linked list is interesting as we cannot perform back
        traversals in it.
        Will be focused on later when solving problems
     */
    }
}

// Implementing Linked List and related operations with only the head Node:

class LinkedListH<T> {
    private class Node {
        T value;
        Node next;
        Node(T value) {
            this.value = value;
        }
        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

    LinkedListH() {
        this.head = null;
    }

    int size() {
        int size = 0;
        Node node = this.head;
        while(node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    void addFirst(T value) {
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    void addLast(T value) {
        add(value);
    }

    void add(T value) {
        if(this.head == null) {
            addFirst(value);
            return;
        }
        Node lastNode = getLastNode();
        lastNode.next = new Node(value);
    }

    void add(int index, T value) {
        if(this.head == null || index == 0) {
            addFirst(value);
            return;
        }
        Node node = getNode(index - 1);
        if (node == null) throw new IndexOutOfBoundsException(index);
        node.next = new Node(value, node.next);
    }

    void removeFirst() {
        if(this.head == null) throw new IndexOutOfBoundsException();
        this.head = this.head.next;
    }

    void removeLast() {
        remove();
    }

    void remove() {
        int size = this.size();
        remove(size - 1);
    }

    void remove(int index) {
        Node prevNode = getNode(index - 1);
        if(prevNode == null) throw new IndexOutOfBoundsException(index);
        prevNode.next = prevNode.next.next;
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

    T get(int index) {
        Node node = getNode(index);
        if(node == null) throw new IndexOutOfBoundsException(index);
        return node.value;
    }

    void set(int index, T value) {
        Node node = getNode(index);
        if(node == null) throw new IndexOutOfBoundsException(index);
        node.value = value;
    }

    private Node getLastNode() {
        Node node = this.head;
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }

    private Node getNode(int index) {
        if(index < 0) return null;
        Node node = this.head;
        int pointer = 0;
        while(pointer < index && this.head != null) {
            node = node.next;
            pointer++;
        }
        return node;
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
