package viinimuistio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.tiedostojenkasittely.MuistiinpanonTallentaja;

/**
 * ActionListener joka tallentaa muistiinpanon
 *
 * @author TLKoodi
 */
public class TallennuksenKuuntelija implements ActionListener {

    private JTextArea nimiTextArea;
    private JTextArea maistamishetkiTextArea;
    private JTextArea viinityyppiTextArea;
    private JTextArea vuosikertaTextArea;
    private JTextArea viinialueTextArea;
    private JTextArea rypaleetTextArea;
    private JTextArea arvioTextArea;
    private JTextArea kuvausTextArea;
    private JLabel palaute;
    private JPanel paivitettava;

    public TallennuksenKuuntelija(JTextArea nimiTextArea, JTextArea maistamishetkiTextArea, JTextArea viinityyppiTextArea, JTextArea vuosikertaTextArea, JTextArea viinialueTextArea, JTextArea rypaleetTextArea, JTextArea arvioTextArea, JTextArea kuvausTextArea, JLabel palauteLabel) {
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
        if (maistamishetkiTextArea.getText().length() != 10) {
            JOptionPane.showMessageDialog(null, "Päivämääräsi ei ole oikeassa muodossa", "Virhe", JOptionPane.ERROR_MESSAGE);

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
