package _2_Implementation.StacksNQueues;

public class UsingCustomStacks {
    public static void main(String[] args) throws Exception{
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
        for(int i = 0; i < 12; i++) { // Checking pop method and FILO principle
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
        System.out.println();
        CustomStack<Integer> dynaStack = new CustomStack<>();
        System.out.println(dynaStack.getCapacity()); // checking default constructor and getCapacity method
        System.out.println();
        CustomStack<Integer> dynaStack1 = new CustomStack<>(15);
        System.out.println(dynaStack1);
        System.out.println();
        for(int i = 1; i <= 20; i++) dynaStack1.push(i); // checking dynamic nature, 20 > 15
        System.out.println(dynaStack1 + "\n");
        for(int i = 0; i < 2; i++) System.out.println(dynaStack1.peek()); // checking peek
        System.out.println();
        for(int i = 0; i < 20; i++) { // checking pop
            System.out.print(dynaStack1.pop() + " ");
        }
        System.out.println();
        // System.out.println(dynaStack1.pop()); // will throw exception
        System.out.println("\n" + dynaStack1.peek() + "\n"); // will return null
        for(int i = 0; i < 15; i++) {
            dynaStack.push(i + 1);
            System.out.print(dynaStack + ", ");
            System.out.println("Elements in stack: "+dynaStack.size()+", Stack Capacity: "+dynaStack.getCapacity());
        }
    }
}
