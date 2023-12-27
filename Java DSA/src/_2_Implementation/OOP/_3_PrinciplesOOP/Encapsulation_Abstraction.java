package _2_Implementation.OOP._3_PrinciplesOOP;

public class Encapsulation_Abstraction {

    public static void main(String[] args) {
        // Encapsulation:
        /*
            Wrapping up implementation of data members & methods in a class.
            Stores and hides all the logical details and private properties from the outside world
         */
        // Abstraction:
        /*
            Hiding 'Unnecessary' details and showing valuable information
         */
         /*
             Differences:
             Abstraction solves design level issue and Encapsulation solves implementation level issue
             Abstraction focuses on external actions and Encapsulation focuses on internal working
             Abstraction is achieved via Abstract classes & Interfaces while Encapsulation is achieved by
             organizing elements inside classes
             Abstraction is process of gaining information while Encapsulation is process of containing information
         */

        /*
             Data Hiding vs Encapsulation:
             Clear difference, data hiding focuses on security aspects while encapsulation is hiding the complexity
             of the system. However, Encapsulation is a subprocess in Data Hiding
             Example of Data Hiding: (using private keyword), Example of Encapsulation: (use of getters & setters)
         */

        // Good Code Examples of Abstractions will be covered later

        // Encapsulation is all of whatever we did so far. From creating classes with instance variables, placing
        // constructors and methods inside those classes, setting up ways to perform certain functions inside those
        // classes etc.
        // Example:
        // Here we encapsulated all the complexity of maintaining an 'array' as an 'ArrayList' inside the
        // 'ArrayListInteger' class
        ArrayListInteger aL = new ArrayListInteger();
        ArrayListInteger aL1 = new ArrayListInteger(10);
        System.out.println(aL);
        System.out.println(aL1);
        for(int i = 0; i < aL1.size(); i++) {
            aL.add(i);
            aL1.set(i, i);
        }
        System.out.println(aL);
        System.out.println(aL1);
        int pointer = 0;
        while(pointer < aL.size()) {
            if(aL.get(pointer) % 2 != 0) {
                aL.remove(pointer);
                continue;
            }
            pointer++;
        }
        pointer = 0;
        while(pointer < aL1.size()) {
            if(aL1.get(pointer) % 2 == 0) {
                aL1.remove(pointer);
                continue;
            }
            pointer++;
        }
        System.out.println(aL);
        System.out.println(aL1);
        for(int i = 0; i < aL.size(); i += 2) {
            aL.add(i, 0);
            aL1.add(i, 0);
        }
        System.out.println(aL);
        System.out.println(aL1);
        aL.add(2);
    }
}

class ArrayListInteger { // Best way to understand Encapsulation by creating our very own simple Integer ArrayList class
    private int[] arr; // Setting up a data member as well as a way to not provide direct access to it
    // That is, user cannot 'directly' access or modify the array via the ArrayListInteger instance

    ArrayListInteger() {
        this.arr = new int[]{};
    }

    ArrayListInteger(int initLen) {
        this.arr = new int[initLen];
    }

    // Providing Indirect access and Modification options via methods

    public int size() { // Getter
        return this.arr.length;
    }

    public void add(int num) { // Setter
        int[] newArr = new int[this.arr.length + 1];
        for(int i = 0; i < this.arr.length; i++) {
            newArr[i] = this.arr[i];
        }
        newArr[newArr.length - 1] = num;
        this.arr = newArr;
    }

    public void add(int index, int num) { // Setter
        int arrLen = this.arr.length;
        if(index > arrLen || index < 0) {
            System.out.println("ArrayIndexOutOfBounds");
            return;
        }
        int[] newArr = new int[arrLen + 1];
        for(int i = 0, j = 0; i < newArr.length; i++) {
            if(i == index) {
                newArr[i] = num;
                continue;
            }
            newArr[i] = this.arr[j];
            j++;
        }
        this.arr = newArr;
    }

    public int get(int index) { // Getter
        if(index > this.arr.length - 1 || index < 0) {
            System.out.println("ArrayIndexOutOfBounds");
            return index;
        }
        return arr[index];
    }

    public void set(int index, int num) { // Setter
        if(index > this.arr.length - 1 || index < 0) {
            System.out.println("ArrayIndexOutOfBounds");
            return;
        }
        this.arr[index] = num;
    }

    public void remove(int index) { // Setter
        if(index > this.arr.length - 1 || index < 0) {
            System.out.println("ArrayIndexOutOfBounds");
            return;
        }
        int[] newArr = new int[this.arr.length - 1];
        for(int i = 0, j = 0; i < this.arr.length; i++) {
            if(i == index) continue;
            newArr[j] = this.arr[i];
            j++;
        }
        this.arr = newArr;
    }

    @Override
    public String toString() {
        StringBuilder allInt = new StringBuilder();
        for(int i = 0; i < this.arr.length; i++) {
            if(i + 1 == this.arr.length) {
                allInt.append(this.arr[i]);
                break;
            }
            allInt.append(this.arr[i]).append(", ");
        }
        return "["+allInt+"]";
    }
}


