package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

/**
 * graphEditor
 * Created by PhilO on 16-Jun-17.
 */
public class UndoableDeleteVertex extends AbstractUndoableEdit {
    private GraphModel model;
    private GraphVertex vertex;

    public UndoableDeleteVertex(GraphModel model, GraphVertex vertex){
        this.model=model;
        this.vertex=vertex;
    }

    public void redo() throws CannotRedoException{
        model.setSelectedVertex(vertex);
        model.removeSelectedVertex();
    }

    public void undo() throws CannotUndoException{
        model.addVertex(vertex);
        model.setSelectedVertex(vertex);
    }
}
