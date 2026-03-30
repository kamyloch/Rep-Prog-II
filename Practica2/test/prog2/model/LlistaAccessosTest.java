package prog2.model;

import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaAccessosTest {

    //Accesos per les proves
    Acces acc1 = new CamiTerra("CamiTerra",false,20);
    Acces acc2 = new CarreteraTerra("Caterraterra", true,10000,0.22F);
    Acces acc3 = new CamiAsfaltat("Asfalt",false, 30.2F);

    @Test
    void afegirAcces() {
        LlistaAccessos llista = new LlistaAccessos();
        llista.afegirAcces(acc1);
        llista.afegirAcces(acc2);
        llista.afegirAcces(acc3);
        //No es poden accesos duplicats (per nom)
        assertThrows(ExcepcioCamping.class, () -> {llista.afegirAcces(acc1);});
    }

    @Test
    void buidar() {
        LlistaAccessos llista = new LlistaAccessos();
        llista.afegirAcces(acc1);
        llista.afegirAcces(acc2);
        llista.afegirAcces(acc3);
        llista.buidar();

        ExcepcioCamping e1 = assertThrows(ExcepcioCamping.class, () -> {llista.llistarAccessos(true);});
        ExcepcioCamping e2 = assertThrows(ExcepcioCamping.class, () -> {llista.llistarAccessos(false);});
        assertEquals("La llista está buida",e1.getMessage());
        assertEquals("La llista está buida",e2.getMessage());
    }

    @Test
    void llistarAccessos() {
        LlistaAccessos llista = new LlistaAccessos();
        llista.afegirAcces(acc1); //false
        llista.afegirAcces(acc2); //true
        llista.afegirAcces(acc3); //false
        assertEquals("Nom: Caterraterra, Estat: obert, Longitud: 10000.0, Amplada: 0.22m",llista.llistarAccessos(true).toString());
        assertEquals("Nom: CamiTerra, Estat: tancat, Longitud: 20.0\nNom: Asfalt, Estat: tancat, Àrea: 30.2m²", llista.llistarAccessos(false).toString());
    }

    @Test
    void actualitzaEstatAccessos() {
        LlistaAccessos llista = new LlistaAccessos();
        llista.afegirAcces(acc1); //false
        llista.afegirAcces(acc2); //true
        llista.afegirAcces(acc3); //false
        llista.actualitzaEstatAccessos();
        //fent debug s'actualitza corectanment
    }

    @Test
    void calculaAccessosNoAccessibles() {
        LlistaAccessos llista = new LlistaAccessos();
        llista.afegirAcces(acc1); //false
        llista.afegirAcces(acc2); //true
        llista.afegirAcces(acc3); //false
        assertEquals(2,llista.calculaAccessosNoAccessibles());
    }

    @Test
    void calculaMetresTerra() {
        LlistaAccessos llista = new LlistaAccessos();
        llista.afegirAcces(acc1);//20m²
        llista.afegirAcces(acc2);//10000m²
        llista.afegirAcces(acc3);//No té terra
        assertEquals(10020,llista.calculaMetresTerra());

    }
}