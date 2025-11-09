import java.awt.*;

import Application.Product;
import Application.Supermarket;

public class displayProductList extends Main {
    displayProductList() {
        Product[] productList = Supermarket.getProductList();

        Frame f = new Frame("Product List");
        f.setSize(500, 600);
        f.setLayout(new BorderLayout());
        f.setLocationRelativeTo(null); // Center the window

        // Title
        Label title = new Label("Available Products", Label.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        f.add(title, BorderLayout.NORTH);

        Panel productpanel = new Panel();
        productpanel.setLayout(new GridLayout(productList.length, 1, 5, 5));

        for (Product p : productList) {
            Panel panel = new Panel(new GridLayout(4, 1));
            panel.setBackground(new Color(230, 240, 255));
            panel.add(new Label("Product ID: " + p.getProductId()));
            panel.add(new Label("Name: " + p.getProductName()));
            panel.add(new Label("Price: $" + p.getProductPrice()));
            panel.add(new Label("Quantity: " + p.getProductQuantity()));
            panel.setFont(new Font("Dialog", Font.PLAIN, 14));
            productpanel.add(panel);
        }

        ScrollPane scrollpanel = new ScrollPane();
        scrollpanel.add(productpanel);
        f.add(scrollpanel, BorderLayout.CENTER);

        // Close Button
        Panel bottomPanel = new Panel();
        Button btn = new Button("Close");
        btn.addActionListener(e -> f.dispose());
        bottomPanel.add(btn);
        f.add(bottomPanel, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
