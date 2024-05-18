package _2_Implementation.Heaps;

import java.util.*;

public class UsingHeaps {
    public static void main(String[] args) {

        // Preparing heaps and required arrays
        Heap<Long> heap1 = new Heap<>(true); // Max Heap
        Heap<Integer> heap2 = new Heap<>(8); // Min Heap
        Integer[] arr1 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Long[] arr2 = new Long[arr1.length];
        for(int i = 0; i < arr1.length; i++) arr2[i] = (long) arr1[i];

        // Filling heaps using the arrays
        heap1.insert(arr2);
        heap2.insert(arr1);

        // Using other operations and heap functions
        System.out.println("Heap 1, Top Element: "+heap1.peek());
        System.out.println("Heap 2, Top Element: "+heap2.peek());
        System.out.println("Heap1: "+heap1);
        System.out.println("Heap2: "+heap2);
        for(int i = -20; i < 41; i += 10) {
            heap1.insert((long) i);
            heap2.insert(i);
            System.out.println("\nInserted: "+i);
            System.out.println("Heap1: "+heap1);
            System.out.println("Heap2: "+heap2);
        }
        for(int i = 0; i < 6 && i < heap1.size(); i++) {
            long item1 = heap1.remove(i);
            int item2 = heap2.remove(i);
            System.out.println("\nDeleted Element "+item1+" at index: "+i);
            System.out.println("Heap1: "+heap1);
            System.out.println("Deleted Element "+item2+" at index: "+i);
            System.out.println("Heap2: "+heap2);
        }

        // Heap Sort:
        List<Long> AL1 = heap1.sort();
        List<Integer> AL2 = heap2.sort();

        System.out.println("\nSorted Heap 1: "+AL1);
        System.out.println("Sorted Heap 2: "+AL2);

        // Using Heapify-Algorithm on pre-existing array to create heap in O(N) time:
        Double[] arr3 = {99.25, 29.2, 30.3, 53.5, 91.11, 45.72};
        Heap<Double> heap3 = new Heap<>();
        Heap<Double> heap4 = new Heap<>(6, true);
        heap3.heapify(arr3); // Min Heap
        heap4.heapify(arr3); // Max Heap
        System.out.println("\nHeap 3: "+heap3);
        System.out.println("Heap 4: "+heap4);

        // The built-in way to use a heap in Java:
        // The Java PriorityQueue can be used as a heap in java.
        PriorityQueue<Double> heapMin = new PriorityQueue<>(); // By-default it will create a minHeap
        Collections.addAll(heapMin, arr3);
        System.out.println("\nMin Heap with Priority Queue: "+heapMin);
        System.out.println("Accessing top element: "+heapMin.peek());
        System.out.println("Removing min element: "+heapMin.remove());
        System.out.println("Heap after removal: "+heapMin);

        // Creating a max heap
        PriorityQueue<Double> heapMax = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.addAll(heapMax, arr3);
        System.out.println("\nMax Heap with Priority Queue: "+heapMax);
        System.out.println("Accessing top element: "+heapMax.peek());
        System.out.println("Removing max element: "+heapMax.remove());
        System.out.println("Heap after removal: "+heapMax);
    }
}
