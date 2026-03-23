package prog2.model;

public class BungalowPremium extends Bungalow{
    private String codiWifi;
    private boolean serveisExtra;
    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public BungalowPremium(String nom_, String Id_,String estat, String iluminacio, String mida_, int numHabit_, int capacitat_,int places_,boolean terrassa_,boolean televisio_,boolean aireFred_,boolean serveisExtra_,String codiWifi_){
        super(nom_, Id_, estat,iluminacio, mida_, numHabit_, capacitat_,places_,terrassa_,televisio_,aireFred_);
        codiWifi=codiWifi_;
        serveisExtra=serveisExtra_;
        setEstadaMinima(7,4); //Estada segons el material (És la mateixa que el normal)
    }
    //Getters
    public String getCodiWifi(){ return codiWifi; }
    public boolean getLlencolsTovalloles(){ return serveisExtra;}
    //Setters
    public void setCodiWifi(String codiWifi_){ codiWifi=codiWifi_;}
    public void setLlencolsTovalloles(boolean serveisExtra_){ serveisExtra=serveisExtra_; }

    //Mètodes
    @Override
    /** La condició aireFred(super)  +  una llargada de [8,16] al wifi (clau)*/
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