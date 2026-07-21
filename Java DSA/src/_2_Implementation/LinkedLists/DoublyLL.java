package _2_Implementation.LinkedLists;

public class DoublyLL {

    /*
        The only difference in doubly linked list is that each node also contains reference to the
        previous node along with the value and next node reference
        The main advantage of doubly linked list becomes clear when we deal with backward traversals
     */

    public static void main(String[] args) {
        // Creating a doubly linked list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

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
        System.out.println();
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

        // Testing reverse():

        // Testing for odd size:
        Object tempNode = list.head; // saving the reference to current head node
        list.reverseShallow();
        System.out.println(list);
        System.out.println(tempNode.equals(list.head)); // Confirming shallow copy (this should return true, size > 1)
        tempNode = list.head; // saving the reference to current head node
        list.reverseDeep();
        System.out.println(list);
        System.out.println(tempNode.equals(list.head)); // This should return false (this should return false, size > 1)

        // Testing for even size:
        list.remove();
        System.out.println(list);
        list.reverseShallow();
        System.out.println(list);
        list.reverseDeep();
        System.out.println(list);
    }
}


// Implementation of Doubly Linked List: (Can also be done without using tail node just like simple Linked List)
class DoublyLinkedList<T> {
    private class Node {
        T value;
        Node prev;
        Node next;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    Node head, tail;
    DoublyLinkedList() {
        this.head = this.tail = null;
    }

    int size() {
        int size = 0;
        Node currentNode = this.head;
        while(currentNode != null) {
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }

    void addFirst(T value) {
        if(this.head == null) {
            this.head = this.tail = new Node(value);
            return;
        }
        Node newNode = new Node(value, null, this.head);
        this.head.prev = newNode;
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
        Node newNode = new Node(value, this.tail, null);
        this.tail.next = newNode;
        this.tail = newNode;
    }

    void add(int index, T value) {
        if(this.head == null || index == 0) {
            addFirst(value);
            return;
        }
        Node currentNode = getNode(index - 1);
        if(currentNode == null) throw new IndexOutOfBoundsException(index);
        if(currentNode.equals(this.tail)) {
            addLast(value);
            return;
        }
        Node newNode = new Node(value, currentNode, currentNode.next);
        if(currentNode.next != null) currentNode.next.prev = newNode;
        currentNode.next = newNode;
    }

    T get(int index) {
        Node reqNode = getNode(index);
        if(reqNode == null) throw new IndexOutOfBoundsException(index);
        return reqNode.value;
    }

    void set(int index, T value) {
        Node reqNode = getNode(index);
        if(reqNode == null) throw new IndexOutOfBoundsException();
        reqNode.value = value;
    }

    void removeFirst() {
        if(this.head == null) throw new IndexOutOfBoundsException(0);
        this.head = this.head.next;
        if(this.head == null) {
            this.tail = null;
            return;
        }
        this.head.prev = null;
    }

    void removeLast() {
        remove();
    }

    void remove() {
        if(this.head == null || this.head == this.tail) {
            removeFirst();
            return;
        }
        this.tail = this.tail.prev; // different from singly linked list
        this.tail.next = null;
    }

    void remove(int index) {
        if(this.head == null || index == 0) {
            removeFirst();
            return;
        }
        Node reqNode = getNode(index); // different from singly linked list
        if(reqNode == null) throw new IndexOutOfBoundsException(index);
        if(reqNode.next == null) removeLast(); // reqNode is tail node
        reqNode.prev.next = reqNode.next;
        reqNode.next.prev = reqNode.prev;
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
        We no longer need to keep updating the index to find the last index now, as we can start
        traversal from tail node in doubly linked list
     */
    Integer lastIndexOf(T value) {
        Integer index = this.size() - 1;
        Node node = this.tail;
        while(node != null) {
            if(node.value.equals(value)) return index;
            node = node.prev;
            index--;
        }
        return null;
    }

    /*
        Reversing a doubly linked list is fairly simple due to back traversal
        We can either maintain a tail node from point of instantiation which I have done in this case,
        or if we do not maintain a tail node, we can first find the end node and then apply the
        algorithm.
     */
    void reverseShallow() {
        // Here we are just swapping the values of respective nodes
        Node startNode = this.head;
        Node endNode = this.tail;
        while(!startNode.equals(endNode)) {
            T temp = startNode.value;
            startNode.value = endNode.value;
            endNode.value = temp;
            startNode = startNode.next;
            endNode = endNode.prev;
            if(startNode.prev == endNode) break;
        }
    }
    void reverseDeep() { // deep Reversal
        // Here we are not just replacing/swapping the values, but changing the structure of linked list
        if(this.head == null || this.head.equals(this.tail)) return;
        Node node = this.tail;
        while(node != null) {
            Node temp = node.next;
            node.next = node.prev;
            node.prev = temp;
            node = node.next;
        }
        // Resetting head and tail
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
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