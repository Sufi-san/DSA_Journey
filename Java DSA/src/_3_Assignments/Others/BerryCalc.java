package _3_Assignments.Others;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class BerryCalc {

    static int pBitter = 72, vBitter = 72, pSweet = 72, vSweet = 72, vSpicy = 3,  pSpicy = 210, days = 0;

    public static void main(String[] args) {
        int yearlyIncome = 0;
        while(days + 31 < 365) {
            yearlyIncome += berryProfit();
            System.out.println("Total after "+days+" days: "+yearlyIncome+"\n");
        }
        System.out.println("Very: "+"sw: "+vSweet+", bi: "+vBitter+", Plain sp: "+pSpicy);
        System.out.println("Yearly Income: "+yearlyIncome);
    }

    static int berryProfit() {
        int cost = 0, i = 0;
        while(pBitter < 372 || pSweet < 372 || vSpicy < 303) {
            i++;
            days++;
            printStatus();
            int berries = getRandomBerries(72, 3, 6);
            System.out.println("Berry Haul: "+berries);
            if(pBitter < 372) {
                pBitter += (berries * 7 / 10) - 72;
                vBitter += (berries * 3 / 10) - 72;
                cost += (berries) * 350;
                continue;
            }
            if(pSweet < 372) {
                pSweet += (berries * 7 / 10) - 72;
                vSweet += (berries * 3 / 10) - 72;
                cost += (berries) * 350;
                continue;
            }
            if(vSpicy < 303) {
                pSpicy += (berries * 7 / 10) - 210;
                vSpicy += (berries * 3 / 10) - 3;
                cost += (berries) * 350;
            }
        }
        System.out.println("\nSeeds left after "+i+" iterations: ");
        System.out.println("Plain: "+"sw: "+pSweet+", bi: "+pBitter+", sp: "+pSpicy);
        System.out.println("Very: "+"sw: "+vSweet+", bi: "+vBitter+", sp: "+vSpicy);
        System.out.println("Total Cost of creation: "+cost);
        int leppa = 0;
        while(pSweet >= 72 * 2 && pBitter >= 72 * 2 && vSpicy >= 72 * 2) {
            pSweet -= 72;
            pBitter -= 72;
            vSpicy -= 72;
            leppa += getRandomBerries(72, 5, 7);
            i++;
            days++;
        }
        System.out.println("Total Leppas made: "+leppa);
        System.out.println("Seeds left: ");
        System.out.println("Plain: "+"sw: "+pSweet+", bi: "+pBitter+", sp: "+pSpicy);
        System.out.println("Very: "+"sw: "+vSweet+", bi: "+vBitter+", sp: "+vSpicy);
        System.out.println("Days spent for current cycle: "+i);
        System.out.println("Total Days spent: "+days);
        int profit = leppa * 800 - cost - leppa * 100;
        profit += ((pSweet - 72) * 600) + ((pBitter - 72) * 700) + ((vSpicy - 3) * 1000);
        profit += ((vSweet - 72) * 600) + ((vBitter - 72) * 600) + ((pSpicy - 210) * 300);
        System.out.println("Total Cost with Sell Fee: "+(cost + leppa * 100 + (vSpicy - 3) * 100 + (pSweet - 72) * 200));
        pBitter = vBitter = 72;
        pSweet = vSweet = 72;
        pSpicy = 210;
        vSpicy = 3;
        System.out.println("Profit: "+profit);
        System.out.print("Seeds left: ");
        printStatus();
        return profit;
    }

    static void printStatus() {
        System.out.println("Day: "+days);
        System.out.println("Plain: "+"sw: "+pSweet+", bi: "+pBitter+", sp: "+pSpicy);
        System.out.println("Very: "+"sw: "+vSweet+", bi: "+vBitter+", sp: "+vSpicy);
    }

    static int getRandomBerries(int plants, int low, int high) {
        int count = 0, i = 1;
        while(i <= plants) {
            count += low + (int)(Math.random() * (high - low + 1));
            i++;
        }
        return count;
    }
}
