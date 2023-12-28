package _2_Implementation.OOP._4_Access_N_More;

public class ObjectDemo {
    // In IntelliJ these 'override' methods can be seen using 'Ctrl + O'

    @Override
    public int hashCode() { // Will be covered in detail later
        // For now we just have to know it gives a unique numerical representation of an object
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException { // It creates a 'copy' of the object
        // By 'copy' we mean that it creates a 'new' object of same type and containing same content
        // but, it occupies new additional space inside the memory
        // We can do 'arr2 = arr1.clone()' to create a copy of array where 'arr2' and 'arr1' will now
        // point to different array objects that contain the same type and number of elements
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) { // we cannot compare object equality the way we want using just '=='
        // 'obj1 == obj2' will only check whether both references are of the same object in the memory
        // So to compare a specific value to determine equality we use the '.equals()' method
        // That is why while comparing Strings we prefer using '.equals()' as it compares the String text
        // and not the actual object in the memory
        return super.equals(obj);
    }

    @Override
    public String toString() { // To provide String representation
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable { // When garbage collection wave hits this method runs
        super.finalize();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3}, arr2 = arr1.clone();
        arr1[0] = -1;
        System.out.println(arr2[0]);
        String s1 = "Sufiyan", s2 = new String("Sufiyan"), s3 = "Sufiyan";
        // Object references in s1 & s3 will be the same due to concept of StringPool
        System.out.println((s1 == s2)+" "+(s1 == s3));
        System.out.println(s1.equals(s2)+" "+s1.equals(s3));
        System.out.println(s1.hashCode()+" "+s2.hashCode()+" "+s3.hashCode());

        // The 'instanceof' keyword: checks whether an object is an instance of a class
        ObjectDemo objD = new ObjectDemo();
        System.out.println("Hey" instanceof String);
        System.out.println(objD instanceof ObjectDemo);
        System.out.println(objD instanceof Object);
        // Will also return true if object is of parent class:
        ObjectDemo objChild = new ObjDemoChild();
        System.out.println(objChild instanceof ObjectDemo);
        System.out.println(objChild instanceof ObjDemoChild);
        System.out.println(objD instanceof ObjDemoChild); // This will return false, parent class obj not instance of child class

        // Since every Object is an instance of Object class, we can use other methods as well
        // The getClass() method:
        System.out.println(objD.getClass()); // ObjectDemo
        System.out.println(objChild.getClass()); // ObjDemoChild
        System.out.println("Hey".getClass()); // String
    }
}

class ObjDemoChild extends ObjectDemo {

}
