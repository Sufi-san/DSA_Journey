package _3_Assignments._3_ConditionalsAndLoops;

public class VolumePrograms {
    /*
        14. Volume Of Cone
        15. Volume Of Prism
        16. Volume Of Cylinder
        17. Volume Of Sphere
        18. Volume Of Pyramid
     */
    public static void main(String[] args) {
        findVolCone(5.8, 39.3);
        findVolPrism(100.38, 7.9);
        findVolCylinder(23.24, 89.3);
        findVolSphere(60.9);
        findVolPyramid(38.26, 39.3, 39);
    }

    static void findVolCone(double radius, double height){
        System.out.println("Volume: "+(Math.PI * Math.pow(radius, 2) * height) / 3);
    }

    static void findVolPrism(double area, double height){
        System.out.println("Volume: "+area * height);
    }

    static void findVolCylinder(double radius, double height){
        findVolCone(radius, height * 3);
    }

    static void findVolSphere(double radius){
        System.out.println("Volume: "+((4 * Math.PI * Math.pow(radius, 3))/3));
    }

    static void findVolPyramid(double baseLength, double baseWidth, double height){
        System.out.println("Volume: "+((baseLength * baseWidth * height) / 3));
    }
}
