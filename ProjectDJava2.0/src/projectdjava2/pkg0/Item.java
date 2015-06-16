/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdjava2.pkg0;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Colin & Jeroen
 */
public class Item {

    BufferedImage plaatje;
    BufferedImage plaatjeL;
    BufferedImage plaatjeR;
    BufferedImage plaatjeU;
    BufferedImage plaatjeD;

    Veld veld;

    public void Teken(Graphics g) {
    }

    public void loopRichting(String richting) {
    }

    public void voerActieUit() {
    }

    public String toString() {
        return "item toegevoegd";
    }

    public void verplaatsItem(Item itm, Veld huidigVeld, Veld buurVeld) {
        huidigVeld.setItem(null);
        buurVeld.setItem(itm);
    }

    public void setVeld(Veld vel) {
        veld = vel;
    }

    public Veld getVeld() {
        return veld;
    }
    
    public BufferedImage getImageFile()
    {
        return plaatje;
    }
    public BufferedImage getImageFileU()
    {
        return plaatjeU;
    }
    public BufferedImage getImageFileD()
    {
        return plaatjeD;
    }
    public BufferedImage getImageFileR()
    {
        return plaatjeR;
    }
    public BufferedImage getImageFileL()
    {
        return plaatjeL;
    }
}
