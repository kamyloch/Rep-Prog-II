package prog2.vista;

import prog2.model.Camping;

public class VistaCamping {

    // Declarem les opcions per a referir-se a les opcions del menú principal
    static private enum OpcionsMenuPrincipal {
        LLISTAR_TOTS_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_TASQUES_ACTIVES,
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


    }
}
