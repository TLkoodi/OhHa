package viinimuistio.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Viinimuistio");
        frame.setPreferredSize(new Dimension(1000, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(17, 1);
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
        JTextArea viinialueTextArea = new JTextArea();
        JLabel rypaleetLabel = new JLabel("Käytetyt rypäleet:");
        JTextArea rypaleetTextArea = new JTextArea();
        JLabel arvioLabel = new JLabel("Arvio tuotteesta (0-5 tähteä):");
        JTextArea arvioTextArea = new JTextArea();
        JLabel kuvausLabel = new JLabel("Vapaa teksti:");
        JTextArea kuvausTextArea = new JTextArea();
        
        JButton tallennusnappi = new JButton("Tallenna muistiinpano");
        
        KenttienTallentaja tallentaja = new KenttienTallentaja(nimiTextArea, maistamishetkiTextArea, viinityyppiTextArea, vuosikertaTextArea, viinialueTextArea, rypaleetTextArea, arvioTextArea, kuvausTextArea);
        tallennusnappi.addActionListener(tallentaja);
        
        
        container.add(nimiLabel);
        container.add(nimiTextArea);
        container.add(maistamishetkiLabel);
        container.add(maistamishetkiTextArea);
        container.add(viinityyppiLabel);
        container.add(viinityyppiTextArea);
        container.add(vuosikertaLabel);
        container.add(vuosikertaTextArea);
        container.add(viinialueLabel);
        container.add(viinialueTextArea);
        container.add(rypaleetLabel);
        container.add(rypaleetTextArea);
        container.add(arvioLabel);
        container.add(arvioTextArea);
        container.add(kuvausLabel);
        container.add(kuvausTextArea);
        container.add(tallennusnappi);
    }

    public JFrame getFrame() {
        return frame;
    }
}
