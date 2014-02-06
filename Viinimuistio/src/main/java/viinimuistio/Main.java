package viinimuistio;

import viinimuistio.domain.ViiniMuistiinpano;
import static viinimuistio.domain.Viinialue.*;
import viinimuistio.tiedostojenkasittely.*;

/**
 * Hello world!
 *
 */
public class Main {
    
    // Jos testit eivät mene läpi, kokeile uudelleen (tai tyhjennä "muistiot"-kansio), välillä tiedostot jäävät kansioihin kummittelemaan
    // ja haittaavat testejä jotka tarkastelevat tiedostojen olemassaoloa

    /**
     *
     * @param args
     */
    
    public static void main(String[] args) {
        TiedostojenListaaja lukija = new TiedostojenListaaja();
        lukija.listaaKansionTiedostot();
        
    }
}
