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
    
    @Test
    public void asettaaVuosikerranOikein(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setVuosi(2000);
        
        int vastaus = muistiinpano.getVuosi();
        
        assertEquals(2000, vastaus);
    }
    
    @Test
    public void EiAsetaLiianIsoaVuosiKertaa(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setVuosi(2020);
        
        Integer vastaus = muistiinpano.getVuosikerta();
        
        assertEquals(null, vastaus);
    }
    
    @Test
    public void EiAsetaLiianPientäVuosikertaa(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setVuosi(1620);
        
        Integer vastaus = muistiinpano.getVuosikerta();
        
        assertEquals(null, vastaus);
    }
    
    @Test
    public void vuosikertaAluksiNull(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        Integer vastaus = muistiinpano.getVuosikerta();
        
        assertEquals(null, vastaus);
    }
    
    @Test
    public void paivamaaraAlussa2014(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        String vastaus = muistiinpano.getMuistiinpanoPaivamaara();
        
        assertEquals("1.1.2014", vastaus);
    }
    
    @Test
    public void paivaAsettuuOikein(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setPaiva(12);
        
        int vastaus = muistiinpano.getPaiva();
        
        assertEquals(12, vastaus);
    }
    
    @Test
    public void eiLiianIsoaPaivalukemaa(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setPaiva(32);
        
        int vastaus = muistiinpano.getPaiva();
        
        assertEquals(1, vastaus);
    }
    
    @Test
    public void eiLiianPientaPaivalukemaa(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setPaiva(0);
        
        int vastaus = muistiinpano.getPaiva();
        
        assertEquals(1, vastaus);
    }
    
    @Test
    public void kuukausiAsettuuOikein(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setKuukausi(12);
        
        int vastaus = muistiinpano.getKuukausi();
        
        assertEquals(12, vastaus);
    }
    
    @Test
    public void eiLiianIsoaKuukautta(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setKuukausi(13);
        
        int vastaus = muistiinpano.getKuukausi();
        
        assertEquals(1, vastaus);
    }
    
    @Test
    public void eiLiianPientaKuukautta(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setKuukausi(0);
        
        int vastaus = muistiinpano.getKuukausi();
        
        assertEquals(1, vastaus);
    }
    
    @Test
    public void eiLiianIsoaVuotta(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setVuosi(2111);
        
        int vastaus = muistiinpano.getVuosi();
        
        assertEquals(2014, vastaus);
    }
    
    @Test
    public void eiLiianPientaVuotta(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setVuosi(1600);
        
        int vastaus = muistiinpano.getVuosi();
        
        assertEquals(2014, vastaus);
    }
    
    @Test
    public void vuosiAsettuuOikein(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setVuosi(1989);
        
        int vastaus = muistiinpano.getVuosi();
        
        assertEquals(1989, vastaus);
    }
    
    @Test
    public void josVuosikertaLisattyNiinOnkoLisattyTrue(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");
        
        muistiinpano.setVuosikerta(1989);
        
        boolean vastaus = muistiinpano.onkoVuosikerta();
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void josVuosikertaaEiLisattyNiinOnkoLisattyFalse(){
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Hienonimi");      
        
        boolean vastaus = muistiinpano.onkoVuosikerta();
        
        assertEquals(false, vastaus);
    }
    
}
