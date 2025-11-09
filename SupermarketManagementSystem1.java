import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.*;

import supermarket.Supermarket;
import people.Customer;
import people.Cashier;
import supermarket.Product;

public class SupermarketManagementSystem1 extends Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Hello! Welcome to the Supermarket Management System.");

        Cashier c1 = new Cashier(123, "Harshit");

        /*
         * loop for validity of caisher , run till valid caisher id is not obtained.
         */
        int cashierId;
        while (true) {
            System.out.print("Please enter your Cashier ID: ");
            int x = scn.nextInt();
            cashierId = c1.getCashierId();
            if (x == cashierId) {
                System.out.println("Welcome! Select the things from menu");
                break;
            } else {
                System.out.println("Please re-enter the correct caisher-Id");
            }
            scn.nextLine(); // Consume newline
        }

        // Main menu loop
        while (true) {
            Main.printMainMenu(); // displaying the main menu to the caisher

            int choice = scn.nextInt();
            scn.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Print Bill
                    new displayBill();
                    break;

                case 2:
                    // Add Product
                    Product product = getProductAttributes(scn);
                    Supermarket.addProduct(product);
                    System.out.println("Product Added.");
                    break;

                case 3:
                    // Remove Product
                    System.out.print("Enter Product ID to Remove: ");
                    int productId = scn.nextInt();
                    scn.nextLine(); // Consume newline
                    if (Supermarket.removeProduct(productId)) {
                        System.out.println("Product Removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    // Get Product List
                   
                    break;

                case 5:
                    // Get Total Price
                    double totalPrice = Supermarket.getTotalPrice();
                    System.out.println("Total Price: $" + totalPrice);


                    Frame frame2 = new Frame("Total Price");
                    frame2.setSize(300, 150);
                    frame2.setLayout(new BorderLayout());
                    frame2.setLocationRelativeTo(null); // Center the window

                    //  Price Label
                    Label priceLabel = new Label("Total Price: $" + totalPrice, Label.CENTER);
                    priceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
                    frame2.add(priceLabel, BorderLayout.CENTER);

                    //  Close Button
                    Panel bottomPanel2 = new Panel();
                    Button closeBtn2 = new Button("Close");
                    closeBtn2.addActionListener(e -> frame2.dispose());
                    bottomPanel2.add(closeBtn2);
                    frame2.add(bottomPanel2, BorderLayout.SOUTH);

                    frame2.setVisible(true);

                    break;

                case 6:
                    // Get Product by ID
                    System.out.print("Enter Product ID: ");
                    int prodId = scn.nextInt();
                    scn.nextLine(); // Consume newline
                    Product productById = getProductById(prodId);
                    if (productById != null) {
                        System.out.println("Product Details:");
                        System.out.println("Product ID: " + productById.getProductId());
                        System.out.println("Product Name: " + productById.getProductName());
                        System.out.println("Product Price: $" + productById.getProductPrice());
                        System.out.println("Product Quantity: " + productById.getProductQuantity());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 7:

                    System.out.println("Thank you for using this application");
                    double totalprice = Supermarket.getTotalPrice();
                    double bonous = totalprice/100;
                    System.out.println("Your Bonous for this transaction is $"+bonous);
                    // Logout Cashier

                    System.out.println("Logged out Cashier with ID: " + cashierId);

                    // Return to the login screen or exit the program if needed.
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
