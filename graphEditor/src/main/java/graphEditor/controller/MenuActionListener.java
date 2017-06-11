package graphEditor.controller;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import graphEditor.model.GraphModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            case "Save":    System.out.println("Switch save");
                            model.saveToFile("testFile");
                            break;
            case "Import":    System.out.println("Switch Import");
                            model.importFromFile("testFile.txt");
                            break;
            case "Exit":    System.out.println("Switch exit");
                            System.exit(0);
                            break;
            default:        System.out.println("Default.");
                            break;
        }
    }
}
