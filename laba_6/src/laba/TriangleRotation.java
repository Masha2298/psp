package laba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TriangleRotation extends JFrame {
    public int angle = 0;

    public TriangleRotation() {
        setTitle("Triangle Rotation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(new MyKeyListener());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private void rotateTriangle(Graphics g) {
        int[] xPoints = {100, 150, 200};
        int[] yPoints = {200, 100, 200};

        // Поворот треугольника
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Math.toRadians(angle), 150, 150);

        g.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        rotateTriangle(g);
    }
    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_RIGHT) {
                angle += 10;
            } else if (key == KeyEvent.VK_LEFT) {
                angle -= 10;
            }

            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TriangleRotation triangleRotation = new TriangleRotation();
            triangleRotation.setVisible(true);
        });
    }
}
