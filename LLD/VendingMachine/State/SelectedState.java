package LLD.VendingMachine.State;

import LLD.VendingMachine.VendingMachine;

public class SelectedState implements State {
    @Override
    public String getName() {
        return "Selected";
    }

    @Override
    public State insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.acceptMoney(amount);
        return this;
    }

    @Override
    public State dispenseProduct(VendingMachine vendingMachine) {
        vendingMachine.completePurchase();
        return new Dispatched();
    }

    @Override
    public State refundMoney(VendingMachine vendingMachine) {
        vendingMachine.refundBalance();
        return new IdleState();
    }
}
