package prog2.model;

class Glamping extends Casa{
    private String material;
    private boolean casaMascotes;
    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public Glamping(String nom_, String Id_,boolean estat,String iluminacio, String mida_, int numHabit_, int capacitat_, String material_, boolean casaMascotes_){
        super(nom_, Id_, estat,iluminacio,mida_, numHabit_, capacitat_,3,3);
        material=material_;
        casaMascotes=casaMascotes_;
        setEstadaMinima(3,3); //Estada segons el material
    }
    //Getters
    public String getMaterial(){
        return material;
    }
    public boolean getCasaMascotes(){
        return casaMascotes;
    }
    //Setters
    public void setMaterial(String material_){
        material=material_;
    }
    public void setCasaGossos(boolean casaMascotes_){
        casaMascotes=casaMascotes_;
    }

    //Mètodes
    @Override
    /** L'única condició és que hi hagi casa per a mascotes **/
    public boolean correcteFuncionament(){
        boolean funciona=false;
        if(casaMascotes==true)
            funciona=true;
        return funciona;
    }
}