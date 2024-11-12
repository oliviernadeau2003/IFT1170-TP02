import classes.Pays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TP02_1170_NumB_A24 {
    public static void AfficherNumB() {
        List<Pays> paysList = new ArrayList<>();
        String currentDirectory = System.getProperty("user.dir");
        int nombrePays = lireFichierPays(currentDirectory + "/src/data/pays_a24.txt", paysList);
        System.out.println("Nombre de pays lus : " + nombrePays);
    }

    public static int lireFichierPays(String fichier, List<Pays> paysList) {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] elements = ligne.trim().split("\\s+");

                char continent = elements[0].charAt(0);
                String capitale = elements[elements.length - 3];
                double superficie = Double.parseDouble(elements[elements.length - 2]);
                long population = Long.parseLong(elements[elements.length - 1]);

                StringBuilder nomBuilder = new StringBuilder();
                for (int i = 0; i < elements.length - 3; i++) {
                    nomBuilder.append(elements[i]);
                    if (i < elements.length - 4) {
                        nomBuilder.append(" ");
                    }
                }
                String nom = nomBuilder.toString().substring(1);

                Pays pays = new Pays(continent, nom, capitale, superficie, population);
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

