# TP RMI : Cabinet Vétérinaire avec Spring Boot et RMI

**Auteur : Sabrina Moufok**

## Description

Ce projet implémente un **cabinet vétérinaire virtuel** permettant la gestion centralisée des animaux et de leurs dossiers médicaux.

Le serveur fournit des services distants via **RMI**, tandis que le client propose une **interface graphique Swing** permettant d'interagir facilement avec le serveur.

## Fonctionnalités principales

- Ajouter, modifier et supprimer des animaux
- Mettre à jour l'état du dossier médical :
  - `CREE`
  - `EN_COURS`
  - `TRAITE`
- Notifications automatiques avec le **design pattern Observer**
- Gestion de la capacité maximale du cabinet
- Ajout d'animaux par lots pour tester la limite de capacité

## Pré-requis

- Java 8
- Maven
- IntelliJ IDEA ou un IDE compatible Java

## Structure du projet

Le projet est composé de trois modules :

- `common` : contient les éléments partagés entre le serveur et le client
- `serveur` : fournit les services RMI et gère la logique métier
- `client` : interface graphique Swing permettant d'interagir avec le serveur

> **Important : le serveur doit toujours être lancé avant le client.**

## Installation et lancement

### 1. Lancement via terminal

#### Module `common`

```bash
cd Common
mvn clean install
