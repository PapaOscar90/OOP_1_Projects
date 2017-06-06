package graphEditor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class MenuActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Selected: " + e.getActionCommand());

        switch (e.getActionCommand()){
            case "Save":    System.out.println("Switch save");
                            break;
            case "Open":    System.out.println("Switch open");
                            break;
            case "Exit":    System.out.println("Switch exit");
                            break;
            default:        System.out.println("Default.");
                            break;
        }
    }
}
