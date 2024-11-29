package JIntW01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowKeyGame extends JFrame{
    private JPanel player;
    private final int STEP = 10; // Movement size

    public ArrowKeyGame() {
        setTitle("Juego con flechas");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Free layout to move object

        // Create player object
        player = new JPanel();
        player.setBackground(Color.BLUE);
        player.setBounds(180, 180, 40, 40); // Initial size and position
        add(player);

        // Adding KeyListener to JFrame
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                // Move object according to pressed key
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> movePlayer(0, -STEP);
                    case KeyEvent.VK_DOWN -> movePlayer(0, STEP);
                    case KeyEvent.VK_LEFT -> movePlayer(-STEP, 0);
                    case KeyEvent.VK_RIGHT -> movePlayer(STEP, 0);
                }
            }
            public void keyTyped(KeyEvent e) {
                // Not used in this example
            }
            public void keyReleased(KeyEvent e) {
                // Not used on this example
            }
        });

        setFocusable(true); // Allows JFrame to receive key events
        setVisible(true);
    }

    //Metodo para mover al jugador
    private void movePlayer(int dx, int dy) {
        int x = player.getX() + dx;
        int y = player.getY() + dy;

        // Limiting movement inside the window
        if (x >= 0 && x + player.getWidth() <= getWidth() &&
            y >= 0 && y + player.getHeight() <= getHeight()) {
            player.setLocation(x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArrowKeyGame :: new);
    }
}
