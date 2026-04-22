package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public abstract class Prestec implements InPrestec, Serializable {
    private Exemplar exemplar;
    private Usuari usuari;
    private Date data;
    private boolean retornat;

    public Prestec (Exemplar exemplar, Usuari usuari, Date data){
        setExemplar(exemplar);
        setUsuari(usuari);
        setDataCreacio(data);
    }

    @Override
    public void setExemplar(Exemplar exemplar_) {
        exemplar = exemplar_;
    }

    @Override
    public Exemplar getExemplar() {
        return exemplar;
    }

    @Override
    public void setUsuari(Usuari usuari_) {
        usuari = usuari_;
    }

    @Override
    public Usuari getUsuari() {
        return usuari;
    }

    @Override
    public void setDataCreacio(Date data_) {
        data = data_;
    }

    @Override
    public Date getDataCreacio() {
        return data;
    }

    @Override
    public void setDataLimitRetorn(Date data_) {
        data = data_;
    }

    @Override
    public Date getDataLimitRetorn() {
        return data;
    }

    @Override
    public abstract String tipusPrestec();

    @Override
    public void setRetornat(boolean retornat_) {
        retornat = retornat_;
    }

    @Override
    public boolean getRetornat() {
        return retornat;
    }

    /**
     * Retornar prestec. Llança excepció si el prestec ja es vaig retornar
     */
    @Override
    public void retorna() {
        if (getRetornat())
            throw new BiblioException("Es préstec ja es va retornar");
        setRetornat(true);
    }

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    @Override
    public abstract long duradaPrestec();

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    @Override
    public boolean prestecEndarrerit() {
        Date ara = new Date();
        return getDataCreacio().before(ara);
    }

    @Override
    public String toString(){
        return "Tipus=" + tipusPrestec() +
                ", Exemplar=" + getExemplar().getAutor() +
                ", Usuari=" + getUsuari().getNom() +
                ", Data de creacio=" + getDataCreacio() +
                ", Data límit retorn=" + getDataLimitRetorn() +
                ", Retornat=" + getRetornat();
    }
}
