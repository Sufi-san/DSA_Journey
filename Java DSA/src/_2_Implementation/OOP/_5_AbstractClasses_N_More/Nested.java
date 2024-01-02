package _2_Implementation.OOP._5_AbstractClasses_N_More;

public class Nested {
    protected interface NestedInterface {
        boolean isPalindrome(String s);
    }
}

class Nested2 implements Nested.NestedInterface { // Using '.' separator to access the Nested Interface
    @Override
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
