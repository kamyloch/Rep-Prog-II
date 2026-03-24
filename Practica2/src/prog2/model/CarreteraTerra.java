package prog2.model;

public class CarreteraTerra extends AccesTerra{

    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float longitud,float amplada) {
        super(nom, estat, longitud);
        this.amplada=amplada;
    }

    public float getAmplada() {return amplada;}

    public void setAmplada(float amplada) {this.amplada = amplada;}

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
