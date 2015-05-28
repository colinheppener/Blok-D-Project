/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdjava2.pkg0;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Colin
 */
public class Frame extends JFrame {

    public Frame() {
        createComponents();
    }
    final int HEIGHT = 950;
    final int WIDTH = 950;


    public void createComponents() {
        final JFrame frame = new JFrame();
        JPanel controlPanel = new JPanel();
        JButton herstartKnop = new JButton("Herstart Level");
        JButton menuKnop = new JButton("Terug naar menu");
        JButton stopKnop = new JButton("sluit schermen");
        frame.setSize(HEIGHT, WIDTH);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JComponent component = new Speelbord();


        frame.add(component);
        frame.setResizable(true);
        component.setFocusable(true);
        frame.add(controlPanel, BorderLayout.EAST);
        GridLayout gridLayout = new GridLayout(20, 2);
        controlPanel.setLayout(gridLayout);
        controlPanel.add(herstartKnop);
        controlPanel.add(menuKnop);
        controlPanel.add(stopKnop);
        controlPanel.setVisible(true);
        frame.setVisible(true);
        herstartKnop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                Speelbord sb = new Speelbord();
                sb.HerstartLevel();
                System.out.println("repaint");
                component.requestFocusInWindow();
            }
        });
        menuKnop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                Menu menu = new Menu();
            }
        });
                stopKnop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
                
            }
        });
        
    }
}
