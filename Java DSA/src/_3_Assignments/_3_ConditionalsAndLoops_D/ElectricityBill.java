package _3_Assignments._3_ConditionalsAndLoops_D;
import java.util.Scanner;
import java.lang.StringBuilder;
public class ElectricityBill {
    // Trying out Object-Oriented Programming
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int typeCount, monthDays;
        double energyTotal = 0;
        StringBuilder energyTotalExpression = new StringBuilder("Totalling Energy Consumption: ");
        System.out.println("\nProgram to calculate Monthly Electricity Bills based on appliances:");
        System.out.println("\nSelect Month Type:\n1. 30 days\n2. 31 days\n3. 28 days\n4. 29 days");
        int option = in.nextInt();
        switch (option){
            case 2 -> monthDays = 31;
            case 3 -> monthDays = 28;
            case 4 -> monthDays = 29;
            default -> monthDays = 30;
        }
        System.out.println("\nHow many appliances in your House?");
        typeCount = in.nextInt();
        in.nextLine();
        Appliance[] apl = new Appliance[typeCount];  // creating array of objects of class Appliance
        for(int i = 0; i < typeCount; i++){
            apl[i] = new Appliance(); // initializing objects inside the array
            System.out.println("\nEnter name of Appliance "+(i+1)+":");
            apl[i].name = in.nextLine();
            System.out.println("How many "+apl[i].name+"s do you have?:");
            apl[i].count = in.nextInt();
            System.out.println("Power consumption(in watts) per single "+apl[i].name+": ");
            apl[i].watts = in.nextDouble();
            System.out.println("Total hours of usage: ");
            apl[i].useHours = in.nextDouble();
            in.nextLine();
        }
        System.out.println("\nEnter rate of electricity per KWh:");
        double rate = in.nextDouble();
        System.out.println("\nDetails of all Appliances: ");
        for(Appliance element:apl){
            System.out.println(element.applianceToString(monthDays));
            energyTotal += element.calcTotalPower(monthDays);
            energyTotalExpression.append(element.calcTotalPower(monthDays)).append(" + ");
        }
        energyTotalExpression.delete(energyTotalExpression.lastIndexOf("+ "), energyTotalExpression.length());
        double energyTotalKWh = energyTotal/1000;
        System.out.printf("\n\n%s= %.3f Wh = %.3f KWh",energyTotalExpression, energyTotal, energyTotalKWh);
        System.out.printf("\nTotal Electricity Bill Amount: %.3f units * %.3f = %.3f", energyTotalKWh, rate, energyTotalKWh*rate);
    }
}

class Appliance{
    String name;
    int count;
    double watts;
    double useHours;
    double calcTotalPower(int days){
        return this.count * this.watts * this.useHours * days;
    }

    String applianceToString(int days){
        return "\nAppliance Name: "+this.name+"\nAppliance Count: "+this.count+"\nPower Consumption(per piece): "+
                this.watts+" W\nUsed for: "+this.useHours+" hour(s)"+"\nEnergy Required("+days+" days): "
                +this.calcTotalPower(days)+" Wh";
    }
}
