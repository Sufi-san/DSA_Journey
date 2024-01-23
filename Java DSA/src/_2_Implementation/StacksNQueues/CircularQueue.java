package _2_Implementation.StacksNQueues;

public class CircularQueue<T> {
    protected Object[] data;
    protected int front;
    protected int end;
    protected int size;
    CircularQueue() {
        this.data = new Object[10];
        this.front = this.end = this.size = 0;
    }
    CircularQueue(int capacity) {
        this.data = new Object[capacity];
        this.front = this.end = this.size = 0;
    }
    public int size() {return this.size; }

    public int getCapacity() {return this.data.length;}

    public boolean add(T value) {
        if(isFull()) return false;
        this.data[end++] = value;
        this.end %= this.data.length;
        this.size++;
        return true;
    }

    public T poll() {
        if(isEmpty()) return null;
        T value = (T) this.data[front++];
        this.front %= this.data.length;
        this.size--;
        return value;
    }

    public T peek() {
        if(isEmpty()) return null;
        return (T) this.data[front];
    }

    public boolean isFull() {return this.size == this.data.length;}

    public boolean isEmpty() {return this.size == 0;}

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        StringBuilder out = new StringBuilder();
        out.append("[..., ");
        int i = this.front;
        do { // do-while because, 'front' and 'end' can be equal in some cases
            out.append(this.data[i]).append(", ");
            i = (i + 1) % this.data.length;
        } while(i != this.end);
        out.append("...]");
        // Uncomment below line to better understand front and end pointer positions and state of the array
        // System.out.println(Arrays.toString(this.data)+", front: "+this.front+", end: "+this.end);
        return out.toString();
    }
}
