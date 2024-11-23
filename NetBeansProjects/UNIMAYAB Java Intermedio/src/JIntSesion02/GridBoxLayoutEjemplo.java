package JIntSesion02;

import javax.swing.*;
import java.awt.*;

public class GridBoxLayoutEjemplo extends JFrame {

    public GridBoxLayoutEjemplo() {
    setTitle("Mi prueba del BoxLayout");
    setSize(400, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar BoxLayout eje de las y
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Agregar componentes
        panel.add(new JLabel("Etiquetita"));
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(new JLabel("Etiquetota"));
        panel.add(Box.createVerticalGlue());
        panel.add(new JButton("Boton"));

        add(panel);

        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GridBoxLayoutEjemplo :: new);
    }

}
