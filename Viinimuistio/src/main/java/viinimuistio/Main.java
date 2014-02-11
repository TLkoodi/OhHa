package viinimuistio;

import javax.swing.SwingUtilities;
import viinimuistio.domain.ViiniMuistiinpano;
import static viinimuistio.domain.Viinialue.*;
import viinimuistio.tiedostojenkasittely.*;
import viinimuistio.ui.Kayttoliittyma;

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
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
    }
}
