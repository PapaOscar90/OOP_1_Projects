package graphEditor.view;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphPanel extends JPanel {
    private GraphModel model;

    private int getLineX(GraphVertex vertex){
        return vertex.getX()+((vertex.getWidth())/2);
    }
    private int getLineY(GraphVertex vertex){
        return vertex.getY()+((vertex.getHeight())/2);
    }

    public GraphPanel(GraphModel model){
        super();
        this.model = model;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Rectangle rectangle;
        Line line;
        String label;
        Graphics2D g2 = (Graphics2D)g;

        for(int i=0; i<model.getNumberEdges(); i++){
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(getLineX(model.getEdges(i).getVertexAt(0)),getLineY(model.getEdges(i).getVertexAt(0)),getLineX(model.getEdges(i).getVertexAt(1)),getLineY(model.getEdges(i).getVertexAt(1)));
        }

        for(int i=0; i<model.getNumberRectangles(); i++){
            rectangle = model.getVertices(i).getRectangle();
            label = model.getVertices(i).getName();
            g2.setColor(Color.green);
            g2.fill(rectangle);
            g2.setColor(Color.black);
            g2.drawString(label, (rectangle.x+(rectangle.width/3)),(rectangle.y+(rectangle.height/2)));
        }
    }
}
