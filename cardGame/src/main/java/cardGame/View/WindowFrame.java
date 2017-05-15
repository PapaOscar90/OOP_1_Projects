package cardGame.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PhilO on 15-May-17.
 */
public class WindowFrame extends JFrame {
    JButton button1 = new JButton("Clickme!");
    JTextField textField1 = new JTextField("Default text");

    public WindowFrame(){
        this.setSize(200,100);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(button1);
        this.getContentPane().add(textField1);
    }
}
