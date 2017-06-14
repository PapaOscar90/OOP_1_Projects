package graphEditor.controller;

import graphEditor.model.GraphModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * graphEditor
 * Created by PhilO on 14-Jun-17.
 */
public class ModelActionListener implements ActionListener{
    private GraphModel model;
    public ModelActionListener(GraphModel model) {this.model = model;}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Next Model":      model.nextModel();
                                    break;
            case "Prev Model":      model.prevModel();
                                    break;
            default:                break;
        }
    }
}
