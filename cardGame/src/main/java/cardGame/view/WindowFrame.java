package cardGame.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 15-May-17.
 * TODO: Make an actual view depending on what game to implement
 */
public class WindowFrame extends JFrame {
    JButton button1 = new JButton("New Game");
    //JTextField textField1 = new JTextField("Default text");

    public WindowFrame(){
        this.setSize(800,600);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(button1);
    }
}
