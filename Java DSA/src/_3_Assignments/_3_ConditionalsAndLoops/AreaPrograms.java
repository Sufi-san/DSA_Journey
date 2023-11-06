package _3_Assignments._3_ConditionalsAndLoops;

public class AreaPrograms {
    /*
        1. Area Of Circle Java Program
        2. Area Of Triangle
        3. Area Of Rectangle Program
        4. Area Of Isosceles Triangle
        5. Area Of Parallelogram
        6. Area Of Rhombus
        7. Area Of Equilateral Triangle
     */
    public static void main(String[] args) {
        findAreaOfCircle(7.6);
        findAreaOfTriangle(8, 17);
        findAreaOfRectangle(78.9, 85.89);
        findAreaOfIsoscelesTriangle(32, 38.88);
        findAreaOfParallelogram(29.283, 833);
        findAreaOfRhombus(93.235, 335.35);
        findAreaOfEquilateralTriangle(82.72);
    }
    static void findAreaOfCircle(double radius){
        System.out.println("Area: "+(Math.PI * Math.pow(radius, 2)));
    }

    static void findAreaOfTriangle(double base, double height){
        System.out.println("Area: "+(0.5 * base * height));
    }

    static void findAreaOfRectangle(double length, double breadth){
        System.out.println("Area: "+(length * breadth));
    }

    static void findAreaOfIsoscelesTriangle(double base, double height){
        findAreaOfTriangle(base, height);
    }

    static void findAreaOfParallelogram(double base, double height){
        findAreaOfTriangle(2 * base, height);
    }

    static void findAreaOfRhombus(double base, double height){
        findAreaOfParallelogram(base, height);
    }

    static void findAreaOfEquilateralTriangle(double base){
        System.out.println("Area: "+((Math.sqrt(3) / 4) * Math.pow(base, 2)));
    }

}
