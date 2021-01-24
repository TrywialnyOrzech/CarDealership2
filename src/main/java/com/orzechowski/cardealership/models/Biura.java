package com.orzechowski.cardealership.models;

import java.sql.Date;

public class Biura {
    private int nr_biura;
    private String nazwa;
    private Date data_zalozenia;
    private int nr_adresu;

    public Biura() {

    }

    public Biura(String nazwa, Date data_zalozenia, int nr_adresu) {
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
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

    public Date getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Date data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
