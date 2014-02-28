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
import viinimuistio.tiedostojenkasittely.TekstitiedostonKasittelija;
import viinimuistio.tiedostojenkasittely.TekstitiedostonKasittelija;
import static org.junit.Assert.*;

/**
 *
 * @author Tony
 */
public class TekstitiedostonKasittelijaTest {

    public TekstitiedostonKasittelijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String nimi = "testitiedosto";
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        tallentaja.poistaTiedosto(nimi);
    }

    @After
    public void tearDown() {
        String nimi = "testitiedosto";
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        tallentaja.poistaTiedosto(nimi);
    }

    @Test
    public void LuoUudenTiedoston() {
        
        String nimi = "besttiedosto";        
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        boolean vastaus = tallentaja.luoUusiTiedosto(nimi, "popop");
        tallentaja.poistaTiedosto(nimi);
        assertEquals(true, vastaus);
    }
    
    @Test
    public void eiLuoUudelleenSamaaTiedostoa() {
        String nimi = "testitiedosto";
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        tallentaja.luoUusiTiedosto(nimi, "popop");
        boolean vastaus = tallentaja.luoUusiTiedosto(nimi, "popop");
        assertEquals(false, vastaus);
    }

    @Test
    public void kirjoittaaOlemassaOlevaanTiedostoon() {
        String nimi = "testitiedosto";
        String kirjoitettava = "popop";
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        tallentaja.luoUusiTiedosto(nimi, kirjoitettava);
        boolean vastaus = tallentaja.kirjoitaOlemassaOlevaanTiedostoon(nimi, kirjoitettava);
        assertEquals(true, vastaus);
    }

    @Test
    public void poistaaTiedoston() {
        String nimi = "testitiedosto2";
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        tallentaja.luoUusiTiedosto(nimi, "popop");
        boolean vastaus = tallentaja.poistaTiedosto(nimi);
        assertEquals(true, vastaus);
    }
    
    @Test
    public void poistaaTiedostoPalauttaaFalseKunPoistettavaaEiOle() {
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        boolean vastaus = tallentaja.poistaTiedosto("huhduwhuhuwewwrawrlkalkra");
        assertEquals(false, vastaus);
    }
}
