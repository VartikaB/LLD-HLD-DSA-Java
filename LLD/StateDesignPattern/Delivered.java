package LLD.StateDesignPattern;

public class Delivered implements OrderState {
    @Override
    public OrderState nextState() {
        return this;
    }

    @Override
    public String getState() {
        return "Delivered";
    }
}
