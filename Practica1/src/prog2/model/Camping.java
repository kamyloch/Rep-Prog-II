package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping{
    private String nom;
    private LlistaReserves llistaReserves;
    private ArrayList <Allotjament> llistaAllotjaments;
    private ArrayList <Client> llistaClients;


    //Constructor
    public Camping(String nom){
        this.nom = nom;
        this.llistaReserves = new LlistaReserves();
        this.llistaClients = new ArrayList<Client>();
        this.llistaAllotjaments = new ArrayList<Allotjament>();
    }

    //Getters
    public String getNom() {
        return nom;
    }
    public LlistaReserves getLlistaReserves(){
        return llistaReserves;
    }
    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return llistaAllotjaments;
    }
    public ArrayList<Client> getLlistaClients(){
        return llistaClients;
    }
    public int getNumAllotjaments(){
        return llistaAllotjaments.size();
    }
    public int getNumReserves() {
        return llistaReserves.getNumReserves();
    }
    public  int getNumClients(){
        return llistaClients.size();
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Afegir Allotjaments
    public void afegirClient(String nom_, String dni_){
        llistaClients.add(new Client(nom_,dni_));
    }
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        llistaAllotjaments.add(new Parcela(nom_,idAllotjament_,metres,connexioElectrica));
    }
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        llistaAllotjaments.add(new Bungalow(nom_,idAllotjament_,mida,habitacions,placesPersones,placesParquing, terrassa, tv, aireFred));
    }
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        llistaAllotjaments.add(new BungalowPremium(nom_,idAllotjament_,mida,habitacions,placesPersones,placesParquing,terrassa,tv,aireFred,serveisExtra,codiWifi));
    }
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        llistaAllotjaments.add(new Glamping(nom_,idAllotjament_,mida,habitacions,placesPersones,material,casaMascota));
    }
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        llistaAllotjaments.add(new MobilHome(nom_,idAllotjament_,mida,habitacions,placesPersones,terrassaBarbacoa));
    }

    //Afegir reserva
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        int i=0;
        while(i<getNumClients() && !(llistaClients.get(i).getDni().equals(dni_))){i++;}
        if(i==getNumClients())
            throw new ExcepcioReserva("No existeix aquest client");
        Client c =  llistaClients.get(i);

        i=0;
        while(i<getNumAllotjaments() && !(llistaAllotjaments.get(i).getId().equals(id_))){i++;}
        if(i==getNumAllotjaments())
            throw new ExcepcioReserva("No existeix aquest allotjament");
        Allotjament a = llistaAllotjaments.get(i);

        llistaReserves.afegirReserva(a,c,dataEntrada, dataSortida);
    }

    public int calculAllotjamentsOperatius() {
        int op = 0;
        for (int i = 0; i<getNumAllotjaments(); i++)
            if (llistaAllotjaments.get(i).correcteFuncionament()) op++;
        return op;
    }
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Allotjament minA = new Parcela("0", "0", 0, false);
        long min = Long.MAX_VALUE;

        for (int i = 0; i < getNumAllotjaments(); i++) {
            Allotjament act = llistaAllotjaments.get(i);
            if (act.getEstadaMinima(temp) < min) {
                minA = act;
                min = act.getEstadaMinima(temp);
            }
        }
        return minA;
    }
}
