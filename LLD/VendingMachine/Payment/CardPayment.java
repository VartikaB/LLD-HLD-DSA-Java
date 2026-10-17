package LLD.VendingMachine.Payment;

public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Accepted card payment of " + amount);
    }
}
