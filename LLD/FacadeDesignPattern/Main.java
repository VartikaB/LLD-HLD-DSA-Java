package LLD.FacadeDesignPattern;
// We use facade design pattern when we have to hide system complexity from users 

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Payment payment = new Payment();
        Shipping shipping = new Shipping();

        OrderFacade orderFacade = new OrderFacade(order, payment, shipping);
        orderFacade.placeOrder();
    }

    
}
