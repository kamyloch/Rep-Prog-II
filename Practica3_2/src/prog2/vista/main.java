package prog2.vista;

import prog2.adaptador.Adaptador;

public class main {
    public static void main(String[] args) {
        AppBiblioUB app= new AppBiblioUB(adaptadorDefault());
    }
    private static Adaptador adaptadorDefault(){
        Adaptador a = new Adaptador();
        try {
            for(int i = 0; i< 10; i++){
                a.afegirExemplar("Id"+i,"Tit"+i,"Aut"+i,i%2 == 0);
                a.afegirUsuari("Mail"+i,"Nom"+i,"Adr"+i,i%2 ==0);
            }
            a.afegirPrestec(1,1,false);
        }
        catch (Exception e){
            System.err.println("Error inesperat:" + e.getMessage());
        }
        return a;
    }

}
