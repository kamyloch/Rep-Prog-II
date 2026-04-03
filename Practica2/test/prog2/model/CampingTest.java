package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class CampingTest {

    private Camping camping;

    @BeforeEach
    void setUp() {
        camping= new Camping("green");
        camping.inicialitzaDadesCamping();
    }

    @Test
    void afegirTascaMantenimentDisponible() throws ExcepcioCamping {
        camping.afegirTascaManteniment(1,"Neteja","ALL3","2026/02/04",7);
        assertEquals("Numero:1, Tipus:" +"Neteja, Allotjament:ALL3, Data:2026-02-04, Dies per completar-la:7",camping.llistarTasquesManteniment());
        assertEquals(2,camping.llistarAccessos("Tancat").split("\r?\n").length); //veiem quants accessos s'han llistat
    }

    @Test
    void afegirTascaMantenimentNoDisponible() throws ExcepcioCamping {

        //tasca incorrecta
        ExcepcioCamping excepcio = assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirTascaManteniment(1,"Net","ALL3","2026/02/04",7);
        });
        assertEquals("La tasca que es vol afegir no existeix",excepcio.getMessage());

        //id incorrecte
        excepcio = assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirTascaManteniment(1,"Neteja","idIncorrecta","2026/02/04",7);
        });
        assertEquals("El allotjament no està a la llista",excepcio.getMessage());

        //data incorrecta
        excepcio = assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirTascaManteniment(1,"Neteja","ALL3","20/02/2026",7);
        });
        assertEquals("Format de data incorrecte, si us plau [aaaa-mm-dd o aaaa/mm/dd]",excepcio.getMessage());

        //allotjament ja té tasca
        camping.afegirTascaManteniment(1,"Neteja","ALL3","2026/02/04",7);
        excepcio = assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirTascaManteniment(2,"Neteja","ALL3","2026/02/10",3);
        });
        assertEquals("Aquest allotjament ja té una tasca assignada",excepcio.getMessage());

        //numero ja usat
        excepcio = assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirTascaManteniment(1,"Neteja","ALL2","2026/02/10",3);
        });
        assertEquals("Ja existeix una tasca amb aquest numero",excepcio.getMessage());
    }

    @Test
    void completarTascaManteniment() throws ExcepcioCamping{
        camping.afegirTascaManteniment(1,"Neteja","ALL3","2026/02/04",7);
        camping.completarTascaManteniment(1);
        ExcepcioCamping excepcio = assertThrows(ExcepcioCamping.class, () -> {
            camping.llistarTasquesManteniment();
        });
        assertEquals("La llista està buida",excepcio.getMessage());
        excepcio=assertThrows(ExcepcioCamping.class, () -> {
            camping.llistarAccessos("Tancat");
        });
        assertEquals("No hi ha accessos amb l'estat Tancat",excepcio.getMessage());
    }

    @Test
    void save() throws ExcepcioCamping{
        camping.afegirTascaManteniment(1,"Neteja","ALL3","2026/02/04",7);
        camping.save("saved.txt");
    }

    @Test
    void load() throws ExcepcioCamping{
        camping=Camping.load("saved.txt");
        assertEquals("Numero:1, Tipus:" +"Neteja, Allotjament:ALL3, Data:2026-02-04, Dies per completar-la:7",camping.llistarTasquesManteniment());
    }
}