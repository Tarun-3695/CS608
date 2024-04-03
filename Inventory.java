/**
 *
 * @author (Fouzan, Tarun, Sandipkumar, Manasa, Mani sri)
 * @version (V 1.0)
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    public ArrayList<Item> itemList;

    public Inventory() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(int itemId) {
        itemList.removeIf(item -> item.getId() == itemId);
    }

    public void updateQuantity(int itemId, int quantity) {
        for (Item item : itemList) {
            if (item.getId() == itemId) {
                item.setQuantity(quantity);
                break;
            }
        }
    }

    public void updatePrice(int itemId, double price) {
        for (Item item : itemList) {
            if (item.getId() == itemId) {
                item.setPrice(price);
                break;
            }
        }
    }

    public Item getItemById(int itemId) {
        for (Item item : itemList) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }

    public void displayInventory() {
        if (itemList.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n===== Inventory Details =====");
            System.out.printf("%-5s | %-15s | %-10s | %-10s | %s\n", "ID", "Name", "Quantity", "Price", "Expiry Date");
            System.out.println("----------------------------------------------------------");

            for (Item item : itemList) {
                System.out.printf("%-5d | %-15s | %-10d | $%-9.2f | %s\n", item.getId(), item.getName(), item.getQuantity(), item.getPrice(), item.getExpiryDate());
            }
        }
    }

    public void checkQuantityThreshold(int threshold) {
        System.out.println("\n===== Quantity Threshold Alert =====");
        boolean lowQuantity = false;

        for (Item item : itemList) {
            if (item.getQuantity() < threshold) {
                lowQuantity = true;
                System.out.println("Low quantity alert for: " + item.getName());
            }
        }

        if (!lowQuantity) {
            System.out.println("All items have sufficient quantity.");
        }
    }

    public void checkExpiryDateAlert(int daysThreshold) {
        System.out.println("\n===== Expiry Date Alert =====");
        boolean nearExpiry = false;
        LocalDate currentDate = LocalDate.now();

        for (Item item : itemList) {
            if (item.getExpiryDate().isBefore(currentDate.plusDays(daysThreshold))) {
                nearExpiry = true;
                System.out.println("Expiry alert for: " + item.getName() + ", Expiry Date: " + item.getExpiryDate());
            }
        }

        if (!nearExpiry) {
            System.out.println("No items are nearing expiry.");
        }
    }
}
