package _2_Implementation.OOP._6_Generics_N_More;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/*
    We cannot directly compare objects using the comparison operators (<, ==, >, <=, >=)
    Thus, like we overrode 'toString' method for printing, we can override 'compareTo' method
    for defining the logic to compare objects.
    However, unlike 'toString' which is already defined inside the 'Object' class, 'compareTo'
    is not present by default.
    So, for making it mandatory to define a 'compareTo' method for comparing objects, we make
    the class implement the 'Comparable' interface.
    The 'Comparable' interface is a Generic Interface (Comparable<T>) using which we can define
    what object will be used for comparison. Due to this it will become mandatory to create an
    overridden 'compareTo' method that accepts an object of '<T>' type.
    The 'compareTo' method can also be overloaded inside the class for class instances other
    than the 'Type Measure (T)'.
 */

public class ObjectComparison {
    public static void main(String[] args) {
        Student s1 = new Student("Kunal", 5, 93.92f);
        Student s2 = new Student("Pepper Potts", 8, 88.93f);
        if(s1.compareTo(s2) > 0) System.out.println(s1.name+" has more marks in comparison to "+s2.name);
        else if(s1.compareTo(s2) < 0) System.out.println(s1.name+" has more marks in comparison to "+s2.name);
        else System.out.println("Both students have the same marks.\n");

        // Let us create an array of Student objects and sort them according to their marks:
        int arrSize = 5;
        Student[] stdArr = new Student[arrSize];
        stdArr[0] = new Student("Sufi", 8, 98.34f);
        stdArr[1] = new Student("Viv", 2, 99.23f);
        stdArr[2] = new Student("Aht", 3, 89.25f);
        stdArr[3] = new Student("Maaz", 5, 97.99f);
        stdArr[4] = new Student("Maviya", 6, 89.97f);
        Student[] cloneStdArr = stdArr.clone();

        System.out.println("Unsorted Student Lists: ");
        for(Student std: stdArr) System.out.print(std+", ");
        System.out.println();
        for(Student std: cloneStdArr) System.out.print(std+", ");

        System.out.println("\n Sorted Student Lists: ");
        Student.sortStdArray(stdArr);
        Arrays.sort(cloneStdArr); // This will work too !! Because internally it calls the object's 'compareTo' method
        for(Student std: stdArr) System.out.print(std+", ");
        System.out.println();
        for(Student std: cloneStdArr) System.out.print(std+", ");
    }
}

class Student implements Comparable<Student>{
    String name;
    int rollNum;
    float marks;

    Student(String name, int rollNum, float marks) {
        this.name = name;
        this.rollNum = rollNum;
        this.marks = marks;
    }

    @Override
    public int compareTo(@NotNull Student s) {
        float diff = this.marks - s.marks;
        if(diff < 0) return -1; // This means that 'this' current object is smaller than 's'
        if(diff > 0) return 1; // This means that 'this' current object is greater than 's'
        return 0; // Both objects are equal
    }

    @Override
    public String toString() {
        return this.name+"("+this.rollNum+", "+this.marks+")";
    }

    // Here we can make use of the 'compareTo' method:
    static void sortStdArray(Student[] stdArr) {
        boolean isSorted = true;
        for(int i = stdArr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(stdArr[j].compareTo(stdArr[j + 1]) > 0) {
                    isSorted = false;
                    Student temp = stdArr[j];
                    stdArr[j] = stdArr[j + 1];
                    stdArr[j + 1] = temp;
                }
            }
            if(isSorted) break;
        }
    }
}
