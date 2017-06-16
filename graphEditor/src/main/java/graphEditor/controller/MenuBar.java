package graphEditor.controller;

import graphEditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by PhilO on 06-Jun-17.
 */



public class MenuBar extends JMenuBar {
    private ButtonBar buttonBar;

    private class fileMenu extends JMenu{
        private JMenuItem nw;
        private JMenuItem save;
        private JMenuItem open;
        private JMenuItem exit;
        public fileMenu(GraphModel model){
            super("File");

            nw = new JMenuItem("New", KeyEvent.VK_N);
            nw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Creating new Model");
                    model.deleteAll();
                }
            });


            save = new JMenuItem("Save Current", KeyEvent.VK_S);
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Switch save");
                    JFileChooser fileChooser = new JFileChooser();
                    File workingDirectory = new File(System.getProperty("user.dir"));
                    fileChooser.setCurrentDirectory(workingDirectory);
                    int returnVal = fileChooser.showOpenDialog(null);
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                        model.saveToFile(fileChooser.getSelectedFile().getAbsolutePath());
                    }
                }
            });


            open = new JMenuItem("Open", KeyEvent.VK_S);
            open.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Switch Load");
                    JFileChooser loadChooser = new JFileChooser();
                    File loadDirectory = new File(System.getProperty("user.dir"));
                    loadChooser.setCurrentDirectory(loadDirectory);
                    int returnV = loadChooser.showOpenDialog(null);
                    if(returnV == JFileChooser.APPROVE_OPTION) {
                        model.loadFromFile(loadChooser.getSelectedFile().getAbsolutePath());
                    }
                }
            });


            exit = new JMenuItem("Exit", KeyEvent.VK_S);
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.saveToFile("persistent.txt");
                    System.exit(0);
                }
            });

            add(nw);
            add(save);
            add(open);
            add(exit);
        }
    }

    private class ModelMenu extends JMenu{
        private JMenuItem nextModel;
        private JMenuItem prevModel;
        public ModelMenu(GraphModel model, ButtonBar buttonBar){
            super("Model");

            nextModel = new JMenuItem("Next Model", KeyEvent.VK_N);
            nextModel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(model.getSelectedVertex()==null){
                        model.nextModel();
                    }else{
                        buttonBar.setSelected();
                        model.setSelectedVertex(null);
                        model.nextModel();
                    }
                }
            });

            prevModel = new JMenuItem("Prev Model", KeyEvent.VK_P);
            prevModel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(model.getSelectedVertex()==null){
                        model.prevModel();
                    }else{
                        buttonBar.setSelected();
                        model.prevModel();
                    }
                }
            });

            add(nextModel);
            add(prevModel);
        }
    }

    public MenuBar(GraphModel model, ButtonBar buttonBar){
        this.buttonBar = buttonBar;
        add(new fileMenu(model));
        add(new ModelMenu(model, buttonBar));
        setBorderPainted(true);
    }
}
