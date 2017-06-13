package graphEditor.view;

import graphEditor.controller.ButtonBar;
import graphEditor.controller.SelectionController;
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
        new SelectionController(model, panel);
        add(panel);
        setSize(new Dimension(1280,720));
        setLocationRelativeTo(null);
        setJMenuBar(new graphEditor.controller.MenuBar(model));
        panel.add(new ButtonBar(model));
        setBackground(Color.gray);;
        setTitle("Graph Editor");
        setVisible(true);
    }
}
