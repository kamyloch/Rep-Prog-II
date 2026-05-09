package prog2.model;

/**Interficie de la classe Usuari
 *
 */
public interface InUsuari {
    void setEmail(String email);

    String getEmail();

    void setNom(String nom);

    String getNom();

    void setAdreca(String adreca);

    String getAdreca();

    String tipusUsuari();

    void setNumPrestecsNormals(int numPrestecsNormals);

    int getNumPrestecsNormals();

    void setNumPrestecsLlargs(int numPrestecstLlargs);

    int getNumPrestecsLlargs();

    int getMaxPrestecsNormals();

    int getMaxPrestecsLlargs();

    @Override
    String toString();
}
