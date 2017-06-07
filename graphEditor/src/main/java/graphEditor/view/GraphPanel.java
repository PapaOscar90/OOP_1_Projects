package graphEditor.view;

import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphPanel extends JPanel {
    private GraphModel model;

    public GraphPanel(GraphModel model){
        super();
        this.model = model;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Rectangle rectangle;
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0; i<model.getNumberRectangles(); i++){
            rectangle = model.getVertices(i).getRectangle();
            g2.draw(rectangle);
        }
    }
}
