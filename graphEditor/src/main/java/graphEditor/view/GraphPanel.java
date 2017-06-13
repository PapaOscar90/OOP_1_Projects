package graphEditor.view;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphPanel extends JPanel implements Observer{
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
        model.addObserver(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        GraphVertex vertex;
        Rectangle rectangle;
        String label;
        Graphics2D g2 = (Graphics2D)g;

        for(int i=0; i<model.getNumberEdges(); i++){
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(getLineX(model.getEdges(i).getVertexAt(0)),getLineY(model.getEdges(i).getVertexAt(0)),getLineX(model.getEdges(i).getVertexAt(1)),getLineY(model.getEdges(i).getVertexAt(1)));
        }

        for(int i = 0; i<model.getVertexCount(); i++){
            vertex = model.getVertex(i);
            rectangle = vertex.getRectangle();
            label = vertex.getName();
            g2.setColor(vertex.getColor());
            g2.fill(rectangle);
            g2.setColor(Color.black);
            g2.drawRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
            g2.drawString(label, (rectangle.x+(rectangle.width/3)),(rectangle.y+(rectangle.height/2)));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
        System.out.println("Repainted.");
    }
}
