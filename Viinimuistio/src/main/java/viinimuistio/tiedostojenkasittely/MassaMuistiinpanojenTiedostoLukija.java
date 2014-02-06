/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.tiedostojenkasittely;

import java.util.ArrayList;
import java.util.List;
import viinimuistio.domain.Muistiinpano;
import viinimuistio.domain.ViiniMuistiinpano;

public class MassaMuistiinpanojenTiedostoLukija {
    
    List<String> tiedostolista;
    
    public MassaMuistiinpanojenTiedostoLukija(){
        TiedostojenListaaja listaaja = new TiedostojenListaaja();
        tiedostolista = listaaja.listaaKansionTiedostot();
    }
    
    public List<ViiniMuistiinpano> luoListaltaMuistiinpanotListaksi(){
        MuistiinpanonTiedostoLukija lukija = new MuistiinpanonTiedostoLukija();
        List<ViiniMuistiinpano> muistiinpanot = new ArrayList<ViiniMuistiinpano>();
        for (String tiedosto : tiedostolista){
            lukija.asetaTiedosto(tiedosto);
            muistiinpanot.add(lukija.tuoViiniTiedosto());
        }
        return muistiinpanot;
    }
    
}
