package prog2.model;

public class Allotjament implements InAllotjament{
    private String nom;
    private String Id;
    private Temp temp;
    private long estadaMinima;
    private long estadaMaxima;

    //Constructor
    public   Allotjament(String nom, String Id, Temp temp) {
        this.nom = nom;
        this.Id = Id;
        this.temp = temp;

    }

    //Setters
    public  void  setId(String Id) {
        this.Id = Id;
    }

    public void  setTemp(Temp temp) {
        this.temp = temp;
    }

    public  void setEstadaMinima(long estadaMinima, long estadaMaxima) {
        this.estadaMinima = estadaMinima;
        this.estadaMaxima = estadaMaxima;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Getters
    public String getNom() {
        return nom;
    }
    public long getEstadaMinima(Temp temp) {
        return temp == Temp.BAIXA?estadaMinima:estadaMaxima;
    }

    public String getId() {
        return Id;
    }

    public boolean correcteFuncionament() {
        return false; /////D
    }
}
