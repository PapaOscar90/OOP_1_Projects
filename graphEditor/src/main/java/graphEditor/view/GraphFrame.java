package graphEditor.view;

import graphEditor.controller.ButtonBar;
import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphFrame extends JFrame {
    private GraphPanel panel;

    public GraphFrame(GraphModel model) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new GraphPanel(model);
        add(new ButtonBar(model));
        add(panel);
        setSize(new Dimension(1200,800));
        setLocationRelativeTo(null);
        setJMenuBar(new graphEditor.controller.MenuBar(model));
        setBackground(Color.gray);
        setTitle("Graph Editor");
        setVisible(true);
    }
}
