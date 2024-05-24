package _2_Implementation.HashMaps;

import _2_Implementation.StringBuffer.RandomString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HashStructs {
    public static void main(String[] args) {
        // Using pre-defined built-in Java classes and the functions they provide
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        // Using 'put' to insert pairs in map and 'add' to insert marks in set.
        String[] names = {"Sufi", "Faizu", "Raiho", "Uzzu", "Zubi"};
        int[] marks = {92, 95, 97, 97, 95};
        for(int i = 0; i < names.length; i++) {
            map.put(names[i], marks[i]);
            set.add(marks[i]);
        }

        // Printing the set and map:
        System.out.println("Set: "+set);
        System.out.println("Map: "+map);

        // Using .keySet() to get a set of keys from HashMap:
        // (return type is 'Set<>'.)
        // (it is a set as all keys are unique)
        System.out.println("Keys in Map: "+map.keySet());

        // Using .values() to get an array of values:
        // (return type is 'Collection<>'.)
        // (this will not be a set as it shows values for all keys irrespective of values being identical)
        System.out.println("Values in Map: "+map.values());

        // Checking using 'contains' for set and 'containsValue' for map
        int[] test = {100, 99, 97, 98, 92, 95};
        System.out.println("\nValues for testing: "+ Arrays.toString(test));
        for(int i = 0; i < marks.length; i++) {
            if(map.containsValue(test[i])) System.out.println("Map has value "+test[i]);
            if(set.contains(test[i])) System.out.println("Set has value "+test[i]);
        }

        // Using 'containsKey' to check for valid keys in map
        // Retrieving values using 'key' from map with 'get' method
        String[] keys = {"Raiho", "Uzzu", "Altaf", "Zubi", "Ammar"};
        System.out.println("\nKeys for checking: "+Arrays.toString(keys));
        for(String key: keys) {
            if(map.containsKey(key)) System.out.println(key+"'s marks: "+map.get(key));
            else System.out.println("No Record found for key: "+key);
        }

        // Removing and reviewing keys in HashMap
        map.remove("Zubi");
        System.out.println("Removed key 'Zubi'");
        System.out.println("Map contains Zubi?: "+map.containsKey("Zubi"));
        System.out.println(map);

        // Using custom map implementation with Chaining, LinkedList and Dynamic Resizing & Restructuring:
        System.out.println("\n\nRepeating operations using Custom Map: ");
        CustomHmap<String, Integer> myMap = new CustomHmap<>();
        for(int i = 0; i < names.length; i++) myMap.put(names[i], marks[i]);
        System.out.println("\nMap: "+myMap);
        System.out.println("Keys in Map: "+myMap.keySet());
        System.out.println("Values in Map: "+myMap.values());
        System.out.println("\nValues for testing: "+ Arrays.toString(test));
        for(int i = 0; i < marks.length; i++) {
            if(myMap.containsValue(test[i])) System.out.println("Map has value "+test[i]);
        }
        System.out.println("\nKeys for checking: "+Arrays.toString(keys));
        for(String key: keys) {
            if(myMap.containsKey(key)) System.out.println(key+"'s marks: "+myMap.get(key));
            else System.out.println("No Record found for key: "+key);
        }
        myMap.remove("Zubi");
        System.out.println("Removed key 'Zubi'");
        System.out.println("Map contains Zubi?: "+myMap.containsKey("Zubi"));
        System.out.println(myMap);

        // Checking restructuring capabilities for custom Map:
        RandomString rObj = new RandomString();
        CustomHmap<String, String> myMap1 = new CustomHmap<>(5);
        for(int i = 0; i < 10; i++) {
            String key = rObj.getRandomAlphaString(5);
            String val = Integer.toString(i);
            myMap1.put(key, val);
        }
        System.out.println(myMap1);
        System.out.println("Number of keys in map: "+myMap1.size());
    }
}
