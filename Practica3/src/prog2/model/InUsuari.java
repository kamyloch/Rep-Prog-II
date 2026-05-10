package prog2.model;

/**Interficie de la classe Usuari
 *
 */
public interface InUsuari {

    /**Assigna l'email de l'usuari
     *
     * @param email
     */
    void setEmail(String email);

    /**Retorna el email de l'usuari
     *
     * @return String
     */
    String getEmail();

    /**Assigna el nom de l'usuari
     *
     * @param nom
     */
    void setNom(String nom);

    /**Retorna el nom de l'usuari
     *
     * @return String
     */
    String getNom();

    /**Assigna l'adreça de l'usuari
     *
     * @param adreca
     */
    void setAdreca(String adreca);

    /**Retorna l'adreça de l'usuari
     *
     * @return String
     */
    String getAdreca();

    /**Retorna el tipus d'usuari
     *
     * @return String
     */
    String tipusUsuari();

    /**Assigna el número de préstecs normals de l'usuari
     *
     * @param numPrestecsNormals
     */
    void setNumPrestecsNormals(int numPrestecsNormals);

    /**Retorna el número de préstecs normals de l'usuari
     *
     * @return int
     */
    int getNumPrestecsNormals();

    /**Assigna el número de préstecs llargs de l'usuari
     *
     * @param numPrestecstLlargs
     */
    void setNumPrestecsLlargs(int numPrestecstLlargs);

    /**Retorna el número de préstecs llargs de l'usuari
     *
     * @return int
     */
    int getNumPrestecsLlargs();

    /**Retorna el màxim de préstecs normals de l'usuari
     *
     * @return int
     */
    int getMaxPrestecsNormals();

    /**Retorna el màxim de préstecs llargs de l'usuari
     *
     * @return int
     */
    int getMaxPrestecsLlargs();

    /**Retorna una representació en String de l'usuari
     *
     * @return String
     */
    @Override
    String toString();
}
