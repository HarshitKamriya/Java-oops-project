import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Application.Product;
import Application.Supermarket;
import Users.Cashier;
import Users.Customer;

import java.awt.*;

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
                    new displayProductList();
                    break;

                case 5:
                    // Get Total Price
                    new displayTotalPrice();
                    break;

                case 6:
                    new displayProductById();
                    break;

                case 7:
                    new LogOutCaisher(cashierId)
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
