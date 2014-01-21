/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tony
 */
public class MuistiinpanoTest {
    
    public MuistiinpanoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNimi method, of class Muistiinpano.
     */
    @Test
    public void testGetNimi() {
        System.out.println("getNimi");
        Muistiinpano instance = new MuistiinpanoImpl();
        String expResult = "";
        String result = instance.getNimi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMuistiinpanoPaivamaara method, of class Muistiinpano.
     */
    @Test
    public void testGetMuistiinpanoPaivamaara() {
        System.out.println("getMuistiinpanoPaivamaara");
        Muistiinpano instance = new MuistiinpanoImpl();
        String expResult = "";
        String result = instance.getMuistiinpanoPaivamaara();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MuistiinpanoImpl implements Muistiinpano {

        public String getNimi() {
            return "";
        }

        public String getMuistiinpanoPaivamaara() {
            return "";
        }
    }
    
}
