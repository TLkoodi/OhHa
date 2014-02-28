/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.tiedostojenkasittely;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Listaa "muistiot"-kansion tiedostot muille luokille käsiteltäväksi.
 *
 * @author TLKoodi
 */
public class TiedostojenListaaja {

    public TiedostojenListaaja() {
    }

    /**
     * Metodi listaa kansion "muistiot"-kansion tiedostot ja palauttaa nimet
     * listana.
     *
     * @return antaa muistiot-kansion tiedostonimet listana Stringejä.
     */
    public List listaaKansionTiedostot() {
        File[] tiedostot = new File("./muistiot").listFiles();

        List<String> tulokset = new ArrayList<>();

        for (File tiedosto : tiedostot) {

            if (tiedosto.isFile() && tiedosto.getName().contains(".txt")) {

                String tiedostonNimiIlmanTxtPaatetta = tiedosto.getName().replace(".txt", "");

                tulokset.add(tiedostonNimiIlmanTxtPaatetta);
            }

        }
        return tulokset;

    }
}
