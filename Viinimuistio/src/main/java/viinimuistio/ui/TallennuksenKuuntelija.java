/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import viinimuistio.domain.ViiniMuistiinpano;
import viinimuistio.tiedostojenkasittely.MuistiinpanonTallentaja;

/**
 *
 * @author lexlex@cs
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
    private JTextArea viiniAlue;
    private JLabel palaute;

    public TallennuksenKuuntelija(JTextArea nimiTextArea, JTextArea maistamishetkiTextArea, JTextArea viinityyppiTextArea, JTextArea vuosikertaTextArea, JTextArea viinialueTextArea, JTextArea rypaleetTextArea, JTextArea arvioTextArea, JTextArea kuvausTextArea, JTextArea viiniAlue, JLabel palauteLabel) {
        this.nimiTextArea = nimiTextArea;
        this.maistamishetkiTextArea = maistamishetkiTextArea;
        this.viinityyppiTextArea = viinityyppiTextArea;
        this.vuosikertaTextArea = vuosikertaTextArea;
        this.viinialueTextArea = viinialueTextArea;
        this.rypaleetTextArea = rypaleetTextArea;
        this.arvioTextArea = arvioTextArea;
        this.kuvausTextArea = kuvausTextArea;
        this.viiniAlue = viiniAlue;
        this.palaute = palauteLabel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ViiniMuistiinpano viinimuistiinpano = new ViiniMuistiinpano(nimiTextArea.getText());
        viinimuistiinpano.setMuistiinpanonPaivamaara(maistamishetkiTextArea.getText());
        viinimuistiinpano.setViinityyppi(viinityyppiTextArea.getText());
        viinimuistiinpano.setVuosikertaStringina(vuosikertaTextArea.getText());
        viinimuistiinpano.setViinialue(viinialueTextArea.getText());       
        viinimuistiinpano.setRypaleet(rypaleetTextArea.getText());
        viinimuistiinpano.setArvioViinistaStringina(arvioTextArea.getText());
        viinimuistiinpano.setVapaaKuvausMuistiinpanoon(kuvausTextArea.getText());
        MuistiinpanonTallentaja muistiinpanonTallentaja = new MuistiinpanonTallentaja(viinimuistiinpano);
        muistiinpanonTallentaja.tallennaUusiMuistiinpano();
        palaute.setText("Tallennettu!");
    }
    
}
