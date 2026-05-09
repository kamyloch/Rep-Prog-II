package prog2.model;

import prog2.vista.BiblioException;

import java.util.Iterator;

/** Subclasse de Llista<Exemplar> que implementa el mètode afegir
 *
 */
public class LlistaExemplars extends Llista<Exemplar>{

    public LlistaExemplars (){
        super();
    }

    @Override
    public void afegir(Exemplar exemplar) throws BiblioException {
        if (llista.contains(exemplar))
            throw new BiblioException("Ja hi ha un exemplar amb el mateix id : " + exemplar.getId());
        else
            llista.add(exemplar);
    }
    public boolean contains(String exemplarId){
        return llista.contains(new Exemplar(exemplarId,"","",false));
    }
}
