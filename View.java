import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Color;

public class View extends JPanel{
    Model m;
    public View(Model m){
        this.m = m;
    }
    public void paintComponent(Graphics g){
		
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());	
        m.draw(g);
    }
}