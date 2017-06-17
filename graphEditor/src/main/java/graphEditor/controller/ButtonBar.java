package graphEditor.controller;

import graphEditor.model.GraphModel;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar {
    private GraphModel model;


    public ButtonBar(GraphModel model, EdgeController edgeController) {
        super("Toolbar");
        this.model = model;
        this.setOrientation(HORIZONTAL);
        this.setBorderPainted(true);
        this.setBackground(Color.darkGray);

        JButton vertexButton = new JButton("Add Vertex");
        vertexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*int newX = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Input x:", "Add Vertex 1/3", JOptionPane.PLAIN_MESSAGE, null, null, "x postion"));
                int newY = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Input y:", "Add Vertex 2/3", JOptionPane.PLAIN_MESSAGE, null, null, "y position"));
                int newWidth = 100;
                int newHeight = 50;
                String newName = (String) JOptionPane.showInputDialog(null, "Input name:", "Add Vertex 3/3", JOptionPane.PLAIN_MESSAGE, null, null, "Name");

                model.addVertex(new GraphVertex(newX, newY, newWidth, newHeight, newName));*/
                model.undoableEditHappened(new UndoableEditEvent(model,new UndoableAddVertex(model)));
            }
        });

        JButton edgeButton = new JButton("Add Edge");
        edgeButton.setEnabled(false);
        edgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edgeController.enableEdgeAdder();
            }
        });

        JButton removeVertex = new JButton("Remove Vertex");
        removeVertex.setEnabled(false);
        removeVertex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeSelectedVertex();
                setSelected();
            }
        });

        JButton removeEdge = new JButton("Remove Edge");
        removeEdge.setEnabled(false);
        removeEdge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edgeController.enableEdgeRemover();
            }
        });

        JButton renameVertex = new JButton("Rename Vertex");
        renameVertex.setEnabled(false);
        renameVertex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName2 = (String) JOptionPane.showInputDialog(null, "Input name:", "Choose Name", JOptionPane.PLAIN_MESSAGE, null, null, "Name");
                model.getSelectedVertex().setName(newName2);
            }
        });

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

        add(vertexButton);
        add(edgeButton);
        add(removeEdge);
        add(removeVertex);
        add(renameVertex);
        add(undoButton);
    }

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

        this.updateUI();
    }
}
