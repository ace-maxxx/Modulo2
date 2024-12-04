package JIntSesion03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EjemploAvanzadoHandling {
    public static void main(String[] args) {

        // Crear el marco principal o ventana
        JFrame frame = new JFrame("Ejemplo avanzado de Listeners");
        //frame.setDefaultCloseOperation();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Crear campo de texto
        JTextField campo1 = new JTextField();
        campo1.setBounds(50, 50, 200, 200);
        frame.add(campo1);

        // Crear un boton
        JButton boton1 = new JButton();
        boton1.setBounds(270, 50, 100, 30);
        frame.add(boton1);

        // Crear un panel que cambie de color
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(50, 100, 300, 200);
        frame.add(panel1);

        // Crear una etiqueta para mostrar info del teclado
        JLabel etiquetaInfo = new JLabel();
        etiquetaInfo.setBounds(50, 320, 400, 30);
        frame.add(etiquetaInfo);

        // Agregamos acciones del listener
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campo1.getText();
                System.out.println("Texto ingresado: " + texto);
                JOptionPane.showMessageDialog(frame, "Texto mandado: " + texto);
            }
        });

        // Agregar MouseListener
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                panel1.setBackground(new Color((int)(Math.random() * 0x1000000)));
                System.out.println("Panel clickeado en la posicion (" + x + ", " + y + ")");

            }
        });

        // Agregar KeyListener
        campo1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int codigoTecla = e.getKeyCode();
                char caracterTecla = e.getKeyChar();
                etiquetaInfo.setText("Tecla presionada: " + caracterTecla + " Codigo de la tecla: " + codigoTecla);

                /*if (codigoTecla == KeyEvent.VK_ESCAPE) {
                    frame.dispose();
                } else {
                    System.out.println("Salga presionando ESC");
                } */

            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);

    }
}
