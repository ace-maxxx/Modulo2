
package JIntSesion01;

import javax.swing.*;
import java.awt.*;

public class MiVentana extends JFrame {
    private JButton boton1, boton2, boton3, boton4, boton5;
        
    public MiVentana(){
        boton1 = new JButton("seno");
        this.getContentPane().add(boton1, BorderLayout.NORTH);
        boton2 = new JButton("coseno");
        this.getContentPane().add(boton2, BorderLayout.WEST);
        boton3 = new JButton("tangente");
        this.getContentPane().add(boton3, BorderLayout.EAST);
        boton4 = new JButton("cotangente");
        this.getContentPane().add(boton4, BorderLayout.SOUTH);
        boton5 = new JButton("secante");
        this.getContentPane().add(boton5, BorderLayout.CENTER);
        setTitle("Calculadora");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        MiVentana miVentana = new MiVentana();
        // miVentana.setBounds(10,10,200,200);
        // miVentana.pack();
        miVentana.setVisible(true);
    }
    
}
