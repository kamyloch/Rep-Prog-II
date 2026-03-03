package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

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
    private boolean allotjamentDisponible (Allotjament allotjament, LocalDate entrada, LocalDate sortida){
        Iterator<Reserva> it = reserves.iterator();
        boolean valid = true;
        while (it.hasNext() && valid) {
            Reserva reserva = it.next();
            Allotjament act = reserva.getAllotjament();
            if (act.equals(allotjament))
                valid = (entrada.isAfter(reserva.getDataSortida()) || sortida.isBefore(reserva.getDataEntrada()));
        }
        return valid;
    }
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate entrada, LocalDate sortida){
        InAllotjament.Temp tempReserva = Camping.getTemporada(entrada);

        long estada = ChronoUnit.DAYS.between(entrada, sortida);
        long minima = allotjament.getEstadaMinima(tempReserva);

        boolean isEstadaMinima = minima <= estada;

        return isEstadaMinima;
    }


    public void afegirReserva(Allotjament allotjament, Client client, LocalDate entrada, LocalDate sortida) throws ExcepcioReserva{
        if (entrada.isAfter(sortida))
            throw new ExcepcioReserva("Entrada i sortida incorrecta (una després de l'altre)");

        if (isEstadaMinima(allotjament, entrada, sortida)){
            if(allotjamentDisponible(allotjament, entrada, sortida))
                reserves.add(new Reserva(allotjament,client,entrada, sortida));
            else
                throw new ExcepcioReserva("L’allotjament amb identificador " + allotjament.getId() + " no està disponible a la data demanada " + entrada.toString() + " a " +sortida.toString()  + " pel client " + client.getNom() + " amb DNI: " + client.getDni());
        }else
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId());

    }
    public String toString(){
        StringBuilder bf = new StringBuilder("---- Reserves ----\n");
        for (int i = 0; i < getNumReserves(); i++)
            bf.append(reserves.get(i).toString()).append("\n-----------------\n");
        return bf.toString();
    }

}
