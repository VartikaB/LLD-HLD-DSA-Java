package LLD.FactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        factory.getVehicle("CAR").start();
        factory.getVehicle("BIKE").start();
        factory.getVehicle("TRUCK").start();
    }
    
}
