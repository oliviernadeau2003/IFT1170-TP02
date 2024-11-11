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

    // Getters
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

}
