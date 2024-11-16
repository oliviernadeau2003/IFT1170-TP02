import classes.Pays;
import classes.PaysUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TP02_1170_NumB_A24 {
    public static void AfficherNumB() {
        System.out.println("\n=== Numéro B ===");
        List<Pays> paysList = new ArrayList<>();
        String currentDirectory = System.getProperty("user.dir");
        int nombrePays = readFilePays(currentDirectory + "/src/data/pays_a24.txt", paysList);

        System.out.println("Nombre de pays lus : " + nombrePays);
        System.out.println();

        PaysUtils.afficher(paysList, 0, 12);
        System.out.println();

        //* Modifier le continent de la Chine, il doit devenir l’Asie
        Pays paysTempo = PaysUtils.retrievePays(paysList, "Chine");
        if (paysTempo != null) paysTempo.setContinent(PaysUtils.Continent.ASIE);

        //* Modifier la capitale de la France, elle doit devenir PARIS ;
        paysTempo = PaysUtils.retrievePays(paysList, "France");
        if (paysTempo != null) paysTempo.setCapitale("PARIS");

        //* Changer la population de l’Allemagne : elle devient 10 fois la population lue ;
        paysTempo = PaysUtils.retrievePays(paysList, "Allemagne");
        if (paysTempo != null) paysTempo.setPopulation(paysTempo.getPopulation() * 10);

        //* Augmenter de 4% la population de tous les pays d’Afrique.
        PaysUtils.augmenterPopulation(paysList, PaysUtils.Continent.AFRIQUE, 1.04);

        //* Afficher les 15 premier pays
        PaysUtils.afficher(paysList, 0, 15);

        //* Afficher dans la console, les pays dont le nom est identique au nom de la capitale.
        System.out.println("Pays dont la capitale porte le même nom que le pays :");
        for (Pays pays : paysList)
            if (pays.getNom().equals(pays.getCapitale())) System.out.println(pays);
        System.out.println();

        //* Déterminer puis afficher dans la console les pays suivant avec la plus grande densité.
        paysTempo = PaysUtils.trouverPaysDensiteMax(paysList, PaysUtils.Continent.ASIE);
        if (paysTempo != null)
            System.out.printf("Le pays avec la plus grande densité d'Asie est :\n%s\n", paysTempo);

        System.out.println();
        paysTempo = PaysUtils.trouverPaysDensiteMax(paysList, PaysUtils.Continent.AMERIQUE);
        if (paysTempo != null)
            System.out.printf("Le pays avec la plus grande densité d'Amérique est :\n%s\n", paysTempo);

        System.out.println();

        //* Déterminer puis afficher le pays le plus peuplé.
        paysTempo = PaysUtils.trouverPaysLePlusPeuple(paysList, PaysUtils.Continent.EUROPE);
        if (paysTempo != null)
            System.out.printf("Le pays le plus peuplé d'Amérique est :\n%s\n", paysTempo);
        System.out.println();

        paysTempo = PaysUtils.trouverPaysLePlusPeuple(paysList, PaysUtils.Continent.AFRIQUE);
        if (paysTempo != null)
            System.out.printf("Le pays le plus peuplé d'Afrique est :\n%s\n", paysTempo);
        System.out.println();


        //* Déterminer et afficher les informations dans la console :
        //* Les pays dont le nom commence par une voyelle ;
        System.out.println("Les pays qui commence par une voyelle :");
        PaysUtils.afficherPaysCommencentParVoyelle(paysList);
        System.out.println();

        //* Le pays d’Océanie dont la capitale contient le plus de lettres / caractères alphabétiques.
        paysTempo = PaysUtils.trouverPaysCapitalePlusLongue(paysList, PaysUtils.Continent.OCEANIE);
        if (paysTempo != null)
            System.out.printf("Le pays d’Océanie dont la capitale contient le plus de lettres / caractères alphabétiques : \n%s", paysTempo);
        System.out.println();


        //* Quick Sort
        System.out.println();
        PaysUtils.quickSort(paysList, 0, paysList.size() - 1);
        System.out.println("Tableau après le tri rapide :");
        PaysUtils.afficher(paysList, 0, 10);


        //* Binary Search
        System.out.println();
        System.out.println("Résultat des recherches dichotomiques :");

        //*     Canada
        paysTempo = PaysUtils.rechercheDichotomique(paysList, "Canada");
        if (paysTempo != null)
            System.out.println(paysTempo);

        //*     France
        paysTempo = PaysUtils.rechercheDichotomique(paysList, "France");
        if (paysTempo != null)
            System.out.println(paysTempo);

        //*     Japon
        paysTempo = PaysUtils.rechercheDichotomique(paysList, "Japon");
        if (paysTempo != null)
            System.out.println(paysTempo);

        //*     Mexique
        paysTempo = PaysUtils.rechercheDichotomique(paysList, "Mexique");
        if (paysTempo != null)
            System.out.println(paysTempo);
        System.out.println();


        //* Créer le fichier "Asie.txt" qui contient seulement les pays d'Asie
        PaysUtils.creerFichierParContinent(paysList, PaysUtils.Continent.ASIE, "Asie.txt");
        System.out.println();

        //* Créer le fichier "Europe.txt" qui contient seulement les pays d'Europe
        PaysUtils.creerFichierParContinent(paysList, PaysUtils.Continent.EUROPE, "Europe.txt");
        System.out.println();

    }

    public static int readFilePays(String fichier, List<Pays> paysList) {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Pays pays = PaysUtils.createPays(ligne);
                paysList.add(pays);
                nombrePays++;
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format dans le fichier: " + e.getMessage());
        }

        return nombrePays;
    }

}

