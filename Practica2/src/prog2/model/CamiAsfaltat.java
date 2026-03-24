package prog2.model;

import java.io.Serializable;

public class CamiAsfaltat extends AccesAsfalt implements Serializable {

    public CamiAsfaltat(String nom, boolean estat, float asfalt) {
        super(nom, estat, asfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
