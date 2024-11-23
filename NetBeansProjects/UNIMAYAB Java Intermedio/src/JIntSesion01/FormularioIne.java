
package JIntSesion01;

import javax.swing.*;
import java.awt.*;

public class FormularioIne extends JFrame{
            
    public FormularioIne(){
        
        // Datos del frame
        setTitle("Formulario INE");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        // Layout
        setLayout(new BorderLayout());
        
        // Creacion de etiquetas
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,20));
        
        // Componentes del formulario
        JLabel etiquetaNombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField();
        
        JLabel etiquetaEdad = new JLabel("Edad");
        JTextField campoEdad = new JTextField();
        
        JLabel etiquetaColonia = new JLabel("Colonia");
        JTextField campoColonia = new JTextField();
        
        // Anadir componentes al panel
        inputPanel.add(etiquetaNombre);
        inputPanel.add(campoNombre);
        inputPanel.add(etiquetaEdad);
        inputPanel.add(campoEdad);
        inputPanel.add(etiquetaColonia);
        inputPanel.add(campoColonia);
        
        // Panel para el boton
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Enviar");
        buttonPanel.add(submitButton);
        
        // Anadir paneles al JFrame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Hacer visible el JFrame
        setVisible(true);
               

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormularioIne::new);
    }
}
