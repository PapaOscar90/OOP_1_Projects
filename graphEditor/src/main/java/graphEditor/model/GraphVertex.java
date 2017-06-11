package graphEditor.model;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Observable;

/**
 *   Created by PhilO on 03-Jun-17.
 */
public class GraphVertex extends Observable{
    private String      name;
    private Rectangle   rectangle;
    private int         id;

    public  GraphVertex(){
        this.name = "Vertex";
        this.rectangle = new Rectangle(50,20);
    }

    GraphVertex(int x, int y, int w, int h, String name){
        this.name = name;
        this.rectangle = new Rectangle(x,y,w,h);
    }

    public void setName(String s){
        this.name = s;
        setChanged();
        notifyObservers();
    }

    public void setPosition(int x, int y){
        this.rectangle.setLocation(x,y);
        setChanged();
        notifyObservers();
    }

    public void setSize(int w, int h){this.rectangle.setSize(w,h);}

    public String getName(){return this.name;}

    public int getX(){return this.rectangle.x;}
    public int getY(){return this.rectangle.y;}
    public int getWidth(){return this.rectangle.width;}
    public int getHeight(){return this.rectangle.height;}

    public Rectangle getRectangle(){return rectangle;};
}
