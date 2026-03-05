package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import static prog2.model.InAllotjament.Temp;   //Enum de Temporada
import static prog2.model.InAllotjament.Temp.*; //Contingut del Enum

public class LlistaReserves implements InLlistaReserves {
    private ArrayList <Reserva>  reserves;

    /**Constructor, getters i setters no gaire complicats
     * segons InLlistReserves*/
    //Constructor
    public LlistaReserves() {
        this.reserves = new ArrayList <Reserva>();
    }

    //Getters
    public int getNumReserves() {
        return reserves.size();
    }

    //Mètodes afegirReserva
    private boolean allotjamentDisponible (Allotjament allotjament, LocalDate entrada, LocalDate sortida){
        Iterator<Reserva> it = reserves.iterator();
        boolean valid = true;
        while (it.hasNext() && valid) {
            Reserva reserva = it.next();
            Allotjament act = reserva.getAllotjament();

            if (act.equals(allotjament))    //Es trenca si hi ha solapament
                valid = (entrada.isAfter(reserva.getDataSortida()) || sortida.isBefore(reserva.getDataEntrada()));
        }
        return valid;
    }
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate entrada, LocalDate sortida){
        Temp tempReserva = Camping.getTemporada(entrada);

        long estada = ChronoUnit.DAYS.between(entrada, sortida);
        long minima = allotjament.getEstadaMinima(tempReserva);

        boolean isEstadaMinima = minima <= estada;

        return isEstadaMinima;
    }
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate entrada, LocalDate sortida) throws ExcepcioReserva{
        //Condicións perquè es pugui fer la reserva
        if (entrada.isAfter(sortida))   // <--- Condició duplicada al constructor de reserva
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");

        if (!isEstadaMinima(allotjament, entrada, sortida))
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId());

        if(!allotjamentDisponible(allotjament, entrada, sortida))
            throw new ExcepcioReserva("L’allotjament amb identificador " + allotjament.getId() + " no està disponible a la data demanada " + entrada.toString() + " a " +sortida.toString()  + " pel client " + client.getNom() + " amb DNI: " + client.getDni());

        reserves.add(new Reserva(allotjament,client, entrada,sortida));
    }


    //Només he fet això per mostrar més info al GestióCamping
    public String toString(){
        Iterator<Reserva> it = reserves.iterator();
        StringBuilder bf = new StringBuilder("---- Reserves ----\n");
        while (it.hasNext()){
            Reserva r = it.next();
            bf.append(r).append("\n-----------------\n");
        }
        return bf.toString();
    }

}
