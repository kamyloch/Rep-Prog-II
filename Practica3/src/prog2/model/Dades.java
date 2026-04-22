package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Dades implements InDades, Serializable {

    private LlistaExemplars exemplars;
    private LlistaPrestecs prestecs;
    private LlistaUsuaris usuaris;

    public Dades (){
        usuaris = new LlistaUsuaris<>();
        exemplars = new LlistaExemplars<>();
        prestecs = new LlistaPrestecs();
    }

    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     *
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     */
    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        exemplars.afegir(new Exemplar(id,titol,autor,admetPrestecLlarg));
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     */
    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        return exemplars.getArrayList();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     */
    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        if (esEstudiant)
            usuaris.afegir(new Estudiant(email,nom,adreca));
        else
            usuaris.afegir(new Professor(email,nom,adreca));
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return usuaris.getArrayList();
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar
     * i usuari dins dels seus ArrayLists
     *
     * @param exemplarPos
     * @param usuariPos
     * @param esLlarg
     */
    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        //Falta hacer Prestec llarg-normal
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    @Override
    public void retornarPrestec(int position) throws BiblioException {
        ((Prestec)prestecs.getAt(position)).retorna();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return prestecs.getArrayList();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        ArrayList<Prestec> noReotrn = new ArrayList<>();
        //Quitar el for each
        for (Prestec p : recuperaPrestecs())
            if (p.getRetornat())
                noReotrn.add(p);

        if (noReotrn.isEmpty())
            return null;
        return noReotrn;
    }
}
