package LLD.VendingMachine.State;

import LLD.VendingMachine.VendingMachine;

public class HasMoney implements State {
    @Override
    public String getName() {
        return "HasMoney";
    }

    @Override
    public State insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.acceptMoney(amount);
        return this;
    }

    @Override
    public State chooseProduct(VendingMachine vendingMachine, String code) {
        vendingMachine.selectShelf(code);
        return new SelectedState();
    }

    @Override
    public State refundMoney(VendingMachine vendingMachine) {
        vendingMachine.refundBalance();
        return new IdleState();
    }
}
