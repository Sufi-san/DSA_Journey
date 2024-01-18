package _2_Implementation.StacksNQueues;

import java.util.*;

public class Intro {
    public static void main(String[] args) {
        /*
            Stack:

            They follow the FILO (First In Last Out) or LIFO (Last In First Out) principle
            Stacks have a single opening.
            When an element is inserted (pushed), it becomes the top element and when an element is to
            be removed (popped), the top element itself is again removed.
            If the stack is full and insertion is tried on it, we get the 'StackOverflow Error'
            If the stack is empty and removal is tried on it, we get the 'StackUnderflow Error'
         */
        // In-built stack: internally an array with restrictions imposed
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack);
        for(int i = 0; i < 10; i++) stack.push(i + 1); // This is a dynamic stack so no Overflow error
        System.out.println(stack);
        for(int i = 0; i < 10; i++) System.out.print(stack.pop() + " "); // Returns the popped value too
        System.out.println("\n" + stack);
        // stack.pop(); // Here we will get the underflow error

        /*
            Queue:

            They follow the FIFO (First In First Out) or LILO (Last In Last Out) principle
            Queues have 2 openings/ends, one is the 'front' end and another is 'rear' end.
            Elements are removed from the 'front' and are inserted from the 'rear'.
         */
        // In-built Queue:
        /*
             Though there is a 'Queue' interface in Java, it is not a class using which we
             can create a queue object.
             So, in truth, the in-built implementation of a 'Queue' in java is a
             'Linked List'
             Why? Because similar to Linked List, we cannot directly access middle elements
             of a linked list and require the use of 'head' or 'tail' pointers to do so.
             So we can impose a few restrictions on the Linked List to insert elements only
             at the tail (tail node points to new element node and that new element becomes tail)
             and remove them only from the head (the element to which head points, becomes the new
             head)
             Why not use array for queue too? We can do so, but that will affect the time complexity
             of the push and pop(poll) operations as we might need to place existing elements to previous
             or next indices
         */
        Queue<Integer> queue = new LinkedList<>();
        // As we have used the Queue Interface as type, we cannot access Linked List specific methods via the object
        System.out.println(queue);
        for(int i = 0; i < 10; i++) queue.add(i + 1);
        System.out.println(queue);
        // The LinkedList<>() object has implementation of 'poll' as well and hence the method works
        for(int i = 0; i < 10; i++) System.out.print(queue.poll() + " ");
        System.out.println(queue.poll()); // will now return null as queue is empty

        // Deque: Double Ended Queue (can pop and poll from both sides), also called 'Deck' (correct pronunciation)
        Deque<Integer> deque = new ArrayDeque<>(); // We use ArrayDeque<>() object as 'Deque' is just an interface
        System.out.println(deque);
        // In a Deque, we can insert and remove from both sides
        for(int i = 5; i > 0; i--) deque.push(i); // We cannot do this in simple queue, elements entered from 'head'
        System.out.println(deque);
        for(int i = 5; i < 10; i++) deque.add(i + 1);
        System.out.println(deque);
        for(int i = 0; i < 5; i++) System.out.print(deque.pollFirst() + " ");
        System.out.println("\n" + deque);
        for(int i = 0; i < 5; i++) System.out.print(deque.pollLast() + " "); // We cannot do this in simple queue, removal from tail
        System.out.println("\n" + deque); // Deque now empty
    }
    // When do we use Stack & Queues while solving problems??
    /*
        - When we want to store a couple of values encountered while solving for the answer or an incomplete form of
        answer itself in a certain order, Stack & Queue can come in handy
        - They are also heavily used during tree or graph traversals
        - Also used for conversion of recursive solutions to iterative.
     */
}
