package viinimuistio;

import viinimuistio.domain.ViiniMuistiinpano;
import static viinimuistio.domain.Viinialue.*;
import viinimuistio.tiedostojenkasittely.*;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ){
        
        
        MuistiinpanonTiedostoLukija lukija = new MuistiinpanonTiedostoLukija();
        lukija.asetaTiedosto("testitiedosto");
        ViiniMuistiinpano muistiinpano = lukija.tuoViiniTiedosto();
        if (muistiinpano == null){
            System.out.println("Ei lukenut tiedostoa");
        }
        System.out.println(muistiinpano.getTuotteenNimi());
        
    }
}
