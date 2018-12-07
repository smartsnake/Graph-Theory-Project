import java.awt.Graphics;
import java.awt.Color;


public class Vertice{
    int id;
    int x;
    int y;
    int circleSize = 17;//changes vertice size

    public Vertice(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(this.x, this.y, circleSize, circleSize);
        g.drawString("" + this.id, (this.x + (this.circleSize/2) - 2), this.y + (this.circleSize - 2));
    }
    public Edge addEdge(Vertice b){
        return new Edge(this, b);
    }
}