/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdjava2.pkg0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Colin & Jeroen
 */
public class Menu {

    public Menu() {
        createComponents();
    }

    private void createComponents() {

        final JFrame frame = new JFrame();
        frame.setSize(900, 900);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Start doolhof");
        frame.add(button);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                frame.dispose();
                Frame frame = new Frame();
            }
        });
    }
}
