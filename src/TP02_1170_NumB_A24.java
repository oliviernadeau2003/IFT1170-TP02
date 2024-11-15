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
        int nombrePays = lireFichierPays(currentDirectory + "/src/data/pays_a24.txt", paysList);

        System.out.println("Nombre de pays lus : " + nombrePays);
        System.out.println();

        PaysUtils.afficher(paysList, 0, 12);
        System.out.println();


    }

    public static int lireFichierPays(String fichier, List<Pays> paysList) {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Pays pays = getPays(ligne);
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

    private static Pays getPays(String ligne) {
        char continent = ligne.charAt(0);

        // 1 to 36
        String nom = ligne.substring(1, 36).trim();

        // 36 to 62
        String capitale = ligne.substring(36, 62).trim();

        // 63 to 71
        double superficie = Double.parseDouble(ligne.substring(63, 72).trim());

        // 71 till the end
        long population = Long.parseLong(ligne.substring(72).trim());

        return new Pays(continent, nom, capitale, superficie, population);
    }


}

