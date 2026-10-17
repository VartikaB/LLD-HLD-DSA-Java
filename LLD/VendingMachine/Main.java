package LLD.VendingMachine;

import LLD.VendingMachine.Inventory.Inventory;
import LLD.VendingMachine.Inventory.ItemType;
import LLD.VendingMachine.Payment.CashPayment;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addShelf("A1", ItemType.COKE, 25, 5);
        inventory.addShelf("A2", ItemType.WATER, 15, 8);
        inventory.addShelf("B1", ItemType.JUICE, 30, 4);

        VendingMachine vendingMachine = new VendingMachine(inventory);
        vendingMachine.setPaymentStrategy(new CashPayment());

        vendingMachine.insertMoney(30);
        vendingMachine.chooseProduct("A1");
        vendingMachine.dispenseProduct();
        vendingMachine.collectProduct();

        System.out.println("A1 stock remaining: " + inventory.getShelf("A1").getQuantity());
        System.out.println("Machine state: " + vendingMachine.getCurrentState());
    }
}
