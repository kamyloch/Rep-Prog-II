package prog2.model;

public class BungalowPremium extends Bungalow{
    private String codiWifi;
    private boolean llencolsTovalloles;
    //Constructor
    public BungalowPremium(String nom_, String Id_, String mida_, int numHabit_, int capacitat_,int places_,boolean terrassa_,boolean televisio_,boolean aireFred_,boolean llencolsTovalloles_,String codiWifi_){
        super(nom_, Id_, mida_, numHabit_, capacitat_,places_,terrassa_,televisio_,aireFred_);
        codiWifi=codiWifi_;
        llencolsTovalloles=llencolsTovalloles_;
        setEstadaMinima(7,4); //Estada segons el material (És la mateixa que el normal)
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
        int wifiSize = codiWifi.length();
        boolean correcteWifi = false;
        //Condicions
        if (8 <= wifiSize && wifiSize <= 16)
            correcteWifi=true;
        correcteWifi &= super.correcteFuncionament();
        return correcteWifi;
    }
}