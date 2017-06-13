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
    private GraphVertex selectedVertex;

    public SelectionController(GraphModel gm, GraphPanel p) {
        this.gm = gm;
        this.p = p;
        this.selectedVertex = null;
        p.addMouseListener(this);
    }

    private void selectVertex(int x, int y){
        GraphVertex vertex;
        GraphVertex topVertex = null;

        for(int i = 0; i < gm.getVertexCount(); i++){
            vertex = gm.getVertex(i);
            if (x > vertex.getX() &&
                    x < vertex.getX() + vertex.getWidth() &&
                    y > vertex.getY() &&
                    y < vertex.getY() + vertex.getHeight()){
                topVertex = vertex;
            } else if (vertex.isSelected()){
                vertex.setSelected(false);
            }
        }
        if (topVertex != null && !topVertex.isSelected()){
            setSelectedVertex(topVertex);
            selectedVertex.setSelected(true);
        }
    }

    public GraphVertex getSelectedVertex() {
        return selectedVertex;
    }

    public void setSelectedVertex(GraphVertex selectedVertex) {
        this.selectedVertex = selectedVertex;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        selectVertex(e.getX(), e.getY());
    }
}
