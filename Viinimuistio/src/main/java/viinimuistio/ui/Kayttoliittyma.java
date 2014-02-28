package viinimuistio.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import viinimuistio.tiedostojenkasittely.TiedostojenListaaja;

/**
 * Ohjelman käyttöliittymä
 *
 * @author TLKoodi
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    JLabel nimiLabel = new JLabel("Tuotteen nimi:");
    JTextField nimiTextArea = new JTextField();
    JLabel maistamishetkiLabel = new JLabel("Tuotteen maistamishetki (muodossa DD.MM.YYYY):");
    JTextField maistamishetkiTextArea = new JTextField();
    JLabel viinityyppiLabel = new JLabel("Viinityyppi:");
    JTextField viinityyppiTextArea = new JTextField();
    JLabel vuosikertaLabel = new JLabel("Vuosikerta:");
    JTextField vuosikertaTextArea = new JTextField();
    JLabel viinialueLabel = new JLabel("Viinin valmistusalue:");
    JLabel rypaleetLabel = new JLabel("Käytetyt rypäleet:");
    JTextField rypaleetTextArea = new JTextField();
    JLabel arvioLabel = new JLabel("Arvio tuotteesta (0-5 tähteä):");
    JTextField arvioTextArea = new JTextField();
    JLabel kuvausLabel = new JLabel("Vapaa teksti:");
    JTextField kuvausTextArea = new JTextField();
    JLabel palauteLabel = new JLabel("");
    JLabel valittu = new JLabel("");
    JList muistiinpanoLista;
    JPanel muistiinpanovalikko;
    private Timer timer;
    DefaultListModel model;

    /**
     * Viinityyppi-pudotusvalikon vaihtoehdot
     */
    String[] viiniTyyppiVaihtoehdot = {"", "Punaviini", "Valkoviini", "Kuohuviini", "Portviini", "Jalkiruokaviini", "Muu"};
    final JTextArea valittuViiniTyyppi = new JTextArea();
    final JComboBox viiniTyyppi = new JComboBox(viiniTyyppiVaihtoehdot);

    /**
     * Viinialue-pudotusvalikon vaihtoehdot
     */
    String[] viiniAlueVaihtoehdot = {"", "Argenttiina", "Australia", "Chile", "Espanja", "EtelaAfrikka", "Italia", "Itävalta", "Portugali", "Ranska", "Saksa", "UusiSeelanti", "Yhdysvallat", "Muu"};
    final JTextArea valittuViiniAlue = new JTextArea();
    final JComboBox viiniAlueet = new JComboBox(viiniAlueVaihtoehdot);

    public Kayttoliittyma() {
    }

    @Override
    public void run() {

        frame = new JFrame("Viinimuistio");
        frame.setPreferredSize(new Dimension(800, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 2);
        container.setLayout(layout);
        container.add(luoTallennusvalikko());
        JPanel muistiinpanovalikko = new JPanel();
        muistiinpanovalikko = luoMuistiinpanovalikko();
        this.muistiinpanovalikko = muistiinpanovalikko;
        container.add(this.muistiinpanovalikko);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Luo vasemmanpuoleisen osan ohjelman käyttöliittymästä
     */
    public JPanel luoTallennusvalikko() {
        JPanel panel = new JPanel(new GridLayout(18, 1));

        viiniTyyppi.addItemListener(
                new ItemListener() {
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            valittuViiniTyyppi.setText((String) viiniTyyppi.getSelectedItem());
                        }
                    }
                });

        viiniAlueet.addItemListener(
                new ItemListener() {
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            valittuViiniAlue.setText((String) viiniAlueet.getSelectedItem());
                        }
                    }
                });

        JButton tallennusnappi = new JButton("Tallenna muistiinpano");

        TallennuksenKuuntelija tallentaja = new TallennuksenKuuntelija(nimiTextArea, maistamishetkiTextArea, valittuViiniTyyppi, vuosikertaTextArea, valittuViiniAlue, rypaleetTextArea, arvioTextArea, kuvausTextArea, palauteLabel);
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

    public JPanel luoMuistiinpanovalikonPainikkeet() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton latausnappi = new JButton("Muokkaa");
        JButton poistonappi = new JButton("Poista valittu muistiinpano");
        LatauksenKuuntelija lataaja = new LatauksenKuuntelija(nimiTextArea, maistamishetkiTextArea, valittuViiniTyyppi, vuosikertaTextArea, valittuViiniAlue, rypaleetTextArea, arvioTextArea, kuvausTextArea, palauteLabel, viiniTyyppi, viiniAlueet, valittu);
        PoistonKuuntelija poistaja = new PoistonKuuntelija(valittu, palauteLabel);
        latausnappi.addActionListener(lataaja);
        poistonappi.addActionListener(poistaja);

        panel.add(latausnappi);
        panel.add(poistonappi);
        return panel;
    }

    /**
     * Luo oikeanpuoleisen osan käyttöliittymästä
     *
     */
    public JPanel luoMuistiinpanovalikko() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(luoMuistiinpanolistaus());
        panel.add(luoMuistiinpanovalikonPainikkeet());
        return panel;
    }

    private JPanel luoMuistiinpanolistaus() {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(getMuistiinpanolistaus());
        return panel;
    }

    private JScrollPane getMuistiinpanolistaus() {
        final TiedostojenListaaja listaaja = new TiedostojenListaaja();

        List<String> tunnistetutMuistiinpanojenNimet = listaaja.listaaKansionTiedostot();

        String[] listallaOlevatNimet = new String[tunnistetutMuistiinpanojenNimet.size()];

        listallaOlevatNimet = tunnistetutMuistiinpanojenNimet.toArray(listallaOlevatNimet);
        
        
        JList<String> muistiinpanoLista = new JList<String>();

        muistiinpanoLista.setListData(listallaOlevatNimet);
        

        muistiinpanoLista.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    JList source = (JList) event.getSource();
                    valittu.setText(source.getSelectedValue().toString());
                }
            }
        });
        

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(muistiinpanoLista);
        return scrollPane;
    }


    

}
