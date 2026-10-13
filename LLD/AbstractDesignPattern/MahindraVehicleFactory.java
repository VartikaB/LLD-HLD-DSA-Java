package LLD.AbstractDesignPattern;

public class MahindraVehicleFactory extends VehicleFactory {
    public Car getCar(){
        return new MahindraCar();
    }
    public Bike getBike(){
        return new MahindraBike();
    }
    
    
}
