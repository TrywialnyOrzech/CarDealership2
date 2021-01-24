package com.orzechowski.cardealership.models;

public class Salony {
    private int nr_salonu;
    private String nazwa;
    private String status;
    private int nr_biura;

    public Salony() {

    }

    public Salony(String nazwa, String status, int nr_biura) {
        this.nazwa = nazwa;
        this.status = status;
        this.nr_biura = nr_biura;
    }

    public int getNr_salonu() {
        return nr_salonu;
    }

    public void setNr_salonu(int nr_salonu) {
        this.nr_salonu = nr_salonu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNr_biura() {
        return nr_biura;
    }

    public void setNr_biura(int nr_biura) {
        this.nr_biura = nr_biura;
    }
}
