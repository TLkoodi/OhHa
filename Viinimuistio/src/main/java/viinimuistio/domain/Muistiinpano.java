package viinimuistio.domain;

/**
 * Luokka toimii rajapintana, jos ohjelmaa halutaan jatkossa laajentaa viinimuistiinpanoista myös muille muistiinpanoille.
 */

public interface Muistiinpano {
    
    /**
     *  
     * @return palautuvaa Stringiä voidaan käyttää apuna minkä tyylinen muistiinpano on kysessä. Esim "viini" tai "olut".
     */

    String getTunniste();
    
    /**
     * 
     * @return palautuvaa arvoa käytetään muistiinpanon yksilöimisessä, sekä tiedostonimenä. 
     */

    String getTuotteenNimi();

    /**
     * 
     * @return palautuvaa arvoa voidaan käyttää apuna päivämäärien ryhmittelyssä. 
     */
    
    String getMuistiinpanoPaivamaara();
    
    /**
     * 
     * @return palautuva arvo on vapaa muistiinpanoon sisältyvä teksti.
     */

    String getVapaaKuvausMuistiinpanoon();

    @Override
    String toString();
}
