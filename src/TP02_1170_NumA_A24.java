import classes.Employe;

public class TP02_1170_NumA_A24 {

    public static void AfficherNumA() {

        Employe emp1 = new Employe("250 642 753", 1234.56);
        Employe emp2 = new Employe("123 456 789"); // salaire par défaut 1250.25$
        Employe emp3 = new Employe("250 343 678", 40.00, 25.75); // salHebdo = 40 * 25.75$
        Employe emp4 = new Employe("450 279 321", 1750.75);

        // Affichage des informations
        emp3.afficher();
        emp4.afficher();
        System.out.println();

        // Modification du salaire de emp2 : somme de salaires de emp1 et emp3
        emp2.setSalHebdo(emp1.getSalHebdo() + emp3.getSalHebdo());

        emp2.afficher();
        System.out.println();


        // Déclaration et initialisation du tableau de 6 employés
        Employe[] employes = new Employe[6];

        employes[0] = new Employe("250 642 753", 1234.25);
        employes[1] = new Employe("123 456 789"); // salaire par défaut 1250.25$
        employes[2] = new Employe("250 343 654", 40.00, 17.25); // salHebdo = 40 * 17.25$
        employes[3] = new Employe("231 467 890", 1671.50);
        employes[4] = new Employe("478 343 689", 1750.75);
        employes[5] = new Employe("371 238 432", 50.00, 20.25); // salHebdo = 50 * 20.25$

        // Affichage du contenu du tableau en utilisant toString()
        for (int i = 0; i < employes.length; i++) {
            System.out.println("Employe " + i + ": " + employes[i].toString());
        }
        System.out.println();

    }
}
