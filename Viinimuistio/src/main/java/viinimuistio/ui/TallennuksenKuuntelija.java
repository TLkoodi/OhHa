package viinimuistio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.tiedostojenkasittely.MuistiinpanonTallentaja;

/**
 * ActionListener joka tallentaa muistiinpanon
 *
 * @author TLKoodi
 */
public class TallennuksenKuuntelija implements ActionListener {

    private JTextField nimiTextArea;
    private JTextField maistamishetkiTextArea;
    private JTextArea viinityyppiTextArea;
    private JTextField vuosikertaTextArea;
    private JTextArea viinialueTextArea;
    private JTextField rypaleetTextArea;
    private JTextField arvioTextArea;
    private JTextField kuvausTextArea;
    private JLabel palaute;
    private JPanel paivitettava;

    public TallennuksenKuuntelija(JTextField nimiTextArea, JTextField maistamishetkiTextArea, JTextArea viinityyppiTextArea, JTextField vuosikertaTextArea, JTextArea viinialueTextArea, JTextField rypaleetTextArea, JTextField arvioTextArea, JTextField kuvausTextArea, JLabel palauteLabel) {
        this.nimiTextArea = nimiTextArea;
        this.maistamishetkiTextArea = maistamishetkiTextArea;
        this.viinityyppiTextArea = viinityyppiTextArea;
        this.vuosikertaTextArea = vuosikertaTextArea;
        this.viinialueTextArea = viinialueTextArea;
        this.rypaleetTextArea = rypaleetTextArea;
        this.arvioTextArea = arvioTextArea;
        this.kuvausTextArea = kuvausTextArea;
        this.palaute = palauteLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (nimiTextArea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Sinun täytyy antaa muistiinpanollesi nimi", "Virhe", JOptionPane.ERROR_MESSAGE);
        } else if (maistamishetkiTextArea.getText().length() != 10) {
            JOptionPane.showMessageDialog(null, "Päivämäärää ei ole asetettu, tai se ei ole oikeassa muodossa", "Virhe", JOptionPane.ERROR_MESSAGE);
        } else {
            ViiniMuistiinpano viinimuistiinpano = new ViiniMuistiinpano(nimiTextArea.getText());
            viinimuistiinpano.setMuistiinpanonPaivamaara(maistamishetkiTextArea.getText());
            viinimuistiinpano.setViinityyppi(viinityyppiTextArea.getText());
            viinimuistiinpano.setVuosikertaStringina(vuosikertaTextArea.getText());
            viinimuistiinpano.setViinialue(viinialueTextArea.getText());
            viinimuistiinpano.setRypaleet(rypaleetTextArea.getText());
            viinimuistiinpano.setArvioViinistaStringina(arvioTextArea.getText());
            viinimuistiinpano.setVapaaKuvausMuistiinpanoon(kuvausTextArea.getText());
            MuistiinpanonTallentaja muistiinpanonTallentaja = new MuistiinpanonTallentaja(viinimuistiinpano);
            muistiinpanonTallentaja.muokkaaVanhaaMuistiinpanoa();
            palaute.setText("Tallennettu!");
        }

    }
}
