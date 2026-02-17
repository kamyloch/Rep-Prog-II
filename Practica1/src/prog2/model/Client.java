package prog2.model;

public class Client implements InClient {
    private String nom;
    private String getDni;

    //Constructor
    public Client(String nom, String getDni) {
        this.nom = nom;
        this.getDni = getDni;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDni(String dni) {
        this.getDni = dni;
    }

    //Getters
    public String getNom() {
        return nom;
    }
    public String getDni() {
        return getDni;
    }
}
