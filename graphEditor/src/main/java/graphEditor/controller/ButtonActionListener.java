package graphEditor.controller;


import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import graphEditor.view.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * graphEditor
 * Created by PhilO on 11-Jun-17.
 */
public class ButtonActionListener implements ActionListener {
    private GraphModel model;


    public ButtonActionListener(GraphModel model){
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ButtonActionListener:");

        switch (e.getActionCommand()){
            case "Add Vertex":      int newX = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Input x:", "Add Vertex 1/5", JOptionPane.PLAIN_MESSAGE,null,null,"x postion"));
                                    int newY = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Input y:", "Add Vertex 2/5", JOptionPane.PLAIN_MESSAGE,null,null,"y position"));
                                    int newWidth = 100;
                                    int newHeight = 50;
                                    String newName = (String) JOptionPane.showInputDialog(null,"Input name:", "Add Vertex 5/5", JOptionPane.PLAIN_MESSAGE,null,null,"Name");

                                    model.addVertex(new GraphVertex(newX, newY, newWidth, newHeight, newName));

                                    break;
            case "Add Edge":        System.out.println("Add Edge");
                                    break;
            case "Remove Edge":     JOptionPane.showMessageDialog(null,"Select two vertices to delete the edge between", "How To Delete",JOptionPane.INFORMATION_MESSAGE);
                                    break;
            case "Remove Vertex":   model.removeSelectedVertex();
                                    System.out.println("Poof, gone");
                                    break;
            default:                System.out.println("Default");
                                    break;
        }
    }
}
