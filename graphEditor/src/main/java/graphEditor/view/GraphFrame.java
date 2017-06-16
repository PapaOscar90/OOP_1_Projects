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
    private GraphPanel panel;
    private UndoManager undoManager = new UndoManager();

    public GraphFrame(GraphModel model) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1280,720));
        setLocationRelativeTo(null);
        setTitle("Graph Editor");
        setBackground(Color.gray);

        panel = new GraphPanel(model);

        ButtonBar buttonBar = new ButtonBar(model, undoManager);
        SelectionController sc = new SelectionController(model, panel, buttonBar);
        DraggingController dc = new DraggingController(panel, model);
        setJMenuBar(new graphEditor.controller.MenuBar(model, buttonBar));
        panel.add(buttonBar);
        PopupMenu pm = new PopupMenu(panel, model, sc);
        add(panel);
        setVisible(true);
    }
}
