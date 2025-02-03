package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Administrateur extends Personne {
    private ArrayList<Classe> listeClasses = new ArrayList<>();
    public Administrateur(String nom, int age, ArrayList<Classe> listeClasses) {
        super(nom, age);
        this.listeClasses = listeClasses;
    }

    //Getter pour le nom
    public String getNom() { return nom; }
    //setter pour le nom
    public void setNom(String nom) { this.nom = nom; }

    //Getter pour l'age
    public int getAge() { return age; }
    //setter pour l'age
    public void setAge(int age) { this.age = age; }

    //Getter pour la liste des classes
    public ArrayList<Classe> getListeClasses() { return listeClasses; }
    //setter pour la liste des classes
    public void setListeClasses(ArrayList<Classe> listeClasses) { this.listeClasses = listeClasses; }
    //Fonction pour initialiser un nom
    public String getNomPersonne(Scanner scan) {
        System.out.println("Le nom de la personne est: ");
        String nom = scan.nextLine();
        return nom;
    }
    //Fonction pour initialiser l'age d'une personne
    public int getAgePersonne(Scanner scan) {
        System.out.println("L'age de la personne est: ");
        int age = scan.nextInt();
        return age;
    }
    //fonction pour initialiser le module suivis par un eleve
    public String getModule(Scanner scan) {
        System.out.println("Le module est: ");
        String module = scan.nextLine();
        return module;
    }
    // Fonction pour initialiser la note d'un eleve
    public double getNoteModule(Scanner scan) {
        System.out.println("La note est: ");
        double note = scan.nextDouble();
        return note;
    }
    

    // Fonction relatif à la classe Etudiant

    /**
     * Créer un étudiant et l'initialiser
     * @param classe
     * @param scan
     */
    void creeEtudiant(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        int age = getAgePersonne(scan);
        //double moyenne = scan.nextDouble();
        //Map<String,Double> note = new HashMap<String,Double>();
        //Note de l'étudiant
        //String module = scan.nextLine();
        //double noteModule = scan.nextDouble();
        //note.put(module, noteModule);

        Etudiant etudiant = new Etudiant(nom, age, classe);
        classe.etudiants.add(etudiant);
    }

    // Ajouter une note à un étudiant
    void ajouterNoteEtudiant(Scanner scan, Classe classe) {
        String nom = getNomPersonne(scan);
        String module = getModule(scan);
        double note = getNoteModule(scan);
        Map<String,Double> put = new HashMap<String,Double>();
        put.put(module, note);
        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.nom.equals(nom)) {
                etudiant.getNote().add(put);
                //Somme des notes
                double somme = 0;
                for (Map<String, Double> noteMap : etudiant.getNote()) {
                    for (Map.Entry<String, Double> entry : noteMap.entrySet()) {
                        somme += entry.getValue();
                    }
                }

                //Calcul de la moyenne
                etudiant.setMoyenne(somme / etudiant.getNote().size());
            }
        }
    }

    //Partie suppression de l'étudiant
    void supprimerEtudiant(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.nom.equals(nom)) {
                classe.etudiants.remove(etudiant);
                break;
            }
        }
    }
    // Partie affichage des informations de l'étudiant

    void afficherNotes(Etudiant etudiant) {
        System.out.println(etudiant.nom + " : " + etudiant.getNote());
    }

    void afficherInfos(Etudiant etudiant) {
        etudiant.afficherInfos();
    }

    void afficherMoyenne(Etudiant etudiant) {
        System.out.println(etudiant.nom + " : " + etudiant.getMoyenne());
    }
    // Partie modification des informations de l'étudiant
    void modifierNomEtudiant(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        System.out.println("Le nouveau nom est: ");
        String newNom = scan.nextLine();
        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.nom.equals(nom)) {
                etudiant.setNom(newNom);
                break;
            }
        }
    }
    void modifierAgeEtudiant(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        System.out.println("Le nouvel age est: ");
        int newAge = scan.nextInt();
        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.nom.equals(nom)) {
                etudiant.setAge(newAge);
                break;
            }
        }
    }

    // Partie modification des notes de l'étudiant
    void modifierNoteModule(Etudiant etudiant, Scanner scan) {
        String module = getModule(scan);
        double note = getNoteModule(scan);
        boolean moduleFound = false;
        for (Map<String, Double> noteMap : etudiant.getNote()) {
            if (noteMap.containsKey(module)) {
                noteMap.put(module, note);
                moduleFound = true;
                break;
            }
        }
        if (!moduleFound) {
            Map<String, Double> newNoteMap = new HashMap<>();
            newNoteMap.put(module, note);
            etudiant.getNote().add(newNoteMap);
        }
    }
    void modifierNom(Etudiant etudiant, String nom) {
        etudiant.setNom(nom);
    }
    void modifierAge(Etudiant etudiant, int age) {
        etudiant.setAge(age);
    }


    
    // Fonction relatif à la classe Professeur

    // Fonction relatif à la classe Classe


}