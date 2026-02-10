import java.util.Scanner;

public class CalculadoraMain {
    public static void main(String[] args) {
        double resultat;
        double num1, num2;
        Scanner sc;

        // Crear un objecte Scanner per llegir dades des del teclat
        sc = new Scanner(System.in);

        // Demanem les dades a l'usuari
        System.out.print("Entra el primer número a sumar: ");
        num1 = sc.nextDouble(); // Llegim el primer número

        System.out.print("Entra el según número a sumar: ");
        num2 = sc.nextDouble(); // Llegim el segon número

        // Calculem la suma dels dos números amb el mètode sumar
        resultat = sumar(num1, num2);
        System.out.println("Resultat "+resultat+"!");

        // Exemple d'ús del mètode buclePerSumar
        // Afegeix els números de l'1 al 10 al número 10
        System.out.println("Resultat "+buclePerSumar(10)+"!");

    }

    // Mètode estàtic per sumar dos nombres
    // Recordeu: un mètode estàtic és un mètode que pertany a la mateixa classe
    // i es pot cridar sense crear cap objecte.
    public static double sumar(double a, double b){
        return a+b;
    }

    // Mètode estàtic per restar dos nombres
    public static double restar(double a, double b){
        return b-a;
    }

    /**
     * Afegeix els valors del 1 al 10 al nombre donat i retorna el resultat.
     *
     * @param a valor inicial al qual s’afegeixen els nombres
     * @return el resultat final després d’afegir els valors del 0 al 9
     */
    public static double buclePerSumar(double a){
        for(int i = 1; i <= 10; i++){
            a = sumar(a, i); // Afegim cada valor de 1 a 10
        }
        return a; // Retornem el resultat final
    }

}

