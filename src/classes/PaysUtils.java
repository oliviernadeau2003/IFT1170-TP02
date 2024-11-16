//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]

package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PaysUtils {

    public enum Continent {
        AFRIQUE('1'),
        AMERIQUE('2'),
        ASIE('3'),
        OCEANIE('4'),
        EUROPE('2');

        public final char number;

        Continent(char number) {
            this.number = number;
        }
    }

    static public void afficher(List<Pays> pays) {
        for (int i = 0; i < pays.size(); i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }

    static public void afficher(List<Pays> pays, int start, int end) {
        for (int i = start; i < end; i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }

    public static void augmenterPopulation(List<Pays> paysList, Continent contient, double pourcentage) {
        for (Pays pays : paysList) {
            if (pays.getContinent() == contient.number) {
                long nouvellePopulation = Math.round(pays.getPopulation() * pourcentage);
                pays.setPopulation(nouvellePopulation);
            }
        }
    }

    public static Pays retrievePays(List<Pays> paysList, String nomPays) {
        for (Pays pays : paysList) {
            if (pays.getNom().equalsIgnoreCase(nomPays)) {
                return pays;
            }
        }
        return null;
    }

    public static Pays trouverPaysDensiteMax(List<Pays> paysList, PaysUtils.Continent continent) {
        Pays paysMaxDensite = null;
        double maxDensite = 0;

        for (Pays pays : paysList) {
            if (pays.getContinent() == continent.number) {
                double densite = pays.calculerDensite();
                if (densite > maxDensite) {
                    maxDensite = densite;
                    paysMaxDensite = pays;
                }
            }
        }
        return paysMaxDensite;
    }

    public static Pays trouverPaysLePlusPeuple(List<Pays> paysList, PaysUtils.Continent continent) {
        Pays paysMaxPopulation = null;
        long maxPopulation = 0;

        for (Pays pays : paysList) {
            if (pays.getContinent() == continent.number) {
                if (pays.getPopulation() > maxPopulation) {
                    maxPopulation = pays.getPopulation();
                    paysMaxPopulation = pays;
                }
            }
        }
        return paysMaxPopulation;
    }

    public static void afficherPaysCommencentParVoyelle(List<Pays> paysList) {
        // Liste des voyelles (en majuscule et minuscule)
        String voyelles = "AEIOUaeiou";

        for (Pays pays : paysList) {
            // Vérifie si le nom commence par une voyelle
            if (voyelles.indexOf(pays.getNom().charAt(0)) != -1) {
                // Affiche les informations du pays
                System.out.println(pays);
            }
        }
    }

    public static Pays trouverPaysCapitalePlusLongue(List<Pays> paysList, PaysUtils.Continent continent) {
        Pays paysCapitalePlusLongue = null;
        int maxLettres = 0;

        for (Pays pays : paysList) {
            if (pays.getContinent() == continent.number) {
                // Filtrer les caractères alphabétiques dans le nom de la capitale
                int nbLettres = (int) pays.getCapitale().chars()
                        .filter(Character::isLetter)
                        .count();
                if (nbLettres > maxLettres) {
                    maxLettres = nbLettres;
                    paysCapitalePlusLongue = pays;
                }
            }
        }
        return paysCapitalePlusLongue;
    }

    //* Quick Sort
    public static void quickSort(List<Pays> paysList, int low, int high) {
        if (low < high) {
            // Trouve l'indice de partition
            int pivotIndex = partition(paysList, low, high);

            // Trie récursivement les sous-listes
            quickSort(paysList, low, pivotIndex - 1);
            quickSort(paysList, pivotIndex + 1, high);
        }
    }

    private static int partition(List<Pays> paysList, int low, int high) {
        // Choisir le dernier élément comme pivot
        Pays pivot = paysList.get(high);

        // Index du plus petit élément
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Si le nom du pays est alphabétiquement inférieur ou égal au pivot
            if (paysList.get(j).getNom().compareToIgnoreCase(pivot.getNom()) <= 0) {
                i++;

                // Échange les éléments
                swap(paysList, i, j);
            }
        }

        // Place le pivot à sa position correcte
        swap(paysList, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Pays> paysList, int i, int j) {
        Pays temp = paysList.get(i);
        paysList.set(i, paysList.get(j));
        paysList.set(j, temp);
    }

    //* End Quick Sort

    //* Binary Search
    public static Pays rechercheDichotomique(List<Pays> paysList, String nom) {
        int low = 0;
        int high = paysList.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Pays pays = paysList.get(mid);

            int comparaison = pays.getNom().compareToIgnoreCase(nom);

            if (comparaison == 0) {
                return pays;
            } else if (comparaison < 0) {
                low = mid + 1; // Recherche dans la moitié supérieure
            } else {
                high = mid - 1; // Recherche dans la moitié inférieure
            }
        }
        return null; // Pays non trouvé
    }

    // * End Binary Search

    public static void creerFichierParContinent(List<Pays> paysList, PaysUtils.Continent continent, String nomFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
            for (Pays pays : paysList) {
                if (pays.getContinent() == continent.number) {
                    writer.write(pays.toString());
                    writer.newLine();
                }
            }
            System.out.printf("Fichier \"%s\" créé avec succès.\n", nomFichier);
        } catch (IOException e) {
            System.err.printf("Erreur lors de la création du fichier \"%s\": %s\n", nomFichier, e.getMessage());
        }
    }

    static public Pays createPays(String ligne) {
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
