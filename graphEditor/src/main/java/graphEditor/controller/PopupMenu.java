package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.model.GraphVertex;
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

    private JMenuItem rm;
    private JMenuItem add;
    private JMenuItem rn;
    private GraphPanel panel;
    private GraphModel model;
    private SelectionController sc;
    private int mouseEventX;
    private int mouseEventY;


    public PopupMenu(GraphPanel panel, GraphModel model, SelectionController sc){
        this.panel = panel;
        this.model = model;
        this.sc = sc;
        this.mouseEventX = 0;
        this.mouseEventY = 0;
        this.rm = new JMenuItem("Remove vertex");
        this.add = new JMenuItem("Add vertex here");
        this.rn = new JMenuItem("Rename vertex");
        rm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeSelectedVertex();
                sc.getButtonBar().setSelected();
            }
        });
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int newX = mouseEventX;
                int newY = mouseEventY;
                int newWidth = 100;
                int newHeight = 50;
                String newName = (String) JOptionPane.showInputDialog(null,"Input name:", "Add Vertex 5/5", JOptionPane.PLAIN_MESSAGE,null,null,"Name");
                model.addVertex(new GraphVertex(newX, newY, newWidth, newHeight, newName));
            }
        });
        rn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName2 = (String) JOptionPane.showInputDialog(null,"Input name:", "Add Vertex 5/5", JOptionPane.PLAIN_MESSAGE,null,null,"Name");
                model.getSelectedVertex().setName(newName2);
            }
        });
        panel.addMouseListener(this);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        mouseEventX = e.getX();
        mouseEventY = e.getY();
        if (SwingUtilities.isRightMouseButton(e)){
            if (model.getSelectedVertex() != null) {
                JPopupMenu MainPopup = new JPopupMenu();
                MainPopup.add(rm);
                MainPopup.add(rn);
                MainPopup.show(e.getComponent(), e.getX(), e.getY());
            } else {
                JPopupMenu MainPopup = new JPopupMenu();
                MainPopup.add(add);
                MainPopup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
}
