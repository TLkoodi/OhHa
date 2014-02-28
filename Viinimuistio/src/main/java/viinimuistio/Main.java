package viinimuistio;

import javax.swing.SwingUtilities;
import viinimuistio.ui.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
