package graphEditor.controller;


import graphEditor.model.GraphModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * graphEditor
 * Created by PhilO on 11-Jun-17.
 */
public class ButtonActionListener implements ActionListener {
    private GraphModel model;

    public ButtonActionListener(GraphModel model){this.model = model;}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ButtonActionListener:");

        switch (e.getActionCommand()){
            case "Add Vertex":      System.out.println("Add Vertex");
                                    break;
            case "Add Edge":        System.out.println("Add Edge");
                                    break;
            default:                System.out.println("Default");
                                    break;
        }
    }
}
