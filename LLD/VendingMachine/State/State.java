package LLD.VendingMachine.State;

import LLD.VendingMachine.VendingMachine;

public interface State {
    String getName();

    default State insertMoney(VendingMachine vendingMachine, int amount) {
        throw new IllegalStateException("Cannot insert money while machine is " + getName());
    }

    default State chooseProduct(VendingMachine vendingMachine, String code) {
        throw new IllegalStateException("Cannot choose a product while machine is " + getName());
    }

    default State dispenseProduct(VendingMachine vendingMachine) {
        throw new IllegalStateException("Cannot dispense a product while machine is " + getName());
    }

    default State refundMoney(VendingMachine vendingMachine) {
        throw new IllegalStateException("Cannot refund money while machine is " + getName());
    }

    default State collectProduct(VendingMachine vendingMachine) {
        throw new IllegalStateException("No product is waiting to be collected");
    }
}
