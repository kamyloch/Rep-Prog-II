
package prog2.vista;

/**
 *Exepcio Camping extends de runtime, aixi no ens obliga a posar try catch en fer mètodes que llençin alguna exception "sneaky"
 * @author Camilo i Jean
 */
public class ExcepcioCamping extends RuntimeException {
    public ExcepcioCamping(String missatge) {
        super(missatge);
    }
}
