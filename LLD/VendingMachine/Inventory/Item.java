package LLD.VendingMachine.Inventory;

import java.util.Objects;

public final class Item {
    private final ItemType itemType;
    private final int price;

    public Item(ItemType itemType, int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Item price must be greater than zero");
        }
        this.itemType = Objects.requireNonNull(itemType, "itemType cannot be null");
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getPrice() {
        return price;
    }
}
