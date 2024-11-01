import classes.Pays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TP02_1170_NumB_A24 {
    public static void AfficherNumB() {
        List<Pays> paysList = new ArrayList<>();
        int nombrePays = lireFichierPays("pays_a24.txt", paysList);
        System.out.println("Nombre de pays lus : " + nombrePays);
    }

    public static int lireFichierPays(String fichier, List<Pays> paysList) {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] elements = ligne.split(","); // Assuming comma-separated values
                char continent = elements[0].charAt(0); // First character is continent code
                String nom = elements[1];
                String capitale = elements[2];
                double superficie = Double.parseDouble(elements[3]);

                Pays pays = new Pays(continent, nom, capitale, superficie);
                paysList.add(pays);
                nombrePays++;
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
        }

        return nombrePays;
    }
}
