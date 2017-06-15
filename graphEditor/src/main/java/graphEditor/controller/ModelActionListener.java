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
    private ButtonBar buttonBar;
    public ModelActionListener(GraphModel model, ButtonBar buttonBar) {
        this.model = model;
        this.buttonBar = buttonBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Next Model":      if(model.getSelectedVertex()==null){
                                        model.nextModel();
                                    }else{
                                        buttonBar.setSelected();
                                        model.setSelectedVertex(null);
                                        model.nextModel();
                                    }
                                    break;
            case "Prev Model":      if(model.getSelectedVertex()==null){
                                        model.prevModel();
                                    }else{
                                        buttonBar.setSelected();
                                        model.prevModel();
                                    }
                                    break;
            default:                break;
        }
    }
}
