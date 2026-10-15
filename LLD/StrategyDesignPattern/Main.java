package LLD.StrategyDesignPattern;

public class Main {
    public static void main(String[] args){
        PaymentStrategy cardPayment = new CardPayment();
        PaymentStrategy upi = new UPIPayment();
        cardPayment.pay(100);
        upi.pay(200); 
    }
    
}
