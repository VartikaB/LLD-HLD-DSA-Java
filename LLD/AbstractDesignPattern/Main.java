package LLD.AbstractDesignPattern;

public class Main {
    public static void main(String[] args) {
        MahindraVehicleFactory mahindraVehicleFactory = new MahindraVehicleFactory();
        Car mahindraCar = mahindraVehicleFactory.getCar();
        Bike mahindraBike = mahindraVehicleFactory.getBike();
        mahindraCar.start();
        mahindraBike.start();
        
        TataVehicleFactory tataVehicleFactory = new TataVehicleFactory();
        Car tataCar = tataVehicleFactory.getCar();
        Bike tataBike = tataVehicleFactory.getBike();
        tataCar.start();
        tataBike.start();
    }
    
}
