import java.util.Scanner;

public class MainPOO {
    public static void main(String[] args) {

        double num; // Variable per emmagatzemar el número introduït per l'usuari
        Scanner sc; // Objecte Scanner per llegir dades des del teclat
        sc = new Scanner(System.in); // Inicialitzem el Scanner

        // Creem un objecte de la classe Calculadora
        Calculadora calculadora = new Calculadora();

        // Primer número a sumar
        System.out.print("Entra el número a sumar: ");
        num = Double.parseDouble(sc.nextLine());
        calculadora.sumar(num);
        System.out.println("Resultat "+calculadora.getResult()+"!");

        // Segon número a sumar
        System.out.print("Entra el número a sumar: ");
        num = Double.parseDouble(sc.nextLine());
        calculadora.sumar(num);
        System.out.println("Resultat "+calculadora.getResult()+"!");
    }
}

