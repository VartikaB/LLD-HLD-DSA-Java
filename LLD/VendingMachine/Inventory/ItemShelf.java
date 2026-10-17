package LLD.VendingMachine.Inventory;

import java.util.Objects;

public final class ItemShelf {
    private final String code;
    private final Item item;
    private int quantity;

    ItemShelf(String code, Item item, int quantity) {
        this.code = Objects.requireNonNull(code, "code cannot be null");
        this.item = Objects.requireNonNull(item, "item cannot be null");
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSoldOut() {
        return quantity == 0;
    }

    void restock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Restock amount must be greater than zero");
        }
        quantity = Math.addExact(quantity, amount);
    }

    void dispenseOne() {
        if (isSoldOut()) {
            throw new IllegalStateException("Product " + code + " is sold out");
        }
        quantity--;
    }
}
