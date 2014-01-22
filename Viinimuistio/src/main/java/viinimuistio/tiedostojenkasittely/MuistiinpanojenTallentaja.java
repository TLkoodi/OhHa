package viinimuistio.tiedostojenkasittely;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class MuistiinpanojenTallentaja {

    public boolean luoTiedosto(String tiedostolleTulevaNimi) {
        String tiedostonNimi = tiedostolleTulevaNimi + ".txt";
        try {
            File tiedosto = new File(tiedostonNimi);
            if (tiedosto.exists()) {
                return false;
            }
            BufferedWriter kirjoittaja = new BufferedWriter(new FileWriter(tiedosto));
            kirjoittaja.write("text");
            kirjoittaja.close();
            return true;

        } catch (IOException e) {
        }

        return false;
    }

    public boolean kirjoitaTiedostoon(String tiedostolleTulevaNimi, String tiedostoonKirjoitettavaTeksti) {
        String tiedostonNimi = tiedostolleTulevaNimi + ".txt";
        File tiedosto = new File(tiedostonNimi);
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
            File tiedosto = new File(tiedostonNimi);
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
