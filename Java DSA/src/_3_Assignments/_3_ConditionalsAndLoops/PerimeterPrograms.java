package _3_Assignments._3_ConditionalsAndLoops;

public class PerimeterPrograms {
    /*
        8. Perimeter Of Circle
        9. Perimeter Of Equilateral Triangle
        10. Perimeter Of Parallelogram
        13. Perimeter Of Rhombus
        11. Perimeter Of Rectangle
        12. Perimeter Of Square
     */
    public static void main(String[] args) {
        findPeriCircle(5.86);
        findPeriEquiTriangle(32.76);
        findPeriParallelogram(478.8, 83.2);
        findPeriRhombus(359.3, 38);
        findPeriRectangle(226, 389.9);
        findPeriSquare(3098.1);
    }

    static void findPeriCircle(double radius){
        System.out.println("Perimeter: "+(Math.PI * radius * radius));
    }

    static void findPeriEquiTriangle(double side){
        System.out.println("Perimeter: "+3 * side);
    }

    static void findPeriParallelogram(double side1, double side2){
        findPeriRectangle(side1, side2);
    }

    static void findPeriRhombus(double side1, double side2){
        findPeriRectangle(side1, side2);
    }

    static void findPeriRectangle(double side1, double side2){
        System.out.println("Perimeter: "+side1 * side2);
    }

    static void findPeriSquare(double side){
        System.out.println("Perimeter: "+4 * side);
    }
}
