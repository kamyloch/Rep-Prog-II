package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves {
    public ArrayList <Reserva>  reserves;


    //Constructor
    public LlistaReserves() {
        this.reserves = new ArrayList <Reserva>();
    }

    //Getters
    public int getNumReserves() {
        return reserves.size();
    }

    //Mètodes
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate entrada, LocalDate sortida) throws ExcepcioReserva{
        int entradaInt = entrada.getMonthValue()*100 + entrada.getDayOfMonth();
        int sortidaInt = sortida.getMonthValue()*100 + sortida.getDayOfMonth();
        boolean isAlta = (320 < entradaInt) && (sortidaInt < 921);

        InAllotjament.Temp tempReserva =  (isAlta)?
                                InAllotjament.Temp.ALTA:
                                InAllotjament.Temp.BAIXA;

        LocalDate minima = entrada.plusDays(allotjament.getEstadaMinima(tempReserva)+1);

        boolean valid = entrada.isAfter(sortida) && sortida.isAfter(minima);

        if (valid){
            this.reserves.add(new Reserva(allotjament,client,entrada, sortida));
        }
        else throw new ExcepcioReserva("Comprova dates i disponibilitat");

    }
}
