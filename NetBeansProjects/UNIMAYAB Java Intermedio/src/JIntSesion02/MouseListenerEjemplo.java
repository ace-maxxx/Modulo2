package JIntSesion02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerEjemplo extends JFrame {

    public MouseListenerEjemplo() {
        setTitle("Ejemplo Mouse Listener");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setBackground(Color.BLACK);

        // Añadir Mouse Listener
        panelSeleccion.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No se requiere acción
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No se requiere acción
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // No se requiere acción
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar color al pasar el mouse por encima
                panelSeleccion.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Regresar color original
                panelSeleccion.setBackground(Color.BLACK);
            }
        });

        // Añadir el panel
        add(panelSeleccion);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseListenerEjemplo::new);
    }
}
