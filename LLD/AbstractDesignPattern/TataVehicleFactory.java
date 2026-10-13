package LLD.AbstractDesignPattern;

public class TataVehicleFactory extends VehicleFactory {
    public Car getCar(){
        return new TataCar();
    }
    public Bike getBike(){
        return new TataBike();
    }
    
}
