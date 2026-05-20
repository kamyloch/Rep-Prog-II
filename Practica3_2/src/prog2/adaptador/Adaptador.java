package prog2.adaptador;

import prog2.model.*;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;


/**Classe adaptadora que permet la interacció entre els elements del paquet vista i el paquet model
 *
 */
public class Adaptador implements Serializable{
    private Dades dades;

    public Adaptador(){
        dades=new Dades();
    }

    /**Guarda les dades donada la direcció d'un fitxer
     *
     * @param camiDesti
     * @throws BiblioException
     */
    public void guardaDades(String camiDesti) throws BiblioException{
        File fitxer = new File(camiDesti);

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try{
            fout=new FileOutputStream(fitxer);
        }catch(FileNotFoundException ex){
            throw new BiblioException("El fitxer no s'ha trobat");
        }

        try{
            oos=new ObjectOutputStream(fout);}
        catch(IOException ex){
            throw new BiblioException ("No s'ha pogut crear l'objecte per escriure al fitxer");
        }try {
            oos.writeObject(dades);
        }catch(IOException ex){
            throw new BiblioException("No s'ha pogut escriure al fitxer");
        }finally {
            try {
                oos.close();
                fout.close();
            } catch (IOException ex) {
                throw new BiblioException("No s'ha pogut tancar el fitxer");
            }
        }
    }

    /**Carrega les dades donada la direcció d'un fitxer
     *
     * @param camiDesti
     * @throws BiblioException
     */
    public void carregaDades(String camiDesti) throws BiblioException {
        File fitxer = new File(camiDesti);
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(fitxer);
        } catch (FileNotFoundException ex) {
            throw new BiblioException("El fitxer no s'ha trobat");
        }

        try {
            ois = new ObjectInputStream(fin);
        } catch (IOException ex) {
            throw new BiblioException("No s'ha pogut crear l'objecte per llegir al fitxer");
        }
        try {
            dades = (Dades) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new BiblioException("No s'ha pogut llegir al fitxer");
        } finally {
            try {
                ois.close();
                fin.close();
            } catch (IOException ex) {
                throw new BiblioException("No s'ha pogut tancar el fitxer");
            }
        }
    }
    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     *
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     */
    public ArrayList<Exemplar> recuperaExemplars() {
        return dades.recuperaExemplars();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    public ArrayList<Usuari> recuperaUsuaris() {
        return dades.recuperaUsuaris();
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
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    public void retornarPrestec(int position) throws BiblioException {
        dades.retornarPrestec(position);
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    public ArrayList<Prestec> recuperaPrestecs() {
        return dades.recuperaPrestecs();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     */
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        return dades.recuperaPrestecsNoRetornats();
    }

    public void retornarPrestecTots(int position) throws BiblioException {
        try{
            Prestec prestec=dades.recuperaPrestecs().get(position);
            int position2=-1,i=0;
            Iterator<Prestec> it=dades.recuperaPrestecsNoRetornats().iterator();
            while(it.hasNext()){
                Prestec act=it.next();
                if(prestec.equals(act))
                    position2=i;
                i++;
            }
            dades.retornarPrestec(position2);
        }catch(Exception ex){
            throw new BiblioException("El prèstec seleccionat ja està retornat");
        }
    }

}
