# BibliothequeExamen
Application simulant une bibliothèque.

forthebadge

# Gestion de Bibliothèque

Ce projet est une application Java permettant de gérer une bibliothèque de livres. Il inclut des fonctionnalités pour ajouter des lecteurs, louer des livres, et rechercher des ouvrages par ISBN. L'objectif principal de cette application est de fournir une interface simple pour la gestion des lecteurs et des livres dans une bibliothèque.

## Fonctionnalités principales

- **Gestion des livres** : Ajouter, afficher et rechercher des livres disponibles dans la bibliothèque.
- **Gestion des lecteurs** : Ajouter et suivre les lecteurs inscrits dans la bibliothèque.
- **Location de livres** : Permet à un lecteur de louer un livre en spécifiant l'ISBN.
- **Limite de location** : Un lecteur ne peut pas louer plus de 3 livres simultanément et ne peut pas louer plusieurs exemplaires d'un même livre.
- **Recherche par ISBN** : Possibilité de rechercher un livre spécifique en fournissant son ISBN.

## Technologies utilisées

- **Langage** : Java
- **Gestion des données** : Les livres et les lecteurs sont stockés dans des collections (`List`, `Set`) en mémoire.
- **Dépendances** : 
  - Utilisation de `Jackson` pour la sérialisation/désérialisation des données au format JSON.
  - `Scanner` pour l'entrée utilisateur.

## Installation et exécution

1. Clonez ce dépôt :
   ```bash
   git clone [https://github.com/votre-compte/votre-projet.git](https://github.com/eloiseLBC/BibliothequeExamen.git)

2. Packagez grâce à Maven:
   ```bash
   maven clean package
  
## Structure du projet
Livre.java : Modélisation d'un livre avec ses propriétés (ISBN, titre, auteur, description, prix).
Lecteur.java : Modélisation d'un lecteur, avec ses informations et la liste des livres qu'il a loués.
Bibliotheque.java : Gère les lecteurs et les livres, et inclut les fonctionnalités pour louer des livres, afficher les livres disponibles, et gérer les interactions avec les lecteurs.
Main.java : Classe principale permettant d'exécuter l'application et d'interagir avec la bibliothèque.

## Utilisation
Ajoutez des lecteurs à la bibliothèque.
Ajoutez des livres disponibles à partir d'un fichier JSON ou manuellement.
Louez des livres en entrant l'ISBN correspondant.
Consultez la liste des livres disponibles et des lecteurs inscrits.

## Exemples
Voici un exemple d'ajout d'un livre à la bibliothèque :
```java
  Livre livre = new Livre("1234567890", "Le Petit Prince", "Un classique de la littérature", "Antoine de Saint-Exupéry", 15.99);
  bibliotheque.addLivre(livre);
