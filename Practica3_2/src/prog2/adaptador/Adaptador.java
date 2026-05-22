package prog2.adaptador;

import prog2.model.*;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


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
     * Recuperar préstecs. Retorna un ArrayList de String amb tots els exemplars
     */
    public ArrayList<String> recuperaExemplars() {return toArrayString(dades.recuperaExemplars()); }

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
     * Recuperar usuaris. Retorna un ArrayList de String amb tots els usuaris
     */
    public ArrayList<String> recuperaUsuaris() {return toArrayString(dades.recuperaUsuaris());}

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
     * Recuperar préstecs. Retorna un ArrayList de String amb tots els préstecs
     */
    public ArrayList<String> recuperaPrestecs() {return toArrayString(dades.recuperaPrestecs());
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList de String amb els préstecs no retornats
     */
    public ArrayList<String> recuperaPrestecsNoRetornats() {return toArrayString(dades.recuperaPrestecsNoRetornats()); }

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
            throw new BiblioException("El préstec seleccionat ja s'ha retornat");
        }
    }



    private<T> ArrayList<String> toArrayString(ArrayList<T> llistaObj){
        Iterator<T> it=llistaObj.iterator();
        ArrayList<String> llista=new ArrayList<>();
        while(it.hasNext()){
            llista.add(it.next().toString());
        }
        return llista;
    }

    /**
     * Retorna un preset de adapador per provar la UB
     * @return Adaptador
     */
    public static Adaptador adaptadorDefault(){
        Adaptador a = new Adaptador();
        try {
            // --- 6 EXEMPLARS (id, titol, autor, admetPrestecLlarg) ---
            a.afegirExemplar("L-01", "La plaça del Diamant", "Mercè Rodoreda", true);
            a.afegirExemplar("L-02", "Mecanoscrit", "Manuel de Pedrolo", true);
            a.afegirExemplar("L-03", "Canto jo i la muntanya", "Irene Solà", false);
            a.afegirExemplar("L-04", "Mirall trencat", "Mercè Rodoreda", true);
            a.afegirExemplar("L-05", "El quadern gris", "Josep Pla", false);
            a.afegirExemplar("L-06", "Camí de sirga", "Jesús Moncada", true);

            // --- 6 USUARIS (email, nom, adreca, esEstudiant) ---
            a.afegirUsuari("jordi@email.cat", "Jordi Puig", "Carrer Major 15", true);
            a.afegirUsuari("marta@email.cat", "Marta Soler", "Av. Diagonal 420", false);
            a.afegirUsuari("arnau@email.cat", "Arnau Vives", "Carrer Riba 8", true);
            a.afegirUsuari("laia@email.cat", "Laia Gómez", "Plaça Nova 3", false);
            a.afegirUsuari("oriol@email.cat", "Oriol Martí", "Carrer Unió 24", true);
            a.afegirUsuari("silvia@email.cat", "Sílvia Roca", "Rambla 57", false);

            // --- 4 PRESTECS (exemplarPos, usuariPos, esLlarg) ---
            a.afegirPrestec(0, 0, true);
            a.afegirPrestec(1, 2, false);
            a.afegirPrestec(3, 1, true);
            a.afegirPrestec(4, 4, false);
        }
        catch (Exception e){
            System.err.println("Error inesperat:" + e.getMessage());
        }
        return a;
    }
}
