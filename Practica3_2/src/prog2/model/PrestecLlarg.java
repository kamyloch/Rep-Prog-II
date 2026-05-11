package prog2.model;

import java.io.Serializable;
import java.util.Date;

/**Subclasse de prestec que representa un tipus de prèstec llarg
 *
 */
public class PrestecLlarg extends Prestec {


    public PrestecLlarg(Exemplar exemplar,Usuari usuari, Date data){
        super(exemplar,usuari, data);
    }
    @Override
    public String tipusPrestec() {
        return "Llarg";
    }

    @Override
    public long duradaPrestec() {
        return 140000;
    }
}
