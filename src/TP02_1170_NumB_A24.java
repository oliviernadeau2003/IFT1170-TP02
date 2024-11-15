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

        PaysUtils.afficher(paysList,0,12);
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
        char continent = ligne.charAt(0); // Premier caractère pour le continent

        // Le nom du pays est entre les positions 1 et 34
        String nom = ligne.substring(1, 36).trim();

        // La capitale est entre les positions 34 et 58
        String capitale = ligne.substring(36, 62).trim();

        // La superficie est entre les positions 58 et 69
        double superficie = Double.parseDouble(ligne.substring(63, 71).trim());

        // La population est après la position 69 jusqu'à la fin
        long population = Long.parseLong(ligne.substring(76).trim());

        // Retourner un objet Pays avec les informations extraites
        return new Pays(continent, nom, capitale, superficie, population);
    }


}

