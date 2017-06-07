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
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(new Rectangle(100,100,400,400));
    }
}
