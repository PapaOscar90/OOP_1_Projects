package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
import graphEditor.view.GraphPanel;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.UndoableEditEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created by saidf on 6/14/2017.
 */
public class PopupMenu extends MouseInputAdapter {
    private JMenuItem removeVertex;
    private JMenuItem addVertex;
    private JMenuItem renameVertex;
    private JMenuItem addEdge;
    private JMenuItem removeEdge;
    private GraphModel model;
    private int mouseEventX;
    private int mouseEventY;
    private SelectionController selectionController;

    // Creates the menu that opens when the user right clicks
    public PopupMenu(GraphPanel panel, GraphModel model, SelectionController selectionController, EdgeController edgeController) {
        this.model = model;
        this.mouseEventX = 0;
        this.mouseEventY = 0;
        this.selectionController = selectionController;
        this.removeVertex = new JMenuItem("Remove vertex");
        this.addVertex = new JMenuItem("Add vertex here");
        this.renameVertex = new JMenuItem("Rename vertex");
        this.addEdge = new JMenuItem("Add edge");
        this.removeEdge = new JMenuItem("Remove edge");

        removeVertex.addActionListener(e -> {
            model.undoableEditHappened(new UndoableEditEvent(model,new UndoableRemoveVertex(model)));
            selectionController.getButtonBar().setSelected();
        });

        addVertex.addActionListener(e -> {
            int newX = mouseEventX;
            int newY = mouseEventY;
            int newWidth = 100;
            int newHeight = 50;
            model.undoableEditHappened(new UndoableEditEvent(model,new UndoableAddVertex(model,newX,newY)));
            selectionController.getButtonBar().setSelected();
        });

        renameVertex.addActionListener(e -> {
            model.undoableEditHappened(new UndoableEditEvent(model, new UndoableRenameVertex(model)));
            selectionController.getButtonBar().setSelected();
        });
        addEdge.addActionListener(e -> edgeController.enableEdgeAdder());
        removeEdge.addActionListener(e -> edgeController.enableEdgeRemover());
        panel.addMouseListener(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseEventX = e.getX();
        mouseEventY = e.getY();
        if (SwingUtilities.isRightMouseButton(e)) {
            if (model.getSelectedVertex() != null) {
                JPopupMenu MainPopup = new JPopupMenu();
                MainPopup.add(removeVertex);
                MainPopup.add(renameVertex);
                MainPopup.add(addEdge);
                MainPopup.add(removeEdge);
                MainPopup.show(e.getComponent(), e.getX(), e.getY());
            } else {
                JPopupMenu MainPopup = new JPopupMenu();
                MainPopup.add(addVertex);
                MainPopup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
}
