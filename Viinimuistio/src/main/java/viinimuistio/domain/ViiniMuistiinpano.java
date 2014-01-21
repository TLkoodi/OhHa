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
    private int paiva = 1;
    private int kuukausi = 1;
    private int vuosi = 2014;
    
    public ViiniMuistiinpano(String nimi){
        this.nimi = nimi;
    }

    @Override
    public String getNimi() {
       return nimi;
    }
    
    public void setNimi(String asetettavaNimi){
        nimi = asetettavaNimi;
    }

    @Override
    public String getMuistiinpanoPaivamaara() {
        return paiva + "." + kuukausi + "." + vuosi;
    }
    
    public void setPaiva(int asetettavaPaiva){
        if (asetettavaPaiva > 32 || asetettavaPaiva > 0){
            paiva = asetettavaPaiva;
        }
    }
    
    public void setKuukausi(int asetettavaKuukausi){
        if (asetettavaKuukausi < 13 && asetettavaKuukausi > 0){
            kuukausi = asetettavaKuukausi;
        }
    }
    
    public void setVuosi(int asetettavaVuosi){
        if (asetettavaVuosi < 2020 && asetettavaVuosi > 1970){
            vuosi = asetettavaVuosi;
        }
    }

    public int getPaiva() {
        return paiva;
    }

    public int getKuukausi() {
        return kuukausi;
    }

    public int getVuosi() {
        return vuosi;
    }
    
}
