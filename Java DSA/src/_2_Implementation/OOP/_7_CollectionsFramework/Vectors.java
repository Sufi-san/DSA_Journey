package _2_Implementation.OOP._7_CollectionsFramework;

import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        // Vectors are like an arraylist with a few differences:
        // Vectors are synchronized, can be accessed by 'single' thread at once. (more about threads in multithreading)

        Vector<Integer> vector = new Vector<>();
        for(int i = 0; i <= 16; i += 2) vector.add(i);
        System.out.println(vector);
        for(int i = 0; i < vector.size(); i++) {
            if(i != 0 && vector.get(i) % 4 == 0) vector.set(i, vector.get(i) - 4);
            else vector.set(i, vector.get(i) + 4);
        }
        System.out.println(vector);
    }
}
