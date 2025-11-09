import Application.Supermarket;
import java.awt.*;

public class LogOutCaisher extends Main {
    LogOutCaisher(int cashierId) {
        double totalprice = Supermarket.getTotalPrice();
    
        Frame f = new Frame("Transaction Summary");
        f.setSize(400, 250);
        f.setLayout(new BorderLayout());
        f.setLocationRelativeTo(null); 

        Panel p = new Panel(new GridLayout(5, 1));
        p.add(new Label("Thank you for using this application"));
        p.add(new Label("Total Price: $" + totalprice));
        p.add(new Label("Bonus for this transaction: $" + (totalprice / 100)));
        p.add(new Label("Logged out Cashier with ID: " + cashierId));
        p.add(new Label("Returning to login screen..."));

        Panel bottomPanel = new Panel();
        Button btn = new Button("Close");
        bottomPanel.add(btn);
        btn.addActionListener(e -> f.dispose());

        f.add(p, BorderLayout.CENTER);
        f.add(bottomPanel, BorderLayout.SOUTH);

        f.setVisible(true);

    }
}
