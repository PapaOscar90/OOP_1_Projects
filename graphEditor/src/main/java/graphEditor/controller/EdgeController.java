package graphEditor.controller;

import graphEditor.model.GraphEdge;
import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import graphEditor.view.GraphPanel;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.UndoableEditEvent;
import java.awt.event.MouseEvent;

/**
 * Created by saidf on 6/16/2017.
 */
public class EdgeController extends MouseInputAdapter {
    private GraphModel model;
    private GraphPanel panel;
    private GraphVertex vertex1;
    private GraphVertex vertex2;
    private boolean isEdgeAdder;

    public EdgeController(GraphModel model, GraphPanel panel) {
        this.model = model;
        this.panel = panel;
        vertex1 = null;
        vertex2 = null;
        isEdgeAdder = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isEdgeAdder) {
            if (model.getSelectedVertex() != null) {
                vertex2 = model.getSelectedVertex();
                GraphEdge edge = new GraphEdge(vertex1, vertex2);
                model.undoableEditHappened(new UndoableEditEvent(model, new UndoableAddEdge(model, edge)));
            }
            panel.removeMouseMotionListener(this);
            model.setEdgeSelection(false);
            model.setMousePosX(0);
            model.setMousePosY(0);
            isEdgeAdder = false;
        } else {
            if (model.getSelectedVertex() != null) {
                vertex2 = model.getSelectedVertex();
                GraphEdge edge = new GraphEdge(vertex1, vertex2);
                model.undoableEditHappened(new UndoableEditEvent(model, new UndoableEdgeRemove(model, edge)));
            }
        }
        panel.removeMouseListener(this);
    }

    void enableEdgeAdder() {
        isEdgeAdder = true;
        vertex1 = model.getSelectedVertex();
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        model.setEdgeSelection(true);
    }

    void enableEdgeRemover() {
        vertex1 = model.getSelectedVertex();
        panel.addMouseListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        model.setMousePosX(e.getX());
        model.setMousePosY(e.getY());
    }
}
