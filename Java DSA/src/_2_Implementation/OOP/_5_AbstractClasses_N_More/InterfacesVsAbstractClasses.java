package _2_Implementation.OOP._5_AbstractClasses_N_More;

// Differences between 'interface' and 'abstract classes':
/*
    - interface requires the keyword 'implements', abstract classes approach requires use of the keyword 'extends'
    - interfaces can extend multiple other interfaces, abstract classes cannot extend multiple abstract classes
    - interface members are public by default, abstract class members can have any access modifier
    - a class can implement multiple interfaces, but it can inherit only a single abstract class
    - static methods can be inherited by
 */

// An important point: The access modifier for overridden methods must be the same or better.

/*
    classes 'extend (inherit)' other classes (true for abstract classes too)
    interfaces 'extend' other interfaces
    classes 'implement' interfaces
 */

public class InterfacesVsAbstractClasses {
    public static void main(String[] args) {
        SimpleCar simpleCar = new SimpleCar("My Simple Car", "Diesel");
        FlyingCar flyingCar = new FlyingCar("My Flying Car", "Petrol");
        Submarine submarine = new Submarine("My Submarine", "Nuclear Power", 20);
        Airplane airplane = new Airplane("My Airplane", "Jet Fuel", 150);
        exploreVehicleProps(simpleCar);
        System.out.println();
        exploreVehicleProps(flyingCar);
        System.out.println();
        exploreVehicleProps(submarine);
        System.out.println();
        exploreVehicleProps(airplane);
        System.out.println();
        exploreFlightProps(flyingCar);
        System.out.println();
        exploreFlightProps(airplane);
        System.out.println();
        exploreFlightSystemProps(airplane);
        System.out.println();
        exploreNavProps(flyingCar);
        System.out.println();
        exploreNavProps(submarine);
        submarine.showLoadCapacity();
        System.out.println();
        exploreNavProps(airplane);
        System.out.println();
        exploreAutoProps(airplane);
        System.out.println();
    }

    static void exploreVehicleProps(Vehicle vehicle) {
        System.out.println(vehicle);
        vehicle.startEngine();
        vehicle.accelerate();
        vehicle.brake();
        vehicle.stopEngine();
    }

    static void exploreFlightProps(Flight flyCar) {
        System.out.println(flyCar);
        flyCar.takeOff();
        flyCar.land();
    }

    static void exploreFlightSystemProps(FlightSystem fs) {
        System.out.println(fs);
        fs.increaseAltitude();
        fs.decreaseAltitude();
        fs.showFlightLoadCapacity();
    }

    static void exploreNavProps(NavigationSystem ns) {
        System.out.println(ns);
        ns.displayMap();
        ns.showNearbyLocations();
        ns.showNearbyObjects();
        ns.markDestination();
        ns.showDistanceTillDestination();
    }

    static void exploreAutoProps(AutoPilot ap) {
        System.out.println(ap);
        ap.startAutoPilot();
        ap.endAutoPilot();
    }
}

abstract class Vehicle {
    String name;
    final String vehicleType;
    String fuelType;
    Vehicle(String name, String fuelType) {
        this.name = name;
        this.fuelType = fuelType;
        this.vehicleType = this.getClass().getSimpleName();
        totalVehicles++;
    }
    static int totalVehicles;
    abstract void startEngine();
    abstract void accelerate();
    abstract void stopEngine();
    abstract void brake();

    @Override
    public String toString() {
        return "\nName: "+this.name+"\nVehicle Type: "+this.vehicleType+"\nFuel Type: "+this.fuelType+"\n";
    }
}

class SimpleCar extends Vehicle {
    SimpleCar(String name, String fuelType) {
        super(name, fuelType);
    }

    @Override
    void startEngine() {
        System.out.println("Engine started for "+this.vehicleType+" "+this.name);
    }

    @Override
    void accelerate() {
        System.out.println("Accelerating the "+this.vehicleType);
    }

    @Override
    void stopEngine() {
        System.out.println("Engine stopped for "+this.vehicleType+" "+this.name);
    }

    @Override
    void brake() {
        System.out.println(this.vehicleType+" has stopped.");
    }
}

class FlyingCar extends SimpleCar implements Flight, NavigationSystem {
    FlyingCar(String name, String fuelType) {
        super(name, fuelType);
    }

    @Override
    public void takeOff() {
        System.out.println(this.name+" has started flying.");
    }

    @Override
    public void land() {
        System.out.println(this.name+" has landed.");
    }

    @Override
    public void displayMap() {
        System.out.println("Map has been displayed. (Flying Car)");
    }

    @Override
    public void showNearbyObjects() {
        System.out.println("The nearby objects are shown on the map. (Flying Car)");
    }

