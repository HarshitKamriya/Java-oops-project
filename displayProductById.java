import java.awt.*;
import java.util.Scanner;

import Application.Product;

public class displayProductById extends Main {
    displayProductById() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        int prodId = scn.nextInt();
        scn.nextLine(); 
        Product productById = getProductById(prodId);

        Frame f = new Frame("Product Lookup");
        f.setSize(400, 300);
        f.setLayout(new BorderLayout());
        f.setLocationRelativeTo(null); // Center the window

        //  Product Info Panel (CENTER)
        Panel infoPanel = new Panel(new GridLayout(4, 1));
        infoPanel.add(new Label("Product ID: " + productById.getProductId()));
        infoPanel.add(new Label("Product Name: " + productById.getProductName()));
        infoPanel.add(new Label("Product Price: " + productById.getProductPrice()));
        infoPanel.add(new Label("Product Quantity: " + productById.getProductQuantity() ));

        Panel bottomPanel = new Panel();
        Button closeBtn = new Button("Close");
        bottomPanel.add(closeBtn);
        closeBtn.addActionListener(e -> f.dispose());

        //  Add Panels to Frame
        f.add(infoPanel, BorderLayout.CENTER);
        f.add(bottomPanel, BorderLayout.SOUTH);

        f.setVisible(true);

    }
}
