import java.awt.Graphics;
import java.awt.Color;


public class Edge{
    Vertice a;
    Vertice b;
    public Edge(Vertice a, Vertice b){
        this.a = a;
        this.b = b;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(a.x, a.y, b.x, b.y);
    }
}