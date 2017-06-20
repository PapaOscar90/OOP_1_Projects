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
public class GraphEdge extends Observable {
    private List<GraphVertex> connects;

    // Index 0 is from, index 1 is to. Would allow directed graphs
    public GraphEdge(GraphVertex from, GraphVertex to) {
        this.connects = new ArrayList<>();
        this.connects.add(from);
        this.connects.add(to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphEdge)) return false;

        GraphEdge graphEdge = (GraphEdge) o;

        return connects != null ? connects.equals(graphEdge.connects) : graphEdge.connects == null;
    }

    public GraphVertex getVertexAt(int i) {
        return connects.get(i);
    }


}
