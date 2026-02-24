package prog2.model;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String Id;
    private long estadaAlta;
    private long estadaBaixa;

    //Constructor
    public Allotjament(String nom, String Id) {
        this.nom = nom;
        this.Id = Id;
    }

    //Setters
    public  void  setId(String Id) {
        this.Id = Id;
    }
    public  void setEstadaMinima(long baixa, long alta) {
        this.estadaAlta = alta;
        this.estadaBaixa= baixa;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Getters
    public String getNom() {
        return nom;
    }
    public long getEstadaMinima(Temp temp) {
        return temp == Temp.BAIXA? estadaBaixa:estadaAlta;
    }
    public String getId() {
        return Id;
    }

    //Mètodes
    public abstract boolean correcteFuncionament();
}