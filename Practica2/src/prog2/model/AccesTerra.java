package prog2.model;

import java.io.Serializable;

/** Classe abstracte que representa els accessos de terra del camping
 */
public abstract class AccesTerra extends Acces implements Serializable {

    private float longitud;

    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Retorna la longitud de l'accés.
     * @return float
     */
    public float getLongitud() {return longitud;}

    /**
     * Estableix la longitud de l'accés .
     * @param longitud la longitud a assignar.
     */
    public void setLongitud(float longitud) {this.longitud = longitud;}

    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String toString(){
        return super.toString()+", Longitud: "+longitud;
    }
}
