package LLD.StateDesignPattern;

public class Shipped implements OrderState {
    @Override
    public OrderState nextState() {
        return new Delivered();
    }

    @Override
    public String getState() {
        return "Shipped";
    }
}
