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
 * @author TLKoodi
 */
public class MassaMuistiinpanojenTiedostoLukijaTest {
    
    public MassaMuistiinpanojenTiedostoLukijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.luoUusiTiedosto("listaustesti1", "");
        tallentaja.luoUusiTiedosto("listaustesti2", "");
        tallentaja.luoUusiTiedosto("listaustesti3", "");
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();
        muistiinpano.setTuotteenNimi("asdsadsdsd49449");
        muistiinpano.setViinityyppi("Kuohuviini");

        MuistiinpanonTallentaja muistiinpanontallentaja = new MuistiinpanonTallentaja(muistiinpano);
        muistiinpanontallentaja.tallennaUusiMuistiinpano();

    }
    
    @After
    public void tearDown() {
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.poistaTiedosto("listaustesti1");
        tallentaja.poistaTiedosto("listaustesti2");
        tallentaja.poistaTiedosto("listaustesti3");       
        tallentaja.poistaTiedosto("asdsadsdsd49449");
    }
    
    @Test
    public void LuoListaltaMuistiinpanotListaksi() {
        boolean loytyykoListasta = false;
        MassaViiniMuistiinpanojenTiedostoLukija lukija = new MassaViiniMuistiinpanojenTiedostoLukija();
        List<ViiniMuistiinpano> lista = lukija.luoListaltaMuistiinpanotListaksi();
        for (ViiniMuistiinpano muistiinpano : lista){
            if (muistiinpano.getTuotteenNimi().equals("asdsadsdsd49449")){
                loytyykoListasta = true;
            }
        }
        
        assertEquals(true, loytyykoListasta);
    }
    
}
