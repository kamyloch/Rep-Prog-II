package prog2.model;

import java.io.Serializable;

public abstract class Casa extends Allotjament implements Serializable {
    private float mida;
    private int numHabit;
    private int capacitat;

    /**Constructor, getters i setters no gaire complicats
     * tenim en compte els atributs nous */
    //Constructor
    public Casa(String nom_, String Id_,boolean estat, String iluminacio,float mida_, int numHabit_, int capacitat_,long alta,long baixa) {
        super(nom_, Id_,alta,baixa,estat,iluminacio); //Casa no porta cap estada com que ès abstracta (cada constructor de subclase n'especifica)
        mida = mida_;
        numHabit = numHabit_;
        capacitat = capacitat_;
    }
    //Getters
    public float getMida(){
        return mida;
    }
    public int getNumHabitants(){
        return numHabit;
    }
    public int getCapacitat(){
        return capacitat;
    }
    //Setters
    public void setMida(float mida_){ mida=mida_;}
    public void setNumHabit(int numHabit_){numHabit=numHabit_;}
    public void setCapacitat( int capacitat_){ capacitat=capacitat_;}
}