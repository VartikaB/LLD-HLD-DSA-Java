package LLD.VendingMachine.Inventory;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Inventory {
    private final Map<String, ItemShelf> shelves = new LinkedHashMap<>();

    public synchronized void addShelf(String code, ItemType itemType, int price, int quantity) {
        Objects.requireNonNull(code, "code cannot be null");
        if (code.isBlank()) {
            throw new IllegalArgumentException("Shelf code cannot be blank");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Initial quantity must be greater than zero");
        }
        if (shelves.containsKey(code)) {
            throw new IllegalArgumentException("Shelf " + code + " already exists");
        }
        shelves.put(code, new ItemShelf(code, new Item(itemType, price), quantity));
    }

    public synchronized void restock(String code, int quantity) {
        getShelf(code).restock(quantity);
    }

    public synchronized ItemShelf getShelf(String code) {
        ItemShelf shelf = shelves.get(code);
        if (shelf == null) {
            throw new IllegalArgumentException("Unknown shelf code: " + code);
        }
        return shelf;
    }

    public synchronized void dispenseOne(String code) {
        getShelf(code).dispenseOne();
    }

    public synchronized Collection<ItemShelf> getShelves() {
        return java.util.List.copyOf(shelves.values());
    }
}
