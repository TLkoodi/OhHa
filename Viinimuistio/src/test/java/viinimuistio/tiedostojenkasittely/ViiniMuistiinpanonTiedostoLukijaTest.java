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
import static org.junit.Assert.*;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.domain.Viinityyppi;
import viinimuistio.tiedostojenkasittely.ViiniMuistiinpanonTiedostoLukija;

/**
 *
 * @author admin
 */
public class ViiniMuistiinpanonTiedostoLukijaTest {

    public ViiniMuistiinpanonTiedostoLukijaTest() {
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
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
       tallentaja.poistaTiedosto(nimi);
    }

    @Test
    public void asettaaTiedostonimen() {
        ViiniMuistiinpanonTiedostoLukija lukija = new ViiniMuistiinpanonTiedostoLukija();
        lukija.asetaTiedosto("testitiedosto");
        String vastaus = lukija.getTiedostoNimi();

        assertEquals("testitiedosto.txt", vastaus);
    }

    @Test
    public void tuoViiniTiedostoLukeeTiedostonJaTekeeSiitaLuokanIlmentyman() {
        ViiniMuistiinpanonTiedostoLukija lukija = new ViiniMuistiinpanonTiedostoLukija();
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();
        muistiinpano.setTuotteenNimi("testitiedosto");
        muistiinpano.setViinityyppi("Kuohuviini");

        MuistiinpanonTallentaja tallentaja = new MuistiinpanonTallentaja(muistiinpano);
        tallentaja.tallennaUusiMuistiinpano();

        lukija.asetaTiedosto("testitiedosto");
        ViiniMuistiinpano haettuMuistiinpano = lukija.tuoViiniTiedosto();

        String vastaus = haettuMuistiinpano.getTuotteenNimi();

        assertEquals("testitiedosto", vastaus);
    }
}