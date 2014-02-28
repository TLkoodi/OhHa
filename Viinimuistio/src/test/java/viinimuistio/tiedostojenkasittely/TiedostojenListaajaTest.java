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

/**
 *
 * @author TLKoodi
 */
public class TiedostojenListaajaTest {

    public TiedostojenListaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        tallentaja.luoUusiTiedosto("listaustesti1", "");
        tallentaja.luoUusiTiedosto("listaustesti2", "");
    }

    @After
    public void tearDown() {
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        tallentaja.poistaTiedosto("listaustesti1");
        tallentaja.poistaTiedosto("listaustesti2");
    }
    
    
    @Test
    public void ListaaKansionTiedostot() {
        TiedostojenListaaja lukija = new TiedostojenListaaja();

        List lista = lukija.listaaKansionTiedostot();
        
        boolean listaako = false;
        
        if (lista.contains("listaustesti2")){
            listaako = true;
        }

        assertEquals(true, listaako);

    }
    
    @Test
    public void EiListaaKansionTiedostoaJosSellaistaEiOle() {
        TiedostojenListaaja lukija = new TiedostojenListaaja();

        List lista = lukija.listaaKansionTiedostot();
        
        boolean listaako = false;
        
        if (lista.contains("aslrkorrowriowqriowi3533535jsfksjfkfjs")){
            listaako = true;
        }

        assertEquals(false, listaako);

    }
}
