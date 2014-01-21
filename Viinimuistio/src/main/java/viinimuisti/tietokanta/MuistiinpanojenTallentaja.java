package viinimuisti.tietokanta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Tony
 */
public class MuistiinpanojenTallentaja {

    public boolean luoTiedosto(String nimi) {
        String tiedostonNimi = nimi + "txt";
        try {
            File tiedosto = new File(tiedostonNimi);
            BufferedWriter tuotos = new BufferedWriter(new FileWriter(tiedosto));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
//    public boolean kirjoitaTiedostoon(String kirjoitettava){
//        return false;
//    }
}
