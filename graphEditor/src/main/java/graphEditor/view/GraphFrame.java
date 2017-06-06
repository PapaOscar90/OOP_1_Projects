package graphEditor.view;

import graphEditor.model.GraphModel;

import javax.swing.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphFrame extends JFrame {

    public GraphFrame(GraphModel graphModel){
        JFrame frame = new JFrame("Graph Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
