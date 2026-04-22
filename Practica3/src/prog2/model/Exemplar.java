package prog2.model;

import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean disponible;

    public Exemplar (String id, String titol, String autor, boolean admetPrestecLlarg){
        setId(id);
        setTitol(titol);
        setAutor(autor);
        setAdmetPrestecLlarg(admetPrestecLlarg);
        setDisponible(true);
    }

    @Override
    public void setId(String id_) {
        id = id_;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTitol(String titol_) {
        titol = titol_;
    }

    @Override
    public String getTitol() {
        return titol;
    }

    @Override
    public void setAutor(String autor_) {
        autor= autor_;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg_) {
        admetPrestecLlarg =admetPrestecLlarg_;
    }

    @Override
    public boolean getAdmetPrestecLlarg() {
        return admetPrestecLlarg;
    }

    public void setDisponible(boolean disponible_){
        disponible = disponible_;
    }

    public boolean isDisponible(){
        return disponible;
    }

    @Override
    public boolean equals (Object o){
        if (o instanceof  Exemplar)
            return getId().equals(((Exemplar) o).getId());
        return false;
    }

    @Override
    public String toString(){
        return "Id=" + getId() +
                ", Titol=" + getTitol() +
                ", Autor=" + getAutor()+
                ", Admet Prestec Llarg=" + getAdmetPrestecLlarg() +
                ", Disponible=" + isDisponible();
    }
}
