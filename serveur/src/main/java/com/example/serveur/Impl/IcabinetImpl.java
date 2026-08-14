package com.example.serveur.Impl;

import com.example.interfaces.ICabinet;
import com.example.interfaces.IDossierSuivi;
import com.example.interfaces.VetObserver;
import com.example.interfaces.IAnimal;
import com.example.models.AnimalDTO;
import com.example.models.Espece;
import com.example.models.Etat;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IcabinetImpl implements ICabinet, Serializable {

    private List<IAnimal> animals;
    private int size;
    private List<VetObserver> observers;

    public IcabinetImpl() {
        super();
        this.animals = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public List<AnimalDTO> getAllAnimals() throws RemoteException {
        List<AnimalDTO> dtos = new ArrayList<>();
        for (IAnimal a : animals) {
            dtos.add(new AnimalDTO(a.getNomAnimal(), a.getNomMaitre(), a.getRace(), a.getEspece(), a.getDossier().getEtat().getValue()));
        }
        return dtos;
    }

    @Override
    public int sizeAnimal() {
        return this.size;
    }

    @Override
    public AnimalDTO addAnimal(String nomAnimal, String nomMaitre, String race, Espece espece) throws RemoteException {
        DossierSuiviImpl dossierSuivi = new DossierSuiviImpl();
        String dossierEtat = dossierSuivi.getEtat().name();

        AnimalImpl animal = new AnimalImpl(nomAnimal, nomMaitre, race, espece, dossierSuivi);
        this.animals.add(animal);
        size = animals.size();

        return new AnimalDTO(nomAnimal, nomMaitre, race, espece, dossierEtat);
    }

    @Override
    public IAnimal getAnimalByNom(String nom) throws RemoteException {
        for (IAnimal animal : animals) {
            if (animal.getNomAnimal().equalsIgnoreCase(nom)) {
                return animal;
            }
        }
        return null; // animal non trouvé
    }

    @Override
    public void updateAnimal(String nom, AnimalDTO updatedAnimal) throws RemoteException {

        IAnimal existingAnimal = getAnimalByNom(nom); // récupère l'animal existant

        if (existingAnimal == null) {
            throw new RemoteException("Animal avec le nom " + nom + " non trouvé");
        }

        // On crée un nouvel objet à partir des nouvelles données
        IAnimal updated = new AnimalImpl(
                updatedAnimal.getNom(),
                updatedAnimal.getNomMaitre(),
                updatedAnimal.getRace(),
                updatedAnimal.getEspece()
        );

        // On remplace dans la liste
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getNomAnimal().equalsIgnoreCase(nom)) {
                animals.set(i, updated);
                return;
            }
        }
    }

    @Override
    public void removeAnimal(String s) throws RemoteException {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getNomAnimal().equalsIgnoreCase(s)) {
                animals.remove(i);
                size = animals.size();
                return;
            }
        }
        throw new RemoteException("Animal avec le nom '" + s + "' non trouvé.");
    }

    @Override
    public void registerObserver(VetObserver observer) throws RemoteException {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(VetObserver observer) throws RemoteException {
        observers.remove(observer);
        checkAndNotify();
    }

    @Override
    public void setEtatAnimal(String nom, Etat etat) throws RemoteException {
        IAnimal animalByNom = getAnimalByNom(nom);

        if (animalByNom == null) {
            throw new RemoteException("Animal avec le nom " + nom + " non trouvé");
        }
        animalByNom.getDossier().setEtat(etat);
    }

    private void checkAndNotify() {
        int count = animals.size();
        if (count == 50 || count == 100 ){
            System.out.println(" Seuil atteint côté serveur : " + count);
            notifyAllClients(" Seuil atteint : " + count + " animaux !");
        }
    }

    private void notifyAllClients(String message) {
        for (VetObserver observer : observers) {
            try {
                observer.notifyClient(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}



