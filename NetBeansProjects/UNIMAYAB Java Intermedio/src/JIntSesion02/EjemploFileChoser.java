package JIntSesion02;

import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class EjemploFileChoser extends JFrame {
    public EjemploFileChoser(){
        setTitle("File Choser");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Boton abrir JFileChoser
        JButton openButton = new JButton("Seleccione su archivo");
        openButton.addActionListener(e -> {
            // Crear un JFile Choser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Seleccione su archivo");

            // Abrir el cuadro de dialogo
            int result = fileChooser.showOpenDialog(EjemploFileChoser.this);

            // Procesar la accion del usuario
            if(result == JFileChooser.APPROVE_OPTION){
                String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showConfirmDialog(EjemploFileChoser.this,"Archivo seleccionado" + selectedFilePath);
            } else if (result == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(EjemploFileChoser.this,"Seleccion cancelada");
            }
        });

        //Adicionar el boton
        add(openButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EjemploFileChoser :: new);
    }
}
