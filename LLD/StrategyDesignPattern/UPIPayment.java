package LLD.StrategyDesignPattern;

public class UPIPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI Payment");
    }
    
}
