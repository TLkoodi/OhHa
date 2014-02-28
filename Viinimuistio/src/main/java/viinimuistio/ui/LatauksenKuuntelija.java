package viinimuistio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.tiedostojenkasittely.ViiniMuistiinpanonTiedostoLukija;

/**
 * ActionListener joka siirtää tiedoston käsiteltäväksi
 *
 * @author TLKoodi
 */
public class LatauksenKuuntelija implements ActionListener {

    private JTextField nimiTextArea;
    private JTextField maistamishetkiTextArea;
    private JTextArea viinityyppiTextArea;
    private JTextField vuosikertaTextArea;
    private JTextArea viinialueTextArea;
    private JTextField rypaleetTextArea;
    private JTextField arvioTextArea;
    private JTextField kuvausTextArea;
    private JLabel palaute;
    private JLabel valittu;
    private JComboBox viiniAlue;
    private JComboBox viiniTyyppi;

    public LatauksenKuuntelija(JTextField nimiTextArea, JTextField maistamishetkiTextArea, JTextArea viinityyppiTextArea, JTextField vuosikertaTextArea, JTextArea viinialueTextArea, JTextField rypaleetTextArea, JTextField arvioTextArea, JTextField kuvausTextArea, JLabel palauteLabel, JComboBox viiniTyyppi, JComboBox viiniAlue, JLabel valittu) {
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
            palaute.setText("Muistiinpano ladattu.");
        }
    }
}
