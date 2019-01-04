import javax.swing.JFrame;
import java.awt.Toolkit;


public class Graph extends JFrame
{
    Model model;
    View view;
    int numOfVert = 15;

    public Graph(){
        model = new Model();
        model.randomVertices(numOfVert);
        model.randomEdges();
        //model.allEdges();

        model.BFS(0, 2);
        view = new View(model);

        this.setTitle("Graph!");
		this.setSize(900, 600);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

    }
    public void update(){
        //model.update();
        view.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
}