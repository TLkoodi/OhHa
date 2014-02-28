package viinimuistio.domain;

/**
 * Viinimuistiinpano sisältää attribuutit jotka muistiinpanoon tulevat, luokka
 * sisältää lähinnä settereitä ja gettereitä erilaisille arvoille, sekä
 * toiminnallisuus tietojen helppoon siirtoon muille luokille. Totuttaa
 * rajapinnan "Muistiinpano"
 *
 * @author TLKoodi
 *
 *
 */
public class ViiniMuistiinpano implements Muistiinpano {

    /**
     * Sisältää tuotteen nimen, tätä nimeä käytetään myös muistiinpanon
     * identifioimiseen, sekä tiedostonimenä tekstitiedostoille.
     */
    private String tuotteenNimi;

    /**
     * Viinityyppin arvo on jokin Viinityyppi-luokan arvoista.
     */
    private Viinityyppi viinityyppi;

    /**
     * Viinialueen arvo on jokin Viinialue-luokan arvoista.
     */
    private Viinialue viinialue;

    /**
     * Vapaa teksti johon käyttäjän on tarkoitus tallentaa tiedot viinissä
     * käytetyistä rypäleistä. Vapaan tekstikentän takia se voi sisältää tällä
     * hetkellä minkälaista tekstiä tahansa. Rypälelajikkeita on tuhansia joten
     * tämä toteutus on helpoin.
     */
    private String rypaleet;

    /**
     * Viinin vuosikerta, jos sellainen viinillä on. Hyväksyy vuodet väliltä
     * 1701 - 2014.
     */
    private int vuosikerta;

    /**
     * Käyttäjän oma arvio viinin laadusta tai miellekkyydestä. Voi sisältää
     * arvoja väliltä 0-5. Voidaan mieltää "tähtinä".
     */
    private int arvioViinista;

    /**
     * Täysin vapaa teksti johon käyttäjä voi kirjoittaa haluamiaan asioita
     * muistiin viinistä.
     */
    private String vapaaKuvausMuistiinpanoon = "";

    /**
     * Muistiinpanon päivämäärä. Arvot väliltä 1-31.
     */
    private int muistiinpanonPaiva = 1;

    /**
     * Muistiinpanon kuukausi. Arvot väliltä 1-12.
     */
    private int muistiinpanonKuukausi = 1;

    /**
     * Muistiinpanon vuosi. Arvot väliltä 1971 - 2019.
     */
    private int muistiinpanonVuosi = 2014;

    /**
     * Kertoo onko muistiinpanon tuote vuosikerrallinen.
     */
    private boolean onkoVuosikerta;

    /**
     * Luodaan uusi Viinimuistiinpano, annetaan nimi konstruktorissa.
     * Vuosikerrallisuutta ei vielä määritelty joten oletukseksi asetetaan sille
     * false.
     *
     * @param nimi Muistiinpanolle annettava nimi
     */
    public ViiniMuistiinpano(String nimi) {
        this.tuotteenNimi = nimi;
        this.onkoVuosikerta = false;
    }

    /**
     * Luodaan uusi Viinimuistiinpano ilman nimeä. Vuosikerrallisuutta ei vielä
     * määritelty joten oletukseksi asetetaan sille false.
     *
     */
    public ViiniMuistiinpano() {
        this.onkoVuosikerta = false;
    }

    /**
     *
     * @return Palauttaa muistiinpanon rypäleet-stringiin tallennetun arvon.
     * Palauttaa "Ei määritelty" jos arvo on null
     */
    public String getRypaleet() {
        if (rypaleet == null) {
            return "Ei määritelty";
        }
        return rypaleet;
    }

    public void setViinityyppi(Viinityyppi viinityyppi) {
        this.viinityyppi = viinityyppi;
    }

    public void setRypaleet(String rypaleet) {
        this.rypaleet = rypaleet;
    }

    /**
     *
     * @return palauttaa arvon väliltä 0-5. Jos arvoa ei ole tallennettu tai
     * arvo on väärän suuruinen, palauttaa arvon 0.
     */
    public Integer getArvioViinista() {
        if (arvioViinista >= 0 && arvioViinista < 6) {
            return arvioViinista;
        }
        return 0;
    }

    /**
     *
     * @param arvioViinista asettaa arvion viinistä. Arvoiksi kelpaa arvot 0-5.
     */
    public void setArvioViinista(int arvioViinista) {
        if (arvioViinista < 6 && arvioViinista >= 0) {
            this.arvioViinista = arvioViinista;
        }
    }

