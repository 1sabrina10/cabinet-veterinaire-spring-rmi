package com.example.interfaces;

import com.example.models.Etat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDossierSuivi extends Remote {

    Etat getEtat() throws RemoteException;

    void setEtat(Etat etat) throws RemoteException;
}
