package _2_Implementation.StacksNQueues;

public class UsingCustoms {
    public static void main(String[] args) {
        // Always need capacity for static stack, if none is passed then the DEFAULT_CAPACITY (10) will be used
        CustomStaticStack<String> customStringStack = new CustomStaticStack<>();
        System.out.println(customStringStack.getCapacity() + "\n");
        CustomStaticStack<Integer> customStack = new CustomStaticStack<>(11);
        System.out.println(customStack + "\n");
        for(int i = 0; i < 12; i++) { // Note: 12 > capacity, as we want to check for the 'false' return value
            if(customStack.push(i)) System.out.print("Inserted "+i);
            else System.out.print("Insertion Failed ("+i+")");
            System.out.println(", Stack Capacity: "+customStack.getCapacity()+", Items in stack: "+customStack.size());
        }
        System.out.println(customStack + "\n");
        for(int i = 0; i < 2; i++) { // As we are peeking, the element returned will be the same if used in succession
            Integer num = customStack.peek();
            if(num != null) System.out.print("Peeked "+num);
            else System.out.print("Peek failed");
            System.out.println(", Stack Capacity: "+customStack.getCapacity()+", Items in stack: "+customStack.size());
        }
        System.out.println(customStack + "\n");
        for(int i = 0; i < 12; i++) {
            Integer num = customStack.pop();
            if(num != null) System.out.print("Popped "+num);
            else System.out.print("Pop failed");
            System.out.println(", Stack Capacity: "+customStack.getCapacity()+", Items in stack: "+customStack.size());
        }
        System.out.println(customStack + "\n");
        Integer num = customStack.peek();
        if(num != null) System.out.println(num);
        else System.out.println("Stack Empty");

        // Testing Custom Dynamic Stack Implementation

    }
}
