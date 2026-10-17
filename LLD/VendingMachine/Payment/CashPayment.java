package LLD.VendingMachine.Payment;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Accepted " + amount + " in cash");
    }
}
