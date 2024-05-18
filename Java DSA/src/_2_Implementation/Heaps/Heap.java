package _2_Implementation.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap<T extends Comparable<? super T>> {

    private List<T> AL;
    boolean maxHeap;
    private final int capacity = 10;

    Heap() {
        setHeap(capacity, false);
    }

    Heap(boolean isMax) {
       setHeap(capacity, isMax);
    }

    Heap(int capacity) {
        setHeap(capacity, false);
    }

    Heap(int capacity, boolean isMax) {
        setHeap(capacity, isMax);
    }

    private void setHeap(int capacity, boolean isMax) {
        AL = new ArrayList<>(capacity);
        maxHeap = isMax;
    }

    public T peek() {return AL.get(0);}

    private void swap(int parentInd, int i) {
        T temp = AL.get(parentInd);
        AL.set(parentInd, AL.get(i));
        AL.set(i, temp);
    }

    private int parent(int i) {return (i - 1) / 2;}

    private int left(int i) {return 2 * i + 1;}

    private int right(int i) {return 2 * i + 2;}

    public int size() {return AL.size();}

    public boolean isEmpty() {return size() == 0;}

    void insert(T[] arr) {
        for(T comparable: arr) this.insert(comparable);
    }

    void insert(T element) {
        AL.add(element); // First adding at the end of the tree

        // Going up-heap
        for(int i = AL.size() - 1; i > 0; i = (i - 1) / 2) {
            boolean swapped = false;
            int comp = (AL.get(parent(i)).compareTo(AL.get(i)));
            boolean c1 = maxHeap && comp < 0;
            boolean c2 = !maxHeap && comp > 0;
            if(c1 || c2) {
                swap(parent(i), i);
                swapped = true;
            }
            if(!swapped) break;
        }
    }

    public T remove() {return remove(0);}

    T remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= AL.size()) throw new IndexOutOfBoundsException("Index "+index+" out of bounds");
        T item = AL.get(index);
        AL.set(index, AL.get(AL.size() - 1));
        AL.remove(AL.size() - 1);

        // Going down-heap
        while((2 * index + 1 < AL.size())) {
            // Complete Binary Tree nodes do not have guaranteed right child
            // Thus, we are preparing to deal with an edge case with below line of code
            boolean hasRight = right(index) < AL.size();

            T parentVal = AL.get(index);
            T leftVal = AL.get(left(index));
            T rightVal = (hasRight)? AL.get(right(index)): null;
            int compPL = parentVal.compareTo(leftVal);
            int compPR = (hasRight)? parentVal.compareTo(rightVal): 0;
            boolean c1 = maxHeap && compPL >= 0 && compPR >= 0;
            boolean c2 = !maxHeap && compPL <= 0 && compPR <= 0;
            if(c1 || c2) break; // No further swaps required

            // If we reach this part, then it means swap is mandatory, now we just decide which one.
            int compLR = (hasRight)? leftVal.compareTo(rightVal): 0;
            int swapInd = (maxHeap && compLR >= 0 || (!maxHeap && compLR <= 0))? left(index): right(index);
            swap(index, swapInd);
            index = swapInd;
        }
        return item;
    }

    // Created heapify to efficiently create heaps using pre-existing array
    // The array will be first heapified, and then its elements will be copied to AL
    // Both the processes will be completed in O(N) time
    // Also makes use of a recursive down-heap method
    void heapify(T[] arr) {
        for(int i = arr.length / 2 - 1; i >= 0; i--) downHeap(arr, i);
        Collections.addAll(AL, arr);
    }

    private void downHeap(T[] arr, int i) {
        boolean hasRight = 2 * i + 2 < arr.length;
        int leftInd = 2 * i + 1, rightInd = 2 * i + 2;
        T parentVal = arr[i];
        T leftVal = arr[leftInd];
        T rightVal = (hasRight)? arr[rightInd]: null;
        int compPL = parentVal.compareTo(leftVal);
        int compPR = (hasRight)? parentVal.compareTo(rightVal): 0;
        boolean c1 = this.maxHeap && compPL >= 0 && compPR >= 0;
        boolean c2 = !this.maxHeap && compPL <= 0 && compPR <= 0;
        if(c1 || c2) return;
        int compLR = (hasRight)? leftVal.compareTo(rightVal): 0;
        int swapInd = (compLR >= 0 && this.maxHeap || compLR <= 0 && !this.maxHeap)? (leftInd): (rightInd);
        arr[i] = arr[swapInd];
        arr[swapInd] = parentVal;
        if(leftInd < arr.length / 2) downHeap(arr, swapInd); // Don't go lower if index > n / 2;
    }

    public List<T> sort() {return sort(false);}

    public List<T> sort(boolean desc) {
        List<T> sorted = new ArrayList<>();
        while(!this.isEmpty()) sorted.add(this.remove());
        if((desc && !maxHeap) || (!desc && maxHeap)) {
            for(int i = 0; i < (sorted.size() + 1) / 2; i++) {
                T temp = sorted.get(i);
                sorted.set(i, sorted.get(sorted.size() - 1 - i));
                sorted.set(sorted.size() - 1 - i, temp);
            }
        }
        return sorted;
    }

    @Override
    public String toString() {
        return AL.toString();
    }

}
