package prog2.model;

public class Bungalow extends Casa {
    private boolean televisio;
    private boolean aireFred;
    private int placesParquing;
    private boolean terrassa;

    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public Bungalow (String nom_, String Id_,boolean estat,String iluminacio, String mida_, int numHabit_, int capacitat_,int places_,boolean terrassa_,boolean televisio_,boolean aireFred_){
        super(nom_, Id_,estat,iluminacio, mida_, numHabit_, capacitat_,7,4);
        aireFred = aireFred_;
        televisio = televisio_;
        placesParquing = places_;
        terrassa=terrassa_;
    }
    //Getters
    public boolean getAireFred(){return aireFred;}
    public boolean getTelevisio(){return televisio;}
    public int getPlacesParquing (){return placesParquing;}
    public boolean getTerrassa(){return terrassa;}
    //Setters
    public void setTelevisio(boolean televisio_){televisio=televisio_;}
    public void setAireFred(boolean aireFred_){aireFred=aireFred_;}
    public void setPlacesParquing(int placesParquing_){placesParquing=placesParquing_;}
    public void setTerrassa(boolean terrassa_){terrassa=terrassa_;}

    //Mètodes
    @Override
    /** L'única condició és aireFred **/
    public boolean correcteFuncionament() {
        boolean funciona=false;
        if(aireFred==true)
            funciona=true;
        return funciona;
    }
}