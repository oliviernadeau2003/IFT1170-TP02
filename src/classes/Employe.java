package classes;

public class Employe {
    private String NAS; // numéro d’assurance sociale
    private double salHebdo; // salaire hebdomadaire

    // Constructeur avec NAS et salHebdo
    public Employe(String NAS, double salHebdo) {
        this.NAS = NAS;
        this.salHebdo = salHebdo;
    }

    // Constructeur avec NAS, salaire par défaut
    public Employe(String NAS) {
        this(NAS, 1250.25); // 1250.25$ par défaut
    }

    // Constructeur avec NAS, heures et taux d’horaire
    public Employe(String NAS, double heures, double tauxHoraire) {
        this(NAS, heures * tauxHoraire); // Calcul du salaire hebdomadaire
    }

    // Getters et setters
    public double getSalHebdo() {
        return this.salHebdo;
    }

    public void setSalHebdo(double salHebdo) {
        this.salHebdo = salHebdo;
    }

    // . . . Autres méthodes à écrire . . .
    // Méthode afficher
    public void afficher() {
        System.out.printf("NAS: %s, Salaire Hebdomadaire: %.2f $\n", NAS, salHebdo);
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return String.format("NAS: %s, Salaire Hebdomadaire: %.2f $", NAS, salHebdo);
    }


} // fin de la classe Employe
