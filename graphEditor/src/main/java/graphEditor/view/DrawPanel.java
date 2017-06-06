package graphEditor.view;

import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class DrawPanel extends JPanel {

    public DrawPanel(GraphModel model){
        super();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(new Rectangle(50,50,200,200));
    }
}
