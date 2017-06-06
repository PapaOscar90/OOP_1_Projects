package graphEditor.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class MenuBar extends JMenuBar {
    private class FileMenu extends JMenuItem{
        public FileMenu(){
            JMenu file = new JMenu("File");
            file.setMnemonic(KeyEvent.VK_F); // Opens menu with Alt-f

            JMenuItem newItem = new JMenuItem("Exit");
            newItem.setMnemonic(KeyEvent.VK_E);
            newItem.setToolTipText("Quit the application");
            newItem.addActionListener((ActionEvent event) -> {
                System.exit(0);
            });

            file.add(newItem);
        }
    }

    public MenuBar(){
        JMenuBar menuBar = new JMenuBar();
        FileMenu fileMenu = new FileMenu();
        menuBar.add(fileMenu);
    }
}
