package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar{
    private boolean isVisible = false;
    private ButtonBar buttonBar;
    private JButton vertexButton;
    private JButton edgeButton;
    private JButton removeVertex;
    private JButton removeEdge;
    private JButton renameVertex;


    public ButtonBar(GraphModel model){
        super("Toolbar");
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
        edgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Edge");
            }
        });

        removeVertex = new JButton("Remove Vertex");
        removeVertex.setEnabled(false);
        removeVertex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Select two vertices to delete the edge between", "How To Delete",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        removeEdge = new JButton("Remove Edge");
        removeEdge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeSelectedVertex();
                buttonBar.setSelected();
                System.out.println("Poof, gone");
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

    //TODO: For loops here?
    public void setSelected(){
        if(isVisible){
            this.getComponentAtIndex(3).setEnabled(false);
            this.getComponentAtIndex(4).setEnabled(false);
            isVisible = false;
        }else{
            this.getComponentAtIndex(3).setEnabled(true);
            this.getComponentAtIndex(4).setEnabled(true);
            isVisible = true;
        }

        this.updateUI();
    }
}
