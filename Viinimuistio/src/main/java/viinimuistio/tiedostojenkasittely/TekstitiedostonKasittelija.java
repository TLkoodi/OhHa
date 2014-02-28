package viinimuistio.tiedostojenkasittely;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Sisältää tiedostojenkäsittelyyn sisältävän logiikan. Mahdollisuus luoda,
 * muokata ja poistaa tiedostoja.
 *
 * @author TLKoodi
 */
public class TekstitiedostonKasittelija {

    /**
     * Luo uuden tekstitiedoston jos samannimistä tiedostoa ei ole olemassa.
     * Tarkastaa onko muistiot-kansiossa jo samannimistä tiedostoa. Jos ei ole,
     * lähettää tiedot kirjoitaOlemassaOlevaanTiedostoon metodille, joka luo
     * halutun tiedoston.
     *
     * @param tiedostolleTulevaNimi Määrittelee luotavan tekstitiedoston
     * tiedostonimen. Lopulliseen tiedostoon lisätään ".txt" pääte.
     * @param tiedostoonKirjoitettavaTeksti Määrittelee mitä tiedostoon
     * kirjoitetaan sisällöksi
     * @return Palauttaa metodin "kirjoitaOlemassaOlevaanTiedostoon" palauttaman
     * boolean arvon. Jos samanniminen tiedosto on jo olemassa, palauttaa
     * suoraan false.
     */
    public boolean luoUusiTiedosto(String tiedostolleTulevaNimi, String tiedostoonKirjoitettavaTeksti) {
        String tiedostonNimi = tiedostolleTulevaNimi + ".txt";
        File tiedosto = new File("./muistiot/" + tiedostonNimi);
        if (tiedosto.exists()) {
            return false;
        }
        return kirjoitaOlemassaOlevaanTiedostoon(tiedostolleTulevaNimi, tiedostoonKirjoitettavaTeksti);

    }

    /**
     * Kirjoittaa "muistiot"-kansiossa olemassa olevan tiedoston päälle
     * tiedoston ja tiedoston sisällön. Vanhat tiedot katoavat. Jos tiedostoa ei
     * ole olemassa, luo uuden tiedoston.
     *
     * @param tiedostolleTulevaNimi Määrittelee luotavan tekstitiedoston
     * tiedostonimen. Lopulliseen tiedostoon lisätään ".txt" pääte.
     * @param tiedostoonKirjoitettavaTeksti Määrittelee mitä tiedostoon
     * kirjoitetaan sisällöksi
     * @return Palauttaa boolean-arvon. Palauttaa true, mikäli tiedostoon
     * kirjoittaminen onnistui. Palauttaa false, mikäli ei onnistunut.
     */
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

    /**
     * Poistaa halutun tiedoston "muistiot" kansiosta.
     *
     * @param nimi Määrittelee mikä tiedosto poistetaan. Tähän Stringiin
     * lisätään .txt pääte metodissa.
     * @return Palauttaa boolean-arvon. Palauttaa true jos tiedosto poistettiin
     * onnistuneesti. Palauttaa false mikäli tiedostoa ei ole olemassa ennen
     * metodin suorittamista, tai mikäli poisto ei muusta syystä onnistu.
     */
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
