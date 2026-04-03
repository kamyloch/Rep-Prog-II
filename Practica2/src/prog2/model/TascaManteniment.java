package prog2.model;
import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

/** Classe que representa una tasca del camping
 */
public class TascaManteniment implements InTascaManteniment, Serializable {

    /**Enum que defineix els tipus de tasques de manteniment
     *
     */
    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };

    private TipusTascaManteniment tipusTasca;
    private int num;
    private LocalDate data;
    private Allotjament allotjament;
    private int dies;


    public TascaManteniment(int num,TipusTascaManteniment tipus,Allotjament allotjament, String data,int dies) throws ExcepcioCamping {
        this.tipusTasca = tipus;
        this.num = num;
        this.allotjament = allotjament;
        setData(data);
        this.dies=dies;
    }

    /**
     * Retorna el número identificador de la tasca.
     * @return int
     */
    @Override
    public int getNum() {
        return num;
    }

    /**
     * Retorna el tipus de tasca de manteniment.
     * InTascaMantenime
     * @return TipusTascaManteniment
     */
    @Override
    public TipusTascaManteniment getTipus() {
        return tipusTasca;
    }

    /**
     * Retorna l'allotjament associat a la tasca.
     * @return Allotjament
     */
    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    /**
     * Retorna la data de registre de la tasca.
     * @return String
     */
    @Override
    public String getData() {
        return data.toString();
    }

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     * @return int
     */
    @Override
    public int getDies() {
        return dies;
    }

    /**
     * Assigna un nou número identificador a la tasca.
     * @param num_ Número identificador de la tasca.
     */
    @Override
    public void setNum(int num_) {
        num = num_;
    }

    /**
     * Assigna el tipus de tasca de manteniment.
     * @param tipus_ Tipus de tasca.
     */
    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        tipusTasca = tipus_;
    }

    /**
     * Assigna l'allotjament associat a la tasca.
     * @param allotjament_ Allotjament afectat.
     */
    @Override
    public void setAllotjament(Allotjament allotjament_) {
        allotjament = allotjament_;
    }

    /**
     * Assigna la data de registre de la tasca.
     * @param data_ Data de la tasca.
     */
    @Override
    public void setData(String data_) throws ExcepcioCamping {
        try{
            data = LocalDate.parse(data_.replaceAll("/","-"));
        }catch(Exception e){
            throw new ExcepcioCamping("Format de data incorrecte, si us plau [aaaa-mm-dd o aaaa/mm/dd]");
        }
    }

    /**
     * Assigna el nombre de dies previstos per completar la tasca.
     * @param dies_ Nombre de dies.
     */
    @Override
    public void setDies(int dies_) {
        dies=dies_;
    }

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca de manteniment.
     * @return String amb el percentatge d'il·luminació.
     */
    @Override
    public String getIluminacioAllotjament() {
        String iluminacio="";
        switch(this.tipusTasca){
            case Reparacio, RevisioTecnica:
                iluminacio = "50%";
                break;
            case Neteja:
                iluminacio = "100%";
                break;
            case Desinfeccio:
                iluminacio = "0%";
                break;
        }
        return iluminacio;
    }

    @Override
    public String toString(){
        return "Numero:" + num + ", Tipus:" + getTipus().toString() + ", Allotjament:" + allotjament.getId() + ", Data:" + getData() + ", Dies per completar-la:" + dies;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof TascaManteniment)
            return this.num == ((TascaManteniment)obj).getNum();
        return super.equals(obj);
    }

    /**
     * Implements a text menu from a list of options.
     * @author Xavi Baró
     */
    public static class Menu<TEnum> {
         /**
         * Llista de les opcions
         */
        TEnum[] _llistaOpcions=null;

        /**
         * Títol del menú
         */
        String _titol="";

        /**
         * Llista amb els missatges associats a les accions
         */
        String[] _descripcions=null;

        /**
         * Constructor per defecte. Se li ha de passar un enumeració de les opcions.
         * @param titol Títol del menú
         * @param llistaOpcions Enumeració amb les opcions
         */
        public Menu(String titol,TEnum[] llistaOpcions) {
            _titol=titol;
            _llistaOpcions=llistaOpcions;
        }

        /**
         * Permet assignar una descripció personalitzada a les opcions del menú
         * @param descripcions Llista de descripcions
         */
        public void setDescripcions(String[] descripcions) {
            if(descripcions.length!=_llistaOpcions.length) {
                _descripcions=null;
            } else {
                _descripcions=descripcions;
            }
        }

        /**
         * Mostra el menú d'opcions
         */
        public void mostrarMenu() {
            // Mostrem les opcions
            String lines="--------------";
            for(int i=0;i<getMaxLen();i++) {
                lines+="-";
            }
            System.out.println(lines);
            System.out.println(_titol.toUpperCase());
            System.out.println(lines);
            for(TEnum c : _llistaOpcions){

                // Mostrem la posició
                int pos=((Enum)c).ordinal();
                System.out.print("\t" + (pos+1) + ".- ");

                // Mostrem la descripció
                if(_descripcions!=null) {
                    System.out.println(_descripcions[pos]);
                } else {
                    System.out.println(c);
                }
            }
            System.out.println(lines);
        }

        /**
         * Demana una opció utilitzant la entrada passada per paràmetre.
         * @param sc Canal d'entrada utilitzat per a obtenir la opció
         * @return Opció seleccionada.
         */
        public TEnum getOpcio(Scanner sc) {
            TEnum opcio=null;

            // Demanem una opció assegurant que sigui correcta
            int opcioInt=-1;
            do {
                System.out.print("Entra una opcio >> ");
                opcioInt=sc.nextInt();
                sc.nextLine();

                if(opcioInt>0 && opcioInt<=_llistaOpcions.length) {
                    // Passem de l'enter a una opcio i la retornem
                    opcio=_llistaOpcions[opcioInt-1];
                } else {
                    System.err.println("La opció seleccionada no és correcta. Selecciona una opció entre 1 i " + (_llistaOpcions.length));
                }
            } while(opcio==null);

            return opcio;
        }

        /**
         * Troba la longitud màxima en les descripcions de les opcions
         * @return Longitud de la descripció més llarga
         */
        private int getMaxLen() {
            int maxLen=0;

            for(TEnum c : _llistaOpcions){

                // Obtenim la posició
                int pos=((Enum)c).ordinal();

                // Mostrem la descripció
                if(_descripcions!=null) {
                    maxLen=Math.max(maxLen, _descripcions[pos].length());
                } else {
                    maxLen=Math.max(maxLen, c.toString().length());
                }
            }

            return maxLen;
        }
    }
}
