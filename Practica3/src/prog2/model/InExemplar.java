package prog2.model;

/**Interfície de la classe Exemplar
 *
 */
public interface InExemplar {
    void setId(String id);

    String getId();

    void setTitol(String titol);

    String getTitol();

    void setAutor(String autor);

    String getAutor();

    void setAdmetPrestecLlarg(boolean admetPrestecLlarg);

    boolean getAdmetPrestecLlarg();

    @Override
    String toString();
}
