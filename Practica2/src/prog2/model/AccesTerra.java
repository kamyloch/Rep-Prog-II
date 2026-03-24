package prog2.model;

public abstract class AccesTerra extends Acces{

    private float longitud;

    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    public float getLongitud() {return longitud;}
    public void setLongitud(float longitud) {this.longitud = longitud;}

    @Override
    public abstract boolean isAccessibilitat();
}
