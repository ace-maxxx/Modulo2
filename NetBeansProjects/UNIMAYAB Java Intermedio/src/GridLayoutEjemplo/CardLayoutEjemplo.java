package GridLayoutEjemplo;

import javax.swing.*;
import java.awt.*;

public class CardLayoutEjemplo extends JFrame {
    
    public CardLayoutEjemplo()  {
        setTitle("CARD LAYOUT");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        
        cardPanel.add(new JLabel("Tarjeta 1"), "Card 1");
        cardPanel.add(new JLabel("Tarjeta 2"), "Card 2");
        cardPanel.add(new JLabel("Tarjeta 3"), "Card 3");
        cardPanel.add(new JLabel("Tarjeta 4"), "Card 4");
        
        // Botones para navegar
        
    }
    
}
