package classes;

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
