package com.example.models;

public enum Etat {

    CREE("Créé"),       // l’animal est malade
    EN_COURS("En cours"), // il suit un traitement
    TRAITE("Traité");

    private final String value;

    // Constructeur
    Etat(String value) {
        this.value = value;
    }

    // Getter pour l’affichage
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value; // permet d’afficher directement "Créé", "En cours", "Traité"
    }
}
