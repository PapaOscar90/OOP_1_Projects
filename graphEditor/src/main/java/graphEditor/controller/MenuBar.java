package graphEditor.controller;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import graphEditor.controller.MenuActionListener;
import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Created by PhilO on 06-Jun-17.
 */



public class MenuBar extends JMenuBar {


    private class fileMenu extends JMenu{
        public fileMenu(GraphModel model){
            super("File");
            MenuActionListener menuListener= new MenuActionListener(model);

            JMenuItem nw = new JMenuItem("New", KeyEvent.VK_N);
            nw.addActionListener(menuListener);


            JMenuItem save = new JMenuItem("Save Current", KeyEvent.VK_S);
            save.addActionListener(menuListener);


            JMenuItem open = new JMenuItem("Open", KeyEvent.VK_S);
            open.addActionListener(menuListener);


            JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_S);
            exit.addActionListener(menuListener);

            add(nw);
            add(save);
            add(open);
            add(exit);
        }
    }

    private class ModelMenu extends JMenu{
        public ModelMenu(GraphModel model){
            super("Model");
            ModelActionListener modelActionListener = new ModelActionListener(model);

            JMenuItem nextModel = new JMenuItem("Next Model", KeyEvent.VK_N);
            nextModel.addActionListener(modelActionListener);

            JMenuItem prevModel = new JMenuItem("Prev Model", KeyEvent.VK_P);
            prevModel.addActionListener(modelActionListener);

            add(nextModel);
            add(prevModel);
        }
    }

    public MenuBar(GraphModel model){
        add(new fileMenu(model));
        add(new ModelMenu(model));
        setBorderPainted(true);
    }
}
