/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vincent
 */
public class GameoflifeTest {
    
    
    static GameOfLife gof;
    
    public GameoflifeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            gof = FileParser.fromFile(new File("test/test.txt"));
        } catch (Exception ex) {
            fail();
        }
    }
    
   
    @Test
    public void testCellVivant() {
        fail("TODO");
    }
    

    /**
     * Test of main method, of class GameOfLife.
     */
    @Test
    public void testNbVoisinVivant() {
        
        fail("TODO");
    }
    
}
