package graphEditor.model;

import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhilO on 03-Jun-17.
 */
public class GraphModel {
    private List<GraphVertex> vertices;
    private List<GraphEdge> edges;


    public GraphModel(){
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(GraphVertex vertex){
        this.vertices.add(vertex);
    }

    public void addEdge(GraphEdge edge){
        this.edges.add(edge);
    }

    public GraphVertex getVertex(int i){
        return vertices.get(i);
    }

    public GraphEdge getEdge(int i){
        return edges.get(i);
    }
}
