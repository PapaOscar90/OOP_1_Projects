package graphEditor.view;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphPanel extends JPanel implements Observer {
    private GraphModel model;

    private int getLineX(GraphVertex vertex) {
        return vertex.getX() + ((vertex.getWidth()) / 2);
    }

    private int getLineY(GraphVertex vertex) {
        return vertex.getY() + ((vertex.getHeight()) / 2);
    }

    GraphPanel(GraphModel model) {
        super();
        this.model = model;
        this.model.addObserver(this);
    }

    private void paintEdges(Graphics2D g2){
        int lineX0;
        int lineY0;
        int lineX1;
        int lineY1;
        if (model.isEdgeSelection() && (model.getMousePosX() != 0 || model.getMousePosY() != 0)) {
            g2.drawLine(getLineX(model.getSelectedVertex()), getLineY(model.getSelectedVertex()), model.getMousePosX(), model.getMousePosY());
        }
        for (int i = 0; i < model.getNumberEdges(); i++) {
            lineX0 = getLineX(model.getEdges(i).getVertexAt(0));
            lineY0 = getLineY(model.getEdges(i).getVertexAt(0));
            lineX1 = getLineX(model.getEdges(i).getVertexAt(1));
            lineY1 =  getLineY(model.getEdges(i).getVertexAt(1));
            g2.drawLine(lineX0, lineY0,lineX1,lineY1);
        }
    }

    private void paintVertices(Graphics2D g2, Graphics g){
        GraphVertex vertex;
        Rectangle rectangle;
        String label;
        Color vColor = new Color(200, 255, 255);
        for (int i = 0; i < model.getVertexCount(); i++) {
            vertex = model.getVertex(i);
            rectangle = vertex.getRectangle();
            label = vertex.getName();
            int textWidth = g.getFontMetrics().stringWidth(label);
            if (vertex.getWidth() != textWidth + 25){
                vertex.setSize(textWidth + 25, vertex.getHeight());
            }
            if (model.getSelectedVertex() == vertex) {
                g2.setColor(Color.green);
                g2.fill(rectangle);
                g2.setColor(Color.black);
            } else {
                g2.setColor(vColor);
                g2.fill(rectangle);
            }
            g2.setColor(Color.black);
            g2.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
            g2.drawString(label, (rectangle.x + ((rectangle.width / 2)) - textWidth / 2), (rectangle.y + (rectangle.height / 2)));
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        paintEdges(g2);
        paintVertices(g2, g);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
