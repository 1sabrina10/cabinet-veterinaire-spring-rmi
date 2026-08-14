TP RMI: Cabinet Vétérinaire avec Spring Boot et RMI

Auteur: Sabrina Moufok

Description: Ce projet implémente un cabinet vétérinaire virtuel permettant la gestion centralisée des animaux et de leurs dossiers médicaux.
Le serveur fournit des services distants via RMI, tandis que le client offre une interface graphique Swing pour interagir facilement avec le serveur.


Fonctionnalités principales:

-Ajouter, modifier et supprimer des animaux.
-Mettre à jour l’état du dossier médical (CREE, EN_COURS, TRAITE).
-Notifications automatiques via le design pattern Observer.
-Gestion de la capacité maximale du cabinet.


Pré-requis:

Java 8.
IDE compatible Java (IntelliJ).
Maven.


Installation et lancement:

Remarque: Le projet est composé de trois modules : common, serveur et client.

Toujours lancer le serveur avant le client.

1/ Lancement via terminal:
A. Module common:
cd Common
mvn clean install

B. Lancement du serveur:
cd serveur
mvn clean install
mvn spring-boot:run

C. Lancement du client:
cd client
mvn clean install
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Djava.awt.headless=false -Djava.awt.display=:0"

Remarques importantes:

Pour exécuter le client Swing sur Linux, il faut désactiver le mode headless et spécifier l’écran d’affichage.
-Djava.awt.headless=false permet à Java d’afficher l’interface graphique Swing.
-Djava.awt.display=:0 indique sur quel écran la fenêtre doit apparaître.

2/ Lancement via IDE:

A. Module common:
Compiler et installer le module : mvn clean install

B. Serveur:
Fichier principal:
src/main/java/com/example/server/ServeurApplication.java
Lancer le serveur depuis l’IDE.

C. Client:
Fichier principal:
src/main/java/com/example/client/ClientApplication.java

Avant de lancer le client, configurez:
VM options: -Djava.awt.headless=false
Environment variables: DISPLAY=:0
Cliquez sur Apply, puis OK, et lancez le client.


Utilisation:

Capacité maximale du cabinet: 50 ou 100 animaux (Exemple)
Possibilité d’ajouter des animaux par lots de 10 pour tester la limite
Pour chaque animal, remplir tous les champs du formulaire puis cliquer sur Ajouter
Pour les modifications, mises à jour de dossier ou suppression : saisir uniquement le nom de l’animal
Si l’animal n’existe pas, le système renvoie une erreur






