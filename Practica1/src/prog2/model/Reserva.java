package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva implements InReserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    /**Constructor, getters i setters no gaire complicats
     * tenim en compte les variables extres declarades amunt*/
    //Constructor
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        if (dataEntrada.isAfter(dataSortida))
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }
    //Setters
    public void setClient(Client client) {
        this.client = client;
    }
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }
     //Getters
    public Allotjament getAllotjament() {
        return allotjament;
    }
    public Client getClient() {
        return client;
    }
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public LocalDate getDataSortida() {
        return dataSortida;
    }
    public long getEstada(){
        return ChronoUnit.DAYS.between(dataEntrada,dataSortida);
    }

    //Mètodes
    public String toString (){
        return "Client: " + client.getNom() + " ("+ client.getDni()+")\n"+
                "Allotjament: " + allotjament.getNom() + " ("+ allotjament.getId()+")\n"+
                "Estada: " + dataEntrada.toString() + " a " +dataSortida.toString() + " ("+ getEstada()+" dies)";
    }
}
