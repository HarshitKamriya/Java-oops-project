import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import people.Cashier;
import people.Customer;
import supermarket.Product;
import supermarket.Supermarket;

public class Main {
    public static Customer getCustomerDetails(Scanner scn) {
        System.out.println("Enter Customer Details:");

        System.out.print("Customer ID: ");
        int customerId = scn.nextInt();
        scn.nextLine(); // Consume the newline character

        System.out.print("Customer Name: ");
        String customerName = scn.nextLine();

        System.out.print("Customer Phone Number: ");
        String customerPhoneNumber = scn.nextLine();

        // Create a Customer object with the entered details
        Customer customer = new Customer(customerId, customerName, customerPhoneNumber);

        System.out.println("Customer Details captured.");
        return customer;
    }

    public static Product getProductById(int productId) {
        Product[] productList = Supermarket.getProductList();
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product; // Found the product with the specified ID
            }   
        }

        // Product with the specified ID was not found
        return null;
    }

    public static double calculateBill(List<Product> cart) {
        double totalPrice = 0;

        System.out.println("Bill Details:");
        for (Product product : cart) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
         
            System.out.println("Product Quantity: " + product.getProductQuantity());

            double productTotalPrice = product.getProductPrice() * product.getProductQuantity();
            System.out.println("Product Total Price: $" + productTotalPrice);

            totalPrice += productTotalPrice;
            System.out.println();
        }

        System.out.println("Total Price: $" + totalPrice);
        return totalPrice;
    }


    public static Product getProductAttributes(Scanner scn) {
        System.out.println("Enter Product Attributes:");

        System.out.print("Product ID: ");
        int productId = scn.nextInt();
        scn.nextLine(); // Consume the newline character

        System.out.print("Product Name: ");
        String productName = scn.nextLine();

        System.out.print("Product Price: ");
        double productPrice = scn.nextDouble();
        scn.nextLine(); // Consume the newline character

        System.out.print("Product Quantity: ");
        int productQuantity = scn.nextInt();

        // Create a Product object with the entered attributes
        return new Product(productId, productName, productPrice, productQuantity);
    }

    public static void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Print Bill");
        System.out.println("2. Add Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Get Product List");
        System.out.println("5. Get Total Price");
        System.out.println("6. Get Product by ID");
        System.out.println("7. Logout Cashier");
        System.out.print("Enter your choice: ");
    }
}
