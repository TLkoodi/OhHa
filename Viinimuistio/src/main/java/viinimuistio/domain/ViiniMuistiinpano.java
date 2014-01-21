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
    private int arvioViinista;

    public ViiniMuistiinpano(String nimi) {
        this.onkoVuosikerta = false;
        this.nimi = nimi;
    }

    public Integer getArvioViinista() {
        if (arvioViinista >= 0 || arvioViinista < 6) {
            return arvioViinista;
        }
        return null;
    }

    public void setArvioViinista(int arvioViinista) {
        if (arvioViinista < 6 && arvioViinista >= 0) {
            this.arvioViinista = arvioViinista;
        }
    }

    public void setViinialue(Viinialue asetettavaAlue) {
        alue = asetettavaAlue;
    }

    public String getViinialue() {
        if (alue == null){
            return null;
        }
        String palautus = "" + alue;
        return palautus;
    }

    public Integer getVuosikerta() {
        if (onkoVuosikerta) {
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
    
    public boolean onkoVuosikerta(){
        return onkoVuosikerta;
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
        if (asetettavaPaiva < 32 && asetettavaPaiva > 0) {
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
