package prog2.model;

import prog2.vista.BiblioException;

/** Subclasse de Llista<Usuari> que implementa el mètode afegir
 *
 */
public class LlistaUsuaris extends Llista<Usuari>{

    public LlistaUsuaris(){
        super();
    }

    @Override
    public void afegir(Usuari user) throws BiblioException {
        if (llista.contains(user))
            throw new BiblioException("Ja hi ha un exemplar amb el mateix nom : " + user.getNom());
        else
            llista.add(user);
    }

    public boolean contains(String email){
        return llista.contains(new Estudiant(email, "", ""));
    }
}
