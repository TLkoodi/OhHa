package viinimuistio.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
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

        GridLayout layout = new GridLayout(18, 1);
        container.setLayout(layout);


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

        KenttienTallentaja tallentaja = new KenttienTallentaja(nimiTextArea, maistamishetkiTextArea, valittuViiniTyyppi, vuosikertaTextArea, valittuViiniAlue, rypaleetTextArea, arvioTextArea, kuvausTextArea, valittuViiniAlue, palauteLabel);
        tallennusnappi.addActionListener(tallentaja);

        container.add(nimiLabel);
        container.add(nimiTextArea);
        container.add(maistamishetkiLabel);
        container.add(maistamishetkiTextArea);
        container.add(viinityyppiLabel);
        container.add(viiniTyyppi);
        container.add(viinialueLabel);
        container.add(viiniAlueet);
        container.add(vuosikertaLabel);
        container.add(vuosikertaTextArea);
        container.add(rypaleetLabel);
        container.add(rypaleetTextArea);
        container.add(arvioLabel);
        container.add(arvioTextArea);
        container.add(kuvausLabel);
        container.add(kuvausTextArea);
        container.add(tallennusnappi);
        container.add(palauteLabel);
    }

    public JFrame getFrame() {
        return frame;
    }
}
