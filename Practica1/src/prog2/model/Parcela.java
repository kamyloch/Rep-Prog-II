package prog2.model;

public class Parcela extends Allotjament{
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
    public boolean isConnexioElectrica(){
        return connexio;
    }
    //Setters
    public void setMida( float mida_){ mida=mida_;}
    public void setConnexioElectrica( boolean connexio_){ connexio=connexio_;}

    public boolean correcteFuncionament(){return connexio;}
}