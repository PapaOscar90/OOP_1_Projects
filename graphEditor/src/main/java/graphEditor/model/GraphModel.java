package graphEditor.model;

import sun.security.provider.certpath.Vertex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


    public void saveToFile(String filename){
        try{
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i=0; i<edges.size(); i++){
                bufferedWriter.write(edges.get(i).getVertexAt(0).getName());
                bufferedWriter.write(" ");
                bufferedWriter.write(edges.get(i).getVertexAt(1).getName());
                bufferedWriter.newLine();
            }

            for(int i=0; i<vertices.size(); i++){
                bufferedWriter.write(vertices.get(i).getLocation().toString());
                bufferedWriter.write(" ");
                bufferedWriter.write(vertices.get(i).getSize().toString());
                bufferedWriter.write(" ");
                bufferedWriter.write(vertices.get(i).getName());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename){
        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while(line != null){
                //TODO: Implement this!
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
