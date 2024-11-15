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
        if (paysTempo != null)
            paysTempo.setContinent(PaysUtils.Continent.ASIE);

        //* Modifier la capitale de la France, elle doit devenir PARIS ;
        paysTempo = PaysUtils.retrievePays(paysList, "France");
        if (paysTempo != null)
            paysTempo.setCapitale("PARIS");

        //* Changer la population de l’Allemagne : elle devient 10 fois la population lue ;
        paysTempo = PaysUtils.retrievePays(paysList, "Allemagne");
        if (paysTempo != null)
            paysTempo.setPopulation(paysTempo.getPopulation() * 10);

        //* Augmenter de 4% la population de tous les pays d’Afrique.
        PaysUtils.augmenterPopulation(paysList, PaysUtils.Continent.AFRIQUE, 1.04);

        //* Afficher dans la console, les pays dont le nom est identique au nom de la capitale.

        PaysUtils.afficher(paysList, 0, 15);
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

