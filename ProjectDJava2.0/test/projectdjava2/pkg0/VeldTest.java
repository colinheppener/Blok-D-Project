/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdjava2.pkg0;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Colin
 */
public class VeldTest {
    
    public VeldTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLocatie method, of class Veld.
     */
    @Test
    public void testGetLocatie() {
        System.out.println("getLocatie");
        Veld instance = new Veld();
        int[] expResult = null;
        int[] result = instance.getLocatie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class Veld.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        Veld instance = new Veld();
        Item expResult = null;
        Item result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}