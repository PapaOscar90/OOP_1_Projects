package graphEditor.controller;

import graphEditor.model.GraphModel;

import javax.swing.*;

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
        super();
        this.add(new addVertexButton());
        this.add(new addEdgeButton());
    }

}
