package JIntSesion02;

import javax.swing.*;
import java.awt.*;

public class EjemploSeleccion extends JFrame {

    public EjemploSeleccion(){
        setTitle("Ejemplo de seleccion");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Configuracion del panel principal
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Seleccion Unica
        JLabel etiquetaRadio = new JLabel("Seleccion de genero");
        JRadioButton etiqueta1 = new JRadioButton("Masculino");
        JRadioButton etiqueta2 = new JRadioButton("Femenino");
        JRadioButton etiqueta3 = new JRadioButton("Otro");
        ButtonGroup grupoGenero = new ButtonGroup(); // Agrupando los botones
        grupoGenero.add(etiqueta1);
        grupoGenero.add(etiqueta2);
        grupoGenero.add(etiqueta3);

        // Seleccion multiple
        JLabel etiquetaMultiple = new JLabel("Seleccione sus ingredientes");
        JCheckBox check1 = new JCheckBox("Guayaba");
        JCheckBox check2 = new JCheckBox("Melon");
        JCheckBox check3 = new JCheckBox("Papaya");

        // Seleccion de una lista desplegable
        JLabel etiquetaDesplegable = new JLabel("Seleccione su pais");
        String[] paises = {"Mexico", "Argentina", "Colombia", "Chile", "Paraguay"};
        JComboBox<String> comboBoxPaises = new JComboBox<>(paises);

        // Anadiendo componentes al panel
        panel1.add(etiquetaRadio);
        panel1.add(etiqueta1);
        panel1.add(etiqueta2);
        panel1.add(etiqueta3);

        panel1.add(Box.createRigidArea(new Dimension(0,10))); // Espaciado
        panel1.add(etiquetaMultiple);
        panel1.add(check1);
        panel1.add(check2);
        panel1.add(check3);

        panel1.add(Box.createRigidArea(new Dimension(0,10))); // Espaciado
        panel1.add(etiquetaDesplegable);
        panel1.add(comboBoxPaises);

        add(panel1);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EjemploSeleccion :: new);
    }
}
