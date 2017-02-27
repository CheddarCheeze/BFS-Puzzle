
import javax.swing.JFrame;

public class Viz extends JFrame
{
    public Viz() throws Exception
    {
        View view = new View(this);
        view.addMouseListener(view);
        this.setTitle("Puzzle");
        this.setSize(482, 505);
        this.getContentPane().add(view);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception
    {
        new Viz();
    }
}