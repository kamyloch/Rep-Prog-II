package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/** Classe que implementa una llista d'allotjaments
 */
public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {

    private ArrayList<Allotjament> llistaAllotjaments;


    //Constructor
    public LlistaAllotjaments() {
        llistaAllotjaments = new ArrayList<>();
    }

    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     *
     * @param allotjament Objecte de tipus Allotjament
     *
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament){
        if(llistaAllotjaments.contains(allotjament))
            throw new ExcepcioCamping("Ja existeix un allotjament amb el ID " + allotjament.getId());
        llistaAllotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        llistaAllotjaments.clear();
    }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        if (llistaAllotjaments.isEmpty())
            throw new ExcepcioCamping("La llista está buida");
        if (!estat.equals("Operatiu") && !estat.equals("No Operatiu"))
            throw new ExcepcioCamping("Estat no vàlid");

        boolean volgut = estat.equals("Operatiu");

        StringBuilder sb = new StringBuilder("");

        Iterator<Allotjament> it = llistaAllotjaments.iterator();

        while (it.hasNext()) {
            Allotjament actual= it.next();
            if (actual.getEstat() == volgut)
                sb.append(actual.toString()).append("\n");
        }

        String resultado = sb.toString();

        if (resultado.equals(""))
            throw new ExcepcioCamping("No hi ha allotjaments amb l'estat " + estat);

        return sb.toString().trim();
    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     *
     * @return boolean
     */
    @Override
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> it = llistaAllotjaments.iterator();
        boolean trobat = false;
        while (it.hasNext() && !trobat) {
            Allotjament actual= it.next();
            trobat = actual.getEstat(); //???
        }
        return trobat;
    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     *
     * @param allotjament
     * @return boolean
     */
    @Override
    public boolean contains(Allotjament allotjament) {
        return llistaAllotjaments.contains(allotjament);
    }

    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     *
     * @param id String amb el id de l'allotjament
     * @return Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> it = llistaAllotjaments.iterator();
        while(it.hasNext()){
            Allotjament allotjament=it.next();
            if(allotjament.getId().equals(id))
                return allotjament;
        }
        throw new ExcepcioCamping("El allotjament no està a la llista");
    }
}
