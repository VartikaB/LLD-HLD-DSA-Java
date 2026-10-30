package LLD.FacadeDesignPattern;

public class OrderFacade {
    private Order order;
    private Payment payment;
    private Shipping shipping;

    public OrderFacade(Order order, Payment payment, Shipping shipping) {
        this.order = order;
        this.payment = payment;
        this.shipping = shipping;
    }

    public void placeOrder() {
        System.out.println("Placing order through facade");
        order.placeOrder();
        payment.pay();
        shipping.shipOrder();
    }
    
}
