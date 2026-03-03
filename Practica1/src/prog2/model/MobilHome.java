package prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaAmbBarbacoa;
    //Constructor
    public MobilHome(String nom_,String Id_,String mida_,int numHabit_, int capacitat_,boolean terrassaAmbBarbacoa_){
        super(nom_, Id_, mida_, numHabit_, capacitat_);
        terrassaAmbBarbacoa=terrassaAmbBarbacoa_;
        setEstadaMinima(5,3); //Estada segons el material
        //Com que casa havia posat (0,0), doncs ho fem ara
    }
    //Getters
    public boolean getTerrassaAmbBarbacoa(){
        return terrassaAmbBarbacoa;
    }
    //Setters
    public void setTerrassaAmbBarbacoa(boolean terrassaAmbBarbacoa_){
        terrassaAmbBarbacoa=terrassaAmbBarbacoa_;
    }

    //Mètodes
    @Override
    public boolean correcteFuncionament(){
        boolean funciona=false;
        if(terrassaAmbBarbacoa==true)
            funciona=true;
        return funciona;

    }
}