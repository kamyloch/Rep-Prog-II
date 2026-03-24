package prog2.model;

import java.io.Serializable;

public class MobilHome extends Casa implements Serializable {
    private boolean terrassaAmbBarbacoa;
    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public MobilHome(String nom_,String Id_,boolean estat,String iluminacio,float mida_,int numHabit_, int capacitat_,boolean terrassaAmbBarbacoa_){
        super(nom_, Id_,estat,iluminacio,mida_, numHabit_, capacitat_,5,3);
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
    /** L'única condició és tenir terrassa amb barbacoa **/
    public boolean correcteFuncionament(){
        boolean funciona=false;
        if(terrassaAmbBarbacoa==true)
            funciona=true;
        return funciona;

    }
}