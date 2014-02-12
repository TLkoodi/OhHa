 package viinimuistio.tiedostojenkasittely;



import java.util.ArrayList;
import java.util.List;
import viinimuistio.domain.Muistiinpano;
import viinimuistio.domain.ViiniMuistiinpano;

/**
 * Luokka hyväksikäyttää Tiedostojenlistaajaa ja ViiniMuistiinpanonTiedostoLukijaa muodostaakseen tiedostoista listan muistiinpanoja, joita voi jatkokäsitellä muissa luokissa.
 * @author TLKoodi
 */

public class MassaViiniMuistiinpanojenTiedostoLukija {
    
    private List<String> tiedostolista;
 /**
 * 
 *  Konstruktoti ottaa arvot tiedostolista-attribuutille TiedostojenListaaja-luokalta, joka listaa muistiot-kansion sisällön.
 */    
    public MassaViiniMuistiinpanojenTiedostoLukija(){
        TiedostojenListaaja listaaja = new TiedostojenListaaja();
        tiedostolista = listaaja.listaaKansionTiedostot();
    }
    
    /**
 * 
 *  Käyttää ViiniMuistiinpanonTiedostoLukija-luokkaa palauttaakseen Viinimuistiinpanon ilmentymiä listana "muistiot"-kansiossa olevista muistiinpanoista. Lista luotavista muistiinpanoista saadaan TiedostojenListaaja-luokalta konstruktorissa.
 */
    
    public List<ViiniMuistiinpano> luoListaltaMuistiinpanotListaksi(){
        ViiniMuistiinpanonTiedostoLukija lukija = new ViiniMuistiinpanonTiedostoLukija();
        List<ViiniMuistiinpano> muistiinpanot = new ArrayList<ViiniMuistiinpano>();
        for (String tiedosto : tiedostolista){
            lukija.asetaTiedosto(tiedosto);
            muistiinpanot.add(lukija.tuoViiniTiedosto());
        }
        return muistiinpanot;
    }
    
}
