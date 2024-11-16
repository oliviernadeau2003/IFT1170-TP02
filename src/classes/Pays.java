package classes;

public class Pays {

    private char continent;
    private String nom;
    private String capitale;
    private double superficie;
    private long population;

    public Pays(char continent, String nom, String capitale, double superficie, long population) {
        this.continent = continent;
        this.nom = nom;
        this.capitale = capitale;
        this.superficie = superficie;
        this.population = population;
    }

    //* Getters
    public char getContinent() {
        return continent;
    }

    public String getNom() {
        return nom;
    }

    public String getCapitale() {
        return capitale;
    }

    public double getSuperficie() {
        return superficie;
    }

    public long getPopulation() {
        return population;
    }

    //* Setters
    public void setContinent(PaysUtils.Continent newContinent) {
        this.continent = newContinent.number;
    }

    public void setNom(String newNom) {
        this.nom = newNom;
    }

    public void setCapitale(String newCapital) {
        this.capitale = newCapital;
    }

    public void setSuperficie(double newSuperficie) {
        this.superficie = newSuperficie;
    }

    public void setPopulation(long newPopulation) {
        this.population = newPopulation;
    }

    public double calculerDensite() {
        return population / superficie;
    }

    @Override
    public String toString() {
        return String.format("Continent #%c, Nom: %s, Capital: %s, Superficie: %skm2, Population: %d habitant(s)", continent, nom, capitale, superficie, population);
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the object references are the same
        if (this == obj) return true;

        // Check if obj is an instance of Pays
        if (!(obj instanceof Pays)) return false;

        // Cast the object to Pays and compare based on `nom`
        Pays other = (Pays) obj;
        return this.nom != null && this.nom.equalsIgnoreCase(other.nom);
    }

}
