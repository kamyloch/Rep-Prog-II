
package prog2.model;

/**
 * Interfície que defineix les operacions bàsiques per als allotjaments.
 * @author lauraigual
 */
public interface InAllotjament {

    /**
     * Obté el nom de l'allotjament.
     * @return el nom de l'allotjament.
     */
    String getNom();

    /**
     * Estableix el nom de l'allotjament.
     * @param nom el nom a assignar.
     */
    void setNom(String nom);

    /**
     * Obté l'identificador únic de l'allotjament.
     * @return l'identificador únic de l'allotjament.
     */
    String getId();

    /**
     * Estableix l'identificador únic de l'allotjament.
     * @param id l'identificador a assignar.
     */
    void setId(String id);

    /**
     * Obté l'estada mínima segons la temporada.
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    long getEstadaMinima(Temp temp);

    /**
     * Estableix l'estada mínima per a cada temporada.
     * @param estadaMinimaALTA_ l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_);

    /**
     * Comprova si l'allotjament funciona correctament.
     * La implementació dependrà dels criteris específics de cada tipus d'allotjament.
     * @return true si l'allotjament funciona correctament, false altrament.
     */
    boolean correcteFuncionament();

    /**
     * Enumeració que representa les diferents temporades possibles.
     */
     enum Temp {
        ALTA,
        BAIXA
    }

    /**
     * Interfície que defineix les operacions bàsiques d'una llista d'accessos.
     */
    interface InLlistaAccessos {

        /**
         * Afegeix un accés rebut per paràmetre a la llista d'accessos.
         * @param acc Objecte de tipus Acces.
         * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
         */
        public void afegirAcces(Acces acc) throws ExcepcioCamping;

        /**
         * Buida la llista d'accessos
         */
         public void buidar();

         /**
         * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
         * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
         * @param estat boolean
         * @return String
         * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
         *
         */
         public String llistarAccessos(boolean estat) throws ExcepcioCamping;

         /**
          * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
         * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
          */
         public void actualitzaEstatAccessos() throws ExcepcioCamping;

         /**
         * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
         * @return int
         * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
         */
         public int calculaAccessosNoAccessibles() throws ExcepcioCamping;

         /**
         * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
         * @return float amb els metres totals.
         * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
         */
         public float calculaMetresTerra() throws ExcepcioCamping;
    }

    /**
     * Interfície que defineix les operacions bàsiques d'una llista d'allotjaments.
     */
    interface InLlistaAllotjaments {

        /**
         * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
         * @param allotjament Objecte de tipus Allotjament
         * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
         */
        public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping;

        /**
         * Buida la llista d'allotjaments.
         */
        public void buidar();

        /**
         * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
         * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
         * @param estat
         * @return String
         * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
         */
        public String llistarAllotjaments(String estat) throws ExcepcioCamping;

        /**
         * Mira si la llista d'allotjaments conté algun allotjament operatiu.
         * @return boolean
         */
        public boolean containsAllotjamentOperatiu();

        /**
         * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
         * @param allotjament
         * @return boolean
         */

        public boolean contains(Allotjament allotjament);

        /**
         * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
         * @param id String amb el id de l'allotjament
         * @return  Objecte de tipus Allotjament
         * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
         */
        public Allotjament getAllotjament(String id) throws ExcepcioCamping;


    }

    /**
     *
     * @author lauraigual
     */
    interface InLlistaTasquesManteniment {

        /**
         * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
         * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
         * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
         * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
         * @param num Número d'identificació de la tasca.
         * @param tipus Aquest String permet crear el enum TipusTascaManteniment
         * @param allotjament Allotjament on s'afegeix la tasca
         * @param data Data quan genera la tasca
         * @param dies Número de dies esperats per completar la tasca
         * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
         */
        public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping;
        /**
        * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
        * @param tasca Objecte de tipus TascaManteniment
        * @throws ExcepcioCamping
         */
        public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping;

        /**
         * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
         * En cas que no hi hagi cap tasca llança una excepció.
         * @return String
         * @throws ExcepcioCamping
         */
        public String llistarTasquesManteniment() throws ExcepcioCamping;

        /**
         * Busca la tasca amb el número rebut per paràmetre i la retorna.
         * En cas que no existeixi llança una excepció.
         * @param num Número d'identificació de la tasca.
         * @return Objecte de tipus TascaManteniment
         * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
         */
        public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping;
    }

    interface InTascaManteniment {

        /**
         * Retorna el número identificador de la tasca.
         * @return int
         */
        int getNum();

        /**
         * Retorna el tipus de tasca de manteniment.
         * @return TipusTascaManteniment
         */
        TascaManteniment.TipusTascaManteniment getTipus();

        /**
         * Retorna l'allotjament associat a la tasca.
         * @return Allotjament
         */
        Allotjament getAllotjament();

        /**
         * Retorna la data de registre de la tasca.
         * @return String
         */
        String getData();

        /**
         * Retorna el nombre de dies previstos per completar la tasca.
         * @return int
         */
        int getDies();

        /**
         * Assigna un nou número identificador a la tasca.
         * @param num_ Número identificador de la tasca.
         */
        void setNum(int num_);

        /**
         * Assigna el tipus de tasca de manteniment.
         * @param tipus_ Tipus de tasca.
         */
        void setTipus(TascaManteniment.TipusTascaManteniment tipus_);

        /**
         * Assigna l'allotjament associat a la tasca.
         * @param allotjament_ Allotjament afectat.
         */
        void setAllotjament(Allotjament allotjament_);

        /**
         * Assigna la data de registre de la tasca.
         * @param data_ Data de la tasca.
         */
        void setData(String data_);

        /**
         * Assigna el nombre de dies previstos per completar la tasca.
         * @param dies_ Nombre de dies.
         */
        void setDies(int dies_);

        /**
         * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
         * segons el tipus de tasca de manteniment.
         * @return String amb el percentatge d'il·luminació.
         */
        String getIluminacioAllotjament();

    }
}