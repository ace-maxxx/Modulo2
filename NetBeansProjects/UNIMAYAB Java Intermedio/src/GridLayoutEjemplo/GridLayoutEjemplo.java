package GridLayoutEjemplo;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEjemplo extends JFrame {
    
    public GridLayoutEjemplo(){
        // Caracteristicas
        setTitle("Grid 3 x 5");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Configurar el grid
        setLayout(new GridLayout(3, 5, 10, 10));
        
        
                
        // Ciclo for para llenar GridLayout
        for (int i = 1; i <= 15; i++) {
            add(new JButton(String.valueOf(i)));            
        }
              
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GridLayoutEjemplo::new);
    }
}
