package prog2.model;

public class Camping implements InCamping{
    private String nom;
    private LlistaReserves llistaReserves;
    private int numAllotjaments;
    private int NumClients;


    //Constructor
    public Camping(String nom){
        this.nom = nom;
    }

    //Getters
    public String getNom() {
        return nom;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
}
