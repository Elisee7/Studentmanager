package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    // Fonction pour initialiser le niveau de la classe
    public String getNiveauClasse(Scanner scan) {
        System.out.println("Le niveau de la classe est: ");
        String niveau = scan.nextLine();
        return niveau;
    }
    

    // Fonction relatif à la classe Etudiant

    /**
     * Créer un étudiant et l'initialiser
     * @param classe
     * @param scan
     */
    public void creeEtudiant(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        int age = getAgePersonne(scan);
        Etudiant etudiant = new Etudiant(nom, age);
        classe.etudiants.add(etudiant);
    }

    // Ajouter une note à un étudiant
    public void ajouterNoteEtudiant(Scanner scan, Classe classe) {
        String nom = getNomPersonne(scan);
        String module = getModule(scan);
        double note = getNoteModule(scan);
        Map<String, Double> put = new HashMap<>();
        put.put(module, note);
        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.getNom().equals(nom)) {
                etudiant.getNote().add(put);
                // Calcul de la moyenne
                double somme = 0;
                for (Map<String, Double> noteMap : etudiant.getNote()) {
                    for (Map.Entry<String, Double> entry : noteMap.entrySet()) {
                        somme += entry.getValue();
                    }
                }
                etudiant.setMoyenne(somme / etudiant.getNote().size());
                break;
            }
        }
    }

    //Partie suppression de l'étudiant
    public void supprimerEtudiant(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.nom.equals(nom)) {
                classe.etudiants.remove(etudiant);
                break;
            }
        }
    }
    // Partie affichage des informations de l'étudiant

    public void afficherNotes(Etudiant etudiant) {
        System.out.println(etudiant.nom + " : " + etudiant.getNote());
    }

    public void afficherEtudiant(Etudiant etudiant) {
        etudiant.afficherInfos();
    }

    public void afficherEtudiants(ArrayList<Etudiant> etudiants) {
        for (Etudiant etudiant : etudiants) {
            afficherEtudiant(etudiant);
        }
    }

    public void afficherMoyenne(Etudiant etudiant) {
        System.out.println(etudiant.nom + " : " + etudiant.getMoyenne());
    }
    // Partie modification des informations de l'étudiant
    public void modifierNomEtudiant(Classe classe, Scanner scan) {
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
    public void modifierAgeEtudiant(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        System.out.println("Le nouvel age est: ");
        int newAge = scan.nextInt();
        scan.nextLine();
        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.nom.equals(nom)) {
                etudiant.setAge(newAge);
                break;
            }
        }
    }


    // Partie modification des notes de l'étudiant
    public void modifierNoteModule(Classe classe, Scanner scan) {
        String nomEtudiant = getNomPersonne(scan);
        String module = getModule(scan);
        double note = getNoteModule(scan);
        boolean moduleFound = false;

        for (Etudiant etudiant : classe.etudiants) {
            if (etudiant.getNom().equals(nomEtudiant)) {
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
                // Calcul de la moyenne
                double somme = 0;
                for (Map<String, Double> n : etudiant.getNote()) {
                    for (Map.Entry<String, Double> entry : n.entrySet()) {
                        somme += entry.getValue();
                    }
                }
                etudiant.setMoyenne(somme / etudiant.getNote().size());
                break;
            }
        }
    }
    
    // Fonction relatif à la classe Professeur

    // Creations d'un professeur
    public void creerProfesseur(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        int age = getAgePersonne(scan);
        ArrayList<String> moduleEnseigner = new ArrayList<>();
        System.out.println("Entrez le nombre de modules à enseigner: ");
        int nbModules = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < nbModules; i++) {
            System.out.println("Entrez le module à enseigner: ");
            String module = scan.nextLine();
            moduleEnseigner.add(module);
        }
        Professeur professeur = new Professeur(nom, age, moduleEnseigner);
        classe.professeurs.add(professeur);
    }

    // Suppression d'un professeur
    public void supprimerProfesseur(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        for (Professeur professeur : classe.professeurs) {
            if (professeur.nom.equals(nom)) {
                classe.professeurs.remove(professeur);
                break;
            }
        }
    }

    // Affichage des informations d'un professeur
    public void afficherInfos(Professeur professeur) {
        System.out.println("Professeur : " + professeur.nom + ", Âge : " + professeur.age + ", Modules enseignés : " + professeur.getModuleEnseigner());
    }

    // Modification des informations d'un professeur
    public void modifierNomProfesseur(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        System.out.println("Le nouveau nom est: ");
        String newNom = scan.nextLine();
        for (Professeur professeur : classe.professeurs) {
            if (professeur.nom.equals(nom)) {
                professeur.setNom(newNom);
                break;
            }
        }
    }

    // Modification du d'un professeur
    public void modifierAgeProfesseur(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        System.out.println("Le nouvel age est: ");
        int newAge = scan.nextInt();
        for (Professeur professeur : classe.professeurs) {
            if (professeur.nom.equals(nom)) {
                professeur.setAge(newAge);
                break;
            }
        }
    }

    // Ajout d'un module à enseigner
    public void ajouterModuleEnseigner(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        System.out.println("Entrez le module à enseigner: ");
        String module = scan.nextLine();
        for (Professeur professeur : classe.professeurs) {
            if (professeur.nom.equals(nom)) {
                professeur.getModuleEnseigner().add(module);
                break;
            }
        }
    }

    // Suppression d'un module à enseigner
    public void supprimerModuleEnseigner(Classe classe, Scanner scan) {
        String nom = getNomPersonne(scan);
        System.out.println("Entrez le module à supprimer: ");
        String module = scan.nextLine();
        for (Professeur professeur : classe.professeurs) {
            if (professeur.nom.equals(nom)) {
                professeur.getModuleEnseigner().remove(module);
                break;
            }
        }
    }


    // Fonction relatif à la classe Classe

    // Création d'une classe
    public void creerClasse(Scanner scan) {
        String niveau = getNiveauClasse(scan);
        Classe classe = new Classe(niveau, new ArrayList<Professeur>(), new ArrayList<Etudiant>());
        listeClasses.add(classe);
    }

    // Suppression d'une classe
    public void supprimerClasse(Scanner scan) {
        System.out.println("Entrez le niveau de la classe à supprimer: ");
        String niveau = scan.nextLine();
        for (Classe classe : listeClasses) {
            if (classe.niveau.equals(niveau)) {
                listeClasses.remove(classe);
                break;
            }
        }
    }

    // Affichage des informations d'une classe
    public void afficherInfos(Classe classe) {
        System.out.println("Classe : " + classe.niveau);
        System.out.println("Professeurs : ");
        for (Professeur professeur : classe.professeurs) {
            System.out.println(professeur.nom + " : " + professeur.getModuleEnseigner());
        }
        System.out.println("Étudiants : ");
        for (Etudiant etudiant : classe.etudiants) {
            System.out.println(etudiant.nom + " : " + etudiant.getMoyenne());
        }
    }
    // Modification du niveau de la classe
    public void modifierNiveauClasse(Scanner scan) {
        System.out.println("Entrez le niveau de la classe à modifier: ");
        String niveau = scan.nextLine();
        System.out.println("Entrez le nouveau niveau: ");
        String newNiveau = scan.nextLine();
        for (Classe classe : listeClasses) {
            if (classe.niveau.equals(niveau)) {
                classe.setNiveau(newNiveau);
                break;
            }
        }
    }

    // Fonction relatif à la classe Administrateur
    public Administrateur creerAdministrateur(Scanner scan) {
        String nom = getNomPersonne(scan);
        int age = getAgePersonne(scan);
        Administrateur administrateur = new Administrateur(nom, age, new ArrayList<Classe>());
        return administrateur;
    }

    // Modification d'un administrateur
    public void modifierNomAdministrateur(Scanner scan, Administrateur administrateur) {
        System.out.println("Entrez le nouveau nom: ");
        String newNom = scan.nextLine();
        administrateur.setNom(newNom);
    }
    public void modifierAgeAdministrateur(Scanner scan, Administrateur administrateur) {
        System.out.println("Entrez le nouvel age: ");
        int newAge = scan.nextInt();
        administrateur.setAge(newAge);
    }
}
