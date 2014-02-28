package viinimuistio.tiedostojenkasittely;

import java.util.*;
import viinimuistio.domain.ViiniMuistiinpano;

/**
 * Hakee muistiinpanoista käyttäjän haluamia arvoja, kuten hakusanoja.
 *
 * @author TLKoodi
 */
public class ViiniMuistiinpanoAnalyysi {

    /**
     * Sisältää konstruktorissa saadut muistiinpanot sisällään listana. Näytä
     * muistiinpanoja voidaan käsitellä tässä luokassa.
     */
    private List<ViiniMuistiinpano> muistiinpanot;

    /**
     * Sisältää viimeisimmän hakun tulokset listana muistiinpanoja jotka
     * pääsivät määritellyistä kriteereistä läpi.
     */
    private List<ViiniMuistiinpano> haunTulokset;

    /**
     * Konstruktorissa haetaan MassaViiniMuistiinpanojenTiedostoLukija-luokalta
     * lista "muistiot"-kansion muistiinpanoista.
     */
    public ViiniMuistiinpanoAnalyysi() {
        MassaViiniMuistiinpanojenTiedostoLukija lukija = new MassaViiniMuistiinpanojenTiedostoLukija();
        muistiinpanot = lukija.luoListaltaMuistiinpanotListaksi();
    }

    /**
     * Metodi hakee hakusanaa tuotteen nimestä, viinialueesta, rypaleista,
     * viinityypista, paivamaarasta ja kuvauksesta. Haun läpäisseet
     * muistiinpanot lisätään "haunTulokset"-attribuuttiin, josta poistuu
     * mahdollisesti vanhat hakutulokset.
     *
     * @param hakusana String-muotoinen hakusana jota haetaan tiedosoista.
     * @return palauttaa boolean arvon sen mukaan löytyikö yhtään osumaa vai ei.
     */
    public boolean hae(String hakusana) {
        List<ViiniMuistiinpano> palautus = new ArrayList<ViiniMuistiinpano>();
        for (ViiniMuistiinpano muistiinpano : muistiinpanot) {

            if (haeHakusanaaVuosikerrasta(muistiinpano, hakusana) || haeHakusanaaNimesta(muistiinpano, hakusana) || haeHakusanaaAlueesta(muistiinpano, hakusana) || haeHakusanaaRypaleesta(muistiinpano, hakusana) || haeHakusanaaViinityypista(muistiinpano, hakusana) || haeHakusanaaMuistiinpanonPaivamaarasta(muistiinpano, hakusana) || haeHakusanaaKuvauksesta(muistiinpano, hakusana)) {
                palautus.add(muistiinpano);
            }
        }
        haunTulokset = palautus;

        if (haunTulokset == null || haunTulokset.size() == 0) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return palauttaa viimeisimmän haun läpäisseet tulokset listana
     * muistiinpanoja
     */
    public List<ViiniMuistiinpano> getHaunTulokset() {
        return haunTulokset;
    }

    /**
     * Metodilla haetaan hakusanaa muistiinpanon määritellystä attribuutista.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param hakusana hakusana mitä etsitään muistiinpanosta
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeHakusanaaNimesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getTuotteenNimi(), hakusana);
    }

    /**
     * Metodilla haetaan hakusanaa muistiinpanon määritellystä attribuutista.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param hakusana hakusana mitä etsitään muistiinpanosta
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeHakusanaaAlueesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getViinialue(), hakusana);
    }

    /**
     * Metodilla haetaan hakusanaa muistiinpanon määritellystä attribuutista.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param hakusana hakusana mitä etsitään muistiinpanosta
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeHakusanaaRypaleesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getRypaleet(), hakusana);
    }

    /**
     * Metodilla haetaan hakusanaa muistiinpanon määritellystä attribuutista.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param hakusana hakusana mitä etsitään muistiinpanosta
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeHakusanaaVuosikerrasta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako("" + muistiinpano.getVuosikerta(), hakusana);
    }

    /**
     * Metodilla haetaan hakusanaa muistiinpanon määritellystä attribuutista.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param hakusana hakusana mitä etsitään muistiinpanosta
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeHakusanaaViinityypista(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getViinityyppi(), hakusana);
    }

    /**
     * Metodilla haetaan hakusanaa muistiinpanon määritellystä attribuutista.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param hakusana hakusana mitä etsitään muistiinpanosta
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeHakusanaaMuistiinpanonPaivamaarasta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getMuistiinpanoPaivamaara(), hakusana);
    }

    /**
     * Metodilla haetaan hakusanaa muistiinpanon määritellystä attribuutista.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param hakusana hakusana mitä etsitään muistiinpanosta
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeHakusanaaKuvauksesta(ViiniMuistiinpano muistiinpano, String hakusana) {
        return sisaltaako(muistiinpano.getVapaaKuvausMuistiinpanoon(), hakusana);
    }

    /**
     * Metodilla haetaan määriteltyjä arvosanoja muistiinpanon
     * arvioViinista-attribuutista. Esim onko muistiinpano saanut arvosanan 3
     * tai 4.
     *
     * @param muistiinpano muistiinpano mistä etsitään
     * @param haettavat määrittelee mitä arvoja haetaan
     * @return boolean arvo, joka kertoo löytyikö (true) vai eikö löytynt
     * (false)
     */
    public boolean haeArvosanaaMuistiinpanosta(ViiniMuistiinpano muistiinpano, List<Integer> haettavat) {
        for (Integer arvosana : haettavat) {
            if (muistiinpano.getArvioViinista() == arvosana) {
                return true;
            }
        }
        return false;
    }

    /**
     * Hakee analysoitavasta stringistä tiettyä haettua merkkijonoa.F
     *
     * @param analysoitava String mistä etsitään
     * @param hakusana String mitä etsitään
     * @return palauttaa arvon (true) jos löytyi, muuten (false).
     */
    public boolean sisaltaako(String analysoitava, String hakusana) {
        if (analysoitava == null) {
            return false;
        }
        if (analysoitava.contains(hakusana)) {
            return true;
        }
        return false;
    }

}
