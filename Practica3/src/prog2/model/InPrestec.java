package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

/** Interfície de la classe Prestec
 *
 */
public interface InPrestec {
    /**Assigna un exemplar al préstec
     *
     * @param exemplar
     */
    void setExemplar(Exemplar exemplar);

    /**Retorna l'exemplar del préstec
     *
     * @return Exemplar
     */
    Exemplar getExemplar();

    /**Assigna un usuari al préstec
     *
     * @param usuari
     */
    void setUsuari(Usuari usuari);

    /**Retorna l'usuari del préstec
     *
     * @return Usuari
     */
    Usuari getUsuari();

    /**Assigna la data de creació del préstec
     *
     * @param data
     */
    void setDataCreacio(Date data);

    /**Retorna la data de creació del préstec
     *
     * @return Date
     */
    Date getDataCreacio();

    /** Assigna la data límit de retorn del préstec
     *
     * @param data
     */
    void setDataLimitRetorn(Date data);

    /**Retorna la data límit de retorn del préstec
     *
     * @return Date
     */
    Date getDataLimitRetorn();

    /**Retorna el tipus de prèstec (normal o llarg)
     *
     * @return String
     */
    String tipusPrestec();

    /**Assigna si el préstec està retornat o no
     *
     * @param retornat
     */
    void setRetornat(boolean retornat);

    /**Retorna si el préstec ha estat retornat o no
     *
     * @return boolean
     */
    boolean getRetornat();

    /**
     * Retornar prestec. Llança excepció si el prestec ja es vaig retornar
     */
    void retorna();

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    long duradaPrestec();

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    boolean prestecEndarrerit();

    /**Retorna una representació en String del prèstec
     *
     * @return String
     */
    @Override
    String toString();
}
