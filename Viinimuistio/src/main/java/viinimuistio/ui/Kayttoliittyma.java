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
        GridLayout layout = new GridLayout(1, 3);
        container.setLayout(layout);
        Tallennusvalikko tallennusvalikko = new Tallennusvalikko();
        container.add(tallennusvalikko.luoTallennusvalikko());
        container.add(luoMuistiinpanovalikonPainikkeet());
        Muistiinpanovalikko valikko = new Muistiinpanovalikko();
        container.add(valikko.luoMuistiinpanovalikko());

    }
    
        private JPanel luoMuistiinpanovalikonPainikkeet(){
        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton latausnappi = new JButton("latausnappi");
        panel.add(latausnappi);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
