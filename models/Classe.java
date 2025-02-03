package models;

import java.util.ArrayList;

public class Classe {
    public String niveau;// Niveau de la classe

    ArrayList<Professeur> professeurs = new ArrayList<>();
    ArrayList<Etudiant> etudiants = new ArrayList<>();

    // Constructeur de la classe Classe
    public Classe(String niveau, ArrayList<Professeur> professeurs, ArrayList<Etudiant> etudiants) {
        this.niveau = niveau;
        this.professeurs = professeurs;
        this.etudiants = etudiants;
    }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }
}
