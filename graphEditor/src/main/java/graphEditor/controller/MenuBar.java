package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.view.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by PhilO on 06-Jun-17.
 */

// The File/Model menu bar contains application options and controls which model to view
public class MenuBar extends JMenuBar {

    private class fileMenu extends JMenu {
        private JMenuItem nw;
        private JMenuItem newWindow;
        private JMenuItem closeWindow;
        private JMenuItem save;
        private JMenuItem open;
        private JMenuItem exit;

        fileMenu(GraphModel model, ButtonBar buttonbar) {
            super("File");

            // New wipes the model clean and starts fresh
            nw = new JMenuItem("New", KeyEvent.VK_N);
            nw.addActionListener(e -> {
                System.out.println("Creating new Model");
                buttonbar.setSelected();
                model.deleteAll();
            });

            newWindow = new JMenuItem("New Window");
            newWindow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GraphFrame newFrame = new GraphFrame(model);
                }
            });

            // Saves the currently viewed model to a user inputted location
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

            // Openss a user selected file to import
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

            // Exit saves to the persistent file, and then closes the application. The persistent file is opened automatically at start
            exit = new JMenuItem("Exit", KeyEvent.VK_S);
            exit.addActionListener(e -> {
                model.saveToFile("persistent.txt");
                System.exit(0);
            });

            add(nw);
            add(newWindow);
            add(save);
            add(open);
            add(exit);
        }
    }

    // This private class controls the multiple models that can run in the application
    private class ModelMenu extends JMenu {
        private JMenuItem nextModel;
        private JMenuItem prevModel;

        ModelMenu(GraphModel model, ButtonBar buttonBar) {
            super("Model");

            // Cycles to the next model to edit
            nextModel = new JMenuItem("Next Model", KeyEvent.VK_N);
            nextModel.addActionListener(e -> {
                if (model.getSelectedVertex() == null) {
                    model.nextModel();
                } else {
                    model.setSelectedVertex(null);
                    model.nextModel();
                    buttonBar.setSelected();
                }
                buttonBar.setSelected();
                updateUI();
            });

            // Goes to the previous model
            prevModel = new JMenuItem("Prev Model", KeyEvent.VK_P);
            prevModel.addActionListener(e -> {
                if (model.getSelectedVertex() == null) {
                    model.prevModel();
                } else {
                    buttonBar.setSelected();
                    model.prevModel();
                }

                buttonBar.setSelected();
                updateUI();
            });

            add(nextModel);
            add(prevModel);
        }
    }

    // Creates the menu and adds the two menus to it
    public MenuBar(GraphModel model, ButtonBar buttonBar) {
        add(new fileMenu(model, buttonBar));
        add(new ModelMenu(model, buttonBar));
        setBorderPainted(true);
    }
}
