package prog2.model;

import java.time.LocalDate;

public class LlistaReserves implements InLlistaReserves {
    private int numReserves;
    private int i;
    public Reserva[]  reserves;



    public LlistaReserves(int numReserves) {
        this.numReserves = numReserves;
        this.reserves = new Reserva[numReserves];
        this.i = 0;
    }

    public int getNumReserves() {
        return numReserves;
    }

    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida){


        InAllotjament.Temp T =  (true)?InAllotjament.Temp.ALTA: InAllotjament.Temp.BAIXA;
        LocalDate maxima = dataEntrada.plusDays(allotjament.getEstadaMinima(T));

        if (i < numReserves){
            Reserva r = new Reserva(allotjament,client,dataEntrada, dataSortida);
            this.reserves[i] = r;
            i++;
        }

    }
}
