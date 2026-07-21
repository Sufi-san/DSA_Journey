package _2_Implementation.HashMaps;

import java.util.ArrayList;
import java.util.List;

public class HashFunction {
    public static void main(String[] args) {
        // To get a unique number from any input value, we can use the built-in Java 'hashCode' function
        // Every java Object has a function 'hashCode()' that lets us retrieve a hashcode for specific object.
        List<Object> list = new ArrayList<>();
        list.add(762);
        list.add(20);
        list.add(82.0);
        list.add(78d);
        list.add("Sufi");
        list.add("Kunal");
        for(Object obj: list) {
            System.out.println(obj+" ("+obj.getClass().getSimpleName()+")"+": HashCode = "+obj.hashCode());
        }
        // The generated hash code will always be the same (depending on internal algorithm used) for a specific value
    }
}
