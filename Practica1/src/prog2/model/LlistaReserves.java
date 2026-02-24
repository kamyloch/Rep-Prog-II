package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    private boolean isWithin(LocalDate a, LocalDate x, LocalDate b){
        a = a.minusDays(1);
        b = b.plusDays(1);
        return a.isBefore(x) && x.isBefore(b);
    }
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate entrada, LocalDate sortida) throws ExcepcioReserva{
        //Busca reserves en la estada volguda
        for (int i = 0 ; i < getNumReserves();i++){
            Reserva actR = reserves.get(i);
            Allotjament actA =actR.getAllotjament(); //Este es solo por abreviar
            LocalDate entra = actR.getDataEntrada();
            LocalDate surt = actR.getDataSortida();

            //Busquem algun solapament en reserves
            boolean trobat = allotjament.getId().equals(actA.getId()) &&
                    (isWithin(entra,entrada,surt) || isWithin(entra,sortida,surt));
            if (trobat)
                throw new ExcepcioReserva(
                        "L’allotjament amb identificador " + actA.getId() +
                        " no està disponible a la data demanada " + entrada.toString() + " a " +sortida.toString()  +
                        " pel client " + actR.getClient().getNom() + " amb DNI: " + actR.getClient().getDni());
        }



        //Calcula temporada
        int entradaInt = entrada.getMonthValue()*100 + entrada.getDayOfMonth();
        int sortidaInt = sortida.getMonthValue()*100 + sortida.getDayOfMonth();
        boolean isAlta = (320 < entradaInt) && (sortidaInt < 921);
        InAllotjament.Temp tempReserva =  (isAlta)? InAllotjament.Temp.ALTA: InAllotjament.Temp.BAIXA;

        //Calcula estada minima
        long estada = ChronoUnit.DAYS.between(entrada, sortida);
        long minima = allotjament.getEstadaMinima(tempReserva);

        //Afegeix reserva
        if (minima <= estada)
            reserves.add(new Reserva(allotjament,client,entrada, sortida));
        else throw new ExcepcioReserva("Es vol estar per " + estada + " dias " + "pero le mínim es " + minima + " dias" );

    }
    public String toString(){
        StringBuilder bf = new StringBuilder("---- Reserves ----\n");
        for (int i = 0; i < getNumReserves(); i++)
            bf.append(reserves.get(i).toString()).append("\n-----------------\n");
        return bf.toString();
    }

}
