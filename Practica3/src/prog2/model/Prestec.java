package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Date;

/**Classe abstracta que representa un prèstec
 *
 */
public abstract class Prestec implements InPrestec, Serializable {
    private Exemplar exemplar;
    private Usuari usuari;
    private Date dataCreacio;
    private Date dataLimit;
    private boolean retornat;

    public Prestec (Exemplar exemplar, Usuari usuari, Date data){
        setExemplar(exemplar);
        this.exemplar.setDisponible(false);
        setUsuari(usuari);
        setDataCreacio(data);
        setDataLimitRetorn(new Date(data.getTime()+duradaPrestec()));
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
        dataCreacio = data_;
    }

    @Override
    public Date getDataCreacio() {
        return dataCreacio;
    }

    @Override
    public void setDataLimitRetorn(Date data_) {
        dataLimit = data_;
    }

    @Override
    public Date getDataLimitRetorn() {
        return dataLimit;
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
        if(tipusPrestec().equals("Llarg"))
            usuari.setNumPrestecsLlargs(usuari.getNumPrestecsLlargs()-1);
        else
            usuari.setNumPrestecsNormals(usuari.getNumPrestecsNormals()-1);
        exemplar.setDisponible(true);
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
        return !getRetornat() && getDataLimitRetorn().before(ara);
    }

    @Override
    public String toString(){
        return "Tipus=" + tipusPrestec() +
                ", Exemplar=" + getExemplar().getTitol() +
                ", Usuari=" + getUsuari().getNom() +
                ", Data de creacio=" + getDataCreacio() +
                ", Data límit retorn=" + getDataLimitRetorn() +
                ", Retornat=" + getRetornat();
    }
}
