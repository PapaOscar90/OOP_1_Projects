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

    public GraphVertex getVertices(int i){
        return vertices.get(i);
    }

    public GraphEdge getEdges(int i){return edges.get(i);
    }

    public void removeEdge(GraphEdge edge){
        edges.remove(edge);
    }

    private void removeVertex(GraphVertex vertex) {
        // Find all edges that have an end at the vertex to be removed and remove it (linear time 2n)
        for(int i=0; i<edges.size(); i++){
            if(edges.get(i).getVertexAt(0) == vertex || edges.get(i).getVertexAt(1) == vertex){
                removeEdge(edges.get(i));
            }
        }
        vertices.remove(vertex);
    }
}
