package classes;

import java.util.List;

public class PaysUtils {

    static public void afficher(List<Pays> pays) {
        for (int i = 0; i < pays.size(); i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }

    static public void afficher(List<Pays> pays, int start, int end) {
        for (int i = start; i < end; i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }
}
