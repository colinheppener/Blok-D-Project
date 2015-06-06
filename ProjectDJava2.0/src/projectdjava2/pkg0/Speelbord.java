/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdjava2.pkg0;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Point;
import java.util.HashMap;
import javax.swing.SwingUtilities;

/**
 *
 * @author Colin
 */
public class Speelbord extends JComponent {//deze JComponent wordt weergegeven op de Frame in ProjectDJava20.java, in de main klasse dus.

    private Frame frame;
    private Veld[][] grid = new Veld[20][20];
    private int huidiglevel = 1;
    private int[][] opzetGrid;
    private int[][] lvl1 = {
        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
        {1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1,},
        {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1,},
        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1,},
        {1, 0, 1, 0, 5, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1,},
        {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1,},
        {0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1,},
        {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 6, 0, 0, 1, 1, 1, 0, 1, 1,},
        {0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1,},
        {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1,},
        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1,},
        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1,},
        {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1,},
        {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1,},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1,},
        {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1,},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1,},
        {1, 0, 1, 0, 0, 0, 0, 0, 7, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1,},
        {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1,},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 4, 1,}
    };
    private int[][] lvl2 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 1, 6, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 5, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};
    private int[][] lvl3 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 1, 6, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1},
        {1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 7, 1, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 ,0, 1, 0, 1},
        {1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 4, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public Veld[][] getGrid() {
        return grid;
    }

    public Speelbord(Frame fr) {
        frame = fr;
        CreateVelden("lvl1");
    }

    private void CreateVelden(String level) {
        if (level.equals("lvl1")) {
            opzetGrid = lvl1;
        }
        if (level.equals("lvl2")) {
            opzetGrid = lvl2;
        }
        if(level.equals("lvl3"))
        {
            opzetGrid = lvl3;
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (opzetGrid[i][j] == 1) {
                    Point locatie = new Point(i, j);
                    Muur muur = new Muur();
                    grid[i][j] = new Veld(locatie, muur);
                    grid[i][j].getItem().setVeld(grid[i][j]);
                }
                if (opzetGrid[i][j] == 3) {
                    Point locatie = new Point(i, j);
                    Speler speler = new Speler();
                    grid[i][j] = new Veld(locatie, speler);
                    grid[i][j].getItem().setVeld(grid[i][j]);
                    CustomKeyListener keylisten = new CustomKeyListener(speler, this);
                    this.addKeyListener(keylisten);
                }
                if (opzetGrid[i][j] == 4) {
                    Point locatie = new Point(i, j);
                    Vriend vriend = new Vriend(this, frame);
                    grid[i][j] = new Veld(locatie, vriend);
                    grid[i][j].getItem().setVeld(grid[i][j]);
                }
                if (opzetGrid[i][j] == 0) {
                    Point locatie = new Point(i, j);

                    grid[i][j] = new Veld(locatie, null);
//                    grid[i][j].getItem().setVeld(grid[i][j]);
                }
                if (opzetGrid[i][j] == 5) {
                    Point locatie = new Point(i, j);
                    Valsspeler valsspeler = new Valsspeler(frame, 10);
                    grid[i][j] = new Veld(locatie, valsspeler);
                    grid[i][j].getItem().setVeld(grid[i][j]);
                }
                if (opzetGrid[i][j] == 6) {
                    Point locatie = new Point(i, j);
                    Bazooka bazooka = new Bazooka();
                    grid[i][j] = new Veld(locatie, bazooka);
                    grid[i][j].getItem().setVeld(grid[i][j]);
                }
                if (opzetGrid[i][j] == 7) {
                    Point locatie = new Point(i, j);
                    Helper helper = new Helper();
                    grid[i][j] = new Veld(locatie, helper);
                    grid[i][j].getItem().setVeld(grid[i][j]);
                }
            }
        }
        getBuren();
    }

    public void getBuren() {
        HashMap buren = new HashMap<String, Veld>();
        Veld buur;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (j < 19) {
                    buur = grid[i][j + 1];
                    buren.put("oost", buur);
                } else {
                    buren.put("oost", null);
                }
                if (i != 0) {
                    buur = grid[i - 1][j];
                    buren.put("noord", buur);
                } else {
                    buren.put("noord", null);
                }
                if (i < 19) {
                    buur = grid[i + 1][j];
                    buren.put("zuid", buur);
                } else {
                    buren.put("zuid", null);
                }
                if (j != 0) {
                    buur = grid[i][j - 1];
                    buren.put("west", buur);
                } else {
                    buren.put("west", null);
                }
                grid[i][j].setBuren(buren);
//                System.out.println("I: "+i +"J: "+j);
            }
        }
    }

    public void HerstartLevel() {

        this.revalidate();
        this.repaint();

    }

    public void StartNieuwLevel() {
        if(huidiglevel == 1)
        {
            CreateVelden("lvl2");
            huidiglevel++;
            return;
        }
        if(huidiglevel == 2)
        {
            CreateVelden("lvl3");
            huidiglevel++;
            return;
            
        }
        if(huidiglevel == 3)
        {
            System.out.println("GAME COMPLETED");
            System.exit(0);
        }
    }

    @Override
    public void paintComponent(Graphics g) {//hier worden de vierkanten daadwerkelijk samengevoegd 
        //en op het speelbord weergegeven, de velden tekenen zichzelf wel met de Teken methode
        super.paintComponent(g);

        System.out.println("repaint");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Item veldItem = grid[i][j].getItem();
                if (veldItem != null) {
                    veldItem.Teken(g);
                }
            }

        }

    }
}
