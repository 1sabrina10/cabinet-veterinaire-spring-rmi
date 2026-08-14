package com.example.interfaces;

//import com.example.models.Animal;

import com.example.models.AnimalDTO;
import com.example.models.Espece;
import com.example.models.Etat;

import java.rmi.RemoteException;
import java.util.List;

public interface ICabinet {

    List<AnimalDTO> getAllAnimals() throws RemoteException;

    int sizeAnimal() throws RemoteException;

    AnimalDTO addAnimal(String nomAnimal, String nomMaitre, String race, Espece espece) throws RemoteException;

    IAnimal getAnimalByNom(String nom) throws RemoteException;

    void updateAnimal(String nom, AnimalDTO updatedAnimal) throws RemoteException;

    void removeAnimal(String nom) throws RemoteException;

    public void setEtatAnimal(String nom, Etat etat) throws RemoteException;

    void registerObserver(VetObserver observer) throws RemoteException;

    void unregisterObserver(VetObserver observer) throws RemoteException;
}
