import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;

public class Model{
    ArrayList<Vertice> Vertices;
    Random ran;
    

    public Model(){
        this.Vertices = new ArrayList<Vertice>();
        // this.Edges = new ArrayList<Edge>();
        ran = new Random();
    }
    //Should remove all the (int) , they are no longer needed.
    public void draw(Graphics g){
        for(int x = 0; x < Vertices.size(); x++){
            Vertices.get(x).draw(g);
            Vertices.get(x).drawEdges(g);
        }
        // for(int e = 0; e < Edges.size(); e++){
        //     Edges.get(e).draw(g);
        // }
    }
    public void randomVertices(int n){
        for(int x = 0; x < n; x++){
            Vertices.add(new Vertice(Vertices.size(), ran.nextInt(850), ran.nextInt(550)));
        }
    }
    public void randomEdges(){
        for(int x = 0; x < this.Vertices.size(); x++){
            for(int y = 1; y < Vertices.size(); y++){
                float randomFloat = ran.nextFloat();
                if(randomFloat>=(float)0.65){
                    this.Vertices.get(x).Edges.add(this.Vertices.get(y));
                }
            } 
        }
    }
    public void allEdges(){
        for(int x = 0; x < Vertices.size(); x++){
            for(int y = 1; y < Vertices.size(); y++){
                //Edges.add(new Edge(Vertices.get(x), Vertices.get(y)));
                this.Vertices.get(x).Edges.add(this.Vertices.get(y));
            }
        }
    }

    public void update(){
        //TODO: Add the thing here.
    }

    public Vertice getVertice(int n){
        if(this.Vertices.size() > 0){
            return this.Vertices.get(n);
        }
        return null;
    }

    // public Edge getEdge(int n){
    //     if(this.Edges.size() > 0){
    //         return this.Edges.get(n);
    //     }
    //     return null;
    // }
}