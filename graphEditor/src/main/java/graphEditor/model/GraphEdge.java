package graphEditor.model;

import javafx.scene.shape.Shape;

import javax.sound.sampled.Line;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphEdge {
    private List<GraphVertex> connects;

    // Index 0 is from, index 1 is to
    public GraphEdge(GraphVertex from, GraphVertex to){
        this.connects = new ArrayList<GraphVertex>();
        this.connects.add(from);
        this.connects.add(to);
    }

    public void set(int i, GraphVertex vertex){
        this.connects.set(i, vertex);
    }

    public GraphVertex getVertexAt(int i){
        return connects.get(i);
    }

}
