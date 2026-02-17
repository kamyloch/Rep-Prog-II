package prog2.model;

import java.time.LocalDate;

public class Reserva implements InLlistaReserves {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    //Constructor
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) {
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
}
