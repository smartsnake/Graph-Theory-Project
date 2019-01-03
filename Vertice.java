import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;


public class Vertice{
    int id;
    int x;
    int y;
    int circleSize = 17;//changes vertice size
    ArrayList<Vertice> Edges;

    public Vertice(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
        this.Edges = new ArrayList<Vertice>();
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(this.x, this.y, circleSize, circleSize);
        g.drawString("" + this.id, (this.x + (this.circleSize/2) - 2), this.y + (this.circleSize - 2));
    }
    public void drawEdges(Graphics g){
        for(int z = 0; z < this.Edges.size(); z++){
            g.setColor(Color.BLACK);
            g.drawLine(this.x, this.y, this.Edges.get(z).x, this.Edges.get(z).y);
        }
        
    }
    // public Edge addEdge(Vertice b){
    //     return new Edge(this, b);
    // }
}