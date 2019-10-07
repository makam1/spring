package com.sa.filrouge.modele;

import lombok.Data;

import javax.persistence.Entity;

public class Frais {

    private int id;

    private int de;

    private int a;

    private int frais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDe() {
        return de;
    }

    public void setDe(int de) {
        this.de = de;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getFrais() {
        return frais;
    }

    public void setFrais(int frais) {
        this.frais = frais;
    }


}
