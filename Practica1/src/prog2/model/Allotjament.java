package prog2.model;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String Id;
    private long estadaAlta;
    private long estadaBaixa;
    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public Allotjament(String nom, String Id,long alta,long baixa) {
        this.nom = nom;
        this.Id = Id;
        setEstadaMinima(alta,baixa);
    }
    //Setters
    public  void  setId(String Id) {
        this.Id = Id;
    }
    public  void setEstadaMinima(long alta, long baixa) {
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
        long sortida = 0;
        switch (temp){
            case BAIXA -> sortida = estadaBaixa;
            case ALTA -> sortida = estadaAlta;
        }
        return sortida;
    }
    public String getId() {
        return Id;
    }

    //Mètodes
    /** Cada subclase haura de implementar correcte funcionament **/
    public abstract boolean correcteFuncionament();
    public String toString(){
        return "Nom="+getNom()+
                ", Id="+getId()+
                ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA)+
                ", estada mínima en temp BAIXA: " +getEstadaMinima(Temp.BAIXA) + ".";
    }
}