/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdjava2.pkg0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Colin
 */
public class Helper extends Item{
    private Speelbord speelbord;
    private Vriend vriend;
    
    public Helper(Vriend vriend, Speelbord speelbord)
    {
            this.vriend = vriend;
            this.speelbord = speelbord;
    }
    {
        try {
            plaatje = ImageIO.read(new File("src/images/helper.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
            @Override
    public void Teken(Graphics g) {
        g.setColor(Color.MAGENTA);

//        g.fillRect((int) veld.getY() * 40, (int) veld.getX() * 40, 40, 40);
        g.drawImage(getImageFile(), (int) veld.getY() * 40, (int) veld.getX() * 40, 40, 40, null);

    }

    @Override
    public String toString() {
        return "helper";
    }

    public BufferedImage getImageFile() {
        
        return plaatje;
    }
    @Override
    public void voerActieUit()
    {
        MazeSolver mazeSolver = new MazeSolver(this, vriend, speelbord);
        veld.setMazeSolver(mazeSolver);
        System.out.println("helper uitgevoerd");
        mazeSolver.createNewMazeSolver();
    }
}
