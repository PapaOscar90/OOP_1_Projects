package graphEditor.model;

import java.awt.*;
import java.util.Observable;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphVertex extends Observable {
    private String name;
    private Rectangle rectangle;

    public GraphVertex(int x, int y, int w, int h, String name) {
        this.name = name;
        this.rectangle = new Rectangle(x, y, w, h);
    }

    public void setName(String s) {
        if (s != null) {
            this.name = s;
            setChanged();
            notifyObservers();
        }
    }

    public void setPosition(int x, int y) {
        this.rectangle.setLocation(x, y);
        setChanged();
        notifyObservers();
    }

    public void setSize(int w, int h) {
        this.rectangle.setSize(w, h);
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.rectangle.x;
    }

    public int getY() {
        return this.rectangle.y;
    }

    public int getWidth() {
        return this.rectangle.width;
    }

    public int getHeight() {
        return this.rectangle.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphVertex)) return false;

        GraphVertex that = (GraphVertex) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return rectangle != null ? rectangle.equals(that.rectangle) : that.rectangle == null;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
