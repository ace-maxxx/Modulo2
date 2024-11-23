package GridLayoutEjemplo;

import javax.swing.*;
import java.awt.*;

public class GridEjemplo1 extends JFrame {
    
    public GridEjemplo1(){
        // Caracteristicas
        setTitle("Registro Escolar");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Configurar el grid
         setLayout(new GridLayout(3, 3, 10, 10));
        
        // Anadir componentes
        add(new JLabel("Materia"));
        add(new JTextField());
        add(new JLabel());
        add(new JLabel("Curso"));
        add(new JTextField());
        add(new JButton("Aceptar"));
        add(new JLabel("Calificacion"));
        add(new JTextField());
        add(new JLabel());
       
                        
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GridEjemplo1::new);
    }
}
