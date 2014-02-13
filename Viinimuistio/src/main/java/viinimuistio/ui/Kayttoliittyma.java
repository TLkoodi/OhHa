package viinimuistio.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Viinimuistio");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 2);
        container.setLayout(layout);
        container.add(luoTallennusvalikko());
//        Muistiinpanovalikko valikko = new Muistiinpanovalikko();
//        container.add(valikko);

    }
    

    private JPanel luoTallennusvalikko() {
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

    public JFrame getFrame() {
        return frame;
    }
}
