package prog2.model;

import java.time.LocalDate;

public class LlistaReserves implements InLlistaReserves {
    private int numReserves;
    private int reservesFetes;
    public Reserva[]  reserves;



    public LlistaReserves(int numReserves) {
        this.numReserves = numReserves;
        this.reserves = new Reserva[numReserves];
        this.reservesFetes = 0;
    }

    public int getNumReserves() {
        return numReserves;
    }

    public void afegirReserva(Allotjament allotjament, Client client, LocalDate entrada, LocalDate sortida){
        int entradaInt = entrada.getMonthValue()*100 + entrada.getDayOfMonth();
        int sortidaInt = sortida.getMonthValue()*100 + sortida.getDayOfMonth();
        boolean isAlta = (320 < entradaInt) && (sortidaInt < 921);

        InAllotjament.Temp tempReserva =  (isAlta)?
                                InAllotjament.Temp.ALTA:
                                InAllotjament.Temp.BAIXA;

        LocalDate maxima = entrada.plusDays(allotjament.getEstadaMinima(tempReserva)+1);

        boolean valid = entrada.isAfter(sortida) && sortida.isBefore(maxima) && (reservesFetes < numReserves);

        if (valid){
            Reserva r = new Reserva(allotjament,client,entrada, sortida);
            this.reserves[reservesFetes] = r;
            reservesFetes++;
        }
        else throw new IllegalArgumentException("Comprova dates i disponibilitat");

    }
}
