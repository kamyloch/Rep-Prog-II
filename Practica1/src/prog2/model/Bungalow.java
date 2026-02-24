package prog2.model;

public class Bungalow extends Casa {
    private boolean televisio;
    private boolean aireFred;
    private int placesParquing;

    //Constructor
    public Bungalow (String nom_, String Id_, String mida_, int numHabit_, int capacitat_,boolean televisio_,boolean aireFred_,int places_){
        super(nom_, Id_, mida_, numHabit_, capacitat_);
        aireFred = aireFred_;
        televisio = televisio_;
        placesParquing = places_;
    }

    //Getters
    public boolean getAireFred(){return aireFred;}
    public boolean getTelevisio(){return televisio;}
    public int getPlacesParquing (){
        return placesParquing;
    }
    //Setters
    public void setTelevisio(boolean televisio_){televisio=televisio_;}
    public void setAireFred(boolean aireFred_){aireFred=aireFred_;}
    public void setPlacesParquing(int placesParquing_){placesParquing=placesParquing_;}

    //Mètodes
    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }
}