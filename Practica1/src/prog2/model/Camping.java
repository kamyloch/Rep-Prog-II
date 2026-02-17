package prog2.model;

public class Camping implements InCamping{
    private String nom;
    public Camping(String nom){
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
