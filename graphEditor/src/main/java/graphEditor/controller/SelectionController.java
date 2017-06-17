package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import graphEditor.view.GraphPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by saidf on 6/13/2017.
 */
public class SelectionController extends MouseInputAdapter {
    private GraphModel model;
    private ButtonBar buttonBar;

    public SelectionController(GraphModel model, GraphPanel panel, ButtonBar buttonBar) {
        this.model = model;
        this.buttonBar = buttonBar;
        panel.addMouseListener(this);
    }

    private void selectVertex(int x, int y) {
        GraphVertex vertex;
        GraphVertex topVertex = null;

        for (int i = 0; i < model.getVertexCount(); i++) {
            vertex = model.getVertex(i);
            if (x > vertex.getX() &&
                    x < vertex.getX() + vertex.getWidth() &&
                    y > vertex.getY() &&
                    y < vertex.getY() + vertex.getHeight()) {
                topVertex = vertex;
            } else if (model.getSelectedVertex() != null) {
                model.setSelectedVertex(null);
                buttonBar.setSelected();
            }
        }
        if (topVertex != null && model.getSelectedVertex() != topVertex) {
            model.setSelectedVertex(topVertex);
            buttonBar.setSelected();
        }
    }


    ButtonBar getButtonBar() {
        return buttonBar;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        selectVertex(e.getX(), e.getY());
    }
}
