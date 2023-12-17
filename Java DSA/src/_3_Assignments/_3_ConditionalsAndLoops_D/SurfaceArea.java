package _3_Assignments._3_ConditionalsAndLoops_D;

public class SurfaceArea {
    /*
        19. Curved Surface Area Of Cylinder
        20. Total Surface Area Of Cube
     */
    public static void main(String[] args) {
       findCSAofCylinder(2.35, 92.3);
       findTSAofCube(7.98);
    }

    static void findCSAofCylinder(double radius, double height){
        System.out.println("CSA of Cylinder: "+2 * Math.PI * radius * height);
    }

    static void findTSAofCube(double side){
        System.out.println("TSA of Cube: "+6 * Math.pow(side, 2));
    }
}
