package ui;

import models.Administrateur;
import models.Classe;
import models.Etudiant;
import models.Professeur;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Classe> classes = new ArrayList<>();
        Administrateur admin = new Administrateur("admin", 25, classes);
        admin.creerAdministrateur(scanner);
        Appli(scanner, admin);
        scanner.close();
    }

    // Methode pour creer un menu Principal
    public static void menuPrincipal() {
        System.out.println("====Bienvenue dans l'application de gestion scolaire====");
        System.out.println("1. Gestion des classes");
        System.out.println("2. Gestion des étudiants");
        System.out.println("3. Gestion des professeurs");
        System.out.println("4. Gestion des administrateurs");
        System.out.println("5. Quitter");
    }

    // Methode pour creer un menu de gestion des classes
    public static void menuGestionClasses() {
        System.out.println("===Gestion des classes===");
        System.out.println("1. Ajouter une classe");
        System.out.println("2. Supprimer une classe");
        System.out.println("3. Modifier le niveau classe");
        System.out.println("4. Infos sur une classe");
        System.out.println("5. Quitter");
    }
    // Methode pour creer un menu de gestion des etudiants
    public static void menuGestionEtudiants() {
        System.out.println("===Gestion des étudiants===");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Supprimer un étudiant");
        System.out.println("3. Modifier un étudiant");
        System.out.println("4. Lister les étudiants");
        System.out.println("5. Quitter");
    }
    // Methode pour creer un menu de gestion des professeurs
    public static void menuGestionProfesseurs() {
        System.out.println("===Gestion des professeurs===");
        System.out.println("1. Ajouter un professeur");
        System.out.println("2. Supprimer un professeur");
        System.out.println("3. Modifier un professeur");
        System.out.println("4. Lister les professeurs");
        System.out.println("5. Ajout/retrait d'un module");
        System.out.println("6. Quitter");
    }
    // Methode pour creer un menu de gestion des administrateurs
    public static void menuGestionAdministrateurs() {
        System.out.println("===Gestion de l'administrateur===");
        System.out.println("1. Ajouter un administrateur");
        System.out.println("2. Supprimer un administrateur");
        System.out.println("3. Modifier un administrateur");
        System.out.println("4. Lister les administrateurs");
        System.out.println("5. Quitter");
    }

    // Menu pour modifier un etudiant
    public static void menuModifierEtudiant() {
        System.out.println("===Modifier un étudiant===");
        System.out.println("1. Modifier le nom");
        System.out.println("2. Modifier l'âge");
        System.out.println("3. Modifier la note d'une matière");
        System.out.println("4. Afficher la moyenne");
        System.out.println("5. Afficher les notes");
        System.out.println("6. Ajouter une note");
        System.out.println("7. Quitter");
    }

    // Menu pour creer et modifier un professeur
    public static void menuModifierProfesseur() {
        System.out.println("===Modifier un professeur===");
        System.out.println("1. Modifier le nom");
        System.out.println("2. Modifier l'âge");
        System.out.println("3. Modifier le module enseigné");//supprimer et creer un module
        System.out.println("4. Afficher les informations sur le professeur");
        System.out.println("5. Quitter");
    }

    // menu pour ajout/retrait d'un module
    public static void menuAjoutRetraitModule() {
        System.out.println("===Ajout/retrait d'un module===");
        System.out.println("1. Ajouter un module");
        System.out.println("2. Retirer un module");
        System.out.println("3. Quitter");
    }

    // Methode pour creer un menu de gestion des administrateurs
    public static void menuModifierAdministrateur() {
        System.out.println("===Modifier un administrateur===");
        System.out.println("1. Creer un administrateur");
        System.out.println("2. Modifier le nom");
        System.out.println("3. Modifier l'âge");
        System.out.println("4. Quitter");
    }

    // Recuperer le choix de l'utilisateur
    public static int getChoix(Scanner scanner) {
        System.out.print("Entrez votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }

    // Methode Index de l'application
    public static void Appli(Scanner scanner, Administrateur admin) {
        menuPrincipal();
        int choix = getChoix(scanner);
        while (choix != 5) {
            switch (choix) {
                case 1:
                    gestionClasses(scanner, admin);
                    break;
                case 2:
                    gestionEtudiants(scanner, admin);
                    break;
                case 3:
                    gestionProfesseurs(scanner, admin);
                    break;
                case 4:
                    gestionAdministrateurs(scanner, admin);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuPrincipal();
            choix = getChoix(scanner);
        }
    }

    // Methode pour la gestion des classes
    public static void gestionClasses(Scanner scanner, Administrateur admin) {
        menuGestionClasses();
        int choix = getChoix(scanner);
        while (choix != 5) {
            switch (choix) {
                case 1:
                    admin.creerClasse(scanner);
                    break;
                case 2:
                    admin.supprimerClasse(scanner);
                    break;
                case 3:
                    admin.modifierNiveauClasse(scanner);
                    break;
                case 4:
                    String niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if (classe.niveau.equals(niveau)) {
                            admin.afficherInfos(classe);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuGestionClasses();
            choix = getChoix(scanner);
        }
    }

    // Methode pour la gestion des etudiants
    public static void gestionEtudiants(Scanner scanner, Administrateur admin) {
        menuGestionEtudiants();
        int choix = getChoix(scanner);
        String niveau;
        while (choix != 5) {
            switch (choix) {
                case 1:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.creeEtudiant(classe, scanner);
                            break;
                        }
                    }
                    break;
                case 2:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.supprimerEtudiant(classe, scanner);
                            break;
                        }
                    }
                    break;
                case 3:
                    modifierEtudiant(scanner, admin);
                    break;
                case 4:
                    // Afficher les etudiants
                    niveau = admin.getNiveauClasse(scanner);
                    String nomEtudiant = admin.getNomPersonne(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if (classe.niveau.equals(niveau)) {
                            for (Etudiant etudiant : classe.etudiants) {
                                if (etudiant.getNom().equals(nomEtudiant)) {
                                    admin.afficherEtudiant(etudiant);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuGestionEtudiants();
            choix = getChoix(scanner);
        }
    }

    static void modifierEtudiant(Scanner scanner, Administrateur admin) {
        menuModifierEtudiant();
        String niveau;
        int choix = getChoix(scanner);
        while (choix != 7) {
            switch (choix) {
                case 1:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.modifierNomEtudiant(classe, scanner);
                            break;
                        }
                        break;
                    }
                case 2:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.modifierAgeEtudiant(classe, scanner);
                            break;
                        }
                        break;
                    }
                    break;
                case 3:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.modifierNoteModule(classe, scanner);
                            break;
                        }
                        break;
                    }
                    break;
                case 4:
                    niveau = admin.getNiveauClasse(scanner);
                    String nomEtudiant = admin.getNomPersonne(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                       if (classe.niveau.equals(niveau)) {
                           for (Etudiant etudiant : classe.etudiants) {
                               if (etudiant.getNom().equals(nomEtudiant)) {
                                   admin.afficherMoyenne(etudiant);
                                   break;
                               }
                           }
                       }
                    }
                    break;
                case 5:
                    niveau = admin.getNiveauClasse(scanner);
                    String nomEtudiant1 = admin.getNomPersonne(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if (classe.niveau.equals(niveau)) {
                            for (Etudiant etudiant : classe.etudiants) {
                                if (etudiant.getNom().equals(nomEtudiant1)) {
                                    admin.afficherNotes(etudiant);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.ajouterNoteEtudiant(scanner, classe);
                            break;
                        }
                        break;
                    }
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuModifierEtudiant();
            choix = getChoix(scanner);
        }
    }
    // Methode pour la gestion des professeurs
    public static void gestionProfesseurs(Scanner scanner, Administrateur admin) {
        menuGestionProfesseurs();
        int choix = getChoix(scanner);
        String niveau;
        while (choix != 6) {
            switch (choix) {
                case 1:
                    // Ajouter un professeur à une classe
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.creerProfesseur(classe, scanner);
                            break;
                        }
                    }
                    break;
                case 2:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.supprimerProfesseur(classe, scanner);
                            break;
                        }
                    }
                    break;
                case 3:
                    modifierProfesseur(scanner, admin);
                    break;
                case 4:
                    // Afficher les professeurs
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if (classe.niveau.equals(niveau)) {
                            for (Professeur professeur : classe.professeurs) {
                                admin.afficherInfos(professeur);
                            }
                        }
                    }
                    break;
                case 5:
                    ajoutRetraitModule(scanner, admin);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuGestionProfesseurs();
            choix = getChoix(scanner);
        }
    }

    // Methode pour modifier un professeur
    static void modifierProfesseur(Scanner scanner, Administrateur admin) {
        menuModifierProfesseur();
        String niveau;
        int choix = getChoix(scanner);
        while (choix != 5) {
            switch (choix) {
                case 1:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.modifierNomProfesseur(classe, scanner);
                            break;
                        }
                        break;
                    }
                case 2:
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.modifierAgeProfesseur(classe, scanner);
                            break;
                        }
                        break;
                    }
                    break;
                case 3:
                    // Modifier le module enseigné
                    niveau = admin.getNiveauClasse(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            admin.supprimerModuleEnseigner(classe, scanner);
                            admin.ajouterModuleEnseigner(classe, scanner);
                            break;
                        }
                        break;
                    }
                    break;
                case 4:
                    niveau = admin.getNiveauClasse(scanner);
                    String nomProfesseur = admin.getNomPersonne(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if (classe.niveau.equals(niveau)) {
                            for (Professeur professeur : classe.professeurs) {
                                if (professeur.getNom().equals(nomProfesseur)) {
                                    admin.afficherInfos(professeur);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuModifierProfesseur();
            choix = getChoix(scanner);
        }
    }

    // Methode pour ajouter ou retirer un module
    static void ajoutRetraitModule(Scanner scanner, Administrateur admin) {
        menuAjoutRetraitModule();
        String niveau;
        int choix = getChoix(scanner);
        while (choix != 3) {
            switch (choix) {
                case 1:
                    niveau = admin.getNiveauClasse(scanner);
                    String nomEnseignant = admin.getNomPersonne(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            for (Professeur professeur : classe.professeurs) {
                                if(professeur.getNom().equals(nomEnseignant)){
                                    admin.ajouterModuleEnseigner(classe, scanner);
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    break;
                case 2:
                    niveau = admin.getNiveauClasse(scanner);
                    String nomEnseignant1 = admin.getNomPersonne(scanner);
                    for (Classe classe : admin.getListeClasses()) {
                        if(classe.niveau.equals(niveau)){
                            for (Professeur professeur : classe.professeurs) {
                                if(professeur.getNom().equals(nomEnseignant1)){
                                    admin.supprimerModuleEnseigner(classe, scanner);
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuAjoutRetraitModule();
            choix = getChoix(scanner);
        }
    }

    // Gestion des administrateurs
    public static void gestionAdministrateurs(Scanner scanner, Administrateur admin) {
        menuGestionAdministrateurs();
        int choix = getChoix(scanner);
        while (choix != 3) {
            switch (choix) {
                case 1:
                    admin.creerAdministrateur(scanner);
                    break;
                case 2:
                    modifierAdministrateur(scanner, admin);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
            menuGestionAdministrateurs();
            choix = getChoix(scanner);
        }
    }

    static void modifierAdministrateur(Scanner scanner, Administrateur admin){
        modifierAdministrateurMenu();
        int choice = getChoix(scanner);
        while (choice != 3) {
            switch (choice) {
                case 1:
                    admin.setNom(admin.getNomPersonne(scanner));
                    break;
                case 2:
                    admin.setAge(admin.getAgePersonne(scanner));
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }
    static void modifierAdministrateurMenu(){
        System.out.println("===Faites le choix de l'operation a effectue");
        System.out.println("1.Modifier le nom de l'admin");
        System.out.println("2. Modifier l'age de l'admin");
        System.out.println("3. Quitter");
    }
}