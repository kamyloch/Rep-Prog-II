package prog2.model;

import java.io.Serializable;

public abstract class AccesAsfalt extends Acces implements Serializable {

    private float asfalt;

    public AccesAsfalt(String nom, boolean estat, float asfalt) {
        super(nom, estat);
        this.asfalt = asfalt;
    }

    public void setAsfalt(float asfalt) {
        this.asfalt = asfalt;
    }

    public float getAsfalt() {
        return asfalt;
    }

    @Override
    public abstract boolean isAccessibilitat();
}
