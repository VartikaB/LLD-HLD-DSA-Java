package LLD.NullObjectDesignPattern;

public class VehicleFactory {
    Vehicle vehicle;
    public Vehicle getVehicle(String name){
        if(name.equals("CAR")) return new Car();
        else if(name.equals("BIKE")) return new Bike();
        else return new NullObject();
    }
    
}
