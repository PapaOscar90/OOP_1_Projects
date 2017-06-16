package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import graphEditor.view.GraphPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by saidf on 6/13/2017.
 */
public class DraggingController extends MouseInputAdapter {
    private GraphPanel panel;
    private GraphModel model;
    private int startX;
    private int startY;

    public DraggingController(GraphPanel panel, GraphModel model){
        this.panel = panel;
        this.model = model;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (model.getSelectedVertex() != null) {
            startX = e.getX() - model.getSelectedVertex().getX();
            startY = e.getY() - model.getSelectedVertex().getY();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        GraphVertex vertex = model.getSelectedVertex();
        if (vertex != null && vertex == model.getSelectedVertex()){
            vertex.setPosition(e.getX() - startX, e.getY() - startY);
        }
    }
}
