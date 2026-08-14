package com.example.serveur.Impl;

import com.example.interfaces.IAnimal;
import com.example.interfaces.IDossierSuivi;
import com.example.models.Espece;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Service
public class AnimalImpl extends UnicastRemoteObject implements IAnimal, Serializable {

    private String nom;
    private String nomMaitre;
    private String race;
    private Espece espece;
    private DossierSuiviImpl dossierSuivi;

    public AnimalImpl() throws RemoteException {
        super();
    }

    public AnimalImpl(String nom, String nomMaitre, String race, Espece espece, DossierSuiviImpl dossierSuivi) throws RemoteException {
        this.nom = nom;
        this.nomMaitre = nomMaitre;
        this.race = race;
        this.espece = espece;
        this.dossierSuivi = dossierSuivi;
    }

    public AnimalImpl(String nom, String nomMaitre, String race, Espece espece) throws RemoteException {
        this.nom = nom;
        this.nomMaitre = nomMaitre;
        this.race = race;
        this.espece = espece;
        this.dossierSuivi = new DossierSuiviImpl();
    }

    @Override
    public String getNomAnimal() throws RemoteException {
        return nom;
    }

    @Override
    public IDossierSuivi getDossier() throws RemoteException {
        return dossierSuivi;
    }

    @Override
    public String getNomMaitre() throws RemoteException {
        return nomMaitre;
    }

    @Override
    public String getRace() throws RemoteException {
        return race;
    }

    @Override
    public Espece getEspece() throws RemoteException {
        return espece;
    }
}
