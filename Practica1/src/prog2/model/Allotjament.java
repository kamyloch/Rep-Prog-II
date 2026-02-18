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
    public boolean correcteFuncionament() {
        return false; /////D
    }
}

//Subclases
class Parcela extends Allotjament{
    private float mida;
    private boolean connexio;

    public Parcela (String nom_, String Id_, float mida_, boolean connexio_){
        super(nom_, Id_);
        mida = mida_;
        connexio = connexio_;
    }
    //Getters
    public float getMida(){
        return mida;
    }
    public boolean getConnexio(){
        return connexio;
    }
}

abstract class Casa extends Allotjament{
    private String mida;
    private int numHabit;
    private int capacitat;

    //Constructor
    public Casa (String nom_, String Id_, String mida_, int numHabit_, int capacitat_) {
        super(nom_, Id_);
        mida = mida_;
        numHabit = numHabit_;
        capacitat = capacitat_;
    }
    //Getters
    public String getMida(){
        return mida;
    }
    public int getNumHabitants(){
        return numHabit;
    }
    public int getCapacitat(){
        return capacitat;
    }
}
class Bungalow extends Casa {
    private boolean televisio;
    private boolean
    private int placesParquing;

    //Constructor
    public Bungalow (String nom_, String Id_, String mida_, int numHabit_, int capacitat_, int places_){
        super(nom_, Id_, mida_, numHabit_, capacitat_);
        placesParquing = places_;
    }

    //Getters
    public int getPlacesParquing (){
        return placesParquing;
    }
}
