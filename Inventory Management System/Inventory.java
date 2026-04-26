import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Class for Inventory */
class Inventory {
    // Store items and their quantities
    private final Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    // Add item (merge if already exists)
    public void addItem(String item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        items.merge(item, quantity, Integer::sum);
    }

    // Remove item completely
    public void removeItem(String item) {
        items.remove(item);
    }

    // Check if item exists
    public boolean containsItem(String itemName) {
        return items.containsKey(itemName);
    }

    // Get all items (unmodifiable view to prevent external modification)
    public Map<String, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    // Get quantity of a specific item
    public int getQuantity(String item) {
        return items.getOrDefault(item, 0);
    }

    // Reduce quantity of an item (remove if zero or less)
    public void reduceItem(String item, int quantity) {
        if (!items.containsKey(item)) return;
        int updatedQuantity = items.get(item) - quantity;
        if (updatedQuantity > 0) {
            items.put(item, updatedQuantity);
        } else {
            items.remove(item);
        }
    }

    // Clear all items
    public void clearInventory() {
        items.clear();
    }
}
