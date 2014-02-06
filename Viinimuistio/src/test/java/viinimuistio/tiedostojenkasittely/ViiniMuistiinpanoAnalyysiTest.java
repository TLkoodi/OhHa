/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.tiedostojenkasittely;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viinimuistio.domain.ViiniMuistiinpano;

/**
 *
 * @author lexlex@cs
 */
public class ViiniMuistiinpanoAnalyysiTest {
    
    public ViiniMuistiinpanoAnalyysiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ViiniMuistiinpanonTiedostoLukija lukija = new ViiniMuistiinpanonTiedostoLukija();
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();
        ViiniMuistiinpano muistiinpano2 = new ViiniMuistiinpano();
        muistiinpano.setTuotteenNimi("testitiedosto");
        muistiinpano.setViinityyppi("Kuohuviini");
        
        muistiinpano2.setTuotteenNimi("testitiedosto2");
        muistiinpano2.setViinityyppi("Punaviini");
        muistiinpano2.setVuosikerta(2008);

        MuistiinpanonTallentaja tallentaja = new MuistiinpanonTallentaja(muistiinpano);
        tallentaja.tallennaUusiMuistiinpano();
        MuistiinpanonTallentaja tallentaja2 = new MuistiinpanonTallentaja(muistiinpano2);
        tallentaja2.tallennaUusiMuistiinpano();
    }
    
    @After
    public void tearDown() {
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.poistaTiedosto("testitiedosto");        
        tallentaja.poistaTiedosto("testitiedosto2");
    }

    
    @Test
    public void sisaltaakoTunnistaaStringSisaltymisen() {
        ViiniMuistiinpanoAnalyysi analyysi = new ViiniMuistiinpanoAnalyysi();
        boolean vastaus = analyysi.sisaltaako("rakkikoirathaukkuuTESTIonhauskaa", "TESTI");
        assertEquals(true, vastaus);
    }
    
//    @Test
//    public void sisaltaakoMetodiTunnistaaStringSisaltymisenJosIsoillaJaPienillaEroa() {
//        ViiniMuistiinpanoAnalyysi analyysi = new ViiniMuistiinpanoAnalyysi();
//        boolean vastaus = analyysi.sisaltaako("rakkikoirathaukkuuTESTIonhauskaa", "testi");
//        assertEquals(true, vastaus);
//    }

    @Test
    public void kattavaAnalyysiTunnistaaViinitNimenPerusteella() {
        
        ViiniMuistiinpanoAnalyysi analyysi = new ViiniMuistiinpanoAnalyysi();
        analyysi.hae("testitiedosto");
        List<ViiniMuistiinpano> lista = analyysi.getHaunTulokset();
        assertEquals(2, lista.size());
    }
    
    @Test
    public void kattavaAnalyysiEiTunnistaJosEiOle() {
        
        ViiniMuistiinpanoAnalyysi analyysi = new ViiniMuistiinpanoAnalyysi();
        boolean onkoTuloksia = analyysi.hae("naamapalmu");
        assertEquals(false, onkoTuloksia);
    }
    
    @Test
    public void kattavaAnalyysiTunnistaaJoukostaOikeanViinityypin() {
        
        ViiniMuistiinpanoAnalyysi analyysi = new ViiniMuistiinpanoAnalyysi();
        analyysi.hae("Punaviini");
        List<ViiniMuistiinpano> lista = analyysi.getHaunTulokset();
        assertEquals(1, lista.size());
    }

    
}
