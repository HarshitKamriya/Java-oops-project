
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import people.Customer;
import supermarket.Product;

public class displayBill extends Main{
    displayBill() {
        // Print Bill
        Scanner scn = new Scanner(System.in);
        Customer customer = getCustomerDetails(scn);

        ArrayList<Product> cart = new ArrayList<>();
        while (true) {
            System.out.print("Enter Product ID (0 to finish): ");
            int productId = scn.nextInt();
            scn.nextLine(); // Consume newline

            if (productId == 0) {
                break; // Exit the loop when 0 is entered.
            }

            Product product = getProductById(productId);
            if (product != null) {
                cart.add(product);
                System.out.println("Added Product: " + product.getProductName());
            } else {
                System.out.println("Product not found.");
            }
        }

        // Calculate and print the bill
        double totalBill = calculateBill(cart);
        System.out.println("Total Bill: $" + totalBill);
        Frame frame = new Frame("Customer Bill");
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Center the window

        // 🧾 Customer Info Panel
        Panel customerPanel = new Panel(new GridLayout(3, 1));
        customerPanel.add(new Label("Customer ID: " + customer.getCustomerId()));
        customerPanel.add(new Label("Customer Name: " + customer.getCustomerName()));
        customerPanel.add(new Label("Phone No: " + customer.getCustomerPhoneNo()));
        customerPanel.setBackground(Color.LIGHT_GRAY);
        customerPanel.setFont(new Font("SansSerif", Font.BOLD, 14));

        // 🛒 Product List Panel
        Panel productPanel = new Panel(new GridLayout(cart.size(), 1));
        for (Product p : cart) {
            productPanel.add(new Label("• " + p.getProductName() + " - $" + p.getProductPrice()));
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(productPanel);

        // 💰 Total Bill Panel
        Panel totalPanel = new Panel();
        totalPanel.setLayout(new FlowLayout());
        totalPanel.setBackground(Color.YELLOW);
        Label totalLabel = new Label("Total Bill: $" + totalBill);
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        totalPanel.add(totalLabel);

        // 🖱️ Close Button
        Button closeBtn = new Button("Close");
        closeBtn.addActionListener(e -> frame.dispose());
        totalPanel.add(closeBtn);

        // 🧩 Add Panels to Frame
        frame.add(customerPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(totalPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }    
}
