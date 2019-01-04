import java.awt.Graphics;
import java.io.*; 
import java.util.*; 

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
            for(int y = x+1; y < Vertices.size(); y++){
                float randomFloat = ran.nextFloat();
                if(randomFloat>=(float)0.85){
                    this.Vertices.get(x).Edges.add(this.Vertices.get(y));
                    this.Vertices.get(y).Edges.add(this.Vertices.get(x));
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
    public void BFS(int start, int end){

        Vertice startingPoint = Vertices.get(start);
        Vertice Goal = Vertices.get(end);
        if(start == end){
            System.out.println("Found Solution!");
        }
        Queue<Vertice> que = new LinkedList<>();
        ArrayList<Vertice> beenTo = new ArrayList<>();
        que.add(startingPoint);
        while(!que.isEmpty()){
            Vertice current = que.remove();
            if(current == Goal){
                System.out.println("Found Solution!");
                System.out.print("Id: " + current.id + ", ");
                while(current.parent != null){
                    current = current.parent;
                    System.out.print("Id: " + current.id + ", ");
                }
                break;
            }
            else{
                for(int x = 0; x < current.Edges.size(); x++){
                    Vertice child = current.Edges.get(x);
                    if(!que.contains(child) && !beenTo.contains(child)){
                        que.add(child);
                        child.parent = current;
                    }
                }
            }
            beenTo.add(current);
        }
        if(que.isEmpty()){
        System.out.println("No solution!");}
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