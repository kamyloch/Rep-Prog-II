package prog2.model;

import java.io.Serializable;

public class Parcela extends Allotjament implements Serializable {
    private float mida;
    private boolean connexio;
    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public Parcela (String nom_, String Id_,boolean estat, String iluminacio, float mida_, boolean connexio_){
        super(nom_, Id_,4,2,estat,iluminacio); //Estada segons el material
        mida = mida_;
        connexio = connexio_;
    }
    //Getters
    public float getMida(){
        return mida;
    }
    public boolean isConnexioElectrica(){
        return connexio;
    }

    //Setters
    public void setMida( float mida_){
        mida=mida_;
    }
    public void setConnexioElectrica( boolean connexio_){
        connexio=connexio_;
    }

    //Mètodes
    @Override
    /** L'única condició és tindre connexió **/
    public boolean correcteFuncionament(){
        boolean funciona=false;
        if(connexio==true)
            funciona=true;
        return funciona;
    }
}