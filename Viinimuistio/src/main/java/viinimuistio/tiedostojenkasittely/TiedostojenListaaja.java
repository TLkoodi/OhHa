/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.tiedostojenkasittely;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lexlex@cs
 */
public class TiedostojenListaaja {


    public TiedostojenListaaja() {
    }

    public List listaaKansionTiedostot() {
        File[] tiedostot = new File("./muistiot").listFiles();

        List<String> tulokset = new ArrayList<String>();

        for (File file : tiedostot) {
            
            if (file.isFile() && file.getName().contains(".txt")) {
                
                String tiedostonNimiIlmanTxtPaatetta = file.getName().replace(".txt", "");
                
                tulokset.add(tiedostonNimiIlmanTxtPaatetta);
            }
            
        }
        return tulokset;

    }
}
