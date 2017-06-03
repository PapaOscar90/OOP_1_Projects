package graphEditor.model;

import com.sun.javafx.geom.Vec2d;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphVertex {
    private String name;
    private int size;
    private Vec2d position;

    public  GraphVertex(){
        this.name = "Generic Vertex";
        this.size = 50;
        this.position.set(0,0);
    }

    public GraphVertex(String name, int s, int x, int y){
        this.name = name;
        this.size = s;
        this.position.set(x,y);
    }

    public GraphVertex(String s){this.name = s;}

    public String getName(){return name;}

    public void setName(String s){this.name = s;}

    public void setPosition(int x, int y){this.position.set(x,y);}

    public Vec2d getPosition(){return position;};

    public void setSize(int s){this.size=s;}

    public int getSize(){return size;}
}
