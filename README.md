# ProjetChasseAuTresor

Projet Chasse au Trésor
Description
Ce projet implémente un système de jeu de la chasse au trésor où des aventuriers se déplacent sur une carte contenant des montagnes et des trésors. Les aventuriers collectent des trésors et se déplacent en suivant des séquences de mouvements spécifiées.
Structure du Projet
Le projet est organisé de la manière suivante :
src/main/java/ : Contient les sources principales du projet.
src/test/java/ : Contient les classes de tests unitaires.
Classes Principales
Aventurier
Aventurier.java : Représente un aventurier avec un nom, une position, une orientation, une séquence de mouvement et le nombre de trésors collectés.
Carte
Carte.java : Représente la carte du jeu avec sa largeur, sa hauteur, les montagnes et les trésors.
Coordonnee
Coordonnee.java : Représente une coordonnée (x, y) sur la carte.
Tresor
Tresor.java : Représente un trésor avec sa position et son nombre.
Orientation
Orientation.java : Enumération des orientations possibles (Nord, Est, Sud, Ouest).
ChasseAuTresor
ChasseAuTresor.java : Classe principale du jeu contenant les méthodes pour déplacer les aventuriers, tourner à gauche/droite, calculer de nouvelles positions, etc.
Exécution du Projet
Importez le projet dans votre IDE.
Exécutez la classe ChasseAuTresor pour lancer le jeu.
Suivez les instructions affichées dans la console pour jouer à la chasse au trésor.
Tests Unitaires
Le projet comprend des tests unitaires pour chaque classe principale afin de garantir le bon fonctionnement de l'application. Les tests se trouvent dans le répertoire src/test/java/. 
Les tests unitaires de ce projet sont réalisés à l'aide de la classe `ChasseAuTresorTests`, qui teste les différentes fonctionnalités de l'application, telles que la création de la carte, l'ajout de montagnes et de trésors, le déplacement des aventuriers, etc.
Assurez-vous d'avoir JUnit installé dans votre environnement pour exécuter les tests unitaires.






Contributeurs
Wassima AZOUAGH 

AVIS : 


J'ai omis de prendre en compte la possibilité qu'il puisse y avoir plusieurs aventuriers, ce que j'ai réalisé au dernier moment. J'aurais pu mettre en place une ArrayList pour gérer plusieurs aventuriers. Mais, par crainte de casser mon code, étant donné que je me suis rendu compte de cette possibilité tardivement, j'ai préféré livrer une solution prenant en charge un seul aventurier. Bien que mon code puisse être considéré comme incomplet dans ce contexte, il reste néanmoins bien structuré et propre. Le code est conçu de manière logique et orientée objet, avec des commentaires permettant une compréhension claire du code pour toute personne qui pourrait le modifier ou le maintenir à l'avenir.
