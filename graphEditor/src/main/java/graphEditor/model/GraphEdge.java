package graphEditor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphEdge {
    private List<GraphVertex> edge;

    // Index 0 is from, index 1 is to
    public GraphEdge(GraphVertex from, GraphVertex to){
        edge = new ArrayList<>(2);
        this.edge.set(0, from);
        this.edge.set(1, to);
    }

    public void set(int i, GraphVertex vertex){
        this.edge.set(i, vertex);
    }

    public GraphVertex getVertexAt(int i){
        return edge.get(i);
    }
}
