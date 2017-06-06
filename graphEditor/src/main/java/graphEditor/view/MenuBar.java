package graphEditor.view;

import javax.swing.*;

/**
 * Created by PhilO on 06-Jun-17.
 */
public class MenuBar extends JMenuBar {
    private class fileMenu extends JMenu{
        public fileMenu(){
            super("File");

        }
    }

    public MenuBar(){
        add(new fileMenu());
    }
}
