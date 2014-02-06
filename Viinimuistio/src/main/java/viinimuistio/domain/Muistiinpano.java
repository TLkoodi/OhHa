package viinimuistio.domain;

/**
 * Luokka toimii rajapintana, jos ohjelmaa halutaan jatkossa laajentaa viinimuistiinpanoista myös muille muistiinpanoille.
 */

public interface Muistiinpano {

    String getTunniste();

    String getTuotteenNimi();

    String getMuistiinpanoPaivamaara();

    String getVapaaKuvausMuistiinpanoon();

    String toString();
}
