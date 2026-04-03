package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import static prog2.model.TascaManteniment.TipusTascaManteniment.Desinfeccio;
import static prog2.model.TascaManteniment.TipusTascaManteniment.Neteja;

class LlistaTasquesMantenimentTest {
    private LlistaTasquesManteniment llista;

    @BeforeEach
    void setUp(){
        llista=new LlistaTasquesManteniment();
    }
    @Test
    void afegirTascaManteniment() throws ExcepcioCamping {
        Parcela parcela=new Parcela("Parcela nord","PAR1",true,"100%",20f,true);
        llista.afegirTascaManteniment(1,"Desinfeccio",parcela,"2026/02/04",7);
        assertEquals("Numero:1, Tipus:" +"Desinfeccio, Allotjament:PAR1, Data:2026-02-04, Dies per completar-la:7",llista.llistarTasquesManteniment());
        assertEquals("0%",parcela.getIluminacio());
    }

    @Test
    void completarTascaManteniment() throws ExcepcioCamping{
        Parcela parcela=new Parcela("Parcela nord","PAR1",true,"100%",20f,true);
        llista.afegirTascaManteniment(1,"Desinfeccio",parcela,"2026/02/04",7);
        TascaManteniment tasca=new TascaManteniment(1,Desinfeccio,parcela,"2026/02/04",7);
        llista.completarTascaManteniment(tasca);

        ExcepcioCamping excepcio =assertThrows(ExcepcioCamping.class,()->{llista.llistarTasquesManteniment();});
        assertEquals("La llista està buida",excepcio.getMessage());
        assertEquals("100%",parcela.getIluminacio());
    }

    @Test
    void llistarTasquesManteniment() throws ExcepcioCamping {
        Parcela parcela1=new Parcela("Parcela nord","PAR1",true,"100%",20f,true);
        Parcela parcela2=new Parcela("Parcela sud","PAR2",true,"100%",20f,true);
        Parcela parcela3=new Parcela("Parcela est","PAR3",true,"100%",20f,true);

        llista.afegirTascaManteniment(1,"Neteja",parcela1,"2026/02/04",7);
        llista.afegirTascaManteniment(2,"Reparacio",parcela2,"2026/02/01",4);
        llista.afegirTascaManteniment(3,"Desinfeccio",parcela3,"2026/02/06",3);

        String str="Numero:1, Tipus:" +"Neteja, Allotjament:PAR1, Data:2026-02-04, Dies per completar-la:7\n";
        str+="Numero:2, Tipus:" +"Reparacio, Allotjament:PAR2, Data:2026-02-01, Dies per completar-la:4\n";
        str+="Numero:3, Tipus:" +"Desinfeccio, Allotjament:PAR3, Data:2026-02-06, Dies per completar-la:3";

        assertEquals(str,llista.llistarTasquesManteniment());

    }
}