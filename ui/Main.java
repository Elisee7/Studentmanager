package ui;

import models.Administrateur;
import models.Classe;
import models.Etudiant;
import models.Professeur;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Créer une classe
        ArrayList<Professeur> professeurs = new ArrayList<>();
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        Classe classe = new Classe("Terminale", professeurs, etudiants);

        // Créer un administrateur
        ArrayList<Classe> listeClasses = new ArrayList<>();
        listeClasses.add(classe);
        Administrateur admin = new Administrateur("Admin", 45, listeClasses);

        // Ajouter un professeur
        System.out.println("Ajout d'un professeur :");
        admin.creerProfesseur(classe, scan);

        // Ajouter un étudiant
        System.out.println("Ajout d'un étudiant :");
        admin.ajouterEtudiant(new Etudiant("Etudiant1", 18, classe), etudiants);

        // Modifier l'âge d'un étudiant
        System.out.println("Modification de l'âge d'un étudiant :");
        admin.modifierAgeEtudiant(classe, scan);

        // Ajouter une note à un étudiant
        System.out.println("Ajout d'une note à un étudiant :");
        admin.ajouterNoteEtudiant(scan, classe);

        // Modifier une note d'un étudiant
        System.out.println("Modification d'une note d'un étudiant :");
        admin.modifierNoteModule(classe, scan);

        // Afficher les informations des étudiants
        System.out.println("Affichage des informations des étudiants :");
        admin.afficherEtudiants(etudiants);

        // Afficher les informations des professeurs
        System.out.println("Affichage des informations des professeurs :");
        for (Professeur professeur : classe.professeurs) {
            admin.afficherInfos(professeur);
        }

        scan.close();
    }
}
