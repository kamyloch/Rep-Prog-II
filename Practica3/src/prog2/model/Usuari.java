package prog2.model;

import java.io.Serializable;

public abstract class Usuari implements InUsuari, Serializable {

    private String email;
    private String nom;
    private String adreca;
    int numPrestecsNormals;
    int numPrestecsLlargs;

    public Usuari(String email_, String nom_,String adreca_){
        setEmail(email_);
        setNom(nom_);
        setAdreca(adreca_);
        setNumPrestecsNormals(0);
        setNumPrestecsLlargs(0);
    }

    @Override
    public void setEmail(String email_) {
        email = email_;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setNom(String nom_) {
        nom = nom_;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setAdreca(String adreca_) {
        adreca = adreca_;
    }

    @Override
    public String getAdreca() {
        return adreca;
    }

    @Override
    public abstract String tipusUsuari();

    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals_) {
        numPrestecsNormals = numPrestecsNormals_;
    }

    @Override
    public int getNumPrestecsNormals() {
        return numPrestecsNormals;
    }

    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs_) {
        numPrestecsLlargs = numPrestecstLlargs_;
    }

    @Override
    public int getNumPrestecsLlargs() {
        return numPrestecsLlargs;
    }

    @Override
    public abstract int getMaxPrestecsNormals();

    @Override
    public abstract  int getMaxPrestecsLlargs();
    
    @Override
    public boolean equals(Object o){
        if (o instanceof  Usuari)
            return getEmail().equals(((Usuari) o).getEmail());
        return false;
    }

    @Override
    public String toString(){
        return "Tipus="+ tipusUsuari() +
                ", Email=" + getEmail() +
                ", Nom=" + getNom() +
                ", Adreca=" + getAdreca() +
                ", Num. prestecs normals=" +getNumPrestecsNormals() +
                ", Num. prestecs llargs=" + getNumPrestecsLlargs();
    }
}
