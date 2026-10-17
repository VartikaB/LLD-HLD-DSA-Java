package LLD.VendingMachine;

import java.util.Objects;

import LLD.VendingMachine.Inventory.Inventory;
import LLD.VendingMachine.Inventory.Item;
import LLD.VendingMachine.Inventory.ItemShelf;
import LLD.VendingMachine.Payment.PaymentStrategy;
import LLD.VendingMachine.State.IdleState;
import LLD.VendingMachine.State.State;

public class VendingMachine {
    private final Inventory inventory;
    private State currentState = new IdleState();
    private PaymentStrategy paymentStrategy;
    private int balance;
    private ItemShelf selectedShelf;

    public VendingMachine(Inventory inventory) {
        this.inventory = Objects.requireNonNull(inventory, "inventory cannot be null");
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        if (!(currentState instanceof IdleState)) {
            throw new IllegalStateException("Payment method can only be changed while the machine is idle");
        }
        this.paymentStrategy = Objects.requireNonNull(paymentStrategy, "paymentStrategy cannot be null");
    }

    public void insertMoney(int amount) {
        currentState = currentState.insertMoney(this, amount);
    }

    public void chooseProduct(String code) {
        currentState = currentState.chooseProduct(this, code);
    }

    public void dispenseProduct() {
        currentState = currentState.dispenseProduct(this);
    }

    public void cancel() {
        currentState = currentState.refundMoney(this);
    }

    public void collectProduct() {
        currentState = currentState.collectProduct(this);
    }

    public String getCurrentState() {
        return currentState.getName();
    }

    public int getBalance() {
        return balance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void acceptMoney(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Inserted amount must be greater than zero");
        }
        if (paymentStrategy == null) {
            throw new IllegalStateException("Choose a payment method before inserting money");
        }

        int updatedBalance = Math.addExact(balance, amount);
        paymentStrategy.pay(amount);
        balance = updatedBalance;
    }

    public void selectShelf(String code) {
        ItemShelf shelf = inventory.getShelf(code);
        if (shelf.isSoldOut()) {
            throw new IllegalStateException("Product " + code + " is sold out");
        }
        selectedShelf = shelf;
    }

    public void completePurchase() {
        if (selectedShelf == null) {
            throw new IllegalStateException("Select a product before dispensing");
        }

        Item item = selectedShelf.getItem();
        String code = selectedShelf.getCode();
        int price = item.getPrice();
        if (balance < price) {
            throw new IllegalStateException(
                    "Insufficient funds: product costs " + price + ", but balance is " + balance);
        }

        inventory.dispenseOne(selectedShelf.getCode());
        int change = balance - price;
        balance = 0;
        selectedShelf = null;

        System.out.println("Dispensed " + item.getItemType() + " from slot " + code + " for " + price);
        if (change > 0) {
            System.out.println("Returning change: " + change);
        }
    }

    public void refundBalance() {
        if (balance > 0) {
            System.out.println("Refunding " + balance);
        } else {
            System.out.println("There is no balance to refund");
        }
        balance = 0;
        selectedShelf = null;
    }
}
