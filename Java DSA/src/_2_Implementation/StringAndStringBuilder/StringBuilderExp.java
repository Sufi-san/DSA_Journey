package _2_Implementation.StringAndStringBuilder;

public class StringBuilderExp {
    public static void main(String[] args) {
        StringBuilder alpha_seq = new StringBuilder();
        for(int i = 0; i < 26; i++){
            char ch = (char)('a' + i);
            alpha_seq.append(ch);
            // alpha_seq.insert(i, ch); will work the same but, time complexity will be O(n^2).
            // I tried alpha_seq = alpha_seq.append(ch), but alpha_seq's object itself is modified using .append()
            // Also IDE says that alpha_seq is already assigned the value. (assignments are read from right to left!)
        }
        System.out.println(alpha_seq);
        /*
        Above code performs the same task as StringPerformance.java(java class in this folder), however in this case,
        as StringBuilder allows us to modify the same object the time complexity is reduced
        to linear, O(N).

        Other StringBuilder methods: ( '*' stands for also a method for Strings, might differ in functionality )
        .toString()
        .append()
        .insert()
        .reverse()
        .length() *
        .substring() *
        .compareTo() *
        .equals() *
        .replace() *
        .charAt() *
        .delete()
        .deleteCharAt()
        .setCharAt()
         */
    }
}
