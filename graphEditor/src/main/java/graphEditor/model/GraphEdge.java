package graphEditor.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphEdge {
    private List<GraphVertex> connects;

    // Index 0 is from, index 1 is to
    public GraphEdge(GraphVertex from, GraphVertex to){
        connects = new ArrayList<>(2);
        this.connects.set(0, from);
        this.connects.set(1, to);
    }

    public void set(int i, GraphVertex vertex){
        this.connects.set(i, vertex);
    }

    public GraphVertex getVertexAt(int i){
        return connects.get(i);
    }
}
