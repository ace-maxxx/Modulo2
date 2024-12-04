package JIntW01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MousePositionEx extends JFrame {

    private final JLabel positionLabel;

    public MousePositionEx(){
        setTitle("Posicion del raton");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear etiqueta para mostrar la posicion
        positionLabel = new JLabel("Posicion: ");
        positionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(positionLabel, BorderLayout.SOUTH);

        // Anadir MouseMotionListener para capturar movimiento del raton
        addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
                //Actualizar la posicion del raton
                positionLabel.setText("Posicion X= " + e.getX() + "Y= " + e.getY());
            }

            public void mouseDragged(MouseEvent e) {
                // Este metodo no se utiliza en este ejemplo
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MousePositionEx :: new);
    }
}
