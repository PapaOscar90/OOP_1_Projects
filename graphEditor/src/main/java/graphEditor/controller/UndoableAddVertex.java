package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;

/**
 * graphEditor
 * Created by PhilO on 17-Jun-17.
 */
public class UndoableAddVertex extends AbstractUndoableEdit {
    protected GraphModel model;
    protected GraphVertex newVertex;

    public UndoableAddVertex(GraphModel model){
        this.model = model;
        int newX = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Input x:", "Add Vertex 1/3", JOptionPane.PLAIN_MESSAGE, null, null, "x postion"));
        int newY = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Input y:", "Add Vertex 2/3", JOptionPane.PLAIN_MESSAGE, null, null, "y position"));
        int newWidth = 100;
        int newHeight = 50;
        String newName = (String) JOptionPane.showInputDialog(null, "Input name:", "Add Vertex 3/3", JOptionPane.PLAIN_MESSAGE, null, null, "Name");
        newVertex = new GraphVertex(newX, newY, newWidth, newHeight, newName);

        model.addVertex(newVertex);
    }

    public String getPresentationName(){
        return "Vertex Addition";
    }

    public void undo(){
        super.undo();
        model.setSelectedVertex(newVertex);
        model.removeSelectedVertex();
    }

    public void redo(){
        super.redo();
        model.addVertex(newVertex);
    }
}
