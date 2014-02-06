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
import viinimuistio.tiedostojenkasittely.TekstitiedostonTallentaja;
import viinimuistio.tiedostojenkasittely.TekstitiedostonTallentaja;
import static org.junit.Assert.*;

/**
 *
 * @author Tony
 */
public class TekstitiedostonTallentajaTest {

    public TekstitiedostonTallentajaTest() {
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

    @Test
    public void LuoUudenTiedoston() {
        String nimi = "testitiedosto";
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        boolean vastaus = tallentaja.luoUusiTiedosto(nimi, "popop");
        assertEquals(true, vastaus);
    }

    @Test
    public void kirjoittaaOlemassaOlevaanTiedostoon() {
        String nimi = "testitiedosto";
        String kirjoitettava = "popop";
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.luoUusiTiedosto(nimi, kirjoitettava);
        boolean vastaus = tallentaja.kirjoitaOlemassaOlevaanTiedostoon(nimi, kirjoitettava);
        assertEquals(true, vastaus);
    }

    @Test
    public void poistaaTiedoston() {
        String nimi = "testitiedosto2";
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.luoUusiTiedosto(nimi, "popop");
        boolean vastaus = tallentaja.poistaTiedosto(nimi);
        assertEquals(true, vastaus);
    }
}
