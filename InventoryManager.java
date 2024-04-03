/**
 *
 * @author (Fouzan, Tarun, Sandipkumar, Manasa, Mani sri)
 * @version (V 1.0)
 */
import java.time.LocalDate;
import java.util.Scanner;

public class InventoryManager {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n========= \u001B[36mInventory Management System\u001B[0m =========");
            System.out.println("\u001B[33m1. Add Item");
            System.out.println("\u001B[32m2. Remove Item");
            System.out.println("\u001B[34m3. Update Quantity");
            System.out.println("\u001B[35m4. Update Price");
            System.out.println("\u001B[36m5. Display Inventory");
            System.out.println("\u001B[33m6. Expiry Date Alert");
            System.out.println("\u001B[32m7. Quantity Alert");
            System.out.println("\u001B[31m8. Exit\u001B[0m");
            System.out.print("\u001B[35mEnter your choice: \u001B[0m");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n===== \u001B[36mAdd New Item\u001B[0m =====");
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiryDateString = scanner.next();
                    LocalDate expiryDate = LocalDate.parse(expiryDateString);

                    Item newItem = new Item(id, name, quantity, price, expiryDate);
                    inventory.addItem(newItem);
                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    System.out.println("\n===== \u001B[36mRemove Item\u001B[0m =====");
                    System.out.print("Enter Item ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeItem(removeId);
                    System.out.println("Item removed successfully!");                    break;

                case 3:
                    System.out.println("\n===== \u001B[36mUpdate Quantity\u001B[0m =====");
                    System.out.print("Enter Item ID to update quantity: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantity(updateId, newQuantity);
                    System.out.println("Quantity updated successfully!");
                    break;

                case 4:
                    System.out.println("\n===== \u001B[36mUpdate Price\u001B[0m =====");
                    System.out.print("Enter Item ID to update price: ");
                    int updatePriceId = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    inventory.updatePrice(updatePriceId, newPrice);
                    System.out.println("Price updated successfully!");
                    break;

                case 5:
                    System.out.println("\n===== \u001B[36mDisplay Inventory\u001B[0m =====");
                    inventory.displayInventory();
                    break;

                case 6:
                    System.out.println("\n===== \u001B[36mExpiry Date Alert\u001B[0m =====");
                    System.out.print("Enter the number of days for expiry alert: ");
                    int daysThreshold = scanner.nextInt();
                    inventory.checkExpiryDateAlert(daysThreshold);
                    break;
                    
                case 7:
                    System.out.println("\n===== \u001B[36mQuantity Alert\u001B[0m =====");
                    System.out.print("Enter the minimum quantity required for alert: ");
                    int threshold = scanner.nextInt();
                    inventory.checkQuantityThreshold(threshold);
                    break;
                    
                case 8:
                    running = false;
                    System.out.println("\u001B[31mExiting Inventory Management System...\u001B[0m");
                    break;

                default:
                    System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
                    break;
            }
        }
        scanner.close();
    }

}