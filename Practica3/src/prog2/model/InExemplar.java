package prog2.model;

/**Interfície de la classe Exemplar
 *
 */
public interface InExemplar {
    /**Assigna la Id de l'exemplar
     *
     * @param id
     */
    void setId(String id);

    /**Retorna la Id de l'exemplar
     *
     * @return String
     */
    String getId();

    /**Assigna el titol de l'exemplar
     *
     * @param titol
     */
    void setTitol(String titol);

    /**Retorna el títol de l'exemplar
     *
     * @return String
     */
    String getTitol();

    /**Assigna l'autor del llibre
     *
     * @param autor
     */
    void setAutor(String autor);

    /**Retorna l'autor de l'exemplar
     *
     * @return String
     */
    String getAutor();

    /**Assigna si l'exemplar admet un prèstec llarg o no
     *
     * @param admetPrestecLlarg
     */
    void setAdmetPrestecLlarg(boolean admetPrestecLlarg);

    /** Retorna si l'exemplar admet un prèstec llarg
     *
     * @return boolean
     */
    boolean getAdmetPrestecLlarg();

    /**Retorna una representació en String de l'exemplar
     *
     * @return String
     */
    @Override
    String toString();
}
