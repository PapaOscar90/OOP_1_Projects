package graphEditor.model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** graphEditor
 * Created by PhilO on 03-Jun-17.
 */
public class GraphModel {
    private List<GraphVertex> vertices;
    private List<GraphEdge> edges;


    public GraphModel(){
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();/*
        GraphVertex v1 = new GraphVertex(400,400,200,200,"1");
        GraphVertex v2 = new GraphVertex(100,200,200,200,"2");
        GraphVertex v3 = new GraphVertex(800,100,200,200,"3");
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
        for(int i=0; i<edges.size(); i++){
            if(edges.get(i).getVertexAt(0) == vertex || edges.get(i).getVertexAt(1) == vertex){
                removeEdge(edges.get(i));
            }
        }
        vertices.remove(vertex);
    }


    public void saveToFile(String filename){
        try{
            FileWriter fileWriter = new FileWriter(filename+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i=0; i<vertices.size(); i++){
                bufferedWriter.write(Integer.toString(vertices.get(i).getX()));
                bufferedWriter.write(" ");
                bufferedWriter.write(Integer.toString(vertices.get(i).getY()));
                bufferedWriter.write(" ");
                bufferedWriter.write(Integer.toString(vertices.get(i).getWidth()));
                bufferedWriter.write(" ");
                bufferedWriter.write(Integer.toString(vertices.get(i).getHeight()));
                bufferedWriter.write(" ");
                bufferedWriter.write(vertices.get(i).getName());
                bufferedWriter.newLine();
            }

            for(int i=0; i<edges.size(); i++){
                bufferedWriter.write(edges.get(i).getVertexAt(0).getName());
                bufferedWriter.write(" ");
                bufferedWriter.write(edges.get(i).getVertexAt(1).getName());
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

            String line = bufferedReader.readLine();

            while(line != null){
                if(line.lastIndexOf(" ") == 1){
                    edgesToMake.add(line);
                }else{
                    String[] sParts = line.split(" ");
                    GraphVertex loadVertex = new GraphVertex(Integer.parseInt(sParts[0]),Integer.parseInt(sParts[1]),Integer.parseInt(sParts[2]),Integer.parseInt(sParts[3]),sParts[4]);
                    addVertex(loadVertex);
                }
                line = bufferedReader.readLine();
            }

            for(int i=0; i<edgesToMake.size(); i++){
                GraphVertex addFrom = null;
                GraphVertex addTo = null;
                String[] sVerts = edgesToMake.get(i).split(" ");

                for(int j=0; j<vertices.size(); j++){
                    if(vertices.get(j).getName() == sVerts[0]){
                        addFrom = vertices.get(j);
                    }
                    if(vertices.get(j).getName() == sVerts[1]){
                        addTo = vertices.get(j);
                    }
                }
                if (addFrom != null && addTo != null){
                    GraphEdge newEdge = new GraphEdge(addFrom, addTo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberEdges() {return this.edges.size();}
}
