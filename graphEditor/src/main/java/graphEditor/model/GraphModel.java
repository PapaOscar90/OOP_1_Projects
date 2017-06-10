package graphEditor.model;


import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/** graphEditor
 * Created by PhilO on 03-Jun-17.
 */
public class GraphModel {
    private List<GraphVertex> vertices;
    private List<GraphEdge> edges;


    public GraphModel(){
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();/*
        GraphVertex v1 = new GraphVertex(400,400,200,200,"humpty");
        GraphVertex v2 = new GraphVertex(100,200,200,200,"tum");
        GraphVertex v3 = new GraphVertex(800,100,200,200,"lee");
        addVertex(v1);
        addVertex(v2);
        addVertex(v3);
        GraphEdge e1 = new GraphEdge(v1,v2);
        GraphEdge e2 = new GraphEdge(v1,v3);
        addEdge(e1);
        addEdge(e2);
        saveToFile("testFile");*/
        loadFromFile("testFile.txt");
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

    public GraphEdge getEdges(int i){return edges.get(i);}

    public int getNumberRectangles(){return vertices.size();}

    public void removeEdge(GraphEdge edge){
        edges.remove(edge);
    }

    private void removeVertex(GraphVertex vertex) {
        // Find all edges that have an end at the vertex to be removed and remove it (linear time 2n)
        for (GraphEdge edge : edges) {
            if (edge.getVertexAt(0) == vertex || edge.getVertexAt(1) == vertex) {
                removeEdge(edge);
            }
        }
        vertices.remove(vertex);
    }


    public void saveToFile(String filename){
        try{
            FileWriter fileWriter = new FileWriter(filename+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (GraphVertex vertice : vertices) {
                bufferedWriter.write(Integer.toString(vertice.getX()));
                bufferedWriter.write(" ");
                bufferedWriter.write(Integer.toString(vertice.getY()));
                bufferedWriter.write(" ");
                bufferedWriter.write(Integer.toString(vertice.getWidth()));
                bufferedWriter.write(" ");
                bufferedWriter.write(Integer.toString(vertice.getHeight()));
                bufferedWriter.write(" ");
                bufferedWriter.write(vertice.getName());
                bufferedWriter.newLine();
            }

            for (GraphEdge edge : edges) {
                bufferedWriter.write(edge.getVertexAt(0).getName());
                bufferedWriter.write(" ");
                bufferedWriter.write(edge.getVertexAt(1).getName());
                bufferedWriter.newLine();
            }


            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename){
        try{
            List<String> edgesToMake = new ArrayList<>();
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            GraphVertex addFrom = null;
            GraphVertex addTo = null;
            String[] sVerts;
            String[] sParts;
            String line = bufferedReader.readLine();


            while(line != null){
                int numSpaces;
                sParts = line.split(" ");



                if(sParts.length == 2){
                    edgesToMake.add(line);
                }else{
                    try { //Catch an issue with data not being set right in file
                        GraphVertex loadVertex = new GraphVertex(Integer.parseInt(sParts[0]), Integer.parseInt(sParts[1]), Integer.parseInt(sParts[2]), Integer.parseInt(sParts[3]), sParts[4]);
                        addVertex(loadVertex);
                    }catch(Exception e){
                        System.out.println("sParts threw an error. Check valid input!");
                    }
                }
                line = bufferedReader.readLine();
            }

            for (String anEdgesToMake : edgesToMake) {
                sVerts = anEdgesToMake.split(" ");

                for (GraphVertex vertice : vertices) {
                    if (vertice.getName().equals(sVerts[0])) {
                        addFrom = vertice;
                    }
                    if (vertice.getName().equals(sVerts[1])) {
                        addTo = vertice;
                    }
                }
                if (addFrom != null && addTo != null) {
                    GraphEdge newEdge = new GraphEdge(addFrom, addTo);
                    addEdge(newEdge);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberEdges() {return this.edges.size();}
}
