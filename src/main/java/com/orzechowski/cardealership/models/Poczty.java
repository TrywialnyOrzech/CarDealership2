package com.orzechowski.cardealership.models;

public class Poczty {
    private int nr_poczty;
    private String kod_poczty;
    private String poczta;

    public Poczty(){

    }

    public Poczty(String kod_poczty, String poczta) {
        this.kod_poczty = kod_poczty;
        this.poczta = poczta;
    }

    public int getNr_poczty() {
        return nr_poczty;
    }

    public void setNr_poczty(int nr_poczty) {
        this.nr_poczty = nr_poczty;
    }

    public String getKod_poczty() {
        return kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        this.kod_poczty = kod_poczty;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }
}
