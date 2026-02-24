package prog2.model;

class Glamping extends Casa{
    private String material;
    private boolean casaMascotes;

    //Constructor
    public Glamping(String nom_,String Id_,String mida_,int numHabit_, int capacitat_, String material_,boolean casaMascotes_){
        super(nom_, Id_, mida_, numHabit_, capacitat_);
        material=material_;
        casaMascotes=casaMascotes_;
    }
    //Getters
    public String getMaterial(){ return material; }
    public boolean getCasaMascotes(){ return casaMascotes; }

    //Setters
    public void setMaterial(String material_){ material=material_; }
    public void setCasaGossos(boolean casaMascotes_){casaMascotes=casaMascotes_;}

    public boolean correcteFuncionament(){return casaMascotes;}
}