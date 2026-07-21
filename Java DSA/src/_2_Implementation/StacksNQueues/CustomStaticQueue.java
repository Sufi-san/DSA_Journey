package _2_Implementation.StacksNQueues;

public class CustomStaticQueue<T> {
    private final Object[] data;
    private int end;
    CustomStaticQueue() {
        this.data = new Object[10]; // where 10 is the default capacity used when no capacity is provided
        this.end = 0; // marks the end of the queue and also provides the size
    }

    CustomStaticQueue(int capacity) {
        this.data = new Object[capacity];
        this.end = 0;
    }

    public int size() {return end;}

    public int getCapacity(){return data.length;}

    public boolean add(T value) {
        if(isFull()) return false;
        this.data[this.end++] = value;
        return true;
    }

    public T poll() {
        if(isEmpty()) return null;
        T value = (T) this.data[0];
        for(int i = 0; i < this.end - 1; i++) this.data[i] = this.data[i + 1];
        this.end--;
        return value;
    }

    public T peek() {
        if(isEmpty()) return null;
        return (T) this.data[0];
    }

    public boolean isFull() {
        return this.end == data.length;
    }

    public boolean isEmpty() {
        return this.end == 0;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        StringBuilder out = new StringBuilder();
        out.append("[");
        for(int i = 0; i < this.end; i++) out.append(data[i]).append(", ");
        int endIndex = out.length() - 1;
        out.replace(endIndex - 1, endIndex, "]");
        return out.toString();
    }
}
