package graphEditor.controller;

import graphEditor.model.GraphEdge;
import graphEditor.model.GraphModel;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;

/**
 * graphEditor
 * Created by PhilO on 17-Jun-17.
 */
public class UndoableAddEdge extends AbstractUndoableEdit{
    private GraphModel model;
    private GraphEdge edge;

    public UndoableAddEdge(GraphModel model, GraphEdge edge) {
        this.edge =edge;
        this.model = model;
        model.addEdge(edge);
    }

    public void undo(){
        super.undo();
        model.removeEdge(edge);
    }

    public void redo(){
        super.redo();
        model.addEdge(edge);
    }
}
