package _3_Assignments._4_FunctionsAndMethods;
import java.util.Scanner;

public class GradeMarks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double marks;
        System.out.println("Enter your marks out of 100: ");
        marks = in.nextDouble();
        findGrade(marks);
    }
    static void findGrade(double marksOld){
        String grade;
        int marks = (marksOld - (int) marksOld >= .5)? (int) Math.ceil(marksOld): (int) marksOld; // TypeCasting to Integer
        if(marks <= 100 && marks >= 91)
            grade = "AA";
        else if(marks <= 90 && marks >= 81)
            grade = "AB";
        else if(marks <= 80 && marks >= 71)
            grade = "BB";
        else if(marks <= 70 && marks >= 61)
            grade = "BC";
        else if(marks <= 60 && marks >= 51)
            grade = "CD";
        else if(marks <= 50 && marks >= 41)
            grade = "DD";
        else if(marks <= 40)
            grade = "Fail";
        else
            grade = "Entered Marks out of Grade Range.";
        System.out.println("Grade: "+grade);
    }
}
