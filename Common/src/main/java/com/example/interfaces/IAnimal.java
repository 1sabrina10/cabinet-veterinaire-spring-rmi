package com.example.interfaces;

import com.example.models.Espece;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote {

    String getNomAnimal() throws RemoteException;

    String getNomMaitre() throws RemoteException;

    String getRace() throws RemoteException;

    Espece getEspece() throws RemoteException;

    IDossierSuivi getDossier() throws RemoteException;
}
