package prog2.model;

import static prog2.model.InAllotjament.Iluminacio.*; //Enum
import static prog2.model.TascaManteniment.TipusTascaManteniment.*; //Contingut


public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String Id;
    private long estadaAlta;
    private long estadaBaixa;
    private String estat;
    private Iluminacio iluminacio;

    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public Allotjament(String nom, String Id, long alta, long baixa, String estat, Iluminacio iluminacio) {
        this.nom = nom;
        this.Id = Id;
        this.estat = estat;
        this.iluminacio = iluminacio;
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
    public void setEstat(String estat) { this.estat = estat; }
    public void setIluminacio(Iluminacio iluminacio) {this.iluminacio = iluminacio; }

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
    public String getEstat() {return estat;}
    public Iluminacio getIluminacio() {return iluminacio;}

    //Mètodes
    /** Cada subclase haura de implementar correcte funcionament **/
    public abstract boolean correcteFuncionament();
    public String toString(){
        return "Nom="+getNom()+
                ", Id="+getId()+
                ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA)+
                ", estada mínima en temp BAIXA: " +getEstadaMinima(Temp.BAIXA) + ".";
    }

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    @Override
    public void obrirAllotjament() {
        estat="Operatiu";
        iluminacio = CENT;
    }

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     * @param tasca Objecte de tipus TascaManteniment.
     */
    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
        estat = "No operatiu";
        switch(tasca.getTipus()){
            case Reparacio:
                setIluminacio(CINQUANTA);
                break;
            case Neteja:
                setIluminacio(CENT);
                break;
            case RevisioTecnica:
                setIluminacio(CINQUANTA);
                break;
            case Desinfeccio:
                setIluminacio(ZERO);
                break;
        }
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Allotjament))
            return super.equals(obj);

        String altreId = ((Allotjament)obj).getId();

        return altreId.equals(this.Id);
    }
}