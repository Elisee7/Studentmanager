package models;

import java.util.ArrayList;

public class Administrateur extends Personne {
    ArrayList<Classe> listeClasses = new ArrayList<>();
    public Administrateur(String nom, int age, ArrayList<Classe> listeClasses) {
        super(nom, age);
        this.listeClasses = listeClasses;
    }

    // Méthode pour ajouter un étudiant
    public void ajouterEtudiant(Etudiant etudiant, ArrayList<Etudiant> listeEtudiants) {
        listeEtudiants.add(etudiant);
        System.out.println("Étudiant " + etudiant.getNom() + " ajouté avec succès !");
    }

    // Méthode pour supprimer un étudiant
    public void supprimerEtudiant(String nomEtudiant, ArrayList<Etudiant> listeEtudiants) {
        listeEtudiants.removeIf(e -> e.getNom().equals(nomEtudiant));
        System.out.println("Étudiant " + nomEtudiant + " supprimé.");
    }

    // Méthode pour afficher tous les étudiants
    public void afficherEtudiants(ArrayList<Etudiant> listeEtudiants) {
        System.out.println("Liste des étudiants :");
        for (Etudiant e : listeEtudiants) {
            System.out.println(e.getNom() + " - Moyenne : " + e.getMoyenne());
        }
    }
}
