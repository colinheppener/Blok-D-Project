/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdjava2.pkg0;

/**
 *
 * @author Colin
 */
public class Veld {
    private int locatieX;
    private int locatieY;
    
    private int[] getLocatie()
    {
        int[] locatie = new int[2];
        locatie[0]  = locatieX;
        locatie[1] = locatieY;
        
        return locatie; 
    }
}