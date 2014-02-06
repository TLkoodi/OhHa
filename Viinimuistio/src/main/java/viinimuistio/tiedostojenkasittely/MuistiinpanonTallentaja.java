/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.tiedostojenkasittely;

import viinimuistio.domain.Muistiinpano;

public class MuistiinpanonTallentaja {

    Muistiinpano muistiinpano;

    public MuistiinpanonTallentaja(Muistiinpano muistiinpano) {
        this.muistiinpano = muistiinpano;
    }

    public boolean tallennaUusiMuistiinpano() {
        TekstitiedostonTallentaja tallentaja = new TekstitiedostonTallentaja();
        return tallentaja.luoUusiTiedosto(muistiinpano.getTuotteenNimi(), muistiinpano.muistiinpanonTiedotStringiin());
    }
}
