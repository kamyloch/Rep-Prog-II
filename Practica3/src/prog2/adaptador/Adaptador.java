package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;

public class Adaptador {
    private Dades dades;

    public Adaptador(){
        dades=new Dades();
    }

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
            oos.writeObject(this);
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
}
