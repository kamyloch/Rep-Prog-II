import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraMainTest {

    //Comprova que la suma de dos nombres es calcula correctament.
    @Test
    void testSumaDosNumeros() {
        double resultat = CalculadoraMain.sumar(2.5, 3.5);
        assertEquals(6.0, resultat, 0.0001, "La suma ha de ser 6.0");
    }

   //Comprova que la resta de dos nombres es calcula correctament.
    @Test
    void testRestaDosNumeros() {
        double resultat = CalculadoraMain.restar(10.0, 5.0);
        assertEquals(5.0, resultat, 0.0001, "La suma ha de ser 5.0");
    }

   //Comprova que la resta de dos nombres iguals es calcula correctament.
    @Test
    void testRestaDosNumerosIguals() {
        double resultat = CalculadoraMain.restar(5.5, 5.5);
        assertEquals(0.0, resultat, 0.0001, "La suma ha de ser 0.0");
    }


    //Comprova que el mètode buclePerSumar funciona correctament.
    @Test
    void testBuclePerSumarCorrecte() {
        double resultat = CalculadoraMain.buclePerSumar(10.0);
        assertEquals(65.0, resultat, 0.0001, "El resultat ha de ser 65.0");
    }

}


