package com.example.models;

import com.example.interfaces.IDossierSuivi;

import java.io.Serializable;

public class AnimalDTO implements Serializable{

    private String nom;
    private String nomMaitre;
    private String race;
    private Espece espece;
    private String dossierSuivi;

    public AnimalDTO() {

    }

    public AnimalDTO(String nom, String nomMaitre, String race, Espece espece) {
        this.nom = nom;
        this.nomMaitre = nomMaitre;
        this.race = race;
        this.espece = espece;

    }
    public AnimalDTO(String nom, String nomMaitre, String race, Espece espece, String dossierSuivi) {
        this.nom = nom;
        this.nomMaitre = nomMaitre;
        this.race = race;
        this.espece = espece;
        this.dossierSuivi = dossierSuivi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomMaitre() {
        return nomMaitre;
    }

    public void setNomMaitre(String nomMaitre) {
        this.nomMaitre = nomMaitre;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public String getDossierSuivi() {
        return dossierSuivi;
    }

    public void setDossierSuivi(String dossierSuivi) {
        this.dossierSuivi = dossierSuivi;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", nomMaitre='" + nomMaitre + '\'' +
                ", race='" + race + '\'' +
                ", espece=" + espece +
                ", dossierSuivi=" + dossierSuivi +
                '}';
    }
}
