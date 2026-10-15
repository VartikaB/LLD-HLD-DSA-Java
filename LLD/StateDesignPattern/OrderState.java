package LLD.StateDesignPattern;

public interface OrderState {
    OrderState nextState();
    String getState();
}
