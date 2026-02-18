package prog2.model;

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

    //Mètodes

    public void afegirClient(String nom_, String dni_){
        llistaClients.add(new Client(nom_,dni_));
    }
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        llistaAllotjaments.add(new Parcela(nom_,idAllotjament_,metres,connexioElectrica));
    }
}
