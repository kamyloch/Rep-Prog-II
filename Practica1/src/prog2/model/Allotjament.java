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
    //Setters
    public void setMida( float mida_){ mida=mida_;}
    public void setConnexio( boolean connexio_){ connexio=connexio_;}
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
    //Setters
    public void setMida(String mida_){ mida=mida_;}
    public void setNumHabit(int numHabit_){numHabit=numHabit_;}
    public void setCapacitat( int capacitat_){ capacitat=capacitat_;}
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
    //Setters
    public void setPlacesParquing(int placesParquing_){placesParquing=placesParquing_;}
}
class BungalowPremium extends Bungalow{
    private String codiWifi;
    //NO SE SI PONER ALGUN ATRIBUTO MAS PQ LLENÇOLS I TOVALLOLES CREO QUE NO SE USAN
    //Constructor
    public BungalowPremium(String nom_, String Id_, String mida_, int numHabit_, int capacitat_, int places_, String codiWifi_){
        super(nom_, Id_, mida_, numHabit_, capacitat_,places_);
        codiWifi=codiWifi_;
    }
    //Getters
    public String getCodiWifi(){ return codiWifi; }
    //Setters
    public void setCodiWifi(String codiWifi_){ codiWifi=codiWifi_;}
}

class Glamping extends Casa{
    private String material;
    private boolean casaGossos;

    //Constructor
    public Glamping(String nom_,String Id_,String mida_,int numHabit_, int capacitat_, String material_,boolean casaGossos_){
        super(nom_, Id_, mida_, numHabit_, capacitat_);
        material=material_;
        casaGossos=casaGossos_;
    }
    //Getters
    public String getMaterial(){ return material; }
    public boolean getCasaGossos(){ return casaGossos; }

    //Setters
    public void setMaterial(String material_){ material=material_; }
    public void setCasaGossos(boolean casaGossos_){casaGossos=casaGossos_;}
}

class MobilHome extends Casa{
    private boolean terrassaAmbBarbacoa;
    //Constructor
    public MobilHome(String nom_,String Id_,String mida_,int numHabit_, int capacitat_,boolean terrassaAmbBarbacoa_){
        super(nom_, Id_, mida_, numHabit_, capacitat_);
        terrassaAmbBarbacoa=terrassaAmbBarbacoa_;
    }
    //Getters
    public boolean getTerrassaAmbBarbacoa(){ return terrassaAmbBarbacoa;}
    //Setters
    public void setTerrassaAmbBarbacoa(boolean terrassaAmbBarbacoa_){ terrassaAmbBarbacoa=terrassaAmbBarbacoa_; }
}