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

    private class fileMenu extends JMenu {
        private JMenuItem nw;
        private JMenuItem save;
        private JMenuItem open;
        private JMenuItem exit;

        fileMenu(GraphModel model, ButtonBar buttonbar) {
            super("File");

            nw = new JMenuItem("New", KeyEvent.VK_N);
            nw.addActionListener(e -> {
                System.out.println("Creating new Model");
                buttonbar.setSelected();
                model.deleteAll();
            });


            save = new JMenuItem("Save Current", KeyEvent.VK_S);
            save.addActionListener(e -> {
                System.out.println("Switch save");
                JFileChooser fileChooser = new JFileChooser();
                File workingDirectory = new File(System.getProperty("user.dir"));
                fileChooser.setCurrentDirectory(workingDirectory);
                int returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    model.saveToFile(fileChooser.getSelectedFile().getAbsolutePath());
                }
            });


            open = new JMenuItem("Open", KeyEvent.VK_S);
            open.addActionListener(e -> {
                System.out.println("Switch Load");
                JFileChooser loadChooser = new JFileChooser();
                File loadDirectory = new File(System.getProperty("user.dir"));
                loadChooser.setCurrentDirectory(loadDirectory);
                int returnV = loadChooser.showOpenDialog(null);
                if (returnV == JFileChooser.APPROVE_OPTION) {
                    model.loadFromFile(loadChooser.getSelectedFile().getAbsolutePath());
                }
                buttonbar.setSelected();
            });


            exit = new JMenuItem("Exit", KeyEvent.VK_S);
            exit.addActionListener(e -> {
                model.saveToFile("persistent.txt");
                System.exit(0);
            });

            add(nw);
            add(save);
            add(open);
            add(exit);
        }
    }

    private class ModelMenu extends JMenu {
        private JMenuItem nextModel;
        private JMenuItem prevModel;

        ModelMenu(GraphModel model, ButtonBar buttonBar) {
            super("Model");

            nextModel = new JMenuItem("Next Model", KeyEvent.VK_N);
            nextModel.addActionListener(e -> {
                if (model.getSelectedVertex() == null) {
                    model.nextModel();
                } else {
                    model.setSelectedVertex(null);
                    model.nextModel();
                    buttonBar.setSelected();
                }
                updateUI();
            });

            prevModel = new JMenuItem("Prev Model", KeyEvent.VK_P);
            prevModel.addActionListener(e -> {
                if (model.getSelectedVertex() == null) {
                    model.prevModel();
                } else {
                    buttonBar.setSelected();
                    model.prevModel();
                }
            });

            add(nextModel);
            add(prevModel);
        }
    }

    public MenuBar(GraphModel model, ButtonBar buttonBar) {
        add(new fileMenu(model, buttonBar));
        add(new ModelMenu(model, buttonBar));
        setBorderPainted(true);
    }
}
