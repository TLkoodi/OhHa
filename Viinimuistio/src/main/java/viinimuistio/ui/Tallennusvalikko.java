/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.ui;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Tony
 */
public class Tallennusvalikko {
    
    
    public JPanel luoTallennusvalikko(){
    JPanel panel = new JPanel(new GridLayout(18, 1));


        JLabel nimiLabel = new JLabel("Tuotteen nimi:");
        JTextArea nimiTextArea = new JTextArea();
        JLabel maistamishetkiLabel = new JLabel("Tuotteen maistamishetki (muodossa DD.MM.YYYY):");
        JTextArea maistamishetkiTextArea = new JTextArea();
        JLabel viinityyppiLabel = new JLabel("Viinityyppi:");
        JTextArea viinityyppiTextArea = new JTextArea();
        JLabel vuosikertaLabel = new JLabel("Vuosikerta:");
        JTextArea vuosikertaTextArea = new JTextArea();
        JLabel viinialueLabel = new JLabel("Viinialue:");
        JLabel rypaleetLabel = new JLabel("Käytetyt rypäleet:");
        JTextArea rypaleetTextArea = new JTextArea();
        JLabel arvioLabel = new JLabel("Arvio tuotteesta (0-5 tähteä):");
        JTextArea arvioTextArea = new JTextArea();
        JLabel kuvausLabel = new JLabel("Vapaa teksti:");
        JTextArea kuvausTextArea = new JTextArea();
        JLabel palauteLabel = new JLabel("");


        // Viinityypin pudotusvalikko

        String[] viiniTyyppiVaihtoehdot = {"", "Punaviini", "Valkoviini", "Kuohuviini", "Portviini", "Jalkiruokaviini", "Muu"};

        final JTextArea valittuViiniTyyppi = new JTextArea();

        final JComboBox viiniTyyppi = new JComboBox(viiniTyyppiVaihtoehdot);

        viiniTyyppi.addItemListener(
                new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    valittuViiniTyyppi.setText((String) viiniTyyppi.getSelectedItem());
                }
            }
        });


        // Viinialueen pudotusvalikko.

        String[] viiniAlueVaihtoehdot = {"", "Argenttiina", "Australia", "Chile", "Espanja", "EtelaAfrikka", "Italia", "Itävalta", "Portugali", "Ranska", "Saksa", "UusiSeelanti", "Yhdysvallat", "Muu"};

        final JTextArea valittuViiniAlue = new JTextArea();

        final JComboBox viiniAlueet = new JComboBox(viiniAlueVaihtoehdot);

        viiniAlueet.addItemListener(
                new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    valittuViiniAlue.setText((String) viiniAlueet.getSelectedItem());
                }
            }
        });

        JButton tallennusnappi = new JButton("Tallenna muistiinpano");

        TallennuksenKuuntelija tallentaja = new TallennuksenKuuntelija(nimiTextArea, maistamishetkiTextArea, valittuViiniTyyppi, vuosikertaTextArea, valittuViiniAlue, rypaleetTextArea, arvioTextArea, kuvausTextArea, valittuViiniAlue, palauteLabel);
        tallennusnappi.addActionListener(tallentaja);

        panel.add(nimiLabel);
        panel.add(nimiTextArea);
        panel.add(maistamishetkiLabel);
        panel.add(maistamishetkiTextArea);
        panel.add(viinityyppiLabel);
        panel.add(viiniTyyppi);
        panel.add(viinialueLabel);
        panel.add(viiniAlueet);
        panel.add(vuosikertaLabel);
        panel.add(vuosikertaTextArea);
        panel.add(rypaleetLabel);
        panel.add(rypaleetTextArea);
        panel.add(arvioLabel);
        panel.add(arvioTextArea);
        panel.add(kuvausLabel);
        panel.add(kuvausTextArea);
        panel.add(tallennusnappi);
        panel.add(palauteLabel);

        return panel;
    }
    
}
