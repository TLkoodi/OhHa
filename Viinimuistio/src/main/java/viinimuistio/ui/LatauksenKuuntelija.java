package viinimuistio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.tiedostojenkasittely.ViiniMuistiinpanonTiedostoLukija;

/**
 * ActionListener joka siirtää tiedoston käsiteltäväksi
 *
 * @author TLKoodi
 */
public class LatauksenKuuntelija implements ActionListener {

    private JTextArea nimiTextArea;
    private JTextArea maistamishetkiTextArea;
    private JTextArea viinityyppiTextArea;
    private JTextArea vuosikertaTextArea;
    private JTextArea viinialueTextArea;
    private JTextArea rypaleetTextArea;
    private JTextArea arvioTextArea;
    private JTextArea kuvausTextArea;
    private JLabel palaute;
    private JLabel valittu;
    private JComboBox viiniAlue;
    private JComboBox viiniTyyppi;

    public LatauksenKuuntelija(JTextArea nimiTextArea, JTextArea maistamishetkiTextArea, JTextArea viinityyppiTextArea, JTextArea vuosikertaTextArea, JTextArea viinialueTextArea, JTextArea rypaleetTextArea, JTextArea arvioTextArea, JTextArea kuvausTextArea, JLabel palauteLabel, JComboBox viiniTyyppi, JComboBox viiniAlue, JLabel valittu) {
        this.nimiTextArea = nimiTextArea;
        this.maistamishetkiTextArea = maistamishetkiTextArea;
        this.viinityyppiTextArea = viinityyppiTextArea;
        this.vuosikertaTextArea = vuosikertaTextArea;
        this.viinialueTextArea = viinialueTextArea;
        this.rypaleetTextArea = rypaleetTextArea;
        this.arvioTextArea = arvioTextArea;
        this.kuvausTextArea = kuvausTextArea;
        this.palaute = palauteLabel;
        this.valittu = valittu;
        this.viiniAlue = viiniAlue;
        this.viiniTyyppi = viiniTyyppi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ViiniMuistiinpanonTiedostoLukija lukija = new ViiniMuistiinpanonTiedostoLukija();
        lukija.asetaTiedosto(valittu.getText());
        ViiniMuistiinpano muistiinpano = new ViiniMuistiinpano();
        muistiinpano = lukija.tuoViiniTiedosto();
        if (muistiinpano != null) {
            nimiTextArea.setText(muistiinpano.getTuotteenNimi());
            maistamishetkiTextArea.setText(muistiinpano.getMuistiinpanoPaivamaara());
            viiniTyyppi.setSelectedItem(muistiinpano.getViinityyppi());
            viiniAlue.setSelectedItem(muistiinpano.getViinialue());
            vuosikertaTextArea.setText("" + muistiinpano.getVuosikerta());
            rypaleetTextArea.setText(muistiinpano.getRypaleet());
            arvioTextArea.setText("" + muistiinpano.getArvioViinista());
            kuvausTextArea.setText(muistiinpano.getVapaaKuvausMuistiinpanoon());
            palaute.setText("Muistiinpano tuotu");
        }
    }
}
