package LLD.NullObjectDesignPattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle1 = factory.getVehicle("CAR");
        vehicle1.capacity();
        vehicle1.speed();

        Vehicle vehicle2 = factory.getVehicle("BIKE");
        vehicle2.capacity();
        vehicle2.speed();

        Vehicle vehicle3 = factory.getVehicle("TRUCK");
        vehicle3.capacity();
        vehicle3.speed();
    }
    
}
