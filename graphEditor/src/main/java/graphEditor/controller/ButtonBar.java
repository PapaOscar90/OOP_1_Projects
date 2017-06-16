package graphEditor.controller;

import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar{
    private boolean isVisible = false;
    private ButtonBar buttonBar;

    private class AddVertex extends JButton{
        protected AddVertex(){
            super("Add Vertex");
        }
    }

    private class AddEdge extends JButton{
        protected AddEdge(){
            super("Add Edge");
            this.setEnabled(false);
        }
    }

    private class RemoveEdge extends JButton{
        protected RemoveEdge(){
            super("Remove Edge");
            this.setEnabled(false);
        }
    }


    private class RemoveVertex extends JButton{
        protected  RemoveVertex(){
            super("Remove Vertex");
            this.setEnabled(false);
        }
    }

    private class RenameVertex extends JButton{
        protected  RenameVertex(){
            super("Rename Vertex");
            this.setEnabled(false);
        }
    }

    public ButtonBar(GraphModel model){
        super("Toolbar");
        this.setOrientation(HORIZONTAL);
        this.setBorderPainted(true);
        this.setBackground(Color.darkGray);

        ButtonActionListener buttonActionListener = new ButtonActionListener(model, this);

        AddVertex vertexButton = new AddVertex();
        vertexButton.addActionListener(buttonActionListener);

        AddEdge edgeButton = new AddEdge();
        edgeButton.addActionListener(buttonActionListener);

        RemoveVertex removeVertex = new RemoveVertex();
        removeVertex.addActionListener(buttonActionListener);

        RemoveEdge removeEdge = new RemoveEdge();
        removeEdge.addActionListener(buttonActionListener);

        RenameVertex renameVertex = new RenameVertex();
        renameVertex.addActionListener(buttonActionListener);

        add(vertexButton);
        add(edgeButton);
        add(removeEdge);
        add(removeVertex);
        add(renameVertex);
    }

    //TODO: For loops here?
    public void setSelected(){
        if(isVisible){
            for (int i = 1; i < 5; i++){
                this.getComponentAtIndex(i).setEnabled(false);
            }
            isVisible = false;
        }else{
            for (int i = 1; i < 5; i++){
                this.getComponentAtIndex(i).setEnabled(true);
            }
            isVisible = true;
        }

        this.updateUI();
    }
}
