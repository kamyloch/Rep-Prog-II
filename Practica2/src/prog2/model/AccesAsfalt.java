package prog2.model;

import java.io.Serializable;

/** Classe abstracte que representa els accessos d'asfalt del camping
 */
public abstract class AccesAsfalt extends Acces implements Serializable {

    private float asfalt;

    public AccesAsfalt(String nom, boolean estat, float asfalt) {
        super(nom, estat);
        this.asfalt = asfalt;
    }

    /**
     * Estableix els metres quadrats d'asfalt.
     * @param asfalt els metres quadrats a assignar.
     */
    public void setAsfalt(float asfalt) {
        this.asfalt = asfalt;
    }

    /**
     * Retorna els metres quadrats d'asfalt
     * @return float
     */
    public float getAsfalt() {
        return asfalt;
    }


    @Override
    public abstract boolean isAccessibilitat();


    @Override
    public String toString(){
        return super.toString()+", Àrea: "+asfalt+"m²";
    }
}
