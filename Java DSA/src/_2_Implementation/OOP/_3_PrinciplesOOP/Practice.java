package _2_Implementation.OOP._3_PrinciplesOOP;

public class Practice {
    public static void main(String[] args) {
        DoctorN doc1 = new DoctorN("Kunal", 24, 172983.5f, "Surgery", "Saifee");
        DoctorN doc2 = new DoctorN("Rahul", 23, 125633.5f, "Medicine", "Wokhart");
        Pianist pi1 = new Pianist("Sufiyan", 21, 25005.8f);
        Pianist pi2 = new Pianist("Faizan", 18, 29895.8f);
        doc1.curePatient("Raihan");
        doc2.curePatient("Uzair");
        pi1.playMusic("Turkish March");
        pi2.playMusic("Unravel");
        DoctorN.displayDocNum();
        Pianist.displayPianistNum();
        System.out.println(""+doc1+doc2+pi1+pi2);
        System.out.println(DoctorN.ageIsGreater(doc1, doc2));
        System.out.println(Pianist.ageIsGreater(pi1, pi2));
        System.out.println(DoctorN.salaryIsMore(doc1, doc2));
        System.out.println(Pianist.salaryIsMore(pi1, pi2));
    }
}

class DoctorN {
    String name;
    int age;
    float salary;
    String specialisation;
    String worksAt;
    private static int totalDoctors;
    DoctorN(String name, int age, float salary, String specialisation, String worksAt) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.specialisation = specialisation;
        this.worksAt = worksAt;
        totalDoctors++;
    }
    void curePatient(String patient) {
        System.out.println("The patient "+patient+" is cured");
    }

    static boolean salaryIsMore(DoctorN doc1, DoctorN doc2) {
        return doc1.salary > doc2.salary;
    }

    static boolean ageIsGreater(DoctorN doc1, DoctorN doc2) {
        return doc1.age > doc2.age;
    }

    static void displayDocNum() {
        System.out.println("Total Doctors Made: "+totalDoctors);
    }

    @Override
    public String toString() {
        String s1 = "\nDoctor Details - "+"\nName: "+this.name+"\nAge: "+this.age+"\nSalary: "+this.salary;
        String s2 = "\nSpecialisation: "+this.specialisation+"\nWorks At: "+this.worksAt+"\n";
        return s1 + s2;
    }
}

class Pianist {
    String name;
    int age;
    float salary;
    private static int totalPianists;
    Pianist(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        Pianist.totalPianists++;
    }
    void playMusic(String musicName) {
        System.out.println(this.name+" played "+musicName);
    }

    static boolean salaryIsMore(Pianist pi1, Pianist pi2) {
        return pi1.salary > pi2.salary;
    }

    static boolean ageIsGreater(Pianist pi1, Pianist pi2) {
        return pi1.age > pi2.age;
    }

    static void displayPianistNum() {
        System.out.println("Total Pianists Made: "+totalPianists);
    }

    @Override
    public String toString() {
        return "\nPianist Details - "+"\nName: "+this.name+"\nAge: "+this.age+"\nSalary: "+this.salary+"\n";
    }
}

