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

    private String tuotteenNimi;    
    private Viinityyppi viinityyppi;    
    private Viinialue viinialue;    
    private String rypaleet;
    private int vuosikerta;
    private int arvioViinista;
    private String vapaaKuvausMuistiinpanoon = "";    
    private int muistiinpanonPaiva = 1;
    private int muistiinpanonKuukausi = 1;
    private int muistiinpanonVuosi = 2014;    
    private boolean onkoVuosikerta;

    public ViiniMuistiinpano(String nimi) {
        this.onkoVuosikerta = false;
        this.tuotteenNimi = nimi;
    }

    public String getRypaleet() {
        return rypaleet;
    }

    public void setRypaleet(String rypaleet) {
        this.rypaleet = rypaleet;
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
        viinialue = asetettavaAlue;
    }

    public String getViinialue() {
        if (viinialue == null) {
            return null;
        }
        String palautus = "" + viinialue;
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

    public boolean onkoVuosikerta() {
        return onkoVuosikerta;
    }

    @Override
    public String getVapaaKuvausMuistiinpanoon() {
        return this.vapaaKuvausMuistiinpanoon;
    }

    public void setVapaaKuvausMuistiinpanoon(String vapaaKuvausMuistiinpanoon) {
        this.vapaaKuvausMuistiinpanoon = vapaaKuvausMuistiinpanoon;
    }

    @Override
    public String getTuotteenNimi() {
        return tuotteenNimi;
    }

    public void setTuotteenNimi(String asetettavaNimi) {
        tuotteenNimi = asetettavaNimi;
    }

    @Override
    public String getMuistiinpanoPaivamaara() {
        return muistiinpanonPaiva + "." + muistiinpanonKuukausi + "." + muistiinpanonVuosi;
    }

    public void setMuistiinpanonPaiva(int asetettavaPaiva) {
        if (asetettavaPaiva < 32 && asetettavaPaiva > 0) {
            muistiinpanonPaiva = asetettavaPaiva;
        }
    }

    public void setMuistiinpanonKuukausi(int asetettavaKuukausi) {
        if (asetettavaKuukausi < 13 && asetettavaKuukausi > 0) {
            muistiinpanonKuukausi = asetettavaKuukausi;
        }
    }

    public void setVuosi(int asetettavaVuosi) {
        if (asetettavaVuosi < 2020 && asetettavaVuosi > 1970) {
            muistiinpanonVuosi = asetettavaVuosi;
        }
    }

    public int getMuistiinpanonPaiva() {
        return muistiinpanonPaiva;
    }

    public int getMuistiinpanonKuukausi() {
        return muistiinpanonKuukausi;
    }

    public int getVuosi() {
        return muistiinpanonVuosi;
    }

}
