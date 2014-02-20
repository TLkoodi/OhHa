/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viinimuistio.ui;

import java.awt.GridLayout;
import static java.rmi.Naming.list;
import java.util.*;
import static java.util.Collections.list;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import viinimuistio.tiedostojenkasittely.TiedostojenListaaja;

/**
 *
 * @author Tony
 */
public class Muistiinpanovalikko {

    public JPanel luoMuistiinpanovalikko() {
        JPanel panel = new JPanel (new GridLayout(1,1));
        panel.add(luoMuistiinpanolistaus());
        return panel;
    }
    
    private JPanel luoMuistiinpanolistaus(){
        JPanel panel = new JPanel(new GridLayout(1, 1));
        
        TiedostojenListaaja listaaja = new TiedostojenListaaja();
        
        List<String> tunnistetutMuistiinpanojenNimet = listaaja.listaaKansionTiedostot();
        
        String[] listallaOlevatNimet = new String[tunnistetutMuistiinpanojenNimet.size()];
        
        listallaOlevatNimet = tunnistetutMuistiinpanojenNimet.toArray(listallaOlevatNimet);
        
        JList<String> muistiinpanoLista = new JList<String>();
        
        muistiinpanoLista.setListData(listallaOlevatNimet);
        
        panel.add(muistiinpanoLista);
        
        return panel;
    }

}