    /**
     *
     * @param arvioViinista syötetään string arvo jonka pitäisi sisältää arvio
     * viinistä (luku väliltä 0-5). Otetaan arvosta Integer ulos. Jos arviota
     * viinistä ei setArvioViinista metodilla pystytä asettamaan, ei tehdä
     * mitään.
     */
    public void setArvioViinistaStringina(String arvioViinista) {
        try {
            int arvio = Integer.parseInt(arvioViinista);
            setArvioViinista(arvio);
        } catch (Exception e) {
        }
    }

    /**
     *
     * @param asetettavaAlue stringin tulisi sisältää Viinialue-Enumin arvo
     * sisällään, ja se asetetaan muistiinpanon arvoksi. Jos arvoa ei ole,
     * asetetaan "Ei_asetettu"-arvo.
     */
    public void setViinialue(String asetettavaAlue) {
        try {
            this.viinialue = Viinialue.valueOf(asetettavaAlue);
        } catch (Exception e) {
            this.viinialue = Viinialue.Ei_asetettu;
        }
    }

    /**
     *
     * @return palautetaan viinialue-enumin arvo string-muotoisena takaisin. jos
     * ei määritelty, palautetaan null.
     */
    public String getViinialue() {
        if (viinialue == null) {
            return null;
        }
        String palautus = "" + viinialue;
        return palautus;
    }

    /**
     *
     * @return palautetaan muistiinpanoon tallennettu vuosikerta väliltä
     * 1701-2014. Jos arvoa ei ole tai se ei ole halutulla välillä, palautetaan
     * arvona 0.
     */
    public Integer getVuosikerta() {
        if (vuosikerta > 1700 && vuosikerta < 2015) {
            return vuosikerta;
        } else {
            return 0;
        }

    }

    /**
     *
     * @param AsetettavaVuosikerta metodille annetaan int, jos se on väliltä
     * 1701-2014, tallennetaan se vuosikerraksi. Muutetaan muistiinpanon boolean
     * "OnkoVuosikerta" trueksi jos luku oli määritellyllä välillä.
     */
    public void setVuosikerta(int AsetettavaVuosikerta) {
        if (AsetettavaVuosikerta > 1700 && AsetettavaVuosikerta < 2015) {
            this.vuosikerta = AsetettavaVuosikerta;
            onkoVuosikerta = true;
        }
    }

    /**
     *
     * @param AsetettavaVuosiKerta metodille annetaan String arvo, joka
     * yritetään muuttaa Integeriksi ja käytetään metodille setVuosikerta. Jos
     * yritys ei onnistu, ei tehdä mitään.
     */
    public void setVuosikertaStringina(String AsetettavaVuosiKerta) {
        try {
            int vuosikerta = Integer.parseInt(AsetettavaVuosiKerta);
            setVuosikerta(vuosikerta);
        } catch (Exception e) {

        }
    }

    public boolean onkoVuosikerta() {
        return onkoVuosikerta;
    }

    @Override
    public String getVapaaKuvausMuistiinpanoon() {
        return this.vapaaKuvausMuistiinpanoon;
    }

    public void setVapaaKuvausMuistiinpanoon(String vapaaKuvausMuistiinpanoon) {
        this.vapaaKuvausMuistiinpanoon = vapaaKuvausMuistiinpanoon;
    }

    @Override
    public String getTuotteenNimi() {
        if (tuotteenNimi == null) {
            return "tuntematon";
        }
        return tuotteenNimi;
    }

    public void setTuotteenNimi(String asetettavaNimi) {
        tuotteenNimi = asetettavaNimi;
    }

    @Override
    public String getMuistiinpanoPaivamaara() {
        return getMuistiinpanonPaivaKaksinumeroisenaStringina() + "." + getMuistiinpanonKuukausiKaksinumeroisenaStringina() + "." + muistiinpanonVuosi;
    }

