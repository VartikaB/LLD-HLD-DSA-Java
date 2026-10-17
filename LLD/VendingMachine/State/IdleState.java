package LLD.VendingMachine.State;

import LLD.VendingMachine.VendingMachine;

public class IdleState implements State {
    @Override
    public String getName() {
        return "Idle";
    }

    @Override
    public State insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.acceptMoney(amount);
        return new HasMoney();
    }

    @Override
    public State refundMoney(VendingMachine vendingMachine) {
        System.out.println("There is no balance to refund");
        return this;
    }
}
