package prog2.vista;

import prog2.adaptador.Adaptador;

/**Classe que inicia el programa
 *
 */
public class IniciadorBiblioUB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //BiblioUB biblioUB=new BiblioUB(adaptadorDefault());
        BiblioUB biblioUB=new BiblioUB();
        biblioUB.gestioBiblioUB();
    }

    private static Adaptador adaptadorDefault(){
        Adaptador a = new Adaptador();
        try {
            for(int i = 0; i< 10; i++){
                a.afegirExemplar("Id"+i,"Tit"+i,"Aut"+i,i%2 == 0);
                a.afegirUsuari("Mail"+i,"Nom"+i,"Adr"+i,i%2 ==0);
            }
        }
        catch (Exception e){
            System.err.println("Error inesperat:" + e.getMessage());
        }
        return a;
    }
}
