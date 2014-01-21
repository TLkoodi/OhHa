/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.domain;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
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
public class ViiniMuistiinpanoTest {
    
    public ViiniMuistiinpanoTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //("The test case is a prototype.");
    }
    
    @Test
    public void nimiOikeinKunAsetettuKonstruktorilla(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        String vastaus = muistiinpano.getNimi();
        
        assertEquals("Hienonimi", vastaus);
    }
    
    @Test
    public void nimiOikeinKunAsetettuMetodilla(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setNimi("uusinimi");
        
        String vastaus = muistiinpano.getNimi();
        
        assertEquals("uusinimi", vastaus);
    }
    
}
