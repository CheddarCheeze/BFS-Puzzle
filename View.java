import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Color;

class View extends JPanel implements MouseListener {
    Viz viz;
    Random rand;
    byte[] state;
    Graphics graphics;
    int size;

    View(Viz v) throws IOException
    {
        viz = v;
        rand = new Random(0);
        state = new byte[22];
        size = 48;
    }

    public void mousePressed(MouseEvent e)
    {
        state[rand.nextInt(22)] += (rand.nextInt(2) == 0 ? -1 : 1);

        for(int i = 0; i < 11; i++)
        System.out.print("(" + state[2 * i] + "," +
                state[2 * i + 1] + ") ");
        System.out.println();
        viz.repaint();
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    // Draw a block
    public void block(int x, int y)
    {
        graphics.fillRect(size * x, size * y, size, size);
    }

    // Draw a 3-block piece
    public void shape(int id, int red, int green, int blue,
            int x1, int y1, int x2, int y2, int x3, int y3)
    {
        graphics.setColor(new Color(red, green, blue));
        block(state[2 * id] + x1, state[2 * id + 1] + y1);
        block(state[2 * id] + x2, state[2 * id + 1] + y2);
        block(state[2 * id] + x3, state[2 * id + 1] + y3);
    }

    // Draw a 4-block piece
    public void shape(int id, int red, int green, int blue,
            int x1, int y1, int x2, int y2,
            int x3, int y3, int x4, int y4)
    {
        shape(id, red, green, blue, x1, y1, x2, y2, x3, y3);
        block(state[2 * id] + x4, state[2 * id + 1] + y4);
    }

    public void paintComponent(Graphics g)
    {
        // Draw the black squares
        graphics = g;
        g.setColor(new Color(0, 0, 0));
        for(int i = 0; i < 10; i++) { block(i, 0); block(i, 9); }
        for(int i = 1; i < 9; i++) { block(0, i); block(9, i); }
        block(1, 1); block(1, 2); block(2, 1);
        block(7, 1); block(8, 1); block(8, 2);
        block(1, 7); block(1, 8); block(2, 8);
        block(8, 7); block(7, 8); block(8, 8);
        block(3, 4); block(4, 4); block(4, 3);

        // Draw the pieces
        shape(0, 255, 0, 0, 1, 3, 2, 3, 1, 4, 2, 4);
        shape(1, 0, 255, 0, 1, 5, 1, 6, 2, 6);
        shape(2, 128, 128, 255, 2, 5, 3, 5, 3, 6);
        shape(3, 255, 128, 128, 3, 7, 3, 8, 4, 8);
        shape(4, 255, 255, 128, 4, 7, 5, 7, 5, 8);
        shape(5, 128, 128, 0, 6, 7, 7, 7, 6, 8);
        shape(6, 0, 128, 128, 5, 4, 5, 5, 5, 6, 4, 5);
        shape(7, 0, 128, 0, 6, 4, 6, 5, 6, 6, 7, 5);
        shape(8, 0, 255, 255, 8, 5, 8, 6, 7, 6);
        shape(9, 0, 0, 255, 6, 2, 6, 3, 5, 3);
        shape(10, 255, 128, 0, 5, 1, 6, 1, 5, 2);
    }
}