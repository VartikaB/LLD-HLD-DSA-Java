package LLD.StateDesignPattern;

public class Main {
    public static void main(String[] args) {
        OrderManagement order = new OrderManagement();
        System.out.println("Current order state: " + order.getCurrentState());

        order.advanceToNextState();
        System.out.println("Current order state: " + order.getCurrentState());

        order.advanceToNextState();
        System.out.println("Current order state: " + order.getCurrentState());

        order.advanceToNextState();
        System.out.println("Current order state: " + order.getCurrentState());
    }
}
