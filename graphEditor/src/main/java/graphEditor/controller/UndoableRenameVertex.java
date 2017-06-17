package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.*;
import javax.swing.undo.AbstractUndoableEdit;

/**
 * graphEditor
 * Created by PhilO on 17-Jun-17.
 */
class UndoableRenameVertex extends AbstractUndoableEdit {
    private GraphModel model;
    private GraphVertex vertex;
    private String oldName;
    private String newName;

    UndoableRenameVertex(GraphModel model){
        this.model = model;
        this.vertex = model.getSelectedVertex();
        oldName = model.getSelectedVertex().getName();
        newName = (String) JOptionPane.showInputDialog(null, "Input name:", "Choose Name", JOptionPane.PLAIN_MESSAGE, null, null, "Name");
        model.getSelectedVertex().setName(newName);
    }

    public void undo(){
        super.undo();
        model.setSelectedVertex(vertex);
        model.getSelectedVertex().setName(oldName);
        model.setSelectedVertex(null);
    }

    public void redo(){
        super.redo();
        model.setSelectedVertex(vertex);
        model.getSelectedVertex().setName(newName);
        model.setSelectedVertex(null);
    }
}
