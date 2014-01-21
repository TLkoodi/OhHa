package viinimuistio;

import viinimuistio.domain.ViiniMuistiinpano;
import static viinimuistio.domain.Viinialue.*;

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
        System.out.println(muistiinpano.getViinialue());
    }
}
