/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.tiedostojenkasittely;

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
public class MuistiinpanojenTallentajaTest {
    
    public MuistiinpanojenTallentajaTest() {
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
        String nimi = "testitiedosto";
        MuistiinpanojenTallentaja tallentaja = new MuistiinpanojenTallentaja();
        tallentaja.poistaTiedosto(nimi);
    }

    /**
     * Test of luoTiedosto method, of class MuistiinpanojenTallentaja.
     */
    @Test
    public void LuoTiedoston() {
        String nimi = "testitiedosto";
        MuistiinpanojenTallentaja tallentaja = new MuistiinpanojenTallentaja();
        boolean vastaus = tallentaja.luoTiedosto(nimi);
        assertEquals(true, vastaus);
    }

    /**
     * Test of kirjoitaTiedostoon method, of class MuistiinpanojenTallentaja.
     */
    @Test
    public void kirjoittaaTiedostoon() {
        String nimi = "testitiedosto";
        String kirjoitettava = "popop";
        MuistiinpanojenTallentaja tallentaja = new MuistiinpanojenTallentaja();
        tallentaja.luoTiedosto(nimi);
        boolean vastaus = tallentaja.kirjoitaTiedostoon(nimi, kirjoitettava);
        assertEquals(true, vastaus);
    }
    
    @Test
    public void poistaaTiedoston(){
        String nimi = "testitiedosto2";
        MuistiinpanojenTallentaja tallentaja = new MuistiinpanojenTallentaja();
        tallentaja.luoTiedosto(nimi);
        boolean vastaus = tallentaja.poistaTiedosto(nimi);
        assertEquals(true, vastaus);
    }
    
}
