package graphEditor.model;

import java.awt.*;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphVertex {
    private String name;
    private Rectangle rectangle;

    public  GraphVertex(){
        this.name = "Generic Vertex";
        this.rectangle = new Rectangle(50,20);
    }

    public GraphVertex(String name, int s, int x, int y){
        this.name = name;
        this.rectangle = new Rectangle(x,y,s,20);
    }

    public GraphVertex(String s){this.name = s;}

    public void setName(String s){this.name = s;}

    public void setPosition(int x, int y){this.rectangle.setLocation(x,y);}

    public void setSize(int s){this.rectangle.setSize(s,20);}

    public String getName(){return this.name;}

    public Point getLocation(){return this.rectangle.getLocation();};

    public Dimension getSize(){return this.rectangle.getSize();}
}
