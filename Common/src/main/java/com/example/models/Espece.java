package com.example.models;

import java.io.Serializable;

public class Espece implements Serializable {

    protected String especeName;
    protected int duree;

    public Espece(String especeName, int duree) {
        this.especeName = especeName;
        this.duree = duree;
    }

    public Espece() {
        super();
    }

    public String getEspeceName() {
        return especeName;
    }

    public int getDuree() {
        return duree;
    }

    /* @Override
    public String getEspece() throws RemoteException {
        return especeName;
    }

    @Override
    public int getDuree() throws RemoteException {
        return duree;
    }*/



    @Override
    public String toString() {
        return especeName + " (" + duree + " ans)";
    }
}
