package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.view.GraphPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by saidf on 6/16/2017.
 */
public class edgeSelectionController extends MouseInputAdapter {
    private GraphModel model;
    private GraphPanel panel;

    public edgeSelectionController(GraphModel model, GraphPanel panel) {
        this.model = model;
        this.panel = panel;

        panel.addMouseListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        model.setMousePosX(e.getX());
        model.setMousePosY(e.getY());
    }
}
