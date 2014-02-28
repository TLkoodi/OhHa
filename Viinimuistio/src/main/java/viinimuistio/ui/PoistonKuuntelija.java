package viinimuistio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import viinimuistio.tiedostojenkasittely.TekstitiedostonKasittelija;

/**
 * ActionListener joka poistaa tiedoston
 *
 * @author TLKoodi
 */
public class PoistonKuuntelija implements ActionListener {

    JLabel valittu;
    JLabel palaute;

    public PoistonKuuntelija(JLabel valittu, JLabel palauteLabel) {
        this.valittu = valittu;
        this.palaute = palauteLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TekstitiedostonKasittelija poistaja = new TekstitiedostonKasittelija();
        boolean poistuiko = poistaja.poistaTiedosto(valittu.getText());
        if (poistuiko) {
            palaute.setText("Poistettu!");
        } else {
            palaute.setText("Poisto ei onnistunut!");
        }
    }

}
