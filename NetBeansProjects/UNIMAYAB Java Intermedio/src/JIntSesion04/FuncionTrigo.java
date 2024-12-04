package JIntSesion04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FuncionTrigo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grafica una funcion trigonometrica");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarFuncion(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    // Definir funcion para dibujar
    private static void dibujarFuncion(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = g2d.getClipBounds().width;
        int height = g2d.getClipBounds().height;

        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, height/2, width, height/2);
        g2d.drawLine(width/2, 0, width/2, height);

        g2d.setColor(Color.BLUE); // Agregar un listener que cambie el color de la funcion al pasar el mouse
        for (int x = 0; x < width; x++){
            double radianes = (x - width / 2.0) * Math.PI/180;
            double y = Math.sin(radianes) * height/2.0 + height/2.0;
            g2d.drawLine(x, (int)y, x, (int)y);
        }


    }
}
