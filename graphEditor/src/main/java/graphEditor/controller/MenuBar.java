package graphEditor.controller;

import graphEditor.controller.MenuActionListener;
import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by PhilO on 06-Jun-17.
 */



public class MenuBar extends JMenuBar {


    private class fileMenu extends JMenu{
        public fileMenu(){
            super("File");
            MenuActionListener menuListener= new MenuActionListener();


            JMenuItem save = new JMenuItem("Save", KeyEvent.VK_S);
            save.addActionListener(menuListener);


            JMenuItem open = new JMenuItem("Open", KeyEvent.VK_S);
            open.addActionListener(menuListener);


            JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_S);
            exit.addActionListener(menuListener);

            add(save);
            add(open);
            add(exit);
        }
    }

    public MenuBar(GraphModel model){
        add(new fileMenu());
        setBorderPainted(true);
    }
}
