package graphEditor.controller;

import graphEditor.model.GraphModel;
import javafx.geometry.Orientation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 09-Jun-17.
 */
public class ButtonBar extends JToolBar{

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

        add(vertexButton);
        add(edgeButton);

    }

}
