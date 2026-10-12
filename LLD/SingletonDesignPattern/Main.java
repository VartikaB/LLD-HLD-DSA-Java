package LLD.SingletonDesignPattern;

public class Main {
    public static void main(String args[]){
        ParkingLot.getInstance();
        System.out.println("Performing some operations");
        ParkingLot.getInstance();
    }
    
}
