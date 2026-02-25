package prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaAmbBarbacoa;
    //Constructor
    public MobilHome(String nom_,String Id_,String mida_,int numHabit_, int capacitat_,boolean terrassaAmbBarbacoa_){
        super(nom_, Id_, mida_, numHabit_, capacitat_);
        terrassaAmbBarbacoa=terrassaAmbBarbacoa_;
        setEstadaMinima(5,3);
    }
    //Getters
    public boolean getTerrassaAmbBarbacoa(){ return terrassaAmbBarbacoa;}
    //Setters
    public void setTerrassaAmbBarbacoa(boolean terrassaAmbBarbacoa_){ terrassaAmbBarbacoa=terrassaAmbBarbacoa_; }

    public boolean correcteFuncionament(){return terrassaAmbBarbacoa;}
}