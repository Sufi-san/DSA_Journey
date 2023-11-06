package _2_Implementation.StringAndStringBuilder;

public class StringPerformance {
    public static void main(String[] args) {
        String alphab = "";
        for(int i = 0; i < 26; i++){
            char ch = (char)('a' + i);
            alphab = alphab + ch;
        }
        System.out.println(alphab);
        /*
        Though it looks like only one for loop is used, the complexity is O(N^2).
        This is because, with String objects, we cannot modify the object in heap
        like we do with arrays. Thus, it takes more time and memory space to create
        a new object which is a combination of the old object and new data to be
        added to it. Then the reference variable is made to point towards this
        newly formed object in the String Pool.
        All the while, the old objects like for this case, ('a', 'ab', 'abc', 'abcd', '...', 'abcde..y')
        are not used by any reference variable and just use extra memory for no reason.

        Though there exists 'Garbage Collector' to remove these unused objects, it is better if such
        useless objects are not at all formed from the get go.
        To do this we need such a datatype/class that allows us to edit the same object at which the reference
        variable is pointing instead of creating a new object.

        This can be achieved using the 'StringBuilder' Class. (Mutable Strings)
         */
    }
}
