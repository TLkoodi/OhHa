/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.tiedostojenkasittely;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import viinimuistio.tiedostojenkasittely.MuistiinpanonTallentaja;
import static org.junit.Assert.*;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.tiedostojenkasittely.TekstitiedostonTallentaja;

/**
 *
 * @author admin
 */
public class MuistiinpanonTallentajaTest {

    public MuistiinpanonTallentajaTest() {
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
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.poistaTiedosto(nimi);
    }

    /**
     * Test of tallennaUusiMuistiinpano method, of class
     * MuistiinpanonTallentaja.
     */
    @Test
    public void tallentaaUudenMuistiinpanon() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();
        muistiinpano.setTuotteenNimi("testitiedosto");
        MuistiinpanonTallentaja tallentaja = new MuistiinpanonTallentaja(muistiinpano);
        boolean vastaus = tallentaja.tallennaUusiMuistiinpano();
        assertEquals(true, vastaus);
    }
}