package LLD.StateDesignPattern;

public class Inventory implements OrderState {
    @Override
    public OrderState nextState() {
        return new Shipped();
    }

    @Override
    public String getState() {
        return "Inventory";
    }
}
