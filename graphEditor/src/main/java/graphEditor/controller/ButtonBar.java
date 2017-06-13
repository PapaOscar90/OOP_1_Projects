package graphEditor.controller;

import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar{
    private boolean selected = false;

    private class AddVertex extends JButton{
        protected AddVertex(){
            super("Add Vertex");
        }
    }

    private class AddEdge extends JButton{
        protected AddEdge(){
            super("Add Edge");
        }
    }

    private class RemoveEdge extends JButton{
        protected RemoveEdge(){
            super("Remove Edge");
        }
    }

    private class RemoveVertex extends JButton{
        protected  RemoveVertex(){
            super("Remove Vertex");
            this.setVisible(false);
        }

    }

    public ButtonBar(GraphModel model){
        super("Toolbar");
        this.setOrientation(HORIZONTAL);
        this.setBorderPainted(true);
        this.setBackground(Color.darkGray);

        ButtonActionListener buttonActionListener = new ButtonActionListener(model);

        AddVertex vertexButton = new AddVertex();
        vertexButton.addActionListener(buttonActionListener);

        AddEdge edgeButton = new AddEdge();
        edgeButton.addActionListener(buttonActionListener);

        RemoveVertex removeVertex = new RemoveVertex();
        removeVertex.addActionListener(buttonActionListener);

        RemoveEdge removeEdge = new RemoveEdge();
        removeEdge.addActionListener(buttonActionListener);

        add(vertexButton);
        add(edgeButton);
        add(removeEdge);
        add(removeVertex);
    }

    public void setSelected(){
        if(this.getComponentAtIndex(3).isVisible()){
            this.getComponentAtIndex(3).setVisible(false);
        }else{
            this.getComponentAtIndex(3).setVisible(true);
        }

        this.updateUI();
    }
}
