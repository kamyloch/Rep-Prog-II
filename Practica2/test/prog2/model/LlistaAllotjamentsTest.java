package prog2.model;

import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import static prog2.model.TascaManteniment.TipusTascaManteniment.*;

class LlistaAllotjamentsTest {

    Allotjament all1 = new MobilHome("Mobil","ALL1",true,"20%",30,10,10,false);
    Allotjament all2 = new Parcela("Parcela","ALL2",false,"100%",100,false);


    @Test
    void afegirAllotjament() {
        LlistaAllotjaments llista = new LlistaAllotjaments();
        llista.afegirAllotjament(all1);

        //No es pot duplicat
        assertThrows(ExcepcioCamping.class, () -> {llista.afegirAllotjament(all1);});
    }

    @Test
    void llistarAllotjaments() {
        LlistaAllotjaments llista = new LlistaAllotjaments();
        llista.afegirAllotjament(all1);//Operatiu
        llista.afegirAllotjament(all2);//No Operatiu

        //Ha de ser "Operatiu" o "No Operatiu" lletra per lletra
        assertThrows(ExcepcioCamping.class,()->{llista.llistarAllotjaments("XXXXXX");});
        assertEquals("Nom=Mobil, Id=ALL1, estada mínima en temp ALTA: 5, estada mínima en temp BAIXA: 3.",llista.llistarAllotjaments("Operatiu"));
        assertEquals("Nom=Parcela, Id=ALL2, estada mínima en temp ALTA: 4, estada mínima en temp BAIXA: 2.",llista.llistarAllotjaments("No Operatiu"));
    }

    @Test
    void containsAllotjamentOperatiu() {
        LlistaAllotjaments llista = new LlistaAllotjaments();
        llista.afegirAllotjament(all1);//Operatiu
        llista.afegirAllotjament(all2);//No Operatiu

        assertTrue(llista.containsAllotjamentOperatiu());

        LlistaAllotjaments llista2 = new LlistaAllotjaments();
        llista2.afegirAllotjament(all2);//No Operatiu

        assertFalse(llista2.containsAllotjamentOperatiu());

        LlistaAllotjaments llista3 = new LlistaAllotjaments();
        assertFalse(llista3.containsAllotjamentOperatiu());
    }

}