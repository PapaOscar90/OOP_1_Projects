package graphEditor.controller;

import graphEditor.model.GraphModel;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar {
    private GraphModel model;

    // Constructor for button bar
    public ButtonBar(GraphModel model, EdgeController edgeController) {
        super("Toolbar");
        this.model = model;
        this.setOrientation(HORIZONTAL);
        this.setBorderPainted(true);
        this.setBackground(Color.darkGray);

        // Add Vertex Button and Action
        JButton vertexButton = new JButton("Add Vertex");
        vertexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.undoableEditHappened(new UndoableEditEvent(model,new UndoableAddVertex(model)));
                setSelected();
                updateUI();
            }
        });

        // Add Edge button and Action
        JButton edgeButton = new JButton("Add Edge");
        edgeButton.setEnabled(false);
        edgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edgeController.enableEdgeAdder();

            }
        });

        // Remove Vertex Button and Action
        JButton removeVertex = new JButton("Remove Vertex");
        removeVertex.setEnabled(false);
        removeVertex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.undoableEditHappened(new UndoableEditEvent(model, new UndoableRemoveVertex(model)));
                setSelected();
                updateUI();
            }
        });

        // Remove Edge Button and Action
        JButton removeEdge = new JButton("Remove Edge");
        removeEdge.setEnabled(false);
        removeEdge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edgeController.enableEdgeRemover();
            }
        });

        // Rename Vertex Button and Action
        JButton renameVertex = new JButton("Rename Vertex");
        renameVertex.setEnabled(false);
        renameVertex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.undoableEditHappened(new UndoableEditEvent(model, new UndoableRenameVertex(model)));
                setSelected();
                updateUI();
            }
        });

        // Undo Button and Action
        JButton undoButton = new JButton("Undo");
        undoButton.setEnabled(false);
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.undoLast();
                setSelected();
                updateUI();
            }
        });


        // Redo Button and Action
        JButton redoButton = new JButton("Redo");
        redoButton.setEnabled(false);
        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.redoLast();
                setSelected();
                updateUI();
            }
        });

        // Add the buttons to the bar now that they are configured correctly
        add(vertexButton);
        add(edgeButton);
        add(removeEdge);
        add(removeVertex);
        add(renameVertex);
        add(undoButton);
        add(redoButton);
    }

    // Updated the UI and enables/disables components that must have a selected vertex to work
    void setSelected() {
        if (model.getSelectedVertex() != null) {
            for (int i = 1; i < 5; i++) {
                this.getComponentAtIndex(i).setEnabled(true);
            }
        } else {
            for (int i = 1; i < 5; i++) {
                this.getComponentAtIndex(i).setEnabled(false);
            }
        }

        if(model.canUndo()){
            this.getComponentAtIndex(5).setEnabled(true);
        }else{
            this.getComponentAtIndex(5).setEnabled(false);
        }

        if(model.canRedo()){
            this.getComponentAtIndex(6).setEnabled(true);
        }else{
            this.getComponentAtIndex(6).setEnabled(false);
        }

        this.updateUI();
    }
}
