import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import supermarket.Supermarket;
import people.Customer;
import people.Cashier;
import supermarket.Product;
import java.awt.*;


public class SupermarketManagementSystem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to the Supermarket Management System.");

        // Initialize a variable to store the current cashier ID.
        int cashierId ;
        Cashier c1 = new Cashier(123, "Harshit");

        // Continuously loop until a valid cashier ID is entered.
        while(true){
            System.out.print("Please enter your Cashier ID: ");
            int x = scanner.nextInt();
            cashierId = c1.getCashierId();
            if(x==cashierId){
                break;
            }
            else{
                System.out.println("Please re-enter the correct caisher-Id");
            }
            scanner.nextLine(); // Consume newline
        }
        


        

        // Main menu loop
        while (true) {
            printMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // // Print Bill
                    Customer customer = getCustomerDetails(scanner);

                    List<Product> cart = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter Product ID (0 to finish): ");
                        int productId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

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

                    // // Calculate and print the bill
                    double totalBill = calculateBill(cart);
                    // System.out.println("Total Bill: $" + totalBill);
                    // break;


                    // Now adding Gui to the code


                    Frame frame = new Frame("Customer Bill");
                    frame.setSize(400, 600);
                    frame.setLayout(new BorderLayout());
                    frame.setLocationRelativeTo(null); // Center the window

                    //  Customer Info Panel
                    Panel customerPanel = new Panel(new GridLayout(3, 1));
                    customerPanel.add(new Label("Customer ID: " + customer.getCustomerId()));
                    customerPanel.add(new Label("Customer Name: " + customer.getCustomerName()));
                    customerPanel.add(new Label("Phone No: " + customer.getCustomerPhoneNo()));
                    customerPanel.setBackground(Color.LIGHT_GRAY);
                    customerPanel.setFont(new Font("SansSerif", Font.BOLD, 14));

                    //  Product List Panel
                    Panel productPanel = new Panel(new GridLayout(cart.size(), 1));
                    for (Product p : cart) {
                        productPanel.add(new Label("• " + p.getProductName() + " - $" + p.getProductPrice()));
                    }

                    ScrollPane scrollPane = new ScrollPane();
                    scrollPane.add(productPanel);

                    //  Total Bill Panel
                    Panel totalPanel = new Panel();
                    totalPanel.setLayout(new FlowLayout());
                    totalPanel.setBackground(Color.YELLOW);
                    Label totalLabel = new Label("Total Bill: $" + totalBill);
                    totalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
                    totalPanel.add(totalLabel);

                    //  Close Button
                    Button closeBtn = new Button("Close");
                    closeBtn.addActionListener(e -> frame.dispose());
                    totalPanel.add(closeBtn);

                    //  Add Panels to Frame
                    frame.add(customerPanel, BorderLayout.NORTH);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.add(totalPanel, BorderLayout.SOUTH);

                    frame.setVisible(true);    
                    break;        

                case 2:
                    // Add Product
                    Product product = getProductAttributes(scanner);
                    Supermarket.addProduct(product);
                    System.out.println("Product Added.");
                    break;

                case 3:
                    // Remove Product
                    System.out.print("Enter Product ID to Remove: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (Supermarket.removeProduct(productId)) {
                        System.out.println("Product Removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    // Get Product List
                    Product[] productList = Supermarket.getProductList();
                    // System.out.println("Product List:");
                    // for (Product p : productList) {
                    //     System.out.println("Product ID: " + p.getProductId());
                    //     System.out.println("Product Name: " + p.getProductName());
                    //     System.out.println("Product Price: $" + p.getProductPrice());
                    //     System.out.println("Product Quantity: " + p.getProductQuantity());
                    // }

                    Frame frame1 = new Frame("Product List");
                    frame1.setSize(500, 600);
                    frame1.setLayout(new BorderLayout());
                    frame1.setLocationRelativeTo(null); // Center the window

                    // 🧾 Title
                    Label title = new Label("Available Products", Label.CENTER);
                    title.setFont(new Font("SansSerif", Font.BOLD, 18));
                    frame1.add(title, BorderLayout.NORTH);

                    Panel productPanel1 = new Panel();
                    productPanel1.setLayout(new GridLayout(productList.length, 1, 5, 5));

                    for (Product p : productList) {
                        Panel itemPanel = new Panel(new GridLayout(4, 1));
                        itemPanel.setBackground(new Color(230, 240, 255));
                        itemPanel.add(new Label("Product ID: " + p.getProductId()));
                        itemPanel.add(new Label("Name: " + p.getProductName()));
                        itemPanel.add(new Label("Price: $" + p.getProductPrice()));
                        itemPanel.add(new Label("Quantity: " + p.getProductQuantity()));
                        itemPanel.setFont(new Font("Dialog", Font.PLAIN, 14));
                        productPanel1.add(itemPanel);
                    }

                    ScrollPane scrollPane1 = new ScrollPane();
                    scrollPane1.add(productPanel1);
                    frame1.add(scrollPane1, BorderLayout.CENTER);

                    // ❌ Close Button
                    Panel bottomPanel = new Panel();
                    Button closeBtn1 = new Button("Close");
                    closeBtn1.addActionListener(e -> frame1.dispose());
                    bottomPanel.add(closeBtn1);
                    frame1.add(bottomPanel, BorderLayout.SOUTH);

                    frame1.setVisible(true);
                    break;

                case 5:
                    // Get Total Price
                    double totalPrice = Supermarket.getTotalPrice();
                    System.out.println("Total Price: $" + totalPrice);
                    break;

                case 6:
                    // Get Product by ID
                    System.out.print("Enter Product ID: ");
                    int prodId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
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

    private static Customer getCustomerDetails(Scanner scanner) {
        System.out.println("Enter Customer Details:");

        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Customer Phone Number: ");
        String customerPhoneNumber = scanner.nextLine();

        // Create a Customer object with the entered details
        Customer customer = new Customer(customerId, customerName, customerPhoneNumber);

        System.out.println("Customer Details captured.");
        return customer;
    }

    private static Product getProductById(int productId) {
        Product[] productList = Supermarket.getProductList();
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product; // Found the product with the specified ID
            }   
        }

        // Product with the specified ID was not found
        return null;
    }

    private static double calculateBill(List<Product> cart) {
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



    private static Product getProductAttributes(Scanner scanner) {
        System.out.println("Enter Product Attributes:");

        System.out.print("Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Product Price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Product Quantity: ");
        int productQuantity = scanner.nextInt();

        // Create a Product object with the entered attributes
        return new Product(productId, productName, productPrice, productQuantity);
    }

    private static void printMainMenu() {
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
