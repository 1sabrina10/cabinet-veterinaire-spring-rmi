package com.example.serveur.Impl;

import com.example.interfaces.IDossierSuivi;
import com.example.models.Etat;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.rmi.RemoteException;

@Service
public class DossierSuiviImpl implements IDossierSuivi, Serializable {

    private Etat etat;

    @Override
    public Etat getEtat() throws RemoteException {
        return etat;
    }

    @Override
    public void setEtat(Etat etat) throws RemoteException {
        this.etat = etat;
    }

    public DossierSuiviImpl() {
        this.etat = Etat.CREE;
    }
}
