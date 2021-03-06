/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.domain;

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
    public void nimiOikeinKunAsetettuMetodilla() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setTuotteenNimi("uusinimi");

        String vastaus = muistiinpano.getTuotteenNimi();

        assertEquals("uusinimi", vastaus);
    }

    @Test
    public void nimiNimieamatonKunEiAnnettuNimea() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();


        String vastaus = muistiinpano.getTuotteenNimi();

        assertEquals("tuntematon", vastaus);
    }

    @Test
    public void asettaaVuosikerranOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonVuosi(2000);

        int vastaus = muistiinpano.getMuistiinpanonVuosi();

        assertEquals(2000, vastaus);
    }

    @Test
    public void EiAsetaLiianIsoaVuosiKertaa() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonVuosi(2020);

        int vastaus = muistiinpano.getVuosikerta();

        assertEquals(0, vastaus);
    }

    @Test
    public void EiAsetaLiianPientäVuosikertaa() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonVuosi(1620);

        int vastaus = muistiinpano.getVuosikerta();

        assertEquals(0, vastaus);
    }

    @Test
    public void vuosikertaAluksiNolla() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        int vastaus = muistiinpano.getVuosikerta();

        assertEquals(0, vastaus);
    }

    @Test
    public void paivamaaraAlussa2014() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        String vastaus = muistiinpano.getMuistiinpanoPaivamaara();

        assertEquals("01.01.2014", vastaus);
    }

    @Test
    public void paivaAsettuuOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonPaiva(12);

        int vastaus = muistiinpano.getMuistiinpanonPaiva();

        assertEquals(12, vastaus);
    }

    @Test
    public void eiLiianIsoaPaivalukemaa() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonPaiva(32);

        int vastaus = muistiinpano.getMuistiinpanonPaiva();

        assertEquals(1, vastaus);
    }

    @Test
    public void eiLiianPientaPaivalukemaa() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonPaiva(0);

        int vastaus = muistiinpano.getMuistiinpanonPaiva();

        assertEquals(1, vastaus);
    }

    @Test
    public void kuukausiAsettuuOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonKuukausi(12);

        int vastaus = muistiinpano.getMuistiinpanonKuukausi();

        assertEquals(12, vastaus);
    }

    @Test
    public void eiLiianIsoaKuukautta() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonKuukausi(13);

        int vastaus = muistiinpano.getMuistiinpanonKuukausi();

        assertEquals(1, vastaus);
    }

    @Test
    public void eiLiianPientaKuukautta() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonKuukausi(0);

        int vastaus = muistiinpano.getMuistiinpanonKuukausi();

        assertEquals(1, vastaus);
    }

    @Test
    public void eiLiianIsoaVuotta() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonVuosi(2111);

        int vastaus = muistiinpano.getMuistiinpanonVuosi();

        assertEquals(2014, vastaus);
    }

    @Test
    public void eiLiianPientaVuotta() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonVuosi(1600);

        int vastaus = muistiinpano.getMuistiinpanonVuosi();

        assertEquals(2014, vastaus);
    }

    @Test
    public void vuosiAsettuuOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonVuosi(1989);

        int vastaus = muistiinpano.getMuistiinpanonVuosi();

        assertEquals(1989, vastaus);
    }

    @Test
    public void paivamaaraAsettuuOikeinJosAsetettuStringilla() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonPaivamaara("12.12.2012");

        String vastaus = muistiinpano.getMuistiinpanoPaivamaara();

        assertEquals("12.12.2012", vastaus);
    }

    @Test
    public void josVuosikertaLisattyNiinOnkoLisattyTrue() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setVuosikerta(1989);

        boolean vastaus = muistiinpano.onkoVuosikerta();

        assertEquals(true, vastaus);
    }

    @Test
    public void josVuosikertaaEiLisattyNiinOnkoLisattyFalse() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        boolean vastaus = muistiinpano.onkoVuosikerta();

        assertEquals(false, vastaus);
    }

    @Test
    public void josVirheellinenVuosikertaYritettyLisataNiinOnkoLisatty() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setVuosikerta(2049);

        boolean vastaus = muistiinpano.onkoVuosikerta();

        assertEquals(false, vastaus);
    }

    @Test
    public void kuvauksenLisaysToimii() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setVapaaKuvausMuistiinpanoon("hihi");

        String vastaus = muistiinpano.getVapaaKuvausMuistiinpanoon();

        assertEquals("hihi", vastaus);
    }

    @Test
    public void kuvauksAlussaTyhja() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        String vastaus = muistiinpano.getVapaaKuvausMuistiinpanoon();

        assertEquals("", vastaus);
    }

    @Test
    public void viiniAlueLisaytyyOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setViinialue("Ranska");

        String vastaus = muistiinpano.getViinialue();

        assertEquals("Ranska", vastaus);
    }

    @Test
    public void viiniAlueOnHuonollaSyotteellaEiAsetettu() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setViinialue("lapua");

        String vastaus = muistiinpano.getViinialue();

        assertEquals("Ei_asetettu", vastaus);
    }

    @Test
    public void alussaEiOleViiniAluetta() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        String vastaus = muistiinpano.getViinialue();

        assertEquals(null, vastaus);
    }

    @Test
    public void viiniTyyppiLisaytyyOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setViinityyppi("Punaviini");

        String vastaus = muistiinpano.getViinityyppi();

        assertEquals("Punaviini", vastaus);
    }

    @Test
    public void viiniTyyppiOnHuonollaSyotteellaEiAsetettu() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setViinityyppi("lapua");

        String vastaus = muistiinpano.getViinityyppi();

        assertEquals("Ei_asetettu", vastaus);
    }

    @Test
    public void alussaEiOleViiniTyyppia() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        String vastaus = muistiinpano.getViinityyppi();

        assertEquals(null, vastaus);
    }

    @Test
    public void arvioAsettuuOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setArvioViinista(1);

        int vastaus = muistiinpano.getArvioViinista();

        assertEquals(1, vastaus);
    }

    @Test
    public void eiLiianPientaArviota() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setArvioViinista(-1);

        int vastaus = muistiinpano.getArvioViinista();

        assertEquals(0, vastaus);
    }

    @Test
    public void eiLiianIsoaArviota() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setArvioViinista(6);

        int vastaus = muistiinpano.getArvioViinista();

        assertEquals(0, vastaus);
    }

    @Test
    public void alussaEiArviotaViinista() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        int vastaus = muistiinpano.getArvioViinista();

        assertEquals(0, vastaus);
    }

    @Test
    public void tunnisteOnViini() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        String vastaus = muistiinpano.getTunniste();

        assertEquals("viini", vastaus);
    }

    @Test
    public void rypaleetOnOikein() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setRypaleet("Cabernet Sauvignon");

        String vastaus = muistiinpano.getRypaleet();

        assertEquals("Cabernet Sauvignon", vastaus);
    }

    @Test
    public void josRypaleetEiMaariteltyVastausOnEiMaaritelty() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        String vastaus = muistiinpano.getRypaleet();

        assertEquals("Ei määritelty", vastaus);
    }
    
    @Test
    public void setArvioViinistaStringinaToimiiJosHyvaArvoAnnettu() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setArvioViinistaStringina("4");
        
        int vastaus = muistiinpano.getArvioViinista();

        assertEquals(4, vastaus);
    }
    
    @Test
    public void setArvioViinistaStringinaEiToimiJosHuonoArvoAnnettu() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setArvioViinistaStringina("Hihhei");
        
        int vastaus = muistiinpano.getArvioViinista();

        assertEquals(0, vastaus);
    }
    
    @Test
    public void setVuosikertaStringinaEiToimiJosHuonoArvoAnnettu() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setVuosikertaStringina("Hihhei");
        
        int vastaus = muistiinpano.getVuosikerta();

        assertEquals(0, vastaus);
    }
    
    @Test
    public void setVuosikertaStringinaToimiiJosHyvaArvoAnnettu() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setVuosikertaStringina("1999");
        
        int vastaus = muistiinpano.getVuosikerta();

        assertEquals(1999, vastaus);
    }
    
    @Test
    public void setKuukausiMeneeOikeinKunNollaEnsimmäinenMerkki() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonKuukausi(Integer.parseInt("02"));
        
        int vastaus = muistiinpano.getMuistiinpanonKuukausi();

        assertEquals(2, vastaus);
    }
    
    @Test
    public void setPaivaMeneeOikeinKunNollaEnsimmäinenMerkki() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonPaiva(Integer.parseInt("02"));
        
        int vastaus = muistiinpano.getMuistiinpanonPaiva();

        assertEquals(2, vastaus);
    }
    
    @Test
    public void getPaivaStringinaLisaaNollanYksinumeroiseenPaivaan() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonPaiva(2);
        
        String vastaus = muistiinpano.getMuistiinpanonPaivaKaksinumeroisenaStringina();

        assertEquals("02", vastaus);
    }
    
    @Test
    public void getKuukausiStringinaLisaaNollanYksinumeroiseenKuukauteen() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        muistiinpano.setMuistiinpanonKuukausi(2);
        
        String vastaus = muistiinpano.getMuistiinpanonKuukausiKaksinumeroisenaStringina();

        assertEquals("02", vastaus);
    }
}
