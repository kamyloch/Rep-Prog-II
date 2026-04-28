package prog2.model;

public class LlistaUsuaris<Usuari> extends Llista<Usuari>{

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
}
