package viinimuistio.tiedostojenkasittely;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import viinimuistio.domain.ViiniMuistiinpano;

/**
 * Lukee tekstitiedoston rivit ja muodostaa niistä Viinimuistiinpanon.
 *
 * @author TLKoodi
 */
public class ViiniMuistiinpanonTiedostoLukija {

    /**
     * Tiedoston nimi, mikä tällä hetkellä on luokan käsittelyssä.
     */
    private String tiedostoNimi;

    public ViiniMuistiinpanonTiedostoLukija() {
    }

    public String getTiedostoNimi() {
        return tiedostoNimi;
    }

    /**
     * Asetetaan tiedosto luokalle käyttöön ja lisätään siihen ".txt"
     *
     * @param haettavaTiedostoNimi
     */
    public void asetaTiedosto(String haettavaTiedostoNimi) {
        tiedostoNimi = haettavaTiedostoNimi + ".txt";
    }

    /**
     * Luo viinimuistiinpanon ja lisää sille arvot tiedostosta. Tiedosto haetaan
     * tiedostonNimi-attribuutin perusteella. Jokaisella rivillä on määrätty
     * tieto jonka perusteella muistiinpano rakennetaan.
     *
     * @return palauttaa valmiin muistiinpanon
     */
    public ViiniMuistiinpano tuoViiniTiedosto() {

        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        try {
            FileInputStream fstream = new FileInputStream("./muistiot/" + tiedostoNimi);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader lukija = new BufferedReader(new InputStreamReader(in));

            int i = 0;

            String rivi;

            while ((rivi = lukija.readLine()) != null) {

                if (i == 0) {

                }

                if (i == 1) {
                    muistiinpano.setTuotteenNimi(rivi);
                }

                if (i == 2) {
                    muistiinpano.setMuistiinpanonPaivamaara(rivi);
                }

                if (i == 3) {
                    muistiinpano.setViinityyppi(rivi);
                }

                if (i == 4) {
                    muistiinpano.setViinialue(rivi);
                }

                if (i == 5) {
                    muistiinpano.setRypaleet(rivi);
                }

                if (i == 6) {
                    muistiinpano.setArvioViinista(Integer.parseInt(rivi));
                }

                if (i == 7) {
                    muistiinpano.setVapaaKuvausMuistiinpanoon(rivi);
                }

                if (i == 8) {
                    muistiinpano.setVuosikerta(Integer.parseInt(rivi));
                }

                i++;
            }
            in.close();
        } catch (IOException ex) {
            return null;
        }
        return muistiinpano;
    }
}
