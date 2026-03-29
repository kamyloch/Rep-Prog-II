package prog2.model;

import java.io.Serializable;

/** Classe que representa les carreteres de terra del camping
 */
public class CarreteraTerra extends AccesTerra implements Serializable {

    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float longitud,float amplada) {
        super(nom, estat, longitud);
        this.amplada=amplada;
    }

    /** Retorna el la amplada
     * @return float
     */
    public float getAmplada() {return amplada;}

    /** Estableix l'amplada
     * @param amplada l'amplada a establir
     */
    public void setAmplada(float amplada) {this.amplada = amplada;}

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString(){
        return super.toString()+", Amplada: "+amplada+"m";
    }
}
