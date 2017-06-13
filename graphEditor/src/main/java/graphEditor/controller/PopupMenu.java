package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.view.GraphPanel;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created by saidf on 6/14/2017.
 */
public class PopupMenu extends MouseInputAdapter {

    private JMenuItem test;
    private GraphPanel panel;
    private GraphModel model;

    public PopupMenu(GraphPanel panel, GraphModel model){
        this.test = new JMenuItem("Test");
        this.panel = panel;
        this.model = model;
        test.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Testing...");
            }
        });
        panel.addMouseListener(this);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)){
            JPopupMenu MainPopup = new JPopupMenu();
            MainPopup.add(test);
            MainPopup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
