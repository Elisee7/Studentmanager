package models;

import java.util.ArrayList;

public class Professeur extends Personne{
    private ArrayList<String> moduleEnseigner = new ArrayList<>();

    public Professeur(String nom, int age, ArrayList<String> moduleEnseigner) {
        super(nom, age);
        this.moduleEnseigner = moduleEnseigner;
    }
    //Getter pour les modules à enseigner
    public ArrayList<String> getModuleEnseigner() { return moduleEnseigner; }
    //Setter pour les modules à enseigner
    public void setModuleEnseigner(ArrayList<String> moduleEnseigner) { this.moduleEnseigner = moduleEnseigner; }

    // Getter pour le nom
    public String getNom() { return nom; }
    // Setter pour le nom
    public void setNom(String nom) { this.nom = nom; }

    //Getter pour l'age
    public int getAge() { return age; }
    //setter pour l'age
    public void setAge(int age) { this.age = age; }

}
