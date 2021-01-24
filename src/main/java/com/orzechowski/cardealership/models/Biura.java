package com.orzechowski.cardealership.models;

import java.sql.Date;

public class Biura {
    private int nr_biura;
    private String nazwa;
    private Date data_zalozenia;
    private int nr_adresu;

    public Biura() {

    }

    public Biura(String nazwa, Date dataZalozenia, int nr_adresu) {
        this.nazwa = nazwa;
        this.data_zalozenia = dataZalozenia;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_biura() {
        return nr_biura;
    }

    public void setNr_biura(int nr_biura) {
        this.nr_biura = nr_biura;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataZalozenia() {
        return data_zalozenia;
    }

    public void setDataZalozenia(Date dataZalozenia) {
        this.data_zalozenia = dataZalozenia;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
