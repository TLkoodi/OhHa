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
 * @author lexlex@cs
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
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.luoUusiTiedosto("listaustesti1", "");
        tallentaja.luoUusiTiedosto("listaustesti2", "");
    }

    @After
    public void tearDown() {
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        tallentaja.poistaTiedosto("listaustesti1");
        tallentaja.poistaTiedosto("listaustesti2");
    }
    
    
//   Huono testi! Rikkoutuu jos muistiinpanokansiossa on enemmän tiedostoja alussa.
//    @Test
//    public void ListaaKansionTiedostot() {
//        TiedostojenListaaja lukija = new TiedostojenListaaja();
//
//        int lukumaara = lukija.listaaKansionTiedostot().size();
//
//        assertEquals(2, lukumaara);
//
//    }
}
