package JIntW01;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooserWithFiltersEx extends JFrame {

    public FileChooserWithFiltersEx(){
        setTitle("JFileChooser con Filtros");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Boton para abrir el JFileChooser
        JButton openButton = new JButton("Seleccionar archivo o directorio");
        openButton.addActionListener(e->{
            // Crear JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Seleccione un archivo o directorio");

            // Configurar filtros para archivos especificos
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Archivos de Texto(*.txt)", "txt");
            FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Imagenes (*.png, *.jpg)", "png", "jpg");
            fileChooser.addChoosableFileFilter(textFilter);
            fileChooser.addChoosableFileFilter(imageFilter);
            fileChooser.setFileFilter(textFilter); // Filtro predeterminado

            // Permitir seleccion de archivos y directorios
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            //Abrir el cuadro de dialogo
            int result = fileChooser.showOpenDialog(FileChooserWithFiltersEx.this);

            // Procesar la seleccion
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Seleccionado: " + selectedFile.getAbsolutePath(), "Archivo o directorio seleccionado", JOptionPane.INFORMATION_MESSAGE);
            } else if (result == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(this,"Seleccion cancelada.", "Estado", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Anadir boton al JFrame
        add(openButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileChooserWithFiltersEx :: new);
    }
}
