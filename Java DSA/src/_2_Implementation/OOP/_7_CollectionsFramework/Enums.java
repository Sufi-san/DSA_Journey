package _2_Implementation.OOP._7_CollectionsFramework;

public class Enums {
    // Enums are special classes that contain a group of data members that cannot be changed (constant)
    // Used when we always require the same fixed number of elements/objects
    enum Months implements Seasons {
        January, February, March, April, May, June, July, August, September, October, November, December;
        // these are enum constants
        // All members of 'enums' are public, static and final
        /*
            We cannot create child enums (does not support inheritance)
            All enums explicitly extend 'java.lang.Enums' class and as a class cannot extend multiple
            classes, an enum cannot extend any other class
            Thus, any enum cannot extend other enums as well

            However, we can still implement interfaces !
         */
        // The type of all these data members is the name of the enum, 'Months' in this case

        // Enum Constructor: (can only be private or default)
        // When even a single enum data member is accessed, the constructor is internally called for
        // all the data members as enums ensure that the fixed number of assigned instances are always created
        Months() {
            System.out.println("Constructor called for: "+this);
        }
        // internally the constructor is called 12 times:
        /*
            public static final Months January = new Month();
            public static final Months February = new Month();
            public static final Months March = new Month();
                                        .
                                        .
                                        .
            public static final Months December = new Month();
         */
        @Override
        public String getSeasonName(int num) {
            if(num > 1 && num < 5) return "Summer";
            if(num >= 5 && num < 9) return "Monsoon";
            if(num >= 9 && num < 11) return "Autumn";
            return "Winter";
        }
    }

    interface Seasons {
        String getSeasonName(int month);
    }

    public static void main(String[] args) {
        // Internally constructor will be called once for all data members at the first 'declaration' of the
        // 'enum Months' in the 'main()' method
        Months monthName; // constructor will be called 12 times for all months at this point
        monthName = Months.May; // selecting the object 'May'
        System.out.println("\n"+monthName);

        // Enums are iterable: using the '.values()' method to fetch an array of enum objects
        for(Months month: Months.values()) System.out.print(month+" ");
        System.out.println();

        // We can check position of declaration of enum data member: using the '.ordinal' method
        System.out.println("\n"+monthName.ordinal());
        for(Months month: Months.values()) System.out.print(month.ordinal()+" ");
        System.out.println("\n");

        // Using the overridden method from our 'Seasons' interface:
        for(Months month: Months.values()) System.out.print(month.getSeasonName(month.ordinal())+" ");

        // The constructor for enums:
        // Months allMonths = new Months(); will result in an error
        // Why? Because the 'constructor' for 'enums' is always 'private' or 'default' and never 'public/protected'
        // This prevents instantiation of a NEW 'enum' object and makes sure that always the
        // pre-defined number of data members exists for an enum instance
        // Thus, we can NOT create more than the pre-defined enum instances using the 'new' keyword and constructor
        System.out.println("\n");

        // Equality: simply using "=="
        for(Months month: Months.values()) System.out.print((month == monthName)+" ");
    }
}
