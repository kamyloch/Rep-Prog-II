package prog2.model;

import java.io.Serializable;
import java.util.Date;

/**Subclasse de prestec que representa un tipus de prèstec normal
 *
 */
public class PrestecNormal extends Prestec{


    public PrestecNormal(Exemplar exemplar,Usuari usuari, Date data){
        super(exemplar,usuari, data);
    }
    @Override
    public String tipusPrestec() {
        return "Normal";
    }

    @Override
    public long duradaPrestec() {
        return 70000;
    }
}
