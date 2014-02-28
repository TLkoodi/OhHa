package viinimuistio.tiedostojenkasittely;

import viinimuistio.domain.Muistiinpano;

/**
 * Tallentaa konstruktorissa annetun muistiinpano-rajapinnan toteuttajan
 * tiedostoon.
 *
 * @author TLKoodi
 */
public class MuistiinpanonTallentaja {

    /**
     * Muistiinpano jota halutaan käsitellä. Arvo asetetaan konstruktorissa.
     */
    private Muistiinpano muistiinpano;

    /**
     *
     * @param muistiinpano muistiinpano jota halutaan käsitellä tässä luokassa
     */
    public MuistiinpanonTallentaja(Muistiinpano muistiinpano) {
        this.muistiinpano = muistiinpano;
    }

    /**
     * Tallentaa uuden muistiinpanon tekstitiedostoon käyttäen
     * TekstitiedostonKasittelija-luokkaa. Ei voida käyttää olemassaolevan
     * tiedoston muokkaamiseen.
     *
     * @return palauttaa true/false sen perusteella mitä
     * TekstitiedostonKasittelija-luokan luoUusiTiedosto-metodi on palauttanut.
     */
    public boolean tallennaUusiMuistiinpano() {
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        return tallentaja.luoUusiTiedosto(muistiinpano.getTuotteenNimi(), muistiinpano.toString());
    }

    /**
     * Tallentaa vanhan muokatun tai kokonaan uuden muistiinpanon
     * tekstitiedostoon käyttäen TekstitiedostonKasittelija-luokkaa. Voidaan
     * käyttää ylikirjoittamaan vanha muistiinpano ja päivittämään se.
     *
     * @return palauttaa true/false sen perusteella mitä
     * TekstitiedostonKasittelija-luokan
     * kirjoitaOlemassaOlevaanTiedostoon-metodi on palauttanut.
     */
    public boolean muokkaaVanhaaMuistiinpanoa() {
        TekstitiedostonKasittelija tallentaja = new TekstitiedostonKasittelija();
        return tallentaja.kirjoitaOlemassaOlevaanTiedostoon(muistiinpano.getTuotteenNimi(), muistiinpano.toString());
    }
}
