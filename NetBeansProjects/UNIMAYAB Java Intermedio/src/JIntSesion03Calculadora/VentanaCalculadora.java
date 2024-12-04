package JIntSesion03Calculadora;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class VentanaCalculadora extends JFrame {

    // Numeros del teclado
    JTextField pantalla;

    // Guardar el resultado
    double resultado;

    // Guardar la operacion que se hizo
    String operacion;

    // Paneles para dibujar botones
    JPanel panelNumeros, panelOperaciones;

    // Indicamos si es una operacion nueva o no
    boolean nuevaOperacion = true;

    // Constructor, creamos los botones y componentes de la calculadora
    public VentanaCalculadora() {
        setSize(250, 300);
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // Dibujo de la ventana
        JPanel panelCalc = (JPanel) this.getContentPane();
        panelCalc.setLayout(new BorderLayout());
        panelCalc.setBackground(new Color(54,54, 54));

        // Pantalla
        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Noto Sans", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(new Color(96, 122, 51));
        panelCalc.add("North", pantalla);

        // Panel de numeros
        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));
        panelNumeros.setBackground(new Color(54, 54, 54));

        for(int n=9; n >= 0; n--) {
            nuevoBotonNum("" + n);
        }
        nuevoBotonNum(".");
        panelCalc.add(panelNumeros, BorderLayout.CENTER);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));
        panelOperaciones.setBackground(new Color(54, 54, 54));

        nuevoBotonOperacion("+");
        nuevoBotonOperacion("-");
        nuevoBotonOperacion("*");
        nuevoBotonOperacion("/");
        nuevoBotonOperacion("=");
        nuevoBotonOperacion("CE");

        panelCalc.add(panelOperaciones, BorderLayout.EAST);
        validate();

    }

    // Crear botones numericos

    private void nuevoBotonNum(String digito) {
        JButton botoncito = new JButton();
        botoncito.setText(digito);
        botoncito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                JButton botoncito = (JButton) e.getSource();
                numeroPulsado(botoncito.getText());
            }
        });

        panelNumeros.add(botoncito);

        // Crear botones de operacion
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton botoncito = new JButton();
        botoncito.setText(operacion);
        botoncito.setBackground(new Color(54, 54, 54));
        botoncito.setForeground(Color.WHITE);

        botoncito.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                char numPulsado = e.getKeyChar();
                if (numPulsado == KeyEvent.VK_ENTER) {
                    //
                }
            }
        });

        botoncito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                JButton botoncito = (JButton) e.getSource();
                operacionPulsado(botoncito.getText());
            }
        });

        panelOperaciones.add(botoncito);
    }
    // Gestionar las teclas de pulsacion
    private void numeroPulsado(String digito) {
        if (pantalla.getText().equals("0") || nuevaOperacion) {
            pantalla.setText(digito);
        } else {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    //Gestionar las teclas de operacion
    private void operacionPulsado(String tecla) {
        if(tecla.equals("=")) {
            calcularResultado();
        } else if(tecla.equals("CE")) {
            resultado = 0;
            pantalla.setText("0");
            nuevaOperacion = true;
        } else {
            operacion = tecla;
            if ((resultado >0) && !nuevaOperacion) {
                calcularResultado();
            } else {
                resultado = Double.parseDouble(pantalla.getText());
            }
        }
        nuevaOperacion = true;
    }

    // Calcular resultado
    private void calcularResultado() {
        if (operacion.equals("+")) {
            resultado += Double.parseDouble(pantalla.getText());
        } else if (operacion.equals("-")) {
            resultado -= Double.parseDouble(pantalla.getText());
        } else if (operacion.equals("*")) {
            resultado *= Double.parseDouble(pantalla.getText());
        } else if (operacion.equals("/")) {
            resultado /= Double.parseDouble(pantalla.getText());
        }

        // Mandar a imprimir

        pantalla.setText("" + resultado);
        operacion = "";
    }

}
