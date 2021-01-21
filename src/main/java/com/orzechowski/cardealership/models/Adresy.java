package com.orzechowski.cardealership.models;

public class Adresy {
    private int nr_adresu;
    private String miasto;
    private String ulica;
    private String nr_lokalu;
    private int nr_poczty;

    public Adresy(){

    }

    public Adresy(String miasto, String ulica, String nr_lokalu, int nr_poczty) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_lokalu = nr_lokalu;
        this.nr_poczty = nr_poczty;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    public int getNr_poczty() {
        return nr_poczty;
    }

    public void setNr_poczty(int nr_poczty) {
        this.nr_poczty = nr_poczty;
    }
}
