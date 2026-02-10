public class Calculadora {
    // Variable privada per emmagatzemar el resultat de les operacions
    private double result;

    // Constructor de la classe Calculadora
    // Inicialitza el resultat a 0
    public Calculadora() {
        result = 0;
    }

    // Mètode per sumar dos nombres i guardar el resultat
    public void sumar(double a, double b) {
        result = a + b;
    }

    // Mètode per sumar un nombre al resultat actual
    public void sumar(double a) {
        result += a;
    }

    // Mètode per sumar un nombre al resultat actual
    public void restar(double a, double b) {
        result = a - b;
    }

    // Mètode per restar un nombre al resultat actual
    public void restar(double a) {
        result -= a;
    }

    // Mètode per obtenir el resultat actual
    public double getResult() {
        return result;
    }

    // Mètode per establir un nou valor al resultat
    public void setResult(double a) {
        result=a;
    }

    // Mètode per establir un nou valor al resultat
    public void reset() {
        result = 0;
    }
}

