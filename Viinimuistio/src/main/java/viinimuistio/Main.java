package viinimuistio;

import viinimuistio.domain.ViiniMuistiinpano;
import static viinimuistio.domain.Viinialue.*;
import viinimuistio.tiedostojenkasittely.MuistiinpanojenTallentaja;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano("Muistiinpanon nimi");
        muistiinpano.setViinialue(Ranska);
        MuistiinpanojenTallentaja tallentaja = new MuistiinpanojenTallentaja();
        tallentaja.luoTiedosto("testitiedosto");
        tallentaja.kirjoitaTiedostoon("testitiedosto", "tiedostokirjoitus");
        System.out.println(muistiinpano.getViinialue());
    }
}
