package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeUtils {

    public static void triParSelection(Employe[] employes) {
        int n = employes.length;

        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;

            for (int j = i + 1; j < n; j++) {
                if (employes[j].getNAS().compareTo(employes[indexMin].getNAS()) < 0) {
                    indexMin = j;
                }
            }

            if (indexMin != i) {
                Employe temp = employes[i];
                employes[i] = employes[indexMin];
                employes[indexMin] = temp;
            }
        }
    }

    public static int countBy(Employe[] employes, double salHebdoMax, String nas) {
        int compteur = 0;
        for (Employe employe : employes) {
            if (employe.getSalHebdo() < salHebdoMax && employe.getNAS().contains(nas)) {
                compteur++;
            }
        }
        return compteur;
    }

    // Méthode pour créer et écrire dans le fichier texte "empTri.txt"
    public static void creerFichierTexte(Employe[] employes,String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employe employe : employes) {
                writer.write(String.format("NAS: %s, Salaire Hebdomadaire: %.2f $\n",
                        employe.getNAS(), employe.getSalHebdo()));
            }
            System.out.println("Le fichier 'empTri.txt' a été créé avec succès.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la création du fichier.");
            e.printStackTrace();
        }
    }

}
