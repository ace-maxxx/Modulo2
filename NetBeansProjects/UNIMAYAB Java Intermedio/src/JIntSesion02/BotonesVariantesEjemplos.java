package JIntSesion02;

import javax.swing.*;
import java.awt.*;

public class BotonesVariantesEjemplos extends JFrame {

    public BotonesVariantesEjemplos() {
        setTitle("Botones Variantes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Boton ESTANDAR
        JButton botonEstandar = new JButton("Boton Estandar");
        botonEstandar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Boton ICONO
        JButton botonIcono = new JButton("Boton Icono");
        botonIcono.setIcon(new ImageIcon("/home/perroto/IdeaProjects/Modulo2/out/Imagenes/3669401_ic_work_icon.png"));
        botonIcono.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Boton DESHABILITADO
        JButton botonDisable = new JButton("Boton Deshabilitado");
        botonDisable.setEnabled(false);
        botonDisable.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Boton DOS ESTADOS
        JToggleButton botonToggle = new JToggleButton("Boton Dos Estados");
        botonToggle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Boton BORDES PERSONALIZADOS
        JButton botonBordes = new JButton("Boton Bordes Personalizados");
        botonBordes.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        botonBordes.setBackground(Color.CYAN); // Verificar que hacen las minusculas
        botonBordes.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Añadir botones al panel
        panel1.add(botonEstandar);
        panel1.add(Box.createRigidArea(new Dimension(0,10)));
        panel1.add(botonIcono);
        panel1.add(Box.createRigidArea(new Dimension(5,15)));
        panel1.add(botonDisable);
        panel1.add(Box.createRigidArea(new Dimension(10, 20)));
        panel1.add(botonToggle);
        panel1.add(Box.createRigidArea(new Dimension(10,20)));
        panel1.add(botonBordes);
        panel1.add(Box.createRigidArea(new Dimension(0,30)));

        // Añadir panel al JFrame
        add(panel1);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BotonesVariantesEjemplos :: new);
    }
}
