package graphEditor.controller;

import graphEditor.model.GraphModel;
import graphEditor.view.GraphFrame;
import graphEditor.view.GraphPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class MenuActionListener implements ActionListener {

    private GraphModel model;

    public MenuActionListener(GraphModel model){this.model=model;}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Selected: " + e.getActionCommand());

        switch (e.getActionCommand()){
            case "New":     System.out.println("Creating new Model");
                            model.deleteAll();
                            break;

            case "Save Current":    System.out.println("Switch save");
                                    JFileChooser fileChooser = new JFileChooser();
                                    File workingDirectory = new File(System.getProperty("user.dir"));
                                    fileChooser.setCurrentDirectory(workingDirectory);
                                    int returnVal = fileChooser.showOpenDialog(null);
                                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                                        model.saveToFile(fileChooser.getSelectedFile().getAbsolutePath());
                                    }

                                    model.saveToFile("testFile");
                                    break;

            case "Open":            System.out.println("Switch Load");
                                    JFileChooser loadChooser = new JFileChooser();
                                    File loadDirectory = new File(System.getProperty("user.dir"));
                                    loadChooser.setCurrentDirectory(loadDirectory);
                                    int returnV = loadChooser.showOpenDialog(null);
                                    if(returnV == JFileChooser.APPROVE_OPTION) {
                                        model.loadFromFile(loadChooser.getSelectedFile().getAbsolutePath());
                                    }
                                    break;

            case "Exit":            System.out.println("Switch exit");
                                    System.exit(0);
                                    break;

            default:                System.out.println("Default.");
                                    break;
        }
    }
}
