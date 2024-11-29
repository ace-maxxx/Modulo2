package JIntW01;

import javax.swing.*;
import java.awt.*;

public class TextAreaExample  extends JFrame {

    public TextAreaExample() {
        setTitle("Ejemplo con JTextArea");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiqueta descriptiva
        JLabel textAreaLabel = new JLabel("Ingrese sus comentarios: ");

        // Crear JTextArea
        JTextArea textArea = new JTextArea(10, 30); // 10 filas 30 columnas
        textArea.setLineWrap(true); //Ajustar lineas automaticamente
        textArea.setWrapStyleWord(true); // Ajustar lineas por palabra

        // Colocar el JTextArea dentro de un JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Boton de accion
        JButton submitButton = new JButton("Enviar");

        // Anadir componentes al panel
        panel.add(textAreaLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        // Anadir panel al JFrame
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextAreaExample :: new);
    }
}
