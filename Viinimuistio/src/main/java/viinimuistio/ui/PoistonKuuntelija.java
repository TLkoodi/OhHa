/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import viinimuistio.tiedostojenkasittely.TekstitiedostonTallentaja;

/**
 *
 * @author admin
 */
public class PoistonKuuntelija implements ActionListener{
    
    JLabel valittu;
    
    public PoistonKuuntelija(JLabel valittu){
        this.valittu = valittu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TekstitiedostonTallentaja poistaja = new TekstitiedostonTallentaja();
        poistaja.poistaTiedosto(valittu.getText());
    }
    
}
