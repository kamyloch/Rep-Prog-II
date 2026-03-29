package prog2.model;

import java.io.Serializable;

/** Classe abstracte que representa els allotjaments del camping
 */
public abstract class Allotjament implements InAllotjament, Serializable {
    private String nom;
    private String Id;
    private long estadaAlta;
    private long estadaBaixa;
    private boolean estat;
    private String iluminacio;

    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public Allotjament(String nom, String Id, long alta, long baixa, boolean estat, String iluminacio) {
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

    /** Retorna l'estat (obert o tancat)
     * @return boolean
     */
    public boolean getEstat() {return estat;}

    /** Retorna el nivell d'iluminació
     * @return String
     */
    public String getIluminacio(){
        return iluminacio;
    }

    //Mètodes
    /** Cada subclase haura de implementar correcte funcionament **/
    public abstract boolean correcteFuncionament();

    /**
     * Retorna una representació String de l'objecte
     * @return String
     */
    public String toString(){
        return "Nom="+getNom()+
                ", Id="+getId()+
                ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA)+
                ", estada mínima en temp BAIXA: " +getEstadaMinima(Temp.BAIXA) + ".";
    }

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    public boolean isOperatiu(){//??? el test lo nesecitaba
        return estat;
    }

    @Override
    public void obrirAllotjament() {
        estat=true;
        iluminacio = "100%";
    }

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     * @param tasca Objecte de tipus TascaManteniment.
     */
    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
        estat = false;
        this.iluminacio = tasca.getIluminacioAllotjament();
    }

    /**
     * Retona si dos allotjaments són iguals.
     * @param obj l'objecte a comparar.
     * @return boolean
     */
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Allotjament))
            return super.equals(obj);

        String altreId = ((Allotjament)obj).getId();

        return altreId.equals(this.Id);
    }
}