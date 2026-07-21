package _2_Implementation.StacksNQueues;

public class CustomStaticStack<T> {
    protected Object[] arr;
    protected int size; // this will serve as the pointer for insertion and removal
    private static final int DEFAULT_CAPACITY = 10;

    CustomStaticStack() {
        this.arr = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    CustomStaticStack(int stackCapacity) {
        this.arr = new Object[stackCapacity];
        this.size = 0;
    }

    // Returns true on successful insertion
    public boolean push(T element) {
        if(size == arr.length) return false;
        this.arr[size++] = element;
        return true;
    }

    // Removes the top element from the stack and returns it
    public T pop() throws Exception { // The child class will throw the exception
        if(size == 0) return null;
        return (T) this.arr[--size];
    }

    // Returns the top element without removing it from the stack
    public T peek() {
        if(size == 0) return null;
        return (T) this.arr[size - 1];
    }

    // getters for size and capacity
    public int size() {return this.size;}
    public int getCapacity() {return this.arr.length;}

    // overriding toString method for printing
    @Override
    public String toString() {
        if(this.size == 0) return "[]";
        StringBuilder out = new StringBuilder();
        out.append("[");
        for(int i = 0; i < this.size; i++) out.append(arr[i]).append(", ");
        int endIndex = out.length() - 1;
        out.replace(endIndex - 1, endIndex, "]");
        return out.toString();
    }
}