    @Override
    public void showNearbyLocations() {
        System.out.println("The nearby locations are shown on the map. (Flying Car)");
    }

    @Override
    public void markDestination() {
        System.out.println("Destination has been marked. (Flying Car)");
    }

    @Override
    public void showDistanceTillDestination() {
        System.out.println("Distance left till destination is shown on the map. (Flying Car)");
    }
}

class Submarine extends Vehicle implements NavigationSystem {
    final int capacity;
    Submarine(String name, String fuelType, int capacity) {
        super(name, fuelType);
        this.capacity = capacity;
    }
    @Override
    void startEngine() {
        System.out.println(this.name+" has its engine started.");
    }

    @Override
    void accelerate() {
        System.out.println(this.name+" is accelerating.");
    }

    @Override
    void stopEngine() {
        System.out.println(this.name+" has its engine stopped.");
    }

    @Override
    void brake() {
        System.out.println(this.name+" has stopped.");
    }

    @Override
    public void displayMap() {
        System.out.println("Map has been displayed. ("+this.vehicleType+")");
    }

    @Override
    public void showNearbyObjects() {
        System.out.println("The nearby objects are shown on the map. ("+this.vehicleType+")");
    }

    @Override
    public void showNearbyLocations() {
        System.out.println("The nearby locations are shown on the map. ("+this.vehicleType+")");
    }

    @Override
    public void markDestination() {
        System.out.println("Destination has been marked. ("+this.vehicleType+")");
    }

    @Override
    public void showDistanceTillDestination() {
        System.out.println("Distance left till destination is shown on the map. ("+this.vehicleType+")");
    }

    public void showLoadCapacity() {
        System.out.println("Capacity for "+this.vehicleType+" is "+this.capacity);
    }

    @Override
    public String toString() {
        String s = "\nName: "+this.name+"\nVehicle Type: "+this.vehicleType+"\nFuel Type: "+this.fuelType;
        return s + "\nCapacity: "+this.capacity;
    }
}

class Airplane extends Vehicle implements FlightSystem, AutoPilot {
    final int capacity;
    Airplane(String name, String fuelType, int capacity) {
        super(name, fuelType);
        this.capacity = capacity;
    }

    @Override
    void startEngine() {
        System.out.println(this.name+" has its engine started.");
    }

    @Override
    void accelerate() {
        System.out.println(this.name+" is accelerating.");
    }

    @Override
    void stopEngine() {
        System.out.println(this.name+" has its engine stopped.");
    }

    @Override
    void brake() {
        System.out.println(this.name+" has its brakes applied, reducing Speed.");
    }

    @Override
    public void takeOff() {
        System.out.println(this.vehicleType+" has taken off.");
    }

    @Override
    public void land() {
        System.out.println(this.vehicleType+" has landed.");
    }

    @Override
    public void increaseAltitude() {
        System.out.println(this.vehicleType+" is now flying higher.");
    }

    @Override
    public void decreaseAltitude() {
        System.out.println(this.vehicleType+" is now flying lower.");
    }

    @Override
    public void showFlightLoadCapacity() {
        System.out.println(this.vehicleType+" can carry "+this.capacity+" passengers.");
    }

    @Override
    public void displayMap() {
        System.out.println("Map has been displayed. ("+this.vehicleType+")");
    }

    @Override
    public void showNearbyObjects() {
        System.out.println("The nearby objects are shown on the map. ("+this.vehicleType+")");
    }

    @Override
    public void showNearbyLocations() {
        System.out.println("The nearby locations are shown on the map. ("+this.vehicleType+")");
    }

    @Override
    public void markDestination() {
        System.out.println("Destination has been marked. ("+this.vehicleType+")");
    }

    @Override
    public void showDistanceTillDestination() {
        System.out.println("Distance left till destination is shown on the map. ("+this.vehicleType+")");
    }

    @Override
    public void startAutoPilot() {
        System.out.println(this.vehicleType+" is now on Auto Pilot.");
    }

    @Override
    public void endAutoPilot() {
        System.out.println(this.vehicleType+" is now being controlled manually.");
    }

    @Override
    public String toString() {
        String s = "\nName: "+this.name+"\nVehicle Type: "+this.vehicleType+"\nFuel Type: "+this.fuelType;
        return s + "\nCapacity: "+this.capacity;
    }
}

interface Flight {
    void takeOff();
    void land();
}

interface FlightSystem extends Flight {
    void increaseAltitude();
    void decreaseAltitude();
    void showFlightLoadCapacity();
}

interface NavigationSystem {
    void displayMap();
    void showNearbyObjects();
    void showNearbyLocations();
    void markDestination();
    void showDistanceTillDestination();
}

interface AutoPilot extends NavigationSystem {
    void startAutoPilot();
    void endAutoPilot();
}
