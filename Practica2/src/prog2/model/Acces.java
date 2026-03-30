package prog2.model;

import prog2.vista.ExcepcioCamping;

import javax.smartcardio.CardException;
import java.io.Serializable;
/** Classe abstracte que representa els accessos del camping
 */
public abstract class Acces implements InAcces, Serializable {
    private String nom;
    private boolean estat;
    private LlistaAllotjaments accesos;


    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.accesos = new LlistaAllotjaments();
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        if (accesos.contains(allotjament))
            throw new ExcepcioCamping("Aquest acces ja conté un allotjament amb id " + allotjament.getId());
        accesos.afegirAllotjament(allotjament);
    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() {
        this.estat =  true;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return
     */
    @Override
    public abstract boolean  isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     *
     * @return
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     * @return
     */
    @Override
    public boolean getEstat() {
        return estat;
    }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     * @return LlistaAllotjaments
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return accesos;
    }

    /**
     * Retorna una representació String de l'objecte
     * @return String
     */
    @Override
    public String toString(){
        return "Nom: "+getNom()+", Estat: " + (estat? "obert" : "tancat");
    }
}
