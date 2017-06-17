package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import graphEditor.view.GraphPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar{
    private GraphModel model;
    private EdgeController ec;
    private JButton vertexButton;
    private JButton edgeButton;
    private JButton removeVertex;
    private JButton removeEdge;
    private JButton renameVertex;


    public ButtonBar(GraphModel model, EdgeController ec){
        super("Toolbar");
        this.model = model;
        this.ec = ec;
        this.setOrientation(HORIZONTAL);
        this.setBorderPainted(true);
        this.setBackground(Color.darkGray);

        vertexButton = new JButton("Add Vertex");
        vertexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newX = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Input x:", "Add Vertex 1/5", JOptionPane.PLAIN_MESSAGE,null,null,"x postion"));
                int newY = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Input y:", "Add Vertex 2/5", JOptionPane.PLAIN_MESSAGE,null,null,"y position"));
                int newWidth = 100;
                int newHeight = 50;
                String newName = (String) JOptionPane.showInputDialog(null,"Input name:", "Add Vertex 5/5", JOptionPane.PLAIN_MESSAGE,null,null,"Name");

                model.addVertex(new GraphVertex(newX, newY, newWidth, newHeight, newName));
            }
        });

        edgeButton = new JButton("Add Edge");
        edgeButton.setEnabled(false);
        edgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ec.enableEdgeAdder();
            }
        });

        removeVertex = new JButton("Remove Vertex");
        removeVertex.setEnabled(false);
        removeVertex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeSelectedVertex();
                setSelected();
            }
        });

        removeEdge = new JButton("Remove Edge");
        removeEdge.setEnabled(false);
        removeEdge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ec.enableEdgeRemover();
            }
        });

        renameVertex = new JButton("Rename Vertex");
        renameVertex.setEnabled(false);
        renameVertex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName2 = (String) JOptionPane.showInputDialog(null,"Input name:", "Add Vertex 5/5", JOptionPane.PLAIN_MESSAGE,null,null,"Name");
                model.getSelectedVertex().setName(newName2);
            }
        });

        add(vertexButton);
        add(edgeButton);
        add(removeEdge);
        add(removeVertex);
        add(renameVertex);
    }

    public void setSelected(){
        if(model.getSelectedVertex() != null){
            for (int i = 1; i < 5; i++){
                this.getComponentAtIndex(i).setEnabled(true);
            }
        }else{
            for (int i = 1; i < 5; i++){
                this.getComponentAtIndex(i).setEnabled(false);
            }
        }

        this.updateUI();
    }
}
