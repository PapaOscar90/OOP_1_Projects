package graphEditor.controller;

import graphEditor.model.GraphVertex;
import graphEditor.view.GraphPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by saidf on 6/13/2017.
 */
public class DraggingController extends MouseInputAdapter {
    private SelectionController sc;
    private GraphPanel panel;
    private int startX;
    private int startY;

    public DraggingController(SelectionController sc, GraphPanel panel){
        this.sc = sc;
        this.panel = panel;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (sc.getSelectedVertex() != null) {
            startX = e.getX() - sc.getSelectedVertex().getX();
            startY = e.getY() - sc.getSelectedVertex().getY();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        GraphVertex vertex = sc.getSelectedVertex();
        if (vertex != null && vertex.isSelected()){
            vertex.setPosition(e.getX() - startX, e.getY() - startY);
        }
    }
}
