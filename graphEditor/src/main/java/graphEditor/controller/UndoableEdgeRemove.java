package graphEditor.controller;

import graphEditor.model.GraphEdge;
import graphEditor.model.GraphModel;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;

/**
 * graphEditor
 * Created by PhilO on 17-Jun-17.
 */
public class UndoableEdgeRemove extends AbstractUndoableEdit{
    private GraphModel model;
    private GraphEdge edge;

    UndoableEdgeRemove(GraphModel model, GraphEdge edge) {
        this.model = model;
        this.edge = edge;
        model.removeEdge(edge);
    }

    public void undo(){
        super.undo();
        model.addEdge(edge);
    }

    public void redo() {
        super.redo();
        model.removeEdge(edge);
    }
}
