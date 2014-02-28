package viinimuistio.tiedostojenkasittely;

import java.util.ArrayList;
import java.util.List;
import viinimuistio.domain.ViiniMuistiinpano;

/**
 * Luokka hyväksikäyttää Tiedostojenlistaajaa ja
 * ViiniMuistiinpanonTiedostoLukijaa muodostaakseen tiedostoista listan
 * muistiinpanoja, joita voi jatkokäsitellä muissa luokissa.
 *
 * @author TLKoodi
 */
public class MassaViiniMuistiinpanojenTiedostoLukija {

    /**
     * Attribuutti sisältää muistiinpano-luokan tekstitiedostojen nimet.
     */
    private List<String> tiedostolista;

    /**
     *
     * Konstruktori ottaa arvot tiedostolista-attribuutille
     * TiedostojenListaaja-luokalta, joka listaa muistiot-kansion sisällön.
     */
    public MassaViiniMuistiinpanojenTiedostoLukija() {
        TiedostojenListaaja listaaja = new TiedostojenListaaja();
        tiedostolista = listaaja.listaaKansionTiedostot();
    }

    /**
     *
     * Käyttää ViiniMuistiinpanonTiedostoLukija-luokkaa palauttaakseen
     * Viinimuistiinpanon ilmentymiä listana "muistiot"-kansiossa olevista
     * muistiinpanoista. Lista luotavista muistiinpanoista saadaan
     * TiedostojenListaaja-luokalta konstruktorissa.
     *
     * @return palauttaa "muistiot"-kansion ViiniMuistiinpanot listana.
     */
    public List<ViiniMuistiinpano> luoListaltaMuistiinpanotListaksi() {
        ViiniMuistiinpanonTiedostoLukija viiniMuistiinpanojenLukija = new ViiniMuistiinpanonTiedostoLukija();
        List<ViiniMuistiinpano> muistiinpanot = new ArrayList<ViiniMuistiinpano>();
        for (String tiedostonimi : tiedostolista) {
            viiniMuistiinpanojenLukija.asetaTiedosto(tiedostonimi);
            muistiinpanot.add(viiniMuistiinpanojenLukija.tuoViiniTiedosto());
        }
        return muistiinpanot;
    }

}
