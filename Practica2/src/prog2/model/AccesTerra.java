package prog2.model;

import java.io.Serializable;

public abstract class AccesTerra extends Acces implements Serializable {

    private float longitud;

    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    public float getLongitud() {return longitud;}
    public void setLongitud(float longitud) {this.longitud = longitud;}

    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String toString(){
        return super.toString()+", Longitud: "+longitud;
    }
}
