package LLD.FactoryDesignPattern;

public class VehicleFactory {

    public Vehicle getVehicle(String name){
        if(name.equals("CAR")) return new Car();
        else if(name.equals("TRUCK")) return new Truck();
        else return new Bike();
    }
    
    
}
