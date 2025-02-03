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
            System.out.println(e.getNom() + " - Moyenne : " + e.getMoyenne() + " - Classe : " + e.getClasse().getNiveau());
        }
    }

    /**
     * Description :
     * 
     * @param 
     * @return 
     */
    public void modifierMoyenneEtudiant(String nomEtudiant, double moyenne, ArrayList<Etudiant> listeEtudiants) {
        for (Etudiant e : listeEtudiants) {
            if (e.getNom().equals(nomEtudiant)) {
                e.setMoyenne(moyenne);
                System.out.println("Moyenne de l'étudiant " + nomEtudiant + " modifiée avec succès !");
            }
        }
    }
    public void modifierAgeEtudiant(String nomEtudiant, int age, ArrayList<Etudiant> listeEtudiants) {
        for (Etudiant e : listeEtudiants) {
            if (e.getNom().equals(nomEtudiant)) {
                e.setAge(age);
                System.out.println("Âge de l'étudiant " + nomEtudiant + " modifié avec succès !");
            }
        }
    }
    public void modifierClasseEtudiant(String nomEtudiant, Classe classe, ArrayList<Etudiant> listeEtudiants) {
        for (Etudiant e : listeEtudiants) {
            if (e.getNom().equals(nomEtudiant)) {
                e.setClasse(classe);
                System.out.println("Classe de l'étudiant " + nomEtudiant + " modifiée avec succès !");
            }
        }
    }
    public void modifierNoteEtudiant(String nomEtudiant, String module, double note, ArrayList<Etudiant> listeEtudiants) {
        for (Etudiant e : listeEtudiants) {
            if (e.getNom().equals(nomEtudiant)) {
                e.getNote().put(module, note);
                System.out.println("Note de l'étudiant " + nomEtudiant + " modifiée avec succès !");
            }
        }
    }
    public void modifierNomEtudiant(String nomEtudiant, String nom, ArrayList<Etudiant> listeEtudiants) {
        for (Etudiant e : listeEtudiants) {
            if (e.getNom().equals(nomEtudiant)) {
                e.setNom(nom);
                System.out.println("Nom de l'étudiant " + nomEtudiant + " modifié avec succès !");
            }
        }
    }
}
