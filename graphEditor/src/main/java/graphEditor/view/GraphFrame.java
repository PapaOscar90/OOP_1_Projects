package graphEditor.view;

import graphEditor.model.GraphModel;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphFrame extends JFrame {

    public GraphFrame(GraphModel model) {
        JFrame frame = new JFrame("Graph Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));
        frame.setVisible(true);
        frame.setJMenuBar(new MenuBar());

    }
}
