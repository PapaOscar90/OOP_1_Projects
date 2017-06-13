package graphEditor.model;

import java.awt.*;
import java.util.Observable;

/**
 *   Created by PhilO on 03-Jun-17.
 */
public class GraphVertex extends Observable{
    private String      name;
    private Rectangle   rectangle;
    private Color color = new Color(200,255,255);
    private boolean isSelected;

    public  GraphVertex(int id){
        this.name = "Vertex";
        this.rectangle = new Rectangle(50,20);
        this.isSelected = false;
    }

    public GraphVertex(int x, int y, int w, int h, String name){
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

    public void setSize(int w, int h){
        this.rectangle.setSize(w,h);
        setChanged();
        notifyObservers();
    }

    public String getName(){return this.name;}

    public int getX(){
        return this.rectangle.x;
    }
    public int getY(){
        return this.rectangle.y;
    }
    public int getWidth(){
        return this.rectangle.width;
    }
    public int getHeight(){
        return this.rectangle.height;
    }

    public Rectangle getRectangle(){
        return rectangle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected=selected;
        if (this.isSelected == true){
            this.setColor(new Color(91, 255, 45));
        } else {
            setColor(new Color(200, 255, 255));
        }
        setChanged();
        notifyObservers();
    }
}
