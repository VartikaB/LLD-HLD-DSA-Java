package LLD.VendingMachine.State;

import LLD.VendingMachine.VendingMachine;

public class Dispatched implements State {
    @Override
    public String getName() {
        return "Dispatched";
    }

    @Override
    public State collectProduct(VendingMachine vendingMachine) {
        return new IdleState();
    }
}
