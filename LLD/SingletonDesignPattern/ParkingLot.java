package LLD.SingletonDesignPattern;

public class ParkingLot {
    private static ParkingLot instance;
    ParkingLot(){
        System.out.println("Parking Lot created");
    }
    public static ParkingLot getInstance(){
        if(instance==null){
            instance = new ParkingLot();
            System.out.println("New Parking lot is created");
            return instance;
        }
        System.out.println("We had a existing parking lot");
        return instance; 
    }
    
}
