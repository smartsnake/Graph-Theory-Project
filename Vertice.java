import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.lang.Math;

public class Vertice{
    int id;
    int x;
    int y;
    int circleSize = 17;//changes vertice size
    ArrayList<Vertice> Edges;

    Vertice parent;

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
        float[] dist = getDistance();
        for(int z = 0; z < this.Edges.size(); z++){
            g.setColor(Color.BLACK);
            g.drawString("" + dist[z], (this.x + this.Edges.get(z).x)/2, (this.y + this.Edges.get(z).y)/2);
            g.drawLine(this.x, this.y, this.Edges.get(z).x, this.Edges.get(z).y);
        }
        
    }
    public float dist(int x2, int y2){
        return (float)Math.sqrt((this.x - x2) * (this.x - x2) + (this.y - y2) * (this.y - y2));
    }
    public float[] getDistance(){
        float[] dist = new float[Edges.size()];
        for(int x = 0; x < dist.length; x++){
                dist[x] = dist(Edges.get(x).x, Edges.get(x).y);
        }
        return dist;
    }
}