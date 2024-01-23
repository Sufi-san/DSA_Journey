package _2_Implementation.StacksNQueues;

public class CustomStack<T> extends CustomStaticStack<T> {
    CustomStack() {
        super();
    }

    CustomStack(int capacity) {
        super(capacity);
    }

    @Override
    public boolean push(T element) {
        if(isFull()) increaseCap();
        return super.push(element);
    }

    @Override
    public T pop() throws Exception {
        if(this.size == 0) throw new Exception("Stack Empty");
        return (T) this.arr[--this.size];
    }

    private boolean isFull() {return this.size == this.arr.length - 1;}

    private void increaseCap() {
        Object[] newArr = new Object[this.arr.length * 2];
        for(int i = 0; i < this.arr.length; i++) newArr[i] = this.arr[i];
        this.arr = newArr;
    }
}
