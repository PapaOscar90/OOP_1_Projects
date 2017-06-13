package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import graphEditor.view.GraphPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by saidf on 6/13/2017.
 */
public class SelectionController extends MouseInputAdapter {
    private GraphModel gm;
    private GraphPanel p;

    public SelectionController(GraphModel gm, GraphPanel p) {
        this.gm = gm;
        this.p = p;
        p.addMouseListener(this);
    }

    private void selectVertex(int x, int y){
        GraphVertex vertex;
        for(int i = 0; i < gm.getVertexCount(); i++){
            vertex = gm.getVertex(i);
            if (x > vertex.getX() &&
                    x < vertex.getX() + vertex.getWidth() &&
                    y > vertex.getY() &&
                    y < vertex.getY() + vertex.getHeight()){
                if (vertex.isSelected()){
                    vertex.setSelected(false);
                } else {
                    vertex.setSelected(true);
                }
                //System.out.println("Item selected");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        selectVertex(e.getX(), e.getY());
    }
}
