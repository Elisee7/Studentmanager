package models;

import java.util.ArrayList;

public class Professeur extends Personne{
    private ArrayList<String> moduleEnseigner = new ArrayList<>();

    public Professeur(String nom, int age, ArrayList<String> moduleEnseigner) {
        super(nom, age);
        this.moduleEnseigner = moduleEnseigner;
    }

    public ArrayList<String> getModuleEnseigner() { return moduleEnseigner; }
    public void setModuleEnseigner(ArrayList<String> moduleEnseigner) { this.moduleEnseigner = moduleEnseigner; }
}
