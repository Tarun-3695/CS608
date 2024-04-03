import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class InventoryManagerGUI {
    private ArrayList<Item> itemList;
    private JFrame frame;

    public InventoryManagerGUI() {
        itemList = new ArrayList<>();
        frame = new JFrame("Inventory Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton addItemButton = new JButton("Add Item");
        JButton displayInventoryButton = new JButton("Display Inventory");
        addItemButton.setBounds(50, 50, 150, 30);
        displayInventoryButton.setBounds(50, 100, 150, 30);

        addItemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addNewItem();
                }
            });
            
        displayInventoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayInventory();
                }
            });
        panel.add(addItemButton);
        panel.add(displayInventoryButton);

         

        frame.add(panel);
        frame.setVisible(true);
    }

    private void displayInventory() {
        if (itemList.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Inventory is empty.");
        } else {
            StringBuilder inventoryDetails = new StringBuilder();
            inventoryDetails.append("===== Inventory Details =====\n");
            inventoryDetails.append(String.format("%-5s | %-15s | %-10s | %-10s | %s\n",
                    "ID", "Name", "Quantity", "Price", "Expiry Date"));
            inventoryDetails.append("----------------------------------------------------------\n");

            for (Item item : itemList) {
                inventoryDetails.append(String.format("%-5d | %-15s | %-10d | $%-9.2f | %s\n",
                        item.getId(), item.getName(), item.getQuantity(), item.getPrice(), item.getExpiryDate()));
            }

            JTextArea textArea = new JTextArea(inventoryDetails.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Inventory", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void addNewItem() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Item ID:"));
        String name = JOptionPane.showInputDialog("Enter Item Name:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
        String expiryDateString = JOptionPane.showInputDialog("Enter Expiry Date (YYYY-MM-DD):");
        LocalDate expiryDate = LocalDate.parse(expiryDateString);

        Item newItem = new Item(id, name, quantity, price, expiryDate);
        itemList.add(newItem);
        JOptionPane.showMessageDialog(frame, "Item added successfully!");
    }

     

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new InventoryManagerGUI();
                }
            });
    }
}
