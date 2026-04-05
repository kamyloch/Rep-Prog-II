package prog2.vista;

import prog2.model.Camping;
import prog2.model.TascaManteniment;

import java.util.InputMismatchException;
import java.util.Scanner;

import static prog2.vista.VistaCamping.OpcionsMenuPrincipal.*;


/**Classe que implementa un menu per seleccionar i executar les diferents operacions que es poden realitzar en el camping
 * */
public class VistaCamping {

    // Declarem les opcions per a referir-se a les opcions del menú principal
    static enum OpcionsMenuPrincipal {
        LLISTAR_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_TASQUES,
        AFEGIR_TASCA_MANTENIMENT,
        COMPLETAR_TASCA_MANTENIMENT,
        CALCULAR_ACCESSOS_SENSE_VEHICLE,
        CALCULAR_METRES_TERRA,
        GUARDAR_CAMPING,
        RECUPERAR_CAMPING,
        SORTIR
    };
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal = {
            "Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Llistar la informació de les tasques de manteniments actives",
            "Afegir una tasca de manteniment",
            "Completar una tasca de manteniment",
            "Calcular número total d'accessos sense accessibilitat amb vehicle",
            "Calcular número total de metres dels accessos de terra",
            "Guardar dades del càmping en un fitxer",
            "Recuperar dades del càmping d'un fitxer",
            "Sortir de l'aplicació"
    };
    private Camping camping;

    public VistaCamping(String nomCamping) {
        this.camping = new Camping(nomCamping);
        this.camping.inicialitzaDadesCamping();
    }
    public void gestioCamping(){
        TascaManteniment.Menu<OpcionsMenuPrincipal> menu= new TascaManteniment.Menu<>("Gestió del camping: "+ camping.getNomCamping(), OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenuPrincipal);
        OpcionsMenuPrincipal opcio = null;
        Scanner sc = new Scanner(System.in);

        do{
            menu.mostrarMenu();
            while(true){
                try {
                    opcio = menu.getOpcio(sc);
                    break;
                }
                catch(InputMismatchException e){
                    System.err.println("Si su plau només numeros [1-13]");
                    sc.nextLine();
                }
            }
            switch (opcio){
                case LLISTAR_ALLOTJAMENTS:
                    try {
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                    }catch(ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }try{
                        System.out.println(camping.llistarAllotjaments("No Operatiu"));
                    }catch (ExcepcioCamping e){
                                System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    try{
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                    }catch(ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    try{
                        System.out.println(camping.llistarAllotjaments("No Operatiu"));
                    }catch(ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_OBERTS:
                    try{
                        System.out.println(camping.llistarAccessos("Obert"));
                    }catch(ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_TANCATS:
                    try{
                        System.out.println(camping.llistarAccessos("Tancat"));
                    }catch(ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_TASQUES:
                    try{
                        System.out.println(camping.llistarTasquesManteniment());
                    }catch(ExcepcioCamping e) {
                        if (e.getMessage().equals("La llista està buida"))
                            System.out.println("No hi ha tasques de manteniment actives");
                        else
                            System.err.println(e.getMessage());
                    }
                    break;
                case AFEGIR_TASCA_MANTENIMENT:
                    try {
                        System.out.println("Introdueix el número de la tasca:");
                        int num = Integer.parseInt((sc.nextLine())); //me lo ha dicho la profe, si ponia el next int no me leia el tipo
                        System.out.println("Introdueix el tipus de tasca:");
                        String tipus = sc.nextLine();
                        System.out.println("Introdueix l'identificador de l'allotjament:");
                        String idAllotjament = sc.nextLine();
                        System.out.println("Introdueix la data de la tasca (aaaa/mm/dd):");
                        String data = sc.nextLine();
                        System.out.println("Introdueix el número de dies esperats per completar la tasca:");
                        int dies = sc.nextInt();

                        camping.afegirTascaManteniment(num, tipus, idAllotjament, data, dies);

                        System.out.println("Tasca num '" + num + "' registrada!");
                    }catch(ExcepcioCamping e){
                        System.err.println("Error al afegir la tasca de manteniment: " + e.getMessage());
                    }catch(Exception e){
                        System.err.println("Error a l'entrada de dades: "+e.getMessage());}
                    break;
                case COMPLETAR_TASCA_MANTENIMENT:
                    try{
                        System.out.println(camping.llistarTasquesManteniment());
                        System.out.print("Introdueix el número de la tasca a completar: ");
                        int numTasca = sc.nextInt();
                        camping.completarTascaManteniment(numTasca);

                        System.out.println("Tasca num '" + numTasca + "' completada!");

                    }catch(ExcepcioCamping e){
                        System.err.println("Error al completar la tasca de manteniment: "+e.getMessage());
                    }
                    catch (Exception e){
                        System.err.println("Error a l'entrada de dades: "+e.getMessage());
                    }
                    break;
                case CALCULAR_ACCESSOS_SENSE_VEHICLE:
                    System.out.println("Hi han "+ camping.calculaAccessosNoAccessibles()+ " accessos sense accessibilitat amb vehicle");
                    break;
                case CALCULAR_METRES_TERRA:
                    System.out.println("Hi han " + camping.calculaMetresTerra() + " metres de terra al càmping.");
                    break;
                case GUARDAR_CAMPING:
                    System.out.print("Introdueix la ruta del camping: ");
                    String cami = sc.nextLine();
                    System.out.println("  *** Camping " + camping.getNomCamping() + " desat! *** ");

                    try{
                        camping.save(cami);
                    }catch (ExcepcioCamping e){
                        System.err.println("Error al guardar el camping: " + e.getMessage());
                    }
                    catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case RECUPERAR_CAMPING:
                    String camiOrigen=null;
                    try{
                        System.out.println("Introdueix la ruta del camping a recuperar: ");
                        camiOrigen = sc.nextLine();
                        camping=Camping.load(camiOrigen);

                        System.out.println("  *** Camping " + camping.getNomCamping() + " carregat! *** ");
                    }catch(ExcepcioCamping e) {
                        System.err.println("Error al recuperar el camping: " + e.getMessage());
                    }
                    catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case SORTIR:
            }

        }while(opcio!= SORTIR);

    }
}
