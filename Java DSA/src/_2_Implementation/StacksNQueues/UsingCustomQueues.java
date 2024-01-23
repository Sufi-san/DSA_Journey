package _2_Implementation.StacksNQueues;

public class UsingCustomQueues {
    public static void main(String[] args) throws Exception{
        // Testing Static Queue implemented using Array
        CustomStaticQueue<String> customStringQueue = new CustomStaticQueue<>();
        System.out.println(customStringQueue.getCapacity() + "\n");
        CustomStaticQueue<Integer> customQueue = new CustomStaticQueue<>(11);
        System.out.println(customQueue + "\n");
        for(int i = 0; i < 12; i++) { // Note: 12 > capacity, as we want to check for the 'false' return value
            if(customQueue.add(i)) System.out.print("Inserted "+i);
            else System.out.print("Insertion Failed ("+i+")");
            System.out.println(", Queue Capacity: "+customQueue.getCapacity()+", Items in Queue: "+customQueue.size());
        }
        System.out.println(customQueue + "\n");
        for(int i = 0; i < 2; i++) { // As we are peeking, the element returned will be the same if used in succession
            Integer num = customQueue.peek();
            if(num != null) System.out.print("Peeked "+num);
            else System.out.print("Peek failed");
            System.out.println(", Queue Capacity: "+customQueue.getCapacity()+", Items in Queue: "+customQueue.size());
        }
        System.out.println(customQueue + "\n");
        for(int i = 0; i < 12; i++) { // Checking poll method and FIFO principle
            Integer num = customQueue.poll();
            if(num != null) System.out.print("Polled "+num);
            else System.out.print("Poll failed");
            System.out.println(", Queue Capacity: "+customQueue.getCapacity()+", Items in Queue: "+customQueue.size());
        }
        System.out.println(customQueue + "\n");
        Integer num = customQueue.peek();
        if(num != null) System.out.println(num);
        else System.out.println("Queue Empty");

        // Testing Circular Queue implemented using Array
        System.out.println();
        CircularQueue<Character> dummyQueue = new CircularQueue<>();
        System.out.println(dummyQueue.getCapacity()); // Testing Default Capacity
        System.out.println();
        CircularQueue<Character> circularQueue = new CircularQueue<>(11);
        System.out.println(circularQueue+"\n");
        for(int i = 0; i < 14; i++) {
            char chr = (char)('a' + i);
            if(circularQueue.add(chr)) System.out.print("Added: "+chr+", ");
            else System.out.print("Cannot Add: "+chr+", ");
            System.out.println("Queue Cap: "+circularQueue.getCapacity()+", Size: "+circularQueue.size()+", Queue: "+circularQueue);
        }
        System.out.println();
        for(int i = 0; i < 14; i++) {
            char chr = (char)(circularQueue.peek() + circularQueue.size());
            System.out.print("Removed: "+circularQueue.poll()+", ");
            if(circularQueue.add(chr)) System.out.print("Added: "+chr+", ");
            System.out.println("Queue Cap: "+circularQueue.getCapacity()+", Size: "+circularQueue.size()+", Queue: "+circularQueue);
        }
        System.out.println();
        for(int i = 0; i < 14; i++) {
            Character chr = circularQueue.poll();
            if(chr != null) System.out.print("Removed: "+chr+", ");
            else System.out.print("Queue is Empty, ");
            System.out.println("Queue Cap: "+circularQueue.getCapacity()+", Size: "+circularQueue.size()+", Queue: "+circularQueue);
        }

        // Testing Custom Dynamic Circular Queue implemented using Array
        System.out.println();
        DynamicCQ<Character> dummyDynaQueue = new DynamicCQ<>();
        System.out.println(dummyDynaQueue.getCapacity()); // Testing Default Capacity
        System.out.println();
        DynamicCQ<Character> circularDynaQueue = new DynamicCQ<>(5);
        System.out.println(circularDynaQueue+"\n");
        for(int i = 0; i < 14; i++) {
            char chr = (char)('a' + i);
            if(circularDynaQueue.add(chr)) System.out.print("Added: "+chr+", ");
            else System.out.print("Cannot Add: "+chr+", ");
            System.out.println("Queue Cap: "+circularDynaQueue.getCapacity()+", Size: "+circularDynaQueue.size()+", Queue: "+circularDynaQueue);
        }
        System.out.println();
        for(int i = 0; i < 14; i++) {
            char chr = (char)(circularDynaQueue.peek() + circularDynaQueue.size());
            System.out.print("Removed: "+circularDynaQueue.poll()+", ");
            if(circularDynaQueue.add(chr)) System.out.print("Added: "+chr+", ");
            System.out.println("Queue Cap: "+circularDynaQueue.getCapacity()+", Size: "+circularDynaQueue.size()+", Queue: "+circularDynaQueue);
        }
        System.out.println();
        for(int i = 0; i < 14; i++) {
            Character chr = circularDynaQueue.poll();
            if(chr != null) System.out.print("Removed: "+chr+", ");
            else System.out.print("Queue is Empty, ");
            System.out.println("Queue Cap: "+circularDynaQueue.getCapacity()+", Size: "+circularDynaQueue.size()+", Queue: "+circularDynaQueue);
        }

        // Testing Custom Dynamic Queue implemented using Linked List
        System.out.println();
        CustomQueue<Integer> queue = new CustomQueue<>();
        System.out.println(queue); // Testing toString for empty queue
        System.out.println();
        for(int i = 0; i < 15; i++) queue.add(i + 1); // Testing add (add) method
        System.out.println(queue);
        System.out.println();
        for(int i = 0; i < 2; i++) System.out.println(queue.peek()); // Testing peek method
        System.out.println();
        for(int i = 0; i < 15; i++) {
            // Testing poll and FIFO principle
            System.out.println("Removed: "+queue.poll()+", Queue: "+queue);
        }
        System.out.println();
        System.out.println(queue.peek()); // Testing peek for empty array
        // System.out.println(queue.poll()); // Testing exception handling
        for(int i = 0; i < 10; i++) {
            // Testing size method
            System.out.println("Queue: "+queue+", Size: "+queue.size());
            queue.add(i + 1);
            if(i + 1 == 10) System.out.println("Queue: "+queue+", Size: "+queue.size());
        }
    }
}
