package graphEditor.view;

import graphEditor.controller.*;
import graphEditor.controller.PopupMenu;
import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class GraphFrame extends JFrame {

    public GraphFrame(GraphModel model) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1280, 720));
        setLocationRelativeTo(null);
        setTitle("Graph Editor");
        setBackground(Color.gray);

        GraphPanel panel = new GraphPanel(model);

        EdgeController ec = new EdgeController(model, panel);
        ButtonBar buttonBar = new ButtonBar(model, ec);
        SelectionController sc = new SelectionController(model, panel, buttonBar);
        DraggingController dc = new DraggingController(panel, model);
        setJMenuBar(new graphEditor.controller.MenuBar(model, buttonBar));
        panel.add(buttonBar);
        PopupMenu pm = new PopupMenu(panel, model, sc, ec);
        add(panel);
        setVisible(true);
    }
}
