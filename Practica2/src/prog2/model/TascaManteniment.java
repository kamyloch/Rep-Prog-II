package prog2.model;
import java.io.Serializable;
import java.time.LocalDate;


public class TascaManteniment implements InTascaManteniment, Serializable {

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


    public TascaManteniment(int num,TipusTascaManteniment tipus,Allotjament allotjament, String data,int dies){
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
    public void setData(String data_) {
        data = LocalDate.parse(data_.replaceAll("/","-"));
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
}
