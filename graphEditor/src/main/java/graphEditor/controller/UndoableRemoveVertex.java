package graphEditor.controller;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import graphEditor.model.GraphEdge;
import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.List;

/**
 * graphEditor
 * Created by PhilO on 17-Jun-17.
 */
public class UndoableRemoveVertex extends AbstractUndoableEdit{
    private GraphModel model;
    private GraphVertex vertex;
    private List<GraphEdge> edgeList;

    UndoableRemoveVertex(GraphModel model){
        this.model = model;
        vertex = model.getSelectedVertex();
        edgeList = model.removeSelectedVertex();
    }

    public void undo(){
        super.undo();
        model.addVertex(vertex);
        for(int i=0; i<edgeList.size();i++){
            model.addEdge(edgeList.get(i));
        }
    }

    public void redo(){
        super.redo();
        model.setSelectedVertex(vertex);
        model.removeSelectedVertex();
    }
}
