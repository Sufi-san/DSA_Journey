package _2_Implementation.OOP._6_Generics_N_More;

import java.util.ArrayList;

      /*
        Generics:

        Generics primarily serve to set parameterized types for classes, interfaces, and methods.
        They provide a way to write code that can work with a variety of data types without compromising
        type safety or requiring extensive type casting.

        While using Generic Templates(Type Parameters) for defining classes, it is important to know that
        we cannot directly instantiate objects of 'Type Template' as they will cause ambiguity in 'byte code'.
        Thus, when need arises for instantiation, we can use the 'Object' class instead which is
        automatically inherited by all classes

        We cannot add primitives inside the generic notation, only class names are allowed.
        The use of the 'Object' class and generic templates '<(any name here)>' along with the complete
        example of working with generics becomes clear by observing the custom ArrayList implementation.
     */

public class ArrayListX<T> { // The <T> here will be replaced by class Names and will enforce type safety on instances
    private Object[] arr; // actual array
    // we aren't using T-type array because we cannot instantiate object of type T at runtime
    // because T will not be defined at runtime
    // Thus, T will only serve the purpose of type checking whenever an object is inserted into the array
    // the type checking will happen by using T as the type of the parameter which will represent the arguments
    // passed when the method is used
    private int size = 0; // marks the end of the arraylist inside the actual array

    ArrayListX() {initHelper(10);}
    ArrayListX(int initialCapacity) {initHelper(initialCapacity);}

    private void initHelper(int initialCapacity) {
        this.arr = new Object[initialCapacity];
    }

    private boolean isFull() {
        return this.size == this.arr.length;
    }

    private void resize() {
        Object[] newArr = new Object[this.arr.length * 2];
        for(int i = 0; i < size; i++) newArr[i] = this.arr[i];
        this.arr = newArr;
    }

    void add(T element) { // T performs type-check
        if(isFull()) resize();
        this.arr[size++] = element;
    }

    Object get(int index) {
        if(index >= size && index < 0) {
            System.out.println("Index out of bounds");
            return null;
        }
        return this.arr[index];
    }

    void set(int index, T element) { // T performs type-check
        if(index >= size && index < 0) {
            System.out.println("Index out of bounds");
            return;
        }
        this.arr[index] = element;
    }

    int size() {
        return this.size;
    }

    void remove() {
        this.size--;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("[");
        for(int i = 0; i < size; i++) {
            if(i != 0) strBuild.append(", ");
            strBuild.append(this.arr[i]);
        }
        strBuild.append("]");
        return strBuild.toString();
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw use of parameterized class
        // As ArrayList uses a Generic '<>' if we do not provide a generic then, it is by default
        // considered of the 'Object' type.
        // Thus, when used 'raw' we can perform basic list operations on objects of 'ANY' class
        // as all of them extend the 'Object' class
        // This usage however, is not preferred as the 'type safety' which is one of the reasons
        // behind using Generics, is sacrificed.
        list.add("String");
        list.add(1);
        list.add('c');
        list.add(false);
        list.add(6.7f);
        list.add(5321L);
        list.add(32463.651);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
            System.out.println(list.get(i).getClass().getSimpleName());
        }
        System.out.println("\n"+list);
        System.out.println();

        // Instantiating object of custom arraylist:
        ArrayListX<Integer> customAL = new ArrayListX<>();
        // customAL.add(56.7); will not be valid as input is not 'Integer' instance
        fillAL(customAL, "int");

        ArrayListX<Double> customAL1 = new ArrayListX<>();
        // customAL1.add("String"); will not be valid as input is not 'Double' instance
        fillAL(customAL1, "double");

        ArrayListX<Character> customAL2 = new ArrayListX<>();
        // customAL2.add(8); will return error as input is not 'Character' instance
        fillAL(customAL2, "char");

        ArrayListX<Boolean> customAL3 = new ArrayListX<>();
        // customAL3.add("true"); will return error as input is not 'Boolean' instance
        fillAL(customAL3, "boolean");

        ArrayListX<String> customAL4 = new ArrayListX<>();
        // customAL4.add(true); will return error as input is not 'String' instance
        fillAL(customAL4, "String");

        processAL(customAL);
        processAL(customAL1);
        processAL(customAL2);
        processAL(customAL3);
        processAL(customAL4);

        // Instantiating objects of more restrictive custom arraylist:
        ArrayListX2<Integer> customAL5 = new ArrayListX2<>();
        fillAL(customAL5, "int");
        System.out.println(customAL5);

        ArrayListX2<Long> customAL6 = new ArrayListX2<>();
        fillAL(customAL6, "long");
        System.out.println(customAL6);

        ArrayListX2<Double> customAL7 = new ArrayListX2<>();
        fillAL(customAL7, "double");
        System.out.println(customAL7);
        // ArrayListX2<String> x = new ArrayListX2<String>(); will now be erroneous as 'String' does not extend 'Number'
    }

    static void processAL(ArrayListX customAL) { // We use 'ArrayListX' class Raw, because we want to pass different types
        System.out.println(customAL); // working of overridden .toString() method
        for(int i = 1; i < customAL.size(); i++) { // working of .size() method
            if(i % 4 == 0) { // working of .get() method
                customAL.set(i, customAL.get(i - 1)); // working of .set() method
            }
        }
        System.out.println(customAL);
        for(int i = 0; i < 4; i++) customAL.remove(); // working of .remove() method
        System.out.println(customAL);
    }

    static void fillAL(ArrayListX customAL, String type) {
        switch(type) {
            case "int": {
                for (int i = 0; i < 20; i += 2) {
                    customAL.add(i); // working of .add() method
                }
                break;
            }
            case "long": {
                for (long i = 1000; i <= Math.pow(10, 12); i = (long)Math.pow(i, 2)) {
                    customAL.add(i); // working of .add() method
                }
                break;
            }
            case "double": {
                for (double i = 0.6; i < 20; i += 2.5) {
                    customAL.add(i);
                }
                break;
            }
            case "char": {
                for (char i = 'a'; i <= 'z'; i++) {
                    customAL.add(i);
                }
                break;
            }
            case "boolean": {
                for (int i = 0; i < 20; i++) {
                    customAL.add(i % 2 == 0);
                }
                break;
            }
            case "String": {
                for (int i = 0; i < 20; i += 2) {
                    customAL.add("String" + i);
                }
                break;
            }
        }
    }
}


class ArrayListX2<T extends Number> extends ArrayListX<T> {
    // Here T will restrict the input even further, such that only the objects of those classes
    // that inherit the 'Number' class will be inserted into the array
    // This means now, 'String', 'Character', 'Boolean' cannot be inserted into the ArrayList
}
