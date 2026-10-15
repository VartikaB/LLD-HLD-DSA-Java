package LLD.StateDesignPattern;

public class OrderManagement {
    private OrderState currentState = new Inventory();

    public String getCurrentState() {
        return currentState.getState();
    }

    public void advanceToNextState() {
        currentState = currentState.nextState();
    }
}
