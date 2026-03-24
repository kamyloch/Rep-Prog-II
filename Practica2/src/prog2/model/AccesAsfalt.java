package prog2.model;

public abstract class AccesAsfalt extends Acces{

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
