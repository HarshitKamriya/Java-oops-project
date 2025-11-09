import java.awt.*;

import Application.Supermarket;

public class displayTotalPrice extends Main {
    displayTotalPrice() {
        double totalPrice = Supermarket.getTotalPrice();
        System.out.println("Total Price: $" + totalPrice);

        Frame f = new Frame("Total Price");
        f.setSize(300, 150);
        f.setLayout(new BorderLayout());
        f.setLocationRelativeTo(null); // Center the window

        // Price Label
        Label priceLabel = new Label("Total Price: $" + totalPrice, Label.CENTER);
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        f.add(priceLabel, BorderLayout.CENTER);

        // Close Button
        Panel bottompanel = new Panel();
        Button btn = new Button("Close");
        btn.addActionListener(e -> f.dispose());
        bottompanel.add(btn);
        f.add(bottompanel, BorderLayout.SOUTH);

        f.setVisible(true);
    }
}
