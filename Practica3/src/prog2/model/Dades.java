package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades, Serializable {

    private LlistaExemplars exemplars;
    private LlistaPrestecs prestecs;
    private LlistaUsuaris usuaris;

    public Dades (){
        usuaris = new LlistaUsuaris();
        exemplars = new LlistaExemplars();
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



    private boolean teEndarreit(Usuari user){;
        ArrayList<Prestec> llista = prestecs.getArrayList();
        Iterator<Prestec> it = llista.iterator();

        while(it.hasNext()){
            Prestec p = it.next();
            if (p.getUsuari().equals(user) && p.prestecEndarrerit())
                return true;
        }
        return false;
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
        //Posicio Vàlida
        if(exemplarPos<0 || exemplarPos>=exemplars.getSize())
            throw new BiblioException("No existeix l'exemplar amb número "+exemplarPos);
        if(usuariPos<0 || usuariPos>=usuaris.getSize())
            throw new BiblioException("No existeix l'usuari amb número "+usuariPos);

        Exemplar exemplar = exemplars.getAt(exemplarPos);
        Usuari usuari = usuaris.getAt(usuariPos);

        //Afegir un objecte de tipus PrestecLlarg per a un exempler que no admet prestec llargs.
        if (esLlarg && !exemplar.getAdmetPrestecLlarg())
            throw new BiblioException("Aquest exemplar no admet prestec llarg");

        //Fer un prestec d’un exemplar no disponible.
        if (!exemplar.isDisponible())
            throw new  BiblioException("Aquest exemplar no està disponible");

        //Fer un prestec a un usuari que té prestecs endarrerits.
        if (teEndarreit(usuari))
            throw new BiblioException("Aquest usuari té pestecs endarreits");

        //Fer un prestec a un usuari que excedeix el seu limit de prestecs normals o prestecs llargs.
        if (esLlarg && usuari.getNumPrestecsLlargs()==usuari.getMaxPrestecsLlargs())
            throw new BiblioException("Aquest usuari ha arribat al màxim de prèstecs llargs");
        if (!esLlarg && usuari.getNumPrestecsNormals()==usuari.getMaxPrestecsNormals())
            throw new BiblioException("Aquest usuari ha arribat al màxim de prèstecs normals");

        if (esLlarg){
            prestecs.afegir(new PrestecLlarg(exemplar,usuari, new Date()));
            usuari.setNumPrestecsLlargs(usuari.getNumPrestecsLlargs()+1);
        }
        else{
            prestecs.afegir(new PrestecNormal(exemplar,usuari, new Date()));
            usuari.setNumPrestecsNormals(usuari.getNumPrestecsNormals()+1);
        }

        exemplar.setDisponible(false);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    @Override
    public void retornarPrestec(int position) throws BiblioException {
        Prestec prestec = recuperaPrestecsNoRetornats().get(position);
        prestec.retorna();

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
        ArrayList<Prestec> noRetornat = new ArrayList<>();
        Iterator<Prestec> it =prestecs.getArrayList().iterator();
        while(it.hasNext()){
            Prestec act=it.next();
            if (!act.getRetornat())
                noRetornat.add(act);
        }
        if (noRetornat.isEmpty())
            return null;
        return noRetornat;
    }
}
