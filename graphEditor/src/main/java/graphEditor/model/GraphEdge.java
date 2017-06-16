package graphEditor.model;

import javafx.scene.shape.Shape;

import javax.sound.sampled.Line;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphEdge extends Observable{
    private List<GraphVertex> connects;

    // Index 0 is from, index 1 is to
    public GraphEdge(GraphVertex from, GraphVertex to){
        this.connects = new ArrayList<GraphVertex>();
        this.connects.add(from);
        this.connects.add(to);
    }

    public void set(int i, GraphVertex vertex){
        this.connects.set(i, vertex);
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean equals(Object obj) {
        GraphEdge e = (GraphEdge)obj;
        if ((e.getVertexAt(0).equals(this.getVertexAt(0)) && e.getVertexAt(1).equals(this.getVertexAt(1))) ||
                (e.getVertexAt(1).equals(this.getVertexAt(0)) && e.getVertexAt(1).equals(this.getVertexAt(0)))){
            return true;
        }
        return false;
    }

    public GraphVertex getVertexAt(int i){
        return connects.get(i);
    }



}
