package graphEditor.model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/** graphEditor
 * Created by PhilO on 03-Jun-17.
 */
public class GraphModel extends Observable implements Observer {
    private List<GraphVertex> vertices;
    private List<GraphEdge> edges;
    private GraphVertex selectedVertex;


    public GraphModel(){
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(GraphVertex vertex){
        this.vertices.add(vertex);
        vertex.addObserver(this);
        setChanged();
        notifyObservers();
    }

    public void addEdge(GraphEdge edge){
        this.edges.add(edge);
        setChanged();
        notifyObservers();
    }

    public GraphVertex getVertex(int i){
        return vertices.get(i);
    }

    public GraphEdge getEdges(int i){return edges.get(i);}

    public int getVertexCount(){return vertices.size();}

    public void removeEdge(GraphEdge edge){
        edges.remove(edge);
        setChanged();
        notifyObservers();
    }

    public void removeSelectedVertex() {
        // Find all edges that have an end at the vertex to be removed and remove it (linear time 2n)
        for (int i = 0; i<edges.size(); i++) {
            if (edges.get(i).getVertexAt(0) == selectedVertex || edges.get(i).getVertexAt(1) == selectedVertex) {
                removeEdge(edges.get(i));
                i--;
            }
        }
        this.vertices.remove(selectedVertex);
        setChanged();
        notifyObservers();
    }

    // TODO: Change to serialization method
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
                GraphVertex from, to;
                from = edge.getVertexAt(0);
                to = edge.getVertexAt(1);

                bufferedWriter.write(Integer.toString(vertices.indexOf(from)));
                bufferedWriter.write(" ");
                bufferedWriter.write(Integer.toString(vertices.indexOf(to)));
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
                try {
                    GraphEdge newEdge = new GraphEdge(vertices.get(Integer.parseInt(sVerts[0])), vertices.get(Integer.parseInt(sVerts[1])));
                    addEdge(newEdge);
                }catch (Exception e){
                    System.out.println("Out of bounds loading.");
                }
            }
            setChanged();
            notifyObservers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberEdges() {return this.edges.size();}

    public void deleteAll() {
        this.edges.clear();
        this.vertices.clear();
        setChanged();
        notifyObservers();
        System.out.println("Cleared Memory.");
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

    public void setSelected(GraphVertex selected) {
        this.selectedVertex = selected;
    }
}
