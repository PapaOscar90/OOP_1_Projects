package graphEditor.controller;

import com.sun.org.apache.regexp.internal.RE;
import graphEditor.model.GraphModel;
import javafx.geometry.Orientation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar{
    private boolean selected = false;

    private class addVertexButton extends JButton{
        protected addVertexButton(){
            super("Add Vertex");
        }
    }

    private class addEdgeButton extends JButton{
        protected addEdgeButton(){
            super("Add Edge");
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

        addVertexButton vertexButton = new addVertexButton();
        vertexButton.addActionListener(buttonActionListener);

        addEdgeButton edgeButton = new addEdgeButton();
        edgeButton.addActionListener(buttonActionListener);

        RemoveVertex removeVertex = new RemoveVertex();
        removeVertex.addActionListener(buttonActionListener);

        add(vertexButton);
        add(edgeButton);
        add(removeVertex);
    }

    public void setSelected(){
        if(selected){
            this.getComponentAtIndex(2).setVisible(false);
        }else{
            this.getComponentAtIndex(2).setVisible(true);
        }
        this.updateUI();
    }
}
