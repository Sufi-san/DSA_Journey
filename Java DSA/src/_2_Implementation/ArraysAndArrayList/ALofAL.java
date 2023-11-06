package _2_Implementation.ArraysAndArrayList;
import java.util.Scanner;
import java.util.ArrayList;
public class ALofAL {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(5);  // Here the generic is Arraylist itself.
        // This means that it is a dynamic array containing dynamic arrays as elements.
        // It is basically a 2D ArrayList
        for (int i = 0; i < 3; i++) {  // Initializing the ArrayList of ArrayLists.
            list.add(new ArrayList<>(5));  // Inserted 3 empty ArrayList objects into the ArrayList.
        }
        System.out.println(list);

        //  Input: Creating and adding individual elements to 2D arraylist
        System.out.println(list.size());  // will return 3 due to above for-loop declaration
        ArrayList<Integer> a1 = new ArrayList<>(5);  // creating new arraylist object
        a1.add(45); a1.add(46); a1.add(47);  // Adding three elements in arraylist using arraylist object
        list.add(a1);  // adding the arraylist at index 3 of the 2D arraylist.
        System.out.println(list.size()); // size of 2D arraylist is now updated, thus the dynamic nature is proved.
        System.out.println(list);

        // Input: Using for-loop and taking user-input for 2D ArrayList:
        System.out.println("Enter ArrayList Elements: ");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 3; j++) {  // Here we cannot mention the size of internal arraylists as they are dynamic,
                // Thus, to make the for loop stop at a certain point and accept another arraylist input we define limit.
                // In this case, we have set it up such that we can enter 3 elements inside each arraylist.
                list.get(i).add(s1.nextInt()); // Here list.get(i) obtains sub ArrayList using for loop's 'i' as index
                // and .add(s1.nextInt()) adds user input to the subArrayList.
                // In this case, each arraylist will contain three elements.
                // Since ArrayList at index 3 already has 3 elements, more 3 elements will be added after the old ones.
            }
        }

        /* Enhanced for loop for accepting arraylist input will look like:
        for (ArrayList<Integer> integers : list) { // since each element is an integer arraylist, its type is 'ArrayList<Integer>'
            for (int j = 0; j < 3; j++) {
                integers.add(s1.nextInt());
            }
        }
         */
        System.out.println(list);
    }
}
