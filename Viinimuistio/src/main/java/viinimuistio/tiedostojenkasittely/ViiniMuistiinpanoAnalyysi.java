/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.tiedostojenkasittely;

import java.util.*;
import viinimuistio.domain.ViiniMuistiinpano;

/**
 *
 * @author lexlex@cs
 */
public class ViiniMuistiinpanoAnalyysi {

    private List<ViiniMuistiinpano> muistiinpanot;
    private List<ViiniMuistiinpano> haunTulokset;

    public ViiniMuistiinpanoAnalyysi() {
        MassaViiniMuistiinpanojenTiedostoLukija lukija = new MassaViiniMuistiinpanojenTiedostoLukija();
        muistiinpanot = lukija.luoListaltaMuistiinpanotListaksi();
    }

    public boolean hae(String hakusana) {
        List<ViiniMuistiinpano> palautus = new ArrayList<>();
        for (ViiniMuistiinpano muistiinpano : muistiinpanot){
            // Haetaan tieto tuotteen nimestä, viinialueesta, rypaleista, viinityypista, paivamaarasta, kuvauksesta
            if (haeHakusanaaVuosikerrasta(muistiinpano, hakusana) || haeHakusanaaNimesta(muistiinpano, hakusana) || haeHakusanaaAlueesta(muistiinpano, hakusana) || haeHakusanaaRypaleesta(muistiinpano, hakusana) || haeHakusanaaViinityypista(muistiinpano, hakusana) || haeHakusanaaMuistiinpanonPaivamaarasta(muistiinpano, hakusana) || haeHakusanaaKuvauksesta(muistiinpano, hakusana)) {
                palautus.add(muistiinpano);
            }
        }
        haunTulokset = palautus;
        if (haunTulokset == null || haunTulokset.size() == 0){
            return false;
        }
        return true;
    }
    
    public List<ViiniMuistiinpano> getHaunTulokset(){
        return haunTulokset;
    }

    public boolean haeHakusanaaNimesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getTuotteenNimi(), hakusana);
    }

    public boolean haeHakusanaaAlueesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getViinialue(), hakusana);
    }

    public boolean haeHakusanaaRypaleesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getRypaleet(), hakusana);
    }

    public boolean haeHakusanaaVuosikerrasta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako("" + muistiinpano.getVuosikerta(), hakusana);
    }

    public boolean haeHakusanaaViinityypista(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getViinityyppi(), hakusana);
    }

    public boolean haeHakusanaaMuistiinpanonPaivamaarasta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getMuistiinpanoPaivamaara(), hakusana);
    }

    public boolean haeHakusanaaKuvauksesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getVapaaKuvausMuistiinpanoon(), hakusana);
    }

    public boolean haeArvosanaaMuistiinpanosta(ViiniMuistiinpano muistiinpano, List<Integer> haettavat) {
        for (Integer arvosana : haettavat) {
            if (muistiinpano.getArvioViinista() == arvosana) {
                return true;
            }
        }
        return false;
    }

    public boolean sisaltaako(String analysoitava, String hakusana) {
        if (analysoitava == null){
            return false;
        }
        if (analysoitava.contains(hakusana)) {
            return true;
        }
        return false;
    }

}
