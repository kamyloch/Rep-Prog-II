package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos , Serializable {
    private ArrayList<Acces> accesos;

    public LlistaAccessos(){
        this.accesos = new ArrayList<>();
    }



    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     *
     * @param acc Objecte de tipus Acces.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAcces(Acces acc)  {
        if(!accesos.contains(acc))
            accesos.add(acc);
    }

    /**
     * Buida la llista d'accessos
     */
    @Override
    public void buidar() {
        accesos.clear();
    }

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat boolean
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     *
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        if (accesos.isEmpty())
            throw new ExcepcioCamping("La llista está buida");

        StringBuilder sb = new StringBuilder("");

        Iterator<Acces> it = accesos.iterator();

        while (it.hasNext()) {
            Acces actual= it.next();
            if (actual.getEstat() == estat)
                sb.append(actual.toString()).append("\n");
        }

        String resultado = sb.toString();

        if (resultado.equals(""))
            throw new ExcepcioCamping("No hi ha allotjaments amb l'estat " + estat);

        return sb.toString();
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> it = accesos.iterator();
        while(it.hasNext()){
            Acces actual = it.next();
            if (actual.getAAllotjaments().containsAllotjamentOperatiu())
                actual.obrirAcces();
            else
                actual.tancarAcces();
        }
    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     *
     * @return int
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        if (accesos.isEmpty())
            throw new ExcepcioCamping("La llista está buida");

        int total = 0;
        Acces actual = null;
        for(Iterator<Acces> it  = accesos.iterator(); it.hasNext();actual = it.next())
            total += actual.isAccessibilitat()? 1:0;

        return total;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     *
     * @return float amb els metres totals.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float total = 0;
        Acces actual = null;
        Iterator<Acces> it  = accesos.iterator();
        while(it.hasNext()){
            actual = it.next();
            if (actual instanceof AccesTerra){
                total += ((AccesTerra) actual).getLongitud();
            }
        }
        if(total == 0){
            throw new ExcepcioCamping("No hi han accessos de terra");
        }

        return total;
    }
}
