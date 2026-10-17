package LLD.VendingMachine.Payment;

public class UPIPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Accepted UPI payment of " + amount);
    }
}
