package viinimuistio.tiedostojenkasittely;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class TekstitiedostonTallentaja {

    public boolean luoUusiTiedosto(String tiedostolleTulevaNimi, String tiedostoonKirjoitettavaTeksti) {
        String tiedostonNimi = tiedostolleTulevaNimi + ".txt";
        File tiedosto = new File("./muistiot/" + tiedostonNimi);
        if (tiedosto.exists()) {
            return false;
        }
        return kirjoitaOlemassaOlevaanTiedostoon(tiedostolleTulevaNimi, tiedostoonKirjoitettavaTeksti);

    }

    public boolean kirjoitaOlemassaOlevaanTiedostoon(String tiedostolleTulevaNimi, String tiedostoonKirjoitettavaTeksti) {
        String tiedostonNimi = tiedostolleTulevaNimi + ".txt";
        File tiedosto = new File("./muistiot/" + tiedostonNimi);
        try {
            BufferedWriter kirjoittaja = new BufferedWriter(new FileWriter(tiedosto));
            kirjoittaja.write(tiedostoonKirjoitettavaTeksti);
            kirjoittaja.close();
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    public boolean poistaTiedosto(String nimi) {
        String tiedostonNimi = nimi + ".txt";
        try {
            File tiedosto = new File("./muistiot/" + tiedostonNimi);
            if (!tiedosto.exists()) {
                return false;
            }
            tiedosto.delete();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
