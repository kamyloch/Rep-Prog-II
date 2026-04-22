package prog2.model;

import java.io.Serializable;

public class Estudiant extends Usuari implements Serializable {

    public Estudiant(String email_, String nom_,String adreca_){
        super(email_,nom_,adreca_);
    }

    @Override
    public String tipusUsuari() {
        return "Estudiant";
    }

    @Override
    public int getMaxPrestecsNormals() {
        return 2;
    }

    @Override
    public int getMaxPrestecsLlargs() {
        return 1;
    }

}
