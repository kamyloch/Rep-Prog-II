package prog2.model;

public class BungalowPremium extends Bungalow{
    private String codiWifi;
    private boolean llencolsTovalloles;
    //Constructor
    public BungalowPremium(String nom_, String Id_, String mida_, int numHabit_, int capacitat_,int places_,boolean terrassa_,boolean televisio_,boolean aireFred_,boolean llencolsTovalloles_,String codiWifi_){
        super(nom_, Id_, mida_, numHabit_, capacitat_,places_,terrassa_,televisio_,aireFred_);
        codiWifi=codiWifi_;
        llencolsTovalloles=llencolsTovalloles_;
        setEstadaMinima(7,4);
    }
    //Getters
    public String getCodiWifi(){ return codiWifi; }
    public boolean getLlencolsTovalloles(){ return llencolsTovalloles;}

    //Setters
    public void setCodiWifi(String codiWifi_){ codiWifi=codiWifi_;}
    public void setLlencolsTovalloles(boolean LlencolsTovalloles_){ llencolsTovalloles=LlencolsTovalloles_; }

    //Mètodes

    @Override
    public boolean correcteFuncionament() {
        boolean correcteWifi = 8 <= codiWifi.length() && codiWifi.length() <= 16;
        return super.correcteFuncionament() && correcteWifi;
    }
}