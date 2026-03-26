package prog2.model;

import java.io.Serializable;

public class CarreteraAsfaltada extends AccesAsfalt implements Serializable {

    private float pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat, float asfalt, float pesMaxim) {
        super(nom, estat, asfalt);
        this.pesMaxim = pesMaxim;
        ;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    public float getPesMaxim() {
        return pesMaxim;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString(){
        return super.toString()+", Pes màxim: "+pesMaxim+"kg";
    }
}
