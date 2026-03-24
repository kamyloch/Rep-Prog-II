package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {

    private float pesMaxim;

    public CarreteraAsfalt(String nom, boolean estat, float asfalt, float pesMaxim) {
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
}
