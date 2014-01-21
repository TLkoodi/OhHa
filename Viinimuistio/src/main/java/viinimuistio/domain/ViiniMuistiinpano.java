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
    private String kuvaus = "";
    private int vuosikerta;
    private boolean onkoVuosikerta;
    private Viinialue alue;
    
    
    public ViiniMuistiinpano(String nimi) {
        this.onkoVuosikerta = false;
        this.nimi = nimi;
    }
    
    public void setViinialue(Viinialue asetettavaAlue){
        alue = asetettavaAlue;
    }
    
    public Viinialue getViinialue(){
        return alue;
    }

    public Integer getVuosikerta() {
        if (onkoVuosikerta){        
            return vuosikerta;
        } else {
            return null;
        }
        
    }

    public void setVuosikerta(int AsetettavaVuosikerta) {
        if (AsetettavaVuosikerta > 1700 && AsetettavaVuosikerta < 2015) {
            this.vuosikerta = AsetettavaVuosikerta;
            onkoVuosikerta = true;
        }
    }


    @Override
    public String getKuvaus() {
        return this.kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String asetettavaNimi) {
        nimi = asetettavaNimi;
    }

    @Override
    public String getMuistiinpanoPaivamaara() {
        return paiva + "." + kuukausi + "." + vuosi;
    }

    public void setPaiva(int asetettavaPaiva) {
        if (asetettavaPaiva > 32 || asetettavaPaiva > 0) {
            paiva = asetettavaPaiva;
        }
    }

    public void setKuukausi(int asetettavaKuukausi) {
        if (asetettavaKuukausi < 13 && asetettavaKuukausi > 0) {
            kuukausi = asetettavaKuukausi;
        }
    }

    public void setVuosi(int asetettavaVuosi) {
        if (asetettavaVuosi < 2020 && asetettavaVuosi > 1970) {
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
