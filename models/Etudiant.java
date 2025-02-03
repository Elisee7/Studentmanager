package models;

import java.util.Map;
import java.util.HashMap;

// La classe Etudiant hérite de la classe Personne
public class Etudiant extends Personne {
    private double moyenne; // Moyenne de l'étudiant
    private Classe classe; // Classe de l'étudiant
    private Map<String,Double> note = new HashMap<String,Double>(); // Note de l'étudiant

    // Constructeur pour initialiser les attributs de l'étudiant
    public Etudiant(String nom, int age, double moyenne, Classe classe, Map<String,Double> note) {
        super(nom, age); // Appel du constructeur de la classe parente Personne
        this.moyenne = moyenne;
        this.classe = classe;
        this.note = note;
    }

    // Méthode pour afficher les informations de l'étudiant
    public void afficherInfos() {
        System.out.println("Étudiant : " + nom + ", Âge : " + age + ", Moyenne : " + moyenne);
    }

    // Getter pour la moyenne
    public double getMoyenne() { return moyenne; }
    // Setter pour la moyenne
    public void setMoyenne(double moyenne) { this.moyenne = moyenne; }

    // Getter pour la classe
    public Classe getClasse() { return classe; }
    // Setter pour la classe
    public void setClasse(Classe classe) { this.classe = classe; }

    // Getter pour la note
    public Map<String,Double> getNote() { return note; }
    // Setter pour la note
    public void setNote(Map<String,Double> note) { this.note = note; }

    //Getter pour le nom
    public String getNom() { return nom; }
    //setter pour le nom
    public void setNom(String nom) { this.nom = nom; }

    //Getter pour l'age
    public int getAge() { return age; }
    //setter pour l'age
    public void setAge(int age) { this.age = age; }
}
