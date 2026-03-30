package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesTest {

    private Acces acces1;
    private Acces acces2;

    @BeforeEach
    void setUp() {
        // Dos accessos inicials i un allotjament
        acces1 = new Acces("Acces 1", true){
            @Override
            public boolean isAccessibilitat() {
                return true;
            }
        };
        acces2 = new Acces("Acces 2", false){
            @Override
            public boolean isAccessibilitat() {
                return false;
            }
        };
    }

    @Test
    void comprovarConstructor(){
        assertEquals(acces1.getNom(), "Acces 1");
        assertEquals(acces2.getNom(), "Acces 2");
        assertTrue(acces1.isAccessibilitat());
        assertFalse(acces2.isAccessibilitat());
        assertTrue(acces1.getEstat());
        assertFalse(acces2.getEstat());
        assertTrue(acces1.getAAllotjaments() instanceof LlistaAllotjaments);
    }
    @Test
    void afegirAllotjament() {
        Allotjament all = new BungalowPremium("NewBunga","ALL1",false, "0%",12,1,12,2,false,true,false,true,"wifi88888888");
        acces1.afegirAllotjament(all);
        assertTrue(acces1.getAAllotjaments().contains(all));
        //Els allotjaments de cada acces no es podràn duplicar
        assertThrows(ExcepcioCamping.class, () -> {acces1.afegirAllotjament(all);});

    }

    @Test
    void tancarAcces() {
        acces2.tancarAcces();
        assertFalse(acces2.getEstat());
    }

    @Test
    void obrirAcces() {
        acces2.obrirAcces();
        assertTrue(acces2.getEstat());
    }

    @Test
    void isAccessibilitat() {
        Acces ambCotxe = new CarreteraAsfaltada("No permèt Cotxe",false,12,12);
        Acces ambCotxe2 = new CarreteraTerra("No permèt Cotxe",false,12,23232);
        Acces senseCotxe = new CamiTerra("SI permèt cotxe", false,19292);
        Acces senseCotxe2 = new CamiAsfaltat("SI Permet cotxe",false,12);

        assertTrue(ambCotxe.isAccessibilitat());
        assertTrue(ambCotxe2.isAccessibilitat());
        assertFalse(senseCotxe.isAccessibilitat());
        assertFalse(senseCotxe2.isAccessibilitat());
    }

    @Test
    void testToString() {
        Acces ambCotxe = new CarreteraAsfaltada("No permèt Cotxe",false,12,12);
        Acces ambCotxe2 = new CarreteraTerra("No permèt Cotxe",false,12,23232);
        Acces senseCotxe = new CamiTerra("SI permèt cotxe", false,19292);
        Acces senseCotxe2 = new CamiAsfaltat("SI Permet cotxe",false,12);
        assertEquals("Nom: No permèt Cotxe, Estat: tancat, Àrea: 12.0m², Pes màxim: 12.0kg", ambCotxe.toString());
        assertEquals("Nom: No permèt Cotxe, Estat: tancat, Longitud: 12.0, Amplada: 23232.0m",ambCotxe2.toString());
        assertEquals("Nom: SI permèt cotxe, Estat: tancat, Longitud: 19292.0",senseCotxe.toString());
        assertEquals("Nom: SI Permet cotxe, Estat: tancat, Àrea: 12.0m²",senseCotxe2.toString());
    }
}
