package _2_Implementation.StacksNQueues;

public class DynamicCQ<T> extends CircularQueue<T> {
    DynamicCQ() {
        super();
    }
    DynamicCQ(int capacity) {
        super(capacity);
    }

    @Override
    public boolean add(T value) {
        if(isFull()) resize();
        return super.add(value);
    }

    private void resize() {
        Object[] newArr = new Object[this.size * 2];
        int i = this.front, j = 0;
        do {
            newArr[j] = this.data[i];
            i = (i + 1) % this.data.length;
            j++;
        } while(i != this.end);
        this.front = 0;
        this.end = this.size;
        this.data = newArr;
    }
}
