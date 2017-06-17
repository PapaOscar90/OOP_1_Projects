package graphEditor.view;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphPanel extends JPanel implements Observer{
    private GraphModel model;
    private boolean isEdgeAdding;

    private int getLineX(GraphVertex vertex){
        return vertex.getX()+((vertex.getWidth())/2);
    }
    private int getLineY(GraphVertex vertex){
        return vertex.getY()+((vertex.getHeight())/2);
    }

    public GraphPanel(GraphModel model){
        super();
        this.model = model;
        this.model.addObserver(this);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        GraphVertex vertex;
        Rectangle rectangle;
        String label;
        Graphics2D g2 = (Graphics2D)g;
        Color vColor = new Color(200,255,255);

        g2.setStroke(new BasicStroke(2));
        if (model.isEdgeSelection() && (model.getMousePosX() != 0 || model.getMousePosY() != 0)){
            g2.drawLine(getLineX(model.getSelectedVertex()), getLineY(model.getSelectedVertex()),model.getMousePosX(), model.getMousePosY());
        }
        for(int i = 0; i< model.getNumberEdges(); i++){
            g2.drawLine(getLineX(model.getEdges(i).getVertexAt(0)),getLineY(model.getEdges(i).getVertexAt(0)),getLineX(model.getEdges(i).getVertexAt(1)),getLineY(model.getEdges(i).getVertexAt(1)));
        }
        for(int i = 0; i< model.getVertexCount(); i++){
            vertex = model.getVertex(i);
            rectangle = vertex.getRectangle();
            label = vertex.getName();
            if(model.getSelectedVertex() == vertex){
                g2.setColor(Color.green);
                g2.fill(rectangle);
                g2.setColor(Color.black);
            }else{
                g2.setColor(vColor);
                g2.fill(rectangle);
            }
            g2.setColor(Color.black);
            g2.drawRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
            int textWidth = g.getFontMetrics().stringWidth(label);
            g2.drawString(label, (rectangle.x + ((rectangle.width/2)) - textWidth/2),(rectangle.y+(rectangle.height/2)));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