    /**
     *
     * @param luettuPaiva annetaan metodille stringi jonka tulisi sisältää
     * päivämäärä muodossa "DD.MM.YYYY". Jos String sisältää 10 merkkiä,
     * annetaan päivä, kuukausi ja vuosi omille set-metodeilleen käsiteltäviksi.
     * Jos jokin menee vikaan, ei tehdä mitään.
     */
    public void setMuistiinpanonPaivamaara(String luettuPaiva) {
        if (luettuPaiva.length() == 10) {
            try {
                String paiva = "" + luettuPaiva.charAt(0) + luettuPaiva.charAt(1);
                String kuukausia = "" + luettuPaiva.charAt(3) + luettuPaiva.charAt(4);
                String vuosia = "" + luettuPaiva.charAt(6) + luettuPaiva.charAt(7) + luettuPaiva.charAt(8) + luettuPaiva.charAt(9);
                setMuistiinpanonPaiva(Integer.parseInt(paiva));
                setMuistiinpanonKuukausi(Integer.parseInt(kuukausia));
                setMuistiinpanonVuosi(Integer.parseInt(vuosia));
            } catch (Exception e) {

            }
        }
    }

    /**
     *
     * @param asetettavaPaiva jos int on väliltä 1-31, asetetaan se päiväksi.
     */
    public void setMuistiinpanonPaiva(int asetettavaPaiva) {
        if (asetettavaPaiva < 32 && asetettavaPaiva > 0) {
            muistiinpanonPaiva = asetettavaPaiva;
        }
    }

    /**
     *
     * @param asetettavaKuukausi jos int on väliltä 1-12, asetetaan se
     * kuukaudeksi.
     */
    public void setMuistiinpanonKuukausi(int asetettavaKuukausi) {
        if (asetettavaKuukausi < 13 && asetettavaKuukausi > 0) {
            muistiinpanonKuukausi = asetettavaKuukausi;
        }
    }

    /**
     *
     * @param asetettavaVuosi jos int on väliltä 1971-2019, asetetaan se
     * vuodeksi.
     */
    public void setMuistiinpanonVuosi(int asetettavaVuosi) {
        if (asetettavaVuosi < 2020 && asetettavaVuosi > 1970) {
            muistiinpanonVuosi = asetettavaVuosi;
        }
    }

    public int getMuistiinpanonPaiva() {
        return muistiinpanonPaiva;
    }

    /**
     *
     * @return jos tallennettu päivä on pienempi kuin 10, palautetaan päivä
     * kaksinumeroisena nollalla. Esim "02".
     */
    public String getMuistiinpanonPaivaKaksinumeroisenaStringina() {
        String paiva = "" + muistiinpanonPaiva;
        if (paiva.length() < 2) {
            paiva = "0" + paiva;
        }
        return paiva;
    }

    /**
     *
     * @return jos tallennettu kuukausi on pienempi kuin 10, palautetaan
     * kuukausi kaksinumeroisena nollalla. Esim "04".
     */
    public String getMuistiinpanonKuukausiKaksinumeroisenaStringina() {
        String kuukausi = "" + muistiinpanonKuukausi;
        if (kuukausi.length() < 2) {
            kuukausi = "0" + kuukausi;
        }
        return kuukausi;
    }

    public int getMuistiinpanonKuukausi() {
        return muistiinpanonKuukausi;
    }

    public int getMuistiinpanonVuosi() {
        return muistiinpanonVuosi;
    }

    /**
     *
     * @return palautetaan viinityyppi String-muodossa. Jos arvo on null,
     * palautetaan null.
     */
    public String getViinityyppi() {
        if (viinityyppi == null) {
            return null;
        }
        String palautus = "" + viinityyppi;
        return palautus;
    }

    /**
     *
     * @param viinityyppi jos String on jokin määritellyistä viinityypeistä,
     * tallennetaan se viinityypiksi. Jos ei ole, tallennetaan viinityypiksi
     * "Ei_asetettu".
     */
    public void setViinityyppi(String viinityyppi) {
        try {
            this.viinityyppi = Viinityyppi.valueOf(viinityyppi);
        } catch (Exception e) {
            this.viinityyppi = Viinityyppi.Ei_asetettu;
        }
    }

    @Override
    public String toString() {
        String palautus = "";
        String uusiRivi = System.getProperty("line.separator");

        palautus += getTunniste() + uusiRivi;
        palautus += getTuotteenNimi() + uusiRivi;
        palautus += getMuistiinpanoPaivamaara() + uusiRivi;

        //Voi olla null
        palautus += getViinityyppi() + uusiRivi;

        palautus += getViinialue() + uusiRivi;
        palautus += getRypaleet() + uusiRivi;

        //Voi olla null
        palautus += getArvioViinista() + uusiRivi;

        palautus += getVapaaKuvausMuistiinpanoon() + uusiRivi;
        palautus += getVuosikerta();

        return palautus;
    }

    @Override
    public String getTunniste() {
        return "viini";
    }
}
