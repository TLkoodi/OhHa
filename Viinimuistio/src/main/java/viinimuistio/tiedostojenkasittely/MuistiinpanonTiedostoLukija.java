/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.tiedostojenkasittely;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.domain.Viinialue;
import viinimuistio.domain.Viinityyppi;

/**
 *
 * @author admin
 */
public class MuistiinpanonTiedostoLukija {

    BufferedReader lukija;
    String tiedostoNimi;

    public MuistiinpanonTiedostoLukija() {
    }

    public String getTiedostoNimi() {
        return tiedostoNimi;
    }

    public void asetaTiedosto(String haettavaTiedostoNimi) {
        tiedostoNimi = haettavaTiedostoNimi + ".txt";
    }

//    public boolean lueTiedosto() {
//        try {
//            reader = new BufferedReader(new FileReader(tiedostoNimi));
//            String rivi = null;
//            while (true) {
//                rivi = reader.readLine();
//                if (rivi.equals("viini")) {
//                    
//                }
//            }
//        } catch (IOException e) {
//        }
//        return false;
//    }
    public ViiniMuistiinpano tuoViiniTiedosto() {
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();

        try {
            FileInputStream fstream = new FileInputStream(tiedostoNimi);
            DataInputStream in = new DataInputStream(fstream);
            lukija = new BufferedReader(new InputStreamReader(in));

            int i = 0;


            String rivi;

            while ((rivi = lukija.readLine()) != null) {


                System.out.println(rivi);



                if (i == 0) {
                    System.out.println(rivi);

                }

                if (i == 1) {
                    System.out.println(rivi);
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

                i++;
            }
            in.close();
        } catch (IOException ex) {
            return null;
        }
        return muistiinpano;
    }
}
