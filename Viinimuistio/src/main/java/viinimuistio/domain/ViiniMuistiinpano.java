/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viinimuistio.domain;

/**
 *
 * @author Tony
 */
public class ViiniMuistiinpano implements Muistiinpano {
    
    private String nimi;
    private String paivamaara;

    @Override
    public String getNimi() {
       return nimi;
    }
    
    public void setNimi(String asetettavaNimi){
        nimi = asetettavaNimi;
    }

    @Override
    public String getMuistiinpanoPaivamaara() {
        return paivamaara;
    }
    
    public void setPaivamaara(int paiva, int kuukausi, int vuosi){
        
    }
    
}
